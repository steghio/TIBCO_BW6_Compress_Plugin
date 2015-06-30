package com.tibco.bw.compress.palette.compress.runtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import com.tibco.bw.compress.palette.compress.runtime.RuntimeMessageBundle;
import com.tibco.bw.compress.palette.compress.runtime.fault.ZipFault;
import com.tibco.bw.compress.palette.compress.model.compress.Zip;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.SyncActivity;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.ActivityLifecycleFault;
import com.tibco.bw.runtime.util.XMLUtils;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.genxdm.ProcessingContext;
import org.genxdm.Model;
import org.genxdm.mutable.MutableModel;
import org.genxdm.mutable.NodeFactory;
import com.tibco.neo.localized.LocalizedMessage;
import org.genxdm.io.FragmentBuilder;
import org.genxdm.typed.types.AtomBridge;
import org.genxdm.typed.TypedContext;
import com.tibco.bw.runtime.annotation.Property;


public class ZipSynchronousActivity<N> extends SyncActivity<N> implements CompressContants 


{
	
	//method variables
	private OutputStream out;
	private ArchiveOutputStream zip_out;
	private FileInputStream tmp_fis;
	//input parameters
	protected String location = "";
	protected String name = "";
	protected String ziplocation = "";
	protected String zipname = "";
	protected boolean createDirs = false;
	protected boolean overwrite = false;
	//return parameters
	protected int lretCode = 0;
	protected String lretMsg = "";
	//log settings - INFO should be reserved for ENGINE logs
	private boolean isDebugActive = false;
	private boolean isWarnActive = false;
	private boolean isErrorActive = false;
	private boolean isTraceActive = false;
	
	//aux method for zipping
	private void dozip(File myFile, String baseDir) throws Exception{
		//maintain the directory structure while zipping
		String entryName = baseDir+myFile.getName();
		//DO NOT do a putArchiveEntry for folders as it is not needed
		//if it's a directory then list and zip the contents. Uses recursion for nested directories
		if(myFile.isDirectory() == true){
			File[] filesList = myFile.listFiles();
			if(filesList != null){
				for (File file : filesList) {
					dozip(file, entryName+File.separator);
				}
			}
		}
		else{
			//add file
			tmp_fis = new FileInputStream(myFile);
			try{
				if(isDebugActive){
					activityLogger.debug(RuntimeMessageBundle.DEBUG_ADD_ZIP_ENTRY,new Object[] {entryName});
				}
				zip_out.putArchiveEntry(new ZipArchiveEntry(myFile, entryName));
				IOUtils.copy(tmp_fis, zip_out);
				zip_out.closeArchiveEntry();
			}
			catch(Exception e){
				if(isErrorActive){
					activityLogger.error(RuntimeMessageBundle.ERROR_ADD_ZIP_ENTRY,new Object[] {entryName, e.getMessage()});
				}
				throw e;
			}
			finally{
				if(tmp_fis != null) tmp_fis.close();
			}
		}
	}

	@Property
	public Zip activityConfig;
    /**
	 * @generated
	 * 
	 * This method is called to initialize the activity. It is called by the 
	 * BusinessWorks Engine once for a particular activity lifetime.
	 * 
	 * @throws ActivityLifecycleFault
	 *             Thrown if the activity initialization is unsuccessful or encounters an error.
	 */
	@Override
	public void init() throws ActivityLifecycleFault {
		super.init();
		isDebugActive = getActivityLogger().isDebugEnabled();
		isWarnActive = getActivityLogger().isWarnEnabled();
		isErrorActive = getActivityLogger().isErrorEnabled();
		isTraceActive = getActivityLogger().isTraceEnabled();
	}
	
	/**
	 * @generated
	 * 
	 * This method is called when an activity is destroyed. It is called by the BusinessWorks Engine and 
	 * the method must be implemented to release or cleanup any resources held by this activity.
	 */
    @Override
	public void destroy() {
		super.destroy();
	}
	
