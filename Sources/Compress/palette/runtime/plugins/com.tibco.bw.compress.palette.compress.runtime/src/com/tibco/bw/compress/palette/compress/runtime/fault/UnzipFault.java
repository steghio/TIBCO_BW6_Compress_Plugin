/**
 * Author: Stefano Ghio
 * Version: 1.0.0.FINAL
 * BW Version: 6.2.1-HF3
 */

package com.tibco.bw.compress.palette.compress.runtime.fault;

import javax.xml.namespace.QName;
import org.genxdm.ProcessingContext;
import com.tibco.bw.runtime.ActivityContext;
import com.tibco.neo.localized.BundleMessage;
/*import org.genxdm.mutable.MutableModel;
import org.genxdm.mutable.NodeFactory;
import org.genxdm.typed.types.AtomBridge;
import org.genxdm.typed.TypedContext;*/
public class UnzipFault extends CompressActivityBaseException 
{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private Object data = null;
	
	public <N> UnzipFault(ActivityContext<N> activityContext, Integer code,
			BundleMessage bundleMessage, Object [] data) {
		super(activityContext, code, bundleMessage, data);
		this.data = data;
	}
	
	/**
	 * @generated
	 */
	public QName getFaultElementQName() {
		return new QName("http://schemas.tibco.com/bw/plugins/Compress/CompressExceptions","UnzipFault");
	}
	/**
	 * @generated
	 *
	 * This method to set fault data according to design time
	 * @param processingContext
	 *			XML processing context.  
	 */
	public <N> void buildFault(ProcessingContext<N> pcx) {
		N UnzipFault = this.createFaultMessageElement(pcx);
		//NOT needed since retCode and retMsg are added by default!
		//UnzipFault = this.constructErrData(UnzipFault, pcx);
		this.setData(UnzipFault);
	}
	
	/**
	 * @generated
	 *
	 * This method to generate fault data
	 * @param UnzipFault
	 *			the root element of fault		
	 * @param processingContext
	 *			XML processing context.  
	 * @return An XML Element which adheres to the fault schema of the activity
	 */
	//NOT needed since retCode and retMsg are added by default!
	/*private <N, A> N constructErrData(N UnzipFault, ProcessingContext<N> processingContext) {
		MutableModel<N> mutableModel = processingContext.getMutableContext().getModel();
		
        TypedContext<N, A> tc = processingContext.getTypedContext(null);
	    AtomBridge<A> atomBridge = tc.getAtomBridge();
	    A atom = null;
	    
		NodeFactory<N> noteFactory = mutableModel.getFactory(UnzipFault);
		
		//if the element's MaxOccurs and MinOccurs are 1, that means this element's size is 1
		N retCode = noteFactory.createElement("", "retCode", "");
		mutableModel.appendChild(UnzipFault, retCode);

		atom = atomBridge.createInteger(new Integer(0));
		N retCodevalueNode = noteFactory.createText(atomBridge.getC14NForm(atom));
		mutableModel.appendChild(retCode, retCodevalueNode);
		
		//if the element's MinOccurs are 0, that means this element is option, it is depends on your business, if there is data, you can create node for it
		N retMsg = noteFactory.createElement("", "retMsg", "");
		mutableModel.appendChild(UnzipFault, retMsg);

		N retMsgvalueNode = noteFactory.createText("string value");
		mutableModel.appendChild(retMsg, retMsgvalueNode);
		return UnzipFault;
	}*/

}
