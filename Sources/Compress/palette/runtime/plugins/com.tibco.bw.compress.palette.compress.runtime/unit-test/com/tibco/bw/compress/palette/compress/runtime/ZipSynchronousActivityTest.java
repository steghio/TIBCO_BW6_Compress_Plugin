package com.tibco.bw.compress.palette.compress.runtime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class ZipSynchronousActivityTest 

{
	String expectedResult = null;

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Before
	public void setUp() throws Exception {
		// begin-custom-code
		// add your own business code here
		expectedResult = "result";
		// end-custom-code
	}
	
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@After
	public void tearDown() throws Exception {
		// begin-custom-code
		// add your own business code here
		
		// end-custom-code
	}
	
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Test
	public void testBusiness(){
		// begin-custom-code
		// add your own business code here
        String actualResult = "result";
	    Assert.assertEquals(expectedResult,actualResult);
		
		// end-custom-code
	}
	
}