    /**
	 * @generated
	 *
     * The implementation of this method defines the execution behavior of the synchronous activity.  
     * This method is called by the BusinessWorks Engine on a engine thread to perform 
     * the activity essential functions.
     * 
     * @param input 
     *           This is the activity input data. It is an XML Element which adheres to the input schema of the activity or <code>null</code> if the activity does not require an input. The 
     *           activity input data should be processed using the XML processing context obtained from the method {@link ProcessContext#getXMLProcessingContext()}.
     * @param processContext
	 *           Context that is associated with a BusinessWorks Process instance. This context is unique per BusinessWorks Process instance and it 
	 *           is not visible to other BusinessWorks Process instances.  Also this context is valid only within the BusinessWorks Engine thread on 
	 *           which this method is invoked. Therefore this context must not be saved or used by a different thread that is created or managed by the activity
	 *           implementation. 
     * @return An XML Element which adheres to the output schema of the activity or may return <code>null</code> if the activity does not require an output. 
     *         This is the activity output data and it should be created using the XML processing context obtained from the method {@link ProcessContext#getXMLProcessingContext()}.
     * @throws ActivityFault
     *           Thrown if the activity execution is unsuccessful or encounters an error.
	 */
	@Override
	public N execute(N input, ProcessContext<N> processContext) throws ActivityFault, ZipFault {
        if(getActivityLogger().isDebugEnabled()){
	        String serializedInputNode = XMLUtils.serializeNode(input, processContext.getXMLProcessingContext());
		    activityLogger.debug(RuntimeMessageBundle.DEBUG_PLUGIN_ACTIVITY_INPUT, new Object[] {activityContext.getActivityName(), serializedInputNode});
		}
        N result = null;
        try {
        	//get palette input
        	//for path parameters, check if they already end with path separator, if not, add it
            location = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "location");
            if(!location.endsWith(File.separator)){
        		location+=File.separator;
        	}
            name = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "filename");
            ziplocation = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "zipLocation");
            if(!ziplocation.endsWith(File.separator)){
        		ziplocation+=File.separator;
        	}
            zipname = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "zipFilename");
            createDirs = getInputParameterBooleanValueByName(input, processContext.getXMLProcessingContext(), "createDirs");
            overwrite = getInputParameterBooleanValueByName(input, processContext.getXMLProcessingContext(), "overwrite");
            if(isTraceActive){
            	activityLogger.trace(RuntimeMessageBundle.TRACE_ZIP_ACTIVITY_START, new Object[]{});
            }
            if(isDebugActive){
            	activityLogger.debug(RuntimeMessageBundle.DEBUG_ZIP_ACTIVITY_INPUT, new Object[]{location, name, ziplocation, zipname, createDirs, overwrite});
            }
            try{ 
            	//check if file/folder to be zipped exists
            	File f = new File(location+name);
            	if(!f.exists()){
            		if(isErrorActive){
            			activityLogger.error(RuntimeMessageBundle.ERROR_FILE_NOT_FOUND, new Object[]{f.getAbsolutePath()});
            		}
            		throw new ZipFault(activityContext, RuntimeMessageBundle.ERROR_FILE_NOT_FOUND.getErrorCode(), RuntimeMessageBundle.ERROR_FILE_NOT_FOUND, new Object[]{f.getAbsolutePath()});
            	}
            	//check if location where to create the zip exists
            	File fziploc = new File(ziplocation);
            	if(!fziploc.exists() && createDirs){
                    if(isDebugActive){
                    	activityLogger.debug(RuntimeMessageBundle.DEBUG_CREATE_DIR, new Object[]{fziploc.toString()});
                    }
            		fziploc.mkdirs();
            	}
            	else if(!fziploc.exists() && !createDirs){
            		if(isWarnActive){
            			activityLogger.warn(RuntimeMessageBundle.WARN_PATH_NOT_EXISTS, new Object[]{fziploc.getAbsolutePath()});
            		}
    	    		throw new ZipFault(activityContext, RuntimeMessageBundle.WARN_PATH_NOT_EXISTS.getErrorCode(), RuntimeMessageBundle.WARN_PATH_NOT_EXISTS, new Object[]{fziploc.getAbsolutePath()});
            	}
            	//check if zipfile already exists
            	File fzipname = new File(ziplocation+zipname+".zip");
            	File fzipnamebak = null;
            	//if overwrite is selected, make first a backup copy so that we can recover it in case an exception occurred
            	if(fzipname.exists() && overwrite){
            		fzipnamebak = new File(ziplocation+zipname+".zip.bak");
            		if(isDebugActive){
            			activityLogger.debug(RuntimeMessageBundle.DEBUG_BACKUP_EXISTING_ZIP, new Object[]{fzipname.toString(), fzipnamebak.toString()});
            		}
            		fzipname.renameTo(fzipnamebak);          		
            	}
            	else if(fzipname.exists() && !overwrite){
            		if(isWarnActive){
            			activityLogger.warn(RuntimeMessageBundle.WARN_FILE_ALREADY_EXISTS, new Object[]{fzipname.getAbsolutePath()});
            		}
            		throw new ZipFault(activityContext, RuntimeMessageBundle.WARN_FILE_ALREADY_EXISTS.getErrorCode(), RuntimeMessageBundle.WARN_FILE_ALREADY_EXISTS, new Object[]{fzipname.getAbsolutePath()});
            	}
	        	//out writes the final file, zip_out creates the zip archive
	            out = new FileOutputStream(new File(ziplocation+zipname+".zip"));
	            zip_out = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, out);
		    	//zip it
        		if(isTraceActive){
        			activityLogger.trace(RuntimeMessageBundle.TRACE_ZIPPING, new Object[]{f.toString()});
        		}
	    		//first time baseDir is empty
	    		dozip(f, "");
	    		//close archive 
	    		zip_out.finish();
	    		if(fzipnamebak != null){
	        		if(isDebugActive){
	        			activityLogger.trace(RuntimeMessageBundle.DEBUG_DELETE_BACKUP, new Object[]{fzipnamebak.toString()});
	        		}
	    			Files.delete(fzipnamebak.toPath());
	    		}
	    	}
	    	catch(Exception e){
        		if(isErrorActive){
        			activityLogger.error(RuntimeMessageBundle.ERROR_ZIPPING, new Object[]{ziplocation, zipname, e.getMessage()});
        		}	
        		throw new ZipFault(activityContext, RuntimeMessageBundle.ERROR_ZIPPING.getErrorCode(), RuntimeMessageBundle.ERROR_ZIPPING, new Object[]{ziplocation, zipname, e.getMessage()});
	    	}
            finally{
            	if(out != null)out.close();
            }
            // create output data according the output structure
            result = evalOutput(input, processContext.getXMLProcessingContext(), null);
        } 
        catch(ZipFault zex){
        	throw zex;
        }
        catch (Exception e) {
            throw new ActivityFault(activityContext, new LocalizedMessage(
						RuntimeMessageBundle.ERROR_OCCURED_RETRIEVE_RESULT, new Object[] {activityContext.getActivityName()}));
        }

        if(getActivityLogger().isDebugEnabled()){
	        String serializedOutputNode = XMLUtils.serializeNode(result, processContext.getXMLProcessingContext());
			activityLogger.debug(RuntimeMessageBundle.DEBUG_PLUGIN_ACTIVITY_OUTPUT, new Object[] {activityContext.getActivityName(), serializedOutputNode, activityContext.getActivityName()});
		}
        if(isTraceActive){
			activityLogger.trace(RuntimeMessageBundle.TRACE_ZIP_ACTIVITY_END, new Object[]{});
		}
        return result;
	}
	/**
	 * @generated
	 *  
	 * This method to build the output after finishing the business.
	 * @param inputData
	 *			This is the activity input data. 
	 * @param processingContext
	 *			XML processing context.
	 * @param data
	 *			Business object.
	 * @return An XML Element which adheres to the output schema of the activity or may return <code>null</code> if the activity does not require an output.
	 */
	protected <A> N evalOutput(N inputData, ProcessingContext<N> processingContext, Object data) throws Exception {
	    N ZipOutput = this.getOutputRootElement(processingContext);
	
	    //create output according the xsd file
	    buildStructuredOutput(inputData, ZipOutput, processingContext, data);
	    return ZipOutput;
	}
	
	/**
	 * @generated
	 *
	 * This method to build the output.
	 * @param inputData
	 *			This is the activity input data.
	 * @param ZipOutput
	 *			This is the root element of output. 
	 * @param processingContext
	 *			XML processing context.
 	 * @param data
	 *			Business object.
	 * @return An XML Element which adheres to the output schema of the activity or may return <code>null</code> if the activity does not require an output.
	 */
	private <A> void buildStructuredOutput(N inputData, N ZipOutput, ProcessingContext<N> processingContext, Object data) throws Exception {
	    MutableModel<N> mutableModel = processingContext.getMutableContext().getModel();
        TypedContext<N, A> tc = processingContext.getTypedContext(null);
	    AtomBridge<A> atomBridge = tc.getAtomBridge();
	    A atom = null;
	    
	    NodeFactory<N> noteFactory = mutableModel.getFactory(ZipOutput);
		
		//if the element's MaxOccurs and MinOccurs are 1, that means this element's size is 1
		N retCode = noteFactory.createElement("", "retCode", "");
		mutableModel.appendChild(ZipOutput, retCode);
		atom = atomBridge.createInteger(new Integer(lretCode));
		N retCodevalueNode = noteFactory.createText(atomBridge.getC14NForm(atom));
		mutableModel.appendChild(retCode, retCodevalueNode);
		
		//if the element's MinOccurs are 0, that means this element is option, it is depends on your business, if there is data, you can create node for it
		N retMsg = noteFactory.createElement("", "retMsg", "");
		mutableModel.appendChild(ZipOutput, retMsg);
		N retMsgvalueNode = noteFactory.createText(lretMsg);
		mutableModel.appendChild(retMsg, retMsgvalueNode);
    }
	
    /**
	 * @generated
	 *
	 * This method to get the root element of output.
	 * @param processingContext
	 *				XML processing context.
	 * @return An XML Element.
	 */		
	 protected N getOutputRootElement(ProcessingContext<N> processingContext) {
        final FragmentBuilder<N> builder = processingContext.newFragmentBuilder();

        Model<N> model = processingContext.getModel();
        builder.startDocument(null, "xml");
        try {
			builder.startElement(activityContext.getActivityOutputType().getTargetNamespace(), "ZipOutput", "ns0");
        try {
			} finally {
				builder.endElement();
			}
		} finally {
			builder.endDocument();
		}
        N output = builder.getNode();
        N resultList = model.getFirstChild(output);
        return resultList;
    }
    
	/**
	 * @generated
     * Gets the String type parameter from the input by name.
     * @param inputData
     *			This is the activity input data.
     * @param processingContext
     *			XML processing context.
     * @param parameterName
     *			The parameter name which you want to get the value.
     * @return parameter value.	
     */
 	public String getInputParameterStringValueByName(final N inputData, final ProcessingContext<N> processingContext, final String parameterName) {
         Model<N> model = processingContext.getMutableContext().getModel();
         N parameter = model.getFirstChildElementByName(inputData, null, parameterName);
         if (parameter == null) {
             return "";
         }
         return model.getStringValue(parameter);
     }
     
 	/**
	 * @generated
     * Gets the Boolean type parameter from the input by name.
     * @param inputData
     *			This is the activity input data.
     * @param processingContext
     *			XML processing context.
     * @param parameterName
     *			The parameter name which you want to get the value.
     * @return parameter value.	
     */
 	public boolean getInputParameterBooleanValueByName(final N inputData, final ProcessingContext<N> processingContext, final String parameterName) {
 		Model<N> model = processingContext.getMutableContext().getModel();
 		N parameter = model.getFirstChildElementByName(inputData, null, parameterName);
 		if (parameter == null) {
 			return false;
 		}
 		String valueStr = model.getStringValue(parameter);
 		return Boolean.parseBoolean(valueStr);
 	}
}
