/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.compress.palette.compress.model.compress;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.tibco.bw.compress.palette.compress.model.compress.CompressPackage
 * @generated
 */
public interface CompressFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CompressFactory eINSTANCE = com.tibco.bw.compress.palette.compress.model.compress.impl.CompressFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Zip</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Zip</em>'.
   * @generated
   */
  Zip createZip();

  /**
   * Returns a new object of class '<em>Unzip</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unzip</em>'.
   * @generated
   */
  Unzip createUnzip();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CompressPackage getCompressPackage();

} //CompressFactory
