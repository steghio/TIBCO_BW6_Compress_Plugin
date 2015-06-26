package com.tibco.bw.compress.palette.compress.runtime.fault;

import javax.xml.namespace.QName;
import org.genxdm.ProcessingContext;
import com.tibco.bw.runtime.ActivityContext;
import com.tibco.neo.localized.BundleMessage;
public class CompressPluginException extends CompressActivityBaseException 
{
	private static final long serialVersionUID = 1L;
	
	public <N> CompressPluginException(ActivityContext<N> activityContext, Integer code,
			BundleMessage bundleMessage) {
		super(activityContext, code, bundleMessage);
	}
	
	/**
 	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	public QName getFaultElementQName() {
		// begin-custom-code
        // add your own business code here
        // end-custom-code
		return new QName("http://schemas.tibco.com/bw/plugins/Compress/CompressExceptions","CompressPluginException");
	}
	/**
 	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * This method to set fault data according to design time
	 * @param processingContext
	 *			XML processing context.  
	 */
	public <N> void buildFault(ProcessingContext<N> pcx) {
		N CompressPluginException = this.createFaultMessageElement(pcx);
		
		this.setData(CompressPluginException);
		// begin-custom-code
        // add your own business code here
        // end-custom-code
	}
	

}
