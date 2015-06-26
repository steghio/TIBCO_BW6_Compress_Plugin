package com.tibco.bw.compress.palette.compress.design.unzip;

import org.eclipse.emf.ecore.EObject;
import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.compress.palette.compress.model.compress.CompressFactory;
import com.tibco.bw.compress.palette.compress.model.compress.Unzip;

public class UnzipModelHelper extends BWAbstractModelHelper 

{

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * Create an instance of the activity configuration model and provide "good" default values.
	 *
	 * @return new instance
	 */
    @Override
    public EObject createInstance() {
        Unzip activity = CompressFactory.eINSTANCE.createUnzip();
        // begin-custom-code
        // end-custom-code
        return activity;
    }
}
