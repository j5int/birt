/*******************************************************************************
 * Copyright (c) 2004, 2008 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.data.dte;

import java.io.IOException;

import org.eclipse.birt.core.archive.IDocArchiveReader;
import org.eclipse.birt.report.engine.api.InstanceID;

public class DocumentDataSource {

	IDocArchiveReader dataSource;
	InstanceID iid;
	String bookmark;

	public DocumentDataSource(IDocArchiveReader dataSource) {
		this(dataSource, null, null);
	}

	public DocumentDataSource(IDocArchiveReader dataSource, String bookmark, InstanceID iid) {
		this.dataSource = dataSource;
		this.bookmark = bookmark;
		if (iid != null) {
			this.iid = iid;
		}
	}

	public boolean isReportletDocument() {
		return bookmark != null && iid != null;
	}

	public void open() throws IOException {
		dataSource.open();
	}

	public void close() throws IOException {
		dataSource.close();
	}

	public IDocArchiveReader getDataSource() {
		return dataSource;
	}

	public InstanceID getInstanceID() {
		return iid;
	}

	public long getElementID() {
		if (iid != null) {
			return iid.getComponentID();
		}
		return -1;
	}

	public String getBookmark() {
		return bookmark;
	}
}
