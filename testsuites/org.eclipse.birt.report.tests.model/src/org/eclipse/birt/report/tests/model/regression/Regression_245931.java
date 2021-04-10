/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Actuate Corporation -
 * initial API and implementation
 ******************************************************************************/

package org.eclipse.birt.report.tests.model.regression;

import org.eclipse.birt.report.model.api.AutoTextHandle;
import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.DesignEngine;
import org.eclipse.birt.report.model.api.LibraryHandle;
import org.eclipse.birt.report.model.api.SessionHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.birt.report.model.api.elements.DesignChoiceConstants;
import org.eclipse.birt.report.tests.model.BaseTestCase;

import com.ibm.icu.util.ULocale;

/**
 * <b>Bug Description:</b>
 * <p>
 * AutoText Label display NewAutoText in library
 * <p>
 * <b>Test Description:</b>
 * <p>
 * AutoText display correct label in library master page
 * </p>
 */
public class Regression_245931 extends BaseTestCase {

	public void test_regression_245931() throws SemanticException {
		DesignEngine engine = new DesignEngine(new DesignConfig());
		SessionHandle session = engine.newSessionHandle(ULocale.ENGLISH);
		LibraryHandle libraryHandle = session.createLibrary();

		AutoTextHandle autoTextHandle = libraryHandle.getElementFactory().newAutoText("autotext1");
		autoTextHandle.setAutoTextType(DesignChoiceConstants.AUTO_TEXT_PAGE_NUMBER);

		assertEquals("Page Number", autoTextHandle.getDisplayLabel());

	}

}
