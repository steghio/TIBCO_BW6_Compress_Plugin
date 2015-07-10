/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.compress.palette.compress.model.compress.impl;

import com.tibco.bw.compress.palette.compress.model.compress.CompressFactory;
import com.tibco.bw.compress.palette.compress.model.compress.CompressPackage;
import com.tibco.bw.compress.palette.compress.model.compress.GZDeflate;
import com.tibco.bw.compress.palette.compress.model.compress.GZInflate;
import com.tibco.bw.compress.palette.compress.model.compress.Tar;
import com.tibco.bw.compress.palette.compress.model.compress.Untar;
import com.tibco.bw.compress.palette.compress.model.compress.Unzip;
import com.tibco.bw.compress.palette.compress.model.compress.Zip;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompressPackageImpl extends EPackageImpl implements CompressPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass zipEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unzipEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gzDeflateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gzInflateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass untarEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.tibco.bw.compress.palette.compress.model.compress.CompressPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CompressPackageImpl()
  {
    super(eNS_URI, CompressFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link CompressPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CompressPackage init()
  {
    if (isInited) return (CompressPackage)EPackage.Registry.INSTANCE.getEPackage(CompressPackage.eNS_URI);

    // Obtain or create and register package
    CompressPackageImpl theCompressPackage = (CompressPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompressPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompressPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theCompressPackage.createPackageContents();

    // Initialize created meta-data
    theCompressPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCompressPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CompressPackage.eNS_URI, theCompressPackage);
    return theCompressPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getZip()
  {
    return zipEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnzip()
  {
    return unzipEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGZDeflate()
  {
    return gzDeflateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGZInflate()
  {
    return gzInflateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTar()
  {
    return tarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUntar()
  {
    return untarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompressFactory getCompressFactory()
  {
    return (CompressFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    zipEClass = createEClass(ZIP);

    unzipEClass = createEClass(UNZIP);

    gzDeflateEClass = createEClass(GZ_DEFLATE);

    gzInflateEClass = createEClass(GZ_INFLATE);

    tarEClass = createEClass(TAR);

    untarEClass = createEClass(UNTAR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(zipEClass, Zip.class, "Zip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unzipEClass, Unzip.class, "Unzip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(gzDeflateEClass, GZDeflate.class, "GZDeflate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(gzInflateEClass, GZInflate.class, "GZInflate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tarEClass, Tar.class, "Tar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(untarEClass, Untar.class, "Untar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // dkactivityconfig
    createDkactivityconfigAnnotations();
  }

  /**
   * Initializes the annotations for <b>dkactivityconfig</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createDkactivityconfigAnnotations()
  {
    String source = "dkactivityconfig";		
    addAnnotation
      (zipEClass, 
       source, 
       new String[] 
       {
       "activitytype", "Synchronous",
       "schemaType", "XSD Editor",
       "schemaFile", "C:/bw6_workspace_test_pdk/Compress/palette/design/plugins/com.tibco.bw.compress.palette.compress.design/schema/ZipSchema.xsd",
       "inputelementname", "ZipInput",
       "outputelementname", "ZipOutput",
       "faultelementname", "ZipFault",
       "helpdocuuid", "0ef90eb7-6748-4fb2-bfc2-843662a21bd4"
       });		
    addAnnotation
      (unzipEClass, 
       source, 
       new String[] 
       {
       "activitytype", "Synchronous",
       "schemaType", "XSD Editor",
       "schemaFile", "C:/bw6_workspace_test_pdk/Compress/palette/design/plugins/com.tibco.bw.compress.palette.compress.design/schema/UnzipSchema.xsd",
       "inputelementname", "UnzipInput",
       "outputelementname", "UnzipOutput",
       "faultelementname", "UnzipFault",
       "helpdocuuid", "15bda2a5-9615-45c2-bf10-1fc94f53d0df"
       });		
    addAnnotation
      (gzDeflateEClass, 
       source, 
       new String[] 
       {
       "activitytype", "Synchronous",
       "schemaType", "XSD Editor",
       "schemaFile", "C:/bw6_workspace_test_pdk/Compress/palette/design/plugins/com.tibco.bw.compress.palette.compress.design/schema/GZDeflateSchema.xsd",
       "inputelementname", "GZDeflateInput",
       "outputelementname", "GZDeflateOutput",
       "faultelementname", "GZDeflateFault",
       "helpdocuuid", "6dd301d2-a8ed-4f2d-88e7-3f5056707b92"
       });		
    addAnnotation
      (gzInflateEClass, 
       source, 
       new String[] 
       {
       "activitytype", "Synchronous",
       "schemaType", "XSD Editor",
       "schemaFile", "C:/bw6_workspace_test_pdk/Compress/palette/design/plugins/com.tibco.bw.compress.palette.compress.design/schema/GZInflateSchema.xsd",
       "inputelementname", "GZInflateInput",
       "outputelementname", "GZInflateOutput",
       "faultelementname", "GZInflateFault",
       "helpdocuuid", "df66cbe3-1430-4cb5-8475-c0446752f060"
       });		
    addAnnotation
      (tarEClass, 
       source, 
       new String[] 
       {
       "activitytype", "Synchronous",
       "schemaType", "XSD Editor",
       "schemaFile", "C:/bw6_workspace_test_pdk/Compress/palette/design/plugins/com.tibco.bw.compress.palette.compress.design/schema/TarSchema.xsd",
       "inputelementname", "TarInput",
       "outputelementname", "TarOutput",
       "faultelementname", "TarFault",
       "helpdocuuid", "c76d7bf6-585b-4e3a-8675-a321b1bb72a1"
       });		
    addAnnotation
      (untarEClass, 
       source, 
       new String[] 
       {
       "activitytype", "Synchronous",
       "schemaType", "XSD Editor",
       "schemaFile", "C:/bw6_workspace_test_pdk/Compress/palette/design/plugins/com.tibco.bw.compress.palette.compress.design/schema/UntarSchema.xsd",
       "inputelementname", "UntarInput",
       "outputelementname", "UntarOutput",
       "faultelementname", "UntarFault",
       "helpdocuuid", "16850792-337f-4a0f-8f48-2b94e0b2ee0e"
       });
  }

} //CompressPackageImpl
