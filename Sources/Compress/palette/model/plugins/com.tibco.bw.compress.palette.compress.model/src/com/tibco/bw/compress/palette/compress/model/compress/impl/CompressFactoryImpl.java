/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.compress.palette.compress.model.compress.impl;

import com.tibco.bw.compress.palette.compress.model.compress.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompressFactoryImpl extends EFactoryImpl implements CompressFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CompressFactory init()
  {
    try
    {
      CompressFactory theCompressFactory = (CompressFactory)EPackage.Registry.INSTANCE.getEFactory("http://ns.tibco.com/bw/palette/compress"); 
      if (theCompressFactory != null)
      {
        return theCompressFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CompressFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompressFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case CompressPackage.ZIP: return createZip();
      case CompressPackage.UNZIP: return createUnzip();
      case CompressPackage.GZ_DEFLATE: return createGZDeflate();
      case CompressPackage.GZ_INFLATE: return createGZInflate();
      case CompressPackage.TAR: return createTar();
      case CompressPackage.UNTAR: return createUntar();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Zip createZip()
  {
    ZipImpl zip = new ZipImpl();
    return zip;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Unzip createUnzip()
  {
    UnzipImpl unzip = new UnzipImpl();
    return unzip;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GZDeflate createGZDeflate()
  {
    GZDeflateImpl gzDeflate = new GZDeflateImpl();
    return gzDeflate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GZInflate createGZInflate()
  {
    GZInflateImpl gzInflate = new GZInflateImpl();
    return gzInflate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tar createTar()
  {
    TarImpl tar = new TarImpl();
    return tar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Untar createUntar()
  {
    UntarImpl untar = new UntarImpl();
    return untar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompressPackage getCompressPackage()
  {
    return (CompressPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CompressPackage getPackage()
  {
    return CompressPackage.eINSTANCE;
  }

} //CompressFactoryImpl
