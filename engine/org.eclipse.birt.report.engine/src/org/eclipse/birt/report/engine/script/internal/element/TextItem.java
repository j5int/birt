/*******************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.script.internal.element;

import org.eclipse.birt.report.engine.api.script.ScriptException;
import org.eclipse.birt.report.engine.api.script.element.ITextItem;
import org.eclipse.birt.report.model.api.TextItemHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;

public class TextItem extends ReportItem implements ITextItem {

	public TextItem(TextItemHandle text) {
		super(text);
	}

	public TextItem(org.eclipse.birt.report.model.api.simpleapi.ITextItem textImpl) {
		super(textImpl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.engine.api.script.element.ITextItem#getContent()
	 */

	public String getContent() {
		return ((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).getContent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.api.script.element.ITextItem#getDisplayContent
	 * ()
	 */

	public String getDisplayContent() {
		return ((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).getDisplayContent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.api.script.element.ITextItem#setContent(java.
	 * lang.String)
	 */

	public void setContent(String value) throws ScriptException {
		try {
			((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).setContent(value);
		} catch (SemanticException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.api.script.element.ITextItem#getContentType()
	 */

	public String getContentType() {
		return ((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).getContentType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.api.script.element.ITextItem#setContentType(
	 * java.lang.String)
	 */

	public void setContentType(String contentType) throws ScriptException {
		try {
			((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).setContentType(contentType);
		} catch (SemanticException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.api.script.element.ITextItem#getContentKey()
	 */

	public String getContentKey() {
		return ((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).getContentKey();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.api.script.element.ITextItem#setContentKey(
	 * java.lang.String)
	 */

	public void setContentKey(String resourceKey) throws ScriptException {
		try {
			((org.eclipse.birt.report.model.api.simpleapi.ITextItem) designElementImpl).setContentKey(resourceKey);
		} catch (SemanticException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}
}
