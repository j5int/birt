/*******************************************************************************
 * Copyright (c) 2007 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.designer.ui.templates;

/**
 * ITemplateProvider
 */
public interface ITemplateProvider {

	/**
	 * Gets the provider ID.
	 * 
	 * @return
	 */
	String getParentBaseName();

	/**
	 * Gets the entries.
	 * 
	 * @return
	 */
	ITemplateEntry[] getTemplates();

	/**
	 * Release the resources allocated if applicable.
	 */
	void release();

}
