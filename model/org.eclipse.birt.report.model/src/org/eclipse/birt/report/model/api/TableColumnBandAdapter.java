/**
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.model.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.birt.report.model.api.elements.DesignChoiceConstants;
import org.eclipse.birt.report.model.api.elements.ReportDesignConstants;
import org.eclipse.birt.report.model.elements.Cell;
import org.eclipse.birt.report.model.elements.DroppingHelper;
import org.eclipse.birt.report.model.elements.ReportDesign;
import org.eclipse.birt.report.model.elements.TableGroup;
import org.eclipse.birt.report.model.elements.TableItem;

/**
 * Represents an object of copied objects when do copy/paste operations between
 * tables.
 */

public final class TableColumnBandAdapter extends ColumnBandAdapter
{

	/**
	 * The element where the copy/paste operation occurs.
	 */

	protected TableHandle element;

	TableColumnBandAdapter( )
	{
	}

	TableColumnBandAdapter( ColumnBandData data )
	{
		super( data );
	}

	protected ColumnBandData copyColumn( TableHandle target, int columnNumber )
			throws SemanticException
	{
		assert target != null;

		element = target;

		return super.copyColumnBand( columnNumber );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.ColumnBandAdapter#getDesign()
	 */

	protected ReportDesign getDesign( )
	{
		return element.getDesign( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.ColumnBandAdapter#getElement()
	 */

	protected ReportItemHandle getElementHandle( )
	{
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.ColumnBandAdapter#getColumns()
	 */

	protected SlotHandle getColumns( )
	{
		return element.getColumns( );
	}

	/**
	 * Returns copied cells with the column number.
	 * 
	 * @param columnIndex
	 *            the column number
	 * @return new cell instances
	 */

	protected List getCellsUnderColumn( int columnIndex )
	{
		List cells = new ArrayList( );

		cells.addAll( getCellsInSlot( element.getHeader( ), columnIndex ) );

		SlotHandle groups = element.getGroups( );
		for ( int i = 0; i < groups.getCount( ); i++ )
		{
			GroupHandle group = (GroupHandle) groups.get( i );
			cells.addAll( getCellsInSlot( group.getHeader( ), columnIndex ) );
			cells.addAll( getCellsInSlot( group.getFooter( ), columnIndex ) );
		}

		cells.addAll( getCellsInSlot( element.getDetail( ), columnIndex ) );
		cells.addAll( getCellsInSlot( element.getFooter( ), columnIndex ) );

		return cells;
	}

	/**
	 * Returns the column number with the given cell.
	 * 
	 * @param cell
	 *            the cell to find.
	 * @return the column number
	 */

	protected int getCellPosition( CellHandle cell )
	{
		return DroppingHelper.findCellColumn( getDesign( ), (TableItem) element
				.getElement( ), (Cell) cell.getElement( ) );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.ColumnBandAdapter#getNumberOfRows()
	 */

	protected int getRowCount( )
	{
		// treat the table as a regular layout.

		int numOfRows = 0;
		numOfRows += element.getHeader( ).getCount( );

		SlotHandle groups = element.getGroups( );
		for ( int i = 0; i < groups.getCount( ); i++ )
		{
			GroupHandle group = (GroupHandle) groups.get( i );
			numOfRows += group.getHeader( ).getCount( );
			numOfRows += group.getFooter( ).getCount( );
		}

		numOfRows += element.getDetail( ).getCount( );
		numOfRows += element.getFooter( ).getCount( );

		return numOfRows;
	}

	protected void pasteColumnBand( TableHandle target, int columnIndex,
			boolean inForce ) throws SemanticException
	{
		assert target != null;

		element = target;
		super.pasteColumnBand( columnIndex, inForce );
	}

	protected void insertAndPasteColumnBand( TableHandle target, int columnIndex )
			throws SemanticException
	{
		assert target != null;

		element = target;
		super.insertAndPasteColumnBand( columnIndex );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.ColumnBandAdapter#getColumnCount()
	 */

	protected int getColumnCount( )
	{
		return element.getColumnCount( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.ColumnBandAdapter#getRow(int, int,
	 *      int)
	 */

	protected RowHandle getRow( int slotId, int groupId, int rowNumber )
	{

		RowHandle row = null;

		if ( groupId == -1 )
			row = (RowHandle) element.getSlot( slotId ).get( rowNumber );
		else
		{
			GroupHandle group = (GroupHandle) element.getGroups( )
					.get( groupId );
			row = (RowHandle) group.getSlot( slotId ).get( rowNumber );
		}

		return row;
	}

	/**
	 * Checks whether any cell in <code>cells</code> has a value of
	 * <code>DesignChoiceConstants#DROP_TYPE_DETAIL</code> or
	 * <code>DesignChoiceConstants#DROP_TYPE_ALL</code> for the "drop"
	 * property.
	 * 
	 * @param cells
	 *            a list containing cell handles
	 * @return <code>true</code> if any cell has the "drop" property,
	 *         otherwise <code>false</code>.
	 */

	protected boolean hasDroppingCell( List cells )
	{
		for ( int i = 0; i < cells.size( ); i++ )
		{
			CellContextInfo cellInfo = (CellContextInfo) cells.get( i );
			String containerDefnName = cellInfo.getContainerDefnName( );
			int slotId = cellInfo.getSlotId( );

			if ( ReportDesignConstants.TABLE_GROUP_ELEMENT
					.equals( containerDefnName )
					&& slotId == TableGroup.HEADER_SLOT
					&& !DesignChoiceConstants.DROP_TYPE_NONE
							.equalsIgnoreCase( cellInfo.getDrop( ) ) )
				return true;

		}
		return false;
	}

	/**
	 * Checks whether the paste operation can be done with the given copied
	 * column band data, the column index and the operation flag.
	 * 
	 * @param table
	 *            the table for the paste operation 
	 * @param columnIndex
	 *            the column index
	 * @param inForce
	 *            <code>true</code> indicates to paste the column regardless
	 *            of the different layout of cells. <code>false</code>
	 *            indicates not.
	 * @return <code>true</code> indicates the paste operation can be done.
	 *         Otherwise <code>false</code>.
	 */

	protected boolean canPaste( TableHandle table, int columnIndex,
			boolean inForce )
	{
		assert table != null;

		element = table;

		return super.canPaste( columnIndex, inForce );
	}

	/**
	 * Tests whether the copied data can be inserted into the next position of
	 * <code>columnIndex</code>.
	 * 
	 * @param table
	 *            the table where the data to be inserted
	 * @param columnIndex
	 *            the column index
	 * @return <code>true</code> if the insertion can be done. Otherwise
	 *         <code>false</code>.
	 */

	protected boolean canInsertAndPaste( TableHandle table, int columnIndex )
	{
		assert table != null;
		element = table;

		return super.canInsertAndPaste( columnIndex );
	}
}
