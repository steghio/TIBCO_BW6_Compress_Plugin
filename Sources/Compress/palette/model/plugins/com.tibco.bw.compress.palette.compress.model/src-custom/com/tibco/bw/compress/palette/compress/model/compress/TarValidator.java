package com.tibco.bw.compress.palette.compress.model.compress;

import com.tibco.bw.compress.palette.compress.model.compress.Tar;
import com.tibco.bw.validation.process.ActivityConfigurationValidator;
import com.tibco.bw.validation.process.ActivityValidationContext;

public class TarValidator implements ActivityConfigurationValidator {	
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 * Validates Activity model configuration.
	 * @param context
	 *			The activity validation context.Developers can retrieve following informations:
	 *          <li> Activity Configuration Model(EMF model)</li>
 	 *          <li> Name of the EventSource Activity</li>
     *          <li> Value of process property used in Activity Configuration</li>
     *          <li> Name of property configured in the Attribute Binding Field</li>
     *          <li> Name of the process</li><br>
	 */	
	@Override
	public void validateBWActivityConfiguration(ActivityValidationContext context) {
	    @SuppressWarnings("unused")
	    Tar model =(Tar) context.getActivityConfigurationModel();    	
			
		// begin-custom-code
	    // end-custom-code
  	}
}
