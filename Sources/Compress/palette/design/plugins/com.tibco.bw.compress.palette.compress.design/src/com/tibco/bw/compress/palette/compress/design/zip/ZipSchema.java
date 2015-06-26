package com.tibco.bw.compress.palette.compress.design.zip;
import org.eclipse.xsd.XSDElementDeclaration;
import com.tibco.bw.design.api.BWExtensionActivitySchema;
import java.io.InputStream;
import org.eclipse.xsd.XSDSchema;
import java.util.ArrayList;
import java.util.List;

public class ZipSchema extends BWExtensionActivitySchema 

{
	private static ZipSchema INSTANCE = new ZipSchema();
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * File location.
	 */
	private static final String SCHEMA_FILE_PATH = "/schema/ZipSchema.xsd";
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * The name of the input element.
	 */
	private static final String INPUT_TYPE_ELEMENT_NAME = "ZipInput";
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * The name of the output element.
	 */
	private static final String OUTPUT_TYPE_ELEMENT_NAME = "ZipOutput";
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * The name of the fault elements
	 */
    private static final String[] COMPRESS_PLUGIN_FAULT_TYPE_ELEMENT_NAMES = new String[] { "ZipFault" }; //$NON-NLS-1$
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * Get the input element according to the input name.
	 *
	 * @return input element
	 */
	public static XSDElementDeclaration getInputType() {
     	XSDSchema activitySignatureSchema = INSTANCE.loadSchema();
		XSDElementDeclaration activityInputType = null;
		if (activitySignatureSchema != null) {
			activityInputType = activitySignatureSchema.resolveElementDeclaration(INPUT_TYPE_ELEMENT_NAME);
		}
		// begin-custom-code
        // end-custom-code
		return activityInputType;
	}

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * Get the output element according to the output name.
	 *
	 * @return output element
	 */
	public static XSDElementDeclaration getOutputType() {
     	XSDSchema activitySignatureSchema = INSTANCE.loadSchema(); 
		XSDElementDeclaration activityOutputType = null;
		if (activitySignatureSchema != null) {
			activityOutputType = activitySignatureSchema.resolveElementDeclaration(OUTPUT_TYPE_ELEMENT_NAME);
		}
		// begin-custom-code
        // end-custom-code
		return activityOutputType;
	}	
	
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * Get the fault elements according to the fault names.
	 *
	 * @return list of fault elements
	 */
   public static List<XSDElementDeclaration> getFaultElements() {
      List<XSDElementDeclaration> faultTypeElements = new ArrayList<XSDElementDeclaration>();
      XSDSchema faultSchema = INSTANCE.loadSchema(); 
      if(faultSchema != null) {
         for (String faultElementName : COMPRESS_PLUGIN_FAULT_TYPE_ELEMENT_NAMES) {
            XSDElementDeclaration faultTypesElement = faultSchema.resolveElementDeclaration(faultElementName);
            if(faultTypesElement != null) {
               faultTypeElements.add(faultTypesElement);
            }
         }
      }
      
      // begin-custom-code
      // end-custom-code
      return faultTypeElements;
    }

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 *
	 * Use the Java class loader to find and create a stream to the resource based on schema location in the workspace.
	 * @return stream to read the schema resource.	
	 */
	@Override
	protected InputStream getSchemaAsInputStream() {
		return this.getClass().getResourceAsStream(SCHEMA_FILE_PATH);
	}
	
}
