/*******************************************************************************
 * Copyright (c) 2013 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/
package org.eclipse.birt.data.oda.pojo.api;

import org.eclipse.datatools.connectivity.oda.OdaException;

import org.eclipse.birt.data.oda.pojo.api.IPojoDataSet;
import org.eclipse.birt.data.oda.pojo.api.PojoDataSetFromArray;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 */

public class PojoDataSetFromArrayTest {
	@SuppressWarnings("nls")
	@Test
	public void testNext() throws OdaException {
		IPojoDataSet pds = new PojoDataSetFromArray() {
			@Override
			protected Object[] fetchPojos() throws OdaException {
				return null;
			}
		};
		pds.open(null, null);
		assertTrue(pds.next() == null);
		pds.close();

		pds = new PojoDataSetFromArray() {
			@Override
			protected Object[] fetchPojos() throws OdaException {
				return new Object[0];
			}
		};
		pds.open(null, null);
		assertTrue(pds.next() == null);
		pds.close();

		pds = new PojoDataSetFromArray() {
			@Override
			protected Object[] fetchPojos() throws OdaException {
				return new Object[] { "1", "2", "3" };
			}
		};
		pds.open(null, null);
		assertTrue(pds.next().equals("1"));
		assertTrue(pds.next().equals("2"));
		assertTrue(pds.next().equals("3"));
		assertTrue(pds.next() == null);
		pds.close();

		pds.open(null, null);
		assertTrue(pds.next().equals("1"));
		assertTrue(pds.next().equals("2"));
		assertTrue(pds.next().equals("3"));
		assertTrue(pds.next() == null);
		pds.close();

		pds = new PojoDataSetFromArray() {
			@Override
			protected Object[] fetchPojos() throws OdaException {
				return new Object[] { null, "1", null, null, "2", null, "3", null, null };
			}
		};

		pds.open(null, null);
		assertTrue(pds.next().equals("1"));
		assertTrue(pds.next().equals("2"));
		assertTrue(pds.next().equals("3"));
		assertTrue(pds.next() == null);
		pds.close();

		pds.open(null, null);
		assertTrue(pds.next().equals("1"));
		assertTrue(pds.next().equals("2"));
		assertTrue(pds.next().equals("3"));
		assertTrue(pds.next() == null);
		pds.close();
	}

}
