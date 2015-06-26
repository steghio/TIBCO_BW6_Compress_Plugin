package com.tibco.bw.compress.palette.compress.runtime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import com.tibco.bw.compress.palette.compress.runtime.RuntimeMessageBundle;
import com.tibco.bw.compress.palette.compress.model.compress.Unzip;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.SyncActivity;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.ActivityLifecycleFault;
import com.tibco.bw.runtime.util.XMLUtils;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
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


public class UnzipSynchronousActivity<N> extends SyncActivity<N> implements CompressContants 


{
	
	//method variables
	private ZipFile zipFile;
	private Enumeration<ZipArchiveEntry> entries;
	private ZipArchiveEntry entry;
	private File entryDestination;
	private InputStream in;
	private OutputStream out;
	//input parameters
	protected String ziplocation = "";
	protected String zipname = "";
	protected String unziplocation = "";
	protected boolean createDirs = false;
	protected boolean overwrite = false;
	//return parameters
	protected int lretCode = 0;
	protected String lretMsg = "";

	@Property
	public Unzip activityConfig;
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
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
		// begin-custom-code
        // add your own business code here
        // end-custom-code
	}
	
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 * 
	 * This method is called when an activity is destroyed. It is called by the BusinessWorks Engine and 
	 * the method must be implemented to release or cleanup any resources held by this activity.
	 */
    @Override
	public void destroy() {
		super.destroy();
		// begin-custom-code
        // add your own business code here
        // end-custom-code
	}
	
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
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
	public N execute(N input, ProcessContext<N> processContext) throws ActivityFault {
        if(getActivityLogger().isDebugEnabled()){
	        String serializedInputNode = XMLUtils.serializeNode(input, processContext.getXMLProcessingContext());
		    activityLogger.debug(RuntimeMessageBundle.DEBUG_PLUGIN_ACTIVITY_INPUT, new Object[] {activityContext.getActivityName(), serializedInputNode});
		}
        N result = null;
        try {
        	//get palette input
        	//for path parameters, check if they already end with path separator, if not, add it
        	ziplocation = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "zipLocation");
        	if(!ziplocation.endsWith(File.separator)){
        		ziplocation+=File.separator;
        	}
        	zipname = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "zipFilename");
        	unziplocation = getInputParameterStringValueByName(input, processContext.getXMLProcessingContext(), "unzipLocation");
        	if(!unziplocation.endsWith(File.separator)){
        		unziplocation+=File.separator;
        	}
        	createDirs = getInputParameterBooleanValueByName(input, processContext.getXMLProcessingContext(), "createDirs");
        	overwrite = getInputParameterBooleanValueByName(input, processContext.getXMLProcessingContext(), "overwrite");
        	System.out.println("UNZIP - [INFO] Started");
            System.out.println("UNZIP - [DEBUG] Input: ziplocation = "+ziplocation+" - zipname = "+zipname+" - unziplocation = "+unziplocation+" -createDirs = "+createDirs+" - overwrite = "+overwrite);
            try{
            //check if zipfile exists
            File lzipFile = new File(ziplocation+zipname);
            if(!lzipFile.exists()){
            	System.out.println("UNZIP - [WARN] Zipfile does not exist "+lzipFile.getAbsolutePath());
	    		lretCode = 1;
	    		lretMsg = "UNZIP - [WARN] Zipfile does not exist "+lzipFile.getAbsolutePath();
	    		// create output data according the output structure
	            result = evalOutput(input, processContext.getXMLProcessingContext(), null);
	    		return result;
            }
            //create zipfile object
        	zipFile = new ZipFile(ziplocation+zipname);
        	//check if unzip destination exists
        	File funzip = new File(unziplocation);
        	if(!funzip.exists() && createDirs){
        		System.out.println("UNZIP - [DEBUG] Creating directory "+funzip.toString());
        		funzip.mkdirs();
        	}
        	else if(!funzip.exists() && !createDirs){
        		System.out.println("UNZIP - [WARN] Unzip location does not exist "+funzip.getAbsolutePath());
	    		lretCode = 2;
	    		lretMsg = "UNZIP - [WARN] Unzip location does not exist "+funzip.getAbsolutePath();
	    		// create output data according the output structure
	            result = evalOutput(input, processContext.getXMLProcessingContext(), null);
	    		return result;
        	}
        	//unzip
        	//get zip file content references
        	entries = zipFile.getEntries();
        	//for each reference, unzip to unziplocation, creating directories if needed
            	while (entries.hasMoreElements()) {
        		entry = entries.nextElement();
                	entryDestination = new File(unziplocation,  entry.getName());
                	System.out.println("UNZIP - [DEBUG] Extracting item "+entryDestination.getAbsolutePath());
                	//check if we need to overwrite something
                	/*this means we might add items to the existing directory and we'll stop without rollbacking if we encounter
                	 *an existing item but the overwrite flag was not set to true
                	 */
                	if(entryDestination.exists() && !overwrite){
                		System.out.println("UNZIP - [WARN] Unzip item already exists "+entryDestination.getAbsolutePath());
        	    		lretCode = 3;
        	    		lretMsg = "UNZIP - [WARN] Unzip item already exists "+entryDestination.getAbsolutePath();
        	    		IOUtils.closeQuietly(in);
            			IOUtils.closeQuietly(out);
        	    		break;
                	}
                	else if(entryDestination.exists() && overwrite){
                		System.out.println("UNZIP - [DEBUG] Overwriting existing item "+entryDestination.getAbsolutePath());
                	}
                	entryDestination.getParentFile().mkdirs();
                	if (entry.isDirectory())
                    		entryDestination.mkdirs();
                	else {
                    		in = zipFile.getInputStream(entry);
                    		out = new FileOutputStream(entryDestination);
        			try{
                    			IOUtils.copy(in, out);
        			}
        			catch(Exception e){
        				System.out.println("UNZIP - [ERROR] Exception when extracting "+entry.getName()+" to "+entryDestination.getAbsolutePath()+" - "+e);
        				lretCode = -1;
        	    		lretMsg = "UNZIP - [ERROR] Exception when extracting "+entry.getName()+" to "+entryDestination.getAbsolutePath()+" - "+e;
        	    		break;
        			}
        			finally{
        				//close streams ignoring exceptions
            			IOUtils.closeQuietly(in);
            			IOUtils.closeQuietly(out);
        			}
                	}
            	}
            }
			catch(Exception e){
				System.out.println("UNZIP - [ERROR] Exception when unzipping "+ziplocation+zipname+": "+e);
	    		lretCode = -1;
	    		lretMsg = "UNZIP - [ERROR] Exception when unzipping "+ziplocation+zipname+": "+e;
			}
            // create output data according the output structure
            result = evalOutput(input, processContext.getXMLProcessingContext(), null);
			// end-custom-code
        } catch (Exception e) {
            throw new ActivityFault(activityContext, new LocalizedMessage(
						RuntimeMessageBundle.ERROR_OCCURED_RETRIEVE_RESULT, new Object[] {activityContext.getActivityName()}));
        }

        if(getActivityLogger().isDebugEnabled()){
	        String serializedOutputNode = XMLUtils.serializeNode(result, processContext.getXMLProcessingContext());
			activityLogger.debug(RuntimeMessageBundle.DEBUG_PLUGIN_ACTIVITY_OUTPUT, new Object[] {activityContext.getActivityName(), serializedOutputNode, activityContext.getActivityName()});
		}
        System.out.println("UNZIP - [INFO] End");
        return result;
	}
	/**
	 * <!-- begin-custom-doc -->
	 *
	 *
	 * <!-- end-custom-doc -->
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
	    N UnzipOutput = this.getOutputRootElement(processingContext);
	
	    //create output according the xsd file
	    buildStructuredOutput(inputData, UnzipOutput, processingContext, data);
		// begin-custom-code
        // add your own business code here
        // end-custom-code
	    return UnzipOutput;
	}
	
	/**
	 * <!-- begin-custom-doc -->
	 *
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * This method to build the output.
	 * @param inputData
	 *			This is the activity input data.
	 * @param UnzipOutput
	 *			This is the root element of output. 
	 * @param processingContext
	 *			XML processing context.
 	 * @param data
	 *			Business object.
	 * @return An XML Element which adheres to the output schema of the activity or may return <code>null</code> if the activity does not require an output.
	 */
	private <A> void buildStructuredOutput(N inputData, N UnzipOutput, ProcessingContext<N> processingContext, Object data) throws Exception {
	    MutableModel<N> mutableModel = processingContext.getMutableContext().getModel();
        TypedContext<N, A> tc = processingContext.getTypedContext(null);
	    AtomBridge<A> atomBridge = tc.getAtomBridge();
	    A atom = null;
	    
	    NodeFactory<N> noteFactory = mutableModel.getFactory(UnzipOutput);
		
		//if the element's MaxOccurs and MinOccurs are 1, that means this element's size is 1
		N retCode = noteFactory.createElement("", "retCode", "");
		mutableModel.appendChild(UnzipOutput, retCode);
		//set default value here, please set value by your business
		atom = atomBridge.createInteger(new Integer(lretCode));
		N retCodevalueNode = noteFactory.createText(atomBridge.getC14NForm(atom));
		mutableModel.appendChild(retCode, retCodevalueNode);
		
		//if the element's MinOccurs are 0, that means this element is option, it is depends on your business, if there is data, you can create node for it
		N retMsg = noteFactory.createElement("", "retMsg", "");
		mutableModel.appendChild(UnzipOutput, retMsg);
		//set default value here, please set value by your business
		N retMsgvalueNode = noteFactory.createText(lretMsg);
		mutableModel.appendChild(retMsg, retMsgvalueNode);
		// begin-custom-code
        // add your own business code here
        // end-custom-code
    }
	
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
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
			builder.startElement(activityContext.getActivityOutputType().getTargetNamespace(), "UnzipOutput", "ns0");
        try {
			} finally {
				builder.endElement();
			}
		} finally {
			builder.endDocument();
		}
        N output = builder.getNode();
        N resultList = model.getFirstChild(output);
        // begin-custom-code
        // add your own business code here
        // end-custom-code
        return resultList;
    }
    
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
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
 	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
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
