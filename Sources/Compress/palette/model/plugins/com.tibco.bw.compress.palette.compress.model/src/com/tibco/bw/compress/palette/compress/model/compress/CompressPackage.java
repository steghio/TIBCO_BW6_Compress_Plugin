/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.compress.palette.compress.model.compress;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.tibco.bw.compress.palette.compress.model.compress.CompressFactory
 * @model kind="package"
 * @generated
 */
public interface CompressPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "compress";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://ns.tibco.com/bw/palette/compress";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "compress";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CompressPackage eINSTANCE = com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl.init();

  /**
   * The meta object id for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.ZipImpl <em>Zip</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.ZipImpl
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getZip()
   * @generated
   */
  int ZIP = 0;

  /**
   * The number of structural features of the '<em>Zip</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ZIP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.UnzipImpl <em>Unzip</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.UnzipImpl
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getUnzip()
   * @generated
   */
  int UNZIP = 1;

  /**
   * The number of structural features of the '<em>Unzip</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNZIP_FEATURE_COUNT = 0;


  /**
   * The meta object id for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.GZDeflateImpl <em>GZ Deflate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.GZDeflateImpl
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getGZDeflate()
   * @generated
   */
  int GZ_DEFLATE = 2;

  /**
   * The number of structural features of the '<em>GZ Deflate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GZ_DEFLATE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.GZInflateImpl <em>GZ Inflate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.GZInflateImpl
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getGZInflate()
   * @generated
   */
  int GZ_INFLATE = 3;

  /**
   * The number of structural features of the '<em>GZ Inflate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GZ_INFLATE_FEATURE_COUNT = 0;


  /**
   * The meta object id for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.TarImpl <em>Tar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.TarImpl
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getTar()
   * @generated
   */
  int TAR = 4;

  /**
   * The number of structural features of the '<em>Tar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.UntarImpl <em>Untar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.UntarImpl
   * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getUntar()
   * @generated
   */
  int UNTAR = 5;

  /**
   * The number of structural features of the '<em>Untar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTAR_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link com.tibco.bw.compress.palette.compress.model.compress.Zip <em>Zip</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Zip</em>'.
   * @see com.tibco.bw.compress.palette.compress.model.compress.Zip
   * @generated
   */
  EClass getZip();

  /**
   * Returns the meta object for class '{@link com.tibco.bw.compress.palette.compress.model.compress.Unzip <em>Unzip</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unzip</em>'.
   * @see com.tibco.bw.compress.palette.compress.model.compress.Unzip
   * @generated
   */
  EClass getUnzip();

  /**
   * Returns the meta object for class '{@link com.tibco.bw.compress.palette.compress.model.compress.GZDeflate <em>GZ Deflate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>GZ Deflate</em>'.
   * @see com.tibco.bw.compress.palette.compress.model.compress.GZDeflate
   * @generated
   */
  EClass getGZDeflate();

  /**
   * Returns the meta object for class '{@link com.tibco.bw.compress.palette.compress.model.compress.GZInflate <em>GZ Inflate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>GZ Inflate</em>'.
   * @see com.tibco.bw.compress.palette.compress.model.compress.GZInflate
   * @generated
   */
  EClass getGZInflate();

  /**
   * Returns the meta object for class '{@link com.tibco.bw.compress.palette.compress.model.compress.Tar <em>Tar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tar</em>'.
   * @see com.tibco.bw.compress.palette.compress.model.compress.Tar
   * @generated
   */
  EClass getTar();

  /**
   * Returns the meta object for class '{@link com.tibco.bw.compress.palette.compress.model.compress.Untar <em>Untar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Untar</em>'.
   * @see com.tibco.bw.compress.palette.compress.model.compress.Untar
   * @generated
   */
  EClass getUntar();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CompressFactory getCompressFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.ZipImpl <em>Zip</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.ZipImpl
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getZip()
     * @generated
     */
    EClass ZIP = eINSTANCE.getZip();

    /**
     * The meta object literal for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.UnzipImpl <em>Unzip</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.UnzipImpl
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getUnzip()
     * @generated
     */
    EClass UNZIP = eINSTANCE.getUnzip();

    /**
     * The meta object literal for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.GZDeflateImpl <em>GZ Deflate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.GZDeflateImpl
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getGZDeflate()
     * @generated
     */
    EClass GZ_DEFLATE = eINSTANCE.getGZDeflate();

    /**
     * The meta object literal for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.GZInflateImpl <em>GZ Inflate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.GZInflateImpl
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getGZInflate()
     * @generated
     */
    EClass GZ_INFLATE = eINSTANCE.getGZInflate();

    /**
     * The meta object literal for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.TarImpl <em>Tar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.TarImpl
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getTar()
     * @generated
     */
    EClass TAR = eINSTANCE.getTar();

    /**
     * The meta object literal for the '{@link com.tibco.bw.compress.palette.compress.model.compress.impl.UntarImpl <em>Untar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.UntarImpl
     * @see com.tibco.bw.compress.palette.compress.model.compress.impl.CompressPackageImpl#getUntar()
     * @generated
     */
    EClass UNTAR = eINSTANCE.getUntar();

  }

} //CompressPackage
