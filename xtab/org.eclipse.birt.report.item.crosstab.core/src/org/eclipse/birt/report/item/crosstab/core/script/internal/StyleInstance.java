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

package org.eclipse.birt.report.item.crosstab.core.script.internal;

import org.eclipse.birt.report.engine.api.script.ScriptException;
import org.eclipse.birt.report.engine.api.script.instance.IScriptStyle;
import org.eclipse.birt.report.engine.content.IStyle;
import org.eclipse.birt.report.engine.css.engine.value.DataFormatValue;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSValue;

/**
 * A class representing the style of a report item in the scripting environment
 */
public class StyleInstance implements IScriptStyle {

	private IStyle style;

	public StyleInstance(IStyle style) {
		this.style = style;
	}

	public String getVisibleFormat() {
		return style.getVisibleFormat();
	}

	public void setVisibleFormat(String format) {
		style.setVisibleFormat(format);
	}

	/**
	 * Get the letter spacing
	 */
	public String getLetterSpacing() {
		return style.getLetterSpacing();
	}

	/**
	 * Set the letter spacing
	 */
	public void setLetterSpacing(String spacing) {
		style.setLetterSpacing(spacing);
	}

	/**
	 * Get the line height
	 */
	public String getLineHeight() {
		return style.getLineHeight();
	}

	/**
	 * Set the line height
	 */
	public void setLineHeight(String lineHeight) {
		style.setLineHeight(lineHeight);
	}

	/**
	 * Get the text alignment. Valid return types are LEFT, RIGHT, CENTER and
	 * JUSTIFY.
	 */
	public String getTextAlign() {
		return style.getTextAlign();
	}

	/**
	 * Set the text alignment. Valid return types are LEFT, RIGHT, CENTER and
	 * JUSTIFY.
	 */
	public void setTextAlign(String align) {
		style.setTextAlign(align);
	}

	/**
	 * Get the text indent
	 */
	public String getTextIndent() {
		return style.getTextIndent();
	}

	/**
	 * Get the text indent
	 */
	public void setTextIndent(String indent) {
		style.setTextIndent(indent);
	}

	/**
	 * Get the text transform. Valid return values are NONE, CAPITALIZE, UPPERCASE
	 * and LOWERCASE.
	 */
	public String getTextTransform() {
		return style.getTextTransform();
	}

	/**
	 * Set the text transform. Valid transform values are NONE, CAPITALIZE,
	 * UPPERCASE and LOWERCASE.
	 */
	public void setTextTransform(String transform) {
		style.setTextTransform(transform);
	}

	/**
	 * Get the vertical alignment. Valid return values are BASELINE, SUB, SUPER,
	 * TOP, TEXT_TOP, MIDDLE, BOTTOM and TEXT_BOTTOM
	 */
	public String getVerticalAlign() {
		return style.getVerticalAlign();
	}

	/**
	 * Set the vertical alignment. Valid values are BASELINE, SUB, SUPER, TOP,
	 * TEXT_TOP, MIDDLE, BOTTOM and TEXT_BOTTOM
	 */
	public void setVerticalAlign(String valign) {
		style.setVerticalAlign(valign);
	}

	/**
	 * Get the whitespace. Valid return values are NORMAL, PRE and NOWRAP
	 */
	public String getWhiteSpace() {
		return style.getWhiteSpace();
	}

	/**
	 * Get the whitespace. Valid return values are NORMAL, PRE and NOWRAP
	 */
	public void setWhiteSpace(String whitespace) {
		style.setWhiteSpace(whitespace);
	}

	/**
	 * Get the word spacing
	 */
	public String getWordSpacing() {
		return style.getWordSpacing();
	}

	/**
	 * Set the word spacing
	 */
	public void setWordSpacing(String wordspacing) {
		style.setWordSpacing(wordspacing);
	}

	/**
	 * Get the font color
	 */
	public String getColor() {
		return style.getColor();
	}

	/**
	 * Set the font color
	 */
	public void setColor(String color) {
		style.setColor(color);
	}

	/**
	 * Get the attachement type (either SCROLL or FIXED)
	 * 
	 * @deprecated replaced by getBackgroundAttachment()
	 */
	public String getBackgroundAttachement() {
		return style.getBackgroundAttachment();
	}

	/**
	 * Set the attachement type (either SCROLL or FIXED)
	 * 
	 * @deprecated replaced by setBackgroundAttachment( String attachment )
	 */
	public void setBackgroundAttachement(String attachement) {
		style.setBackgroundAttachment(attachement);
	}

	/**
	 * Get the attachment type (either SCROLL or FIXED)
	 */
	public String getBackgroundAttachment() {
		return style.getBackgroundAttachment();
	}

	/**
	 * Set the attachment type (either SCROLL or FIXED)
	 */
	public void setBackgroundAttachment(String attachment) {
		style.setBackgroundAttachment(attachment);
	}

	/**
	 * Get the background color
	 */
	public String getBackgroundColor() {
		return style.getBackgroundColor();
	}

	/**
	 * Set the background color
	 */
	public void setBackgroundColor(String color) {
		style.setBackgroundColor(color);
	}

	/**
	 * Get the background image URI
	 */
	public String getBackgroundImage() {
		return style.getBackgroundImage();
	}

	/**
	 * Set the background image URI
	 */
	public void setBackgroundImage(String imageURI) {
		style.setBackgroundImage(imageURI);
	}

	/**
	 * Get the background repeat type (valid types are REPEAT, REPEAT_X, REPEAT_Y
	 * and NO_REPEAT)
	 */
	public String getBackgroundRepeat() {
		return style.getBackgroundRepeat();
	}

	/**
	 * Set the background repeat type (valid types are REPEAT, REPEAT_X, REPEAT_Y
	 * and NO_REPEAT)
	 */
	public void setBackgroundRepeat(String repeat) {
		style.setBackgroundRepeat(repeat);
	}

	/**
	 * Get the bottom border color
	 */
	public String getBorderBottomColor() {
		return style.getBorderBottomColor();
	}

	/**
	 * Set the bottom border color
	 */
	public void setBorderBottomColor(String color) {
		style.setBorderBottomColor(color);
	}

	/**
	 * Get the top border color
	 */
	public String getBorderTopColor() {
		return style.getBorderTopColor();
	}

	/**
	 * Set the top border color
	 */
	public void setBorderTopColor(String color) {
		style.setBorderTopColor(color);
	}

	/**
	 * Get the right border color
	 */
	public String getBorderRightColor() {
		return style.getBorderRightColor();
	}

	/**
	 * Set the right border color
	 */
	public void setBorderRightColor(String color) {
		style.setBorderRightColor(color);
	}

	/**
	 * Get the left border color
	 */
	public String getBorderLeftColor() {
		return style.getBorderLeftColor();
	}

	/**
	 * Set the left border color
	 */
	public void setBorderLeftColor(String color) {
		style.setBorderLeftColor(color);
	}

	/**
	 * Get the bottom border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public String getBorderBottomStyle() {
		return style.getBorderBottomStyle();
	}

	/**
	 * Set the bottom border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public void setBorderBottomStyle(String borderstyle) {
		style.setBorderBottomStyle(borderstyle);
	}

	/**
	 * Get the top border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public String getBorderTopStyle() {
		return style.getBorderTopStyle();
	}

	/**
	 * Set the top border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public void setBorderTopStyle(String borderstyle) {
		style.setBorderTopStyle(borderstyle);
	}

	/**
	 * Get the left border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public String getBorderLeftStyle() {
		return style.getBorderLeftStyle();
	}

	/**
	 * Set the left border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public void setBorderLeftStyle(String borderstyle) {
		style.setBorderLeftStyle(borderstyle);
	}

	/**
	 * Get the right border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public String getBorderRightStyle() {
		return style.getBorderRightStyle();
	}

	/**
	 * Set the right border style. Valid styles are NONE, SOLID, DOTTED, DASHED,
	 * DOUBLE, GROVE, RIDGE, INSET and OUTSET.
	 */
	public void setBorderRightStyle(String borderstyle) {
		style.setBorderRightStyle(borderstyle);
	}

	/**
	 * Get the bottom border width.
	 */
	public String getBorderBottomWidth() {
		return style.getBorderBottomWidth();
	}

	/**
	 * Set the bottom border width.
	 */
	public void setBorderBottomWidth(String width) {
		style.setBorderBottomWidth(width);
	}

	/**
	 * Get the top border width.
	 */
	public String getBorderTopWidth() {
		return style.getBorderTopWidth();
	}

	/**
	 * Set the top border width.
	 */
	public void setBorderTopWidth(String width) {
		style.setBorderTopWidth(width);
	}

	/**
	 * Get the left border width.
	 */
	public String getBorderLeftWidth() {
		return style.getBorderLeftWidth();
	}

	/**
	 * Set the left border width.
	 */
	public void setBorderLeftWidth(String width) {
		style.setBorderLeftWidth(width);
	}

	/**
	 * Get the right border width.
	 */
	public String getBorderRightWidth() {
		return style.getBorderRightWidth();
	}

	/**
	 * Set the right border width.
	 */
	public void setBorderRightWidth(String width) {
		style.setBorderRightWidth(width);
	}

	/**
	 * Get the bottom margin
	 */
	public String getMarginBottom() {
		return style.getMarginBottom();
	}

	/**
	 * Set the bottom margin
	 */
	public void setMarginBottom(String margin) {
		style.setMarginBottom(margin);
	}

	/**
	 * Get the top margin
	 */
	public String getMarginTop() {
		return style.getMarginTop();
	}

	/**
	 * Set the top margin
	 */
	public void setMarginTop(String margin) {
		style.setMarginTop(margin);
	}

	/**
	 * Get the left margin
	 */
	public String getMarginLeft() {
		return style.getMarginLeft();
	}

	/**
	 * Set the left margin
	 */
	public void setMarginLeft(String margin) {
		style.setMarginLeft(margin);
	}

	/**
	 * Get the right margin
	 */
	public String getMarginRight() {
		return style.getMarginRight();
	}

	/**
	 * Set the right margin
	 */
	public void setMarginRight(String margin) {
		style.setMarginRight(margin);
	}

	/**
	 * Get the bottom padding.
	 */
	public String getPaddingBottom() {
		return style.getPaddingBottom();
	}

	/**
	 * Set the bottom padding.
	 */
	public void setPaddingBottom(String padding) {
		style.setPaddingBottom(padding);
	}

	/**
	 * Get the top padding.
	 */
	public String getPaddingTop() {
		return style.getPaddingTop();
	}

	/**
	 * Set the top padding.
	 */
	public void setPaddingTop(String padding) {
		style.setPaddingTop(padding);
	}

	/**
	 * Get the left padding.
	 */
	public String getPaddingLeft() {
		return style.getPaddingLeft();
	}

	/**
	 * Set the left padding.
	 */
	public void setPaddingLeft(String padding) {
		style.setPaddingLeft(padding);
	}

	/**
	 * Get the right padding.
	 */
	public String getPaddingRight() {
		return style.getPaddingRight();
	}

	/**
	 * Set the right padding.
	 */
	public void setPaddingRight(String padding) {
		style.setPaddingRight(padding);
	}

	/**
	 * Get the display type (valid types are BLOCK, INLINE and NONE)
	 */
	public String getDisplay() {
		return style.getDisplay();
	}

	/**
	 * Set the display type (valid types are BLOCK, INLINE and NONE)
	 */
	public void setDisplay(String display) {
		style.setDisplay(display);
	}

	/**
	 * Get the master page
	 */
	public String getMasterPage() {
		return style.getMasterPage();
	}

	/**
	 * Set the master page
	 */
	public void setMasterPage(String masterPage) {
		style.setMasterPage(masterPage);
	}

	/**
	 * Get the page break before.
	 */
	public String getPageBreakBefore() {
		return style.getPageBreakBefore();
	}

	/**
	 * Set the page break before
	 */
	public void setPageBreakBefore(String pageBreak) {
		style.setPageBreakBefore(pageBreak);
	}

	/**
	 * Get the page break after.
	 */
	public String getPageBreakAfter() {
		return style.getPageBreakAfter();
	}

	/**
	 * Set the page break after
	 */
	public void setPageBreakAfter(String pageBreak) {
		style.setPageBreakAfter(pageBreak);
	}

	/**
	 * Get the page break inside.
	 */
	public String getPageBreakInside() {
		return style.getPageBreakInside();
	}

	/**
	 * Set the page break inside
	 */
	public void setPageBreakInside(String pageBreak) {
		style.setPageBreakInside(pageBreak);
	}

	/**
	 * Show if blank?
	 */
	public String getShowIfBlank() {
		return style.getShowIfBlank();
	}

	/**
	 * Set show if blank
	 */
	public void setShowIfBlank(String showIfBlank) {
		style.setShowIfBlank(showIfBlank);
	}

	/**
	 * Can this element shrink?
	 */
	public String getCanShrink() {
		return style.getCanShrink();
	}

	/**
	 * Can this element shrink?
	 */
	public void setCanShrink(String canShrink) {
		style.setCanShrink(canShrink);
	}

	/**
	 * Get number format
	 * 
	 * @return the number format
	 */
	public String getNumberFormat() {
		return style.getNumberFormat();
	}

	/**
	 * Set the number format
	 * 
	 * @param numberFormat
	 */
	public void setNumberFormat(String numberFormat) {
		style.setNumberFormat(numberFormat);
	}

	/**
	 * Get the date format
	 * 
	 * @return date format
	 */
	public String getDateFormat() {
		return style.getDateFormat();
	}

	/**
	 * Set the date format
	 * 
	 * @param dateTimeFormat
	 */
	public void setDateFormat(String dateTimeFormat) {
		style.setDateFormat(dateTimeFormat);
	}

	/**
	 * Get the string format
	 * 
	 * @return the string format
	 */
	public String getStringFormat() {
		return style.getStringFormat();
	}

	/**
	 * Set the string format
	 * 
	 * @param stringFormat
	 */
	public void setStringFormat(String stringFormat) {
		style.setStringFormat(stringFormat);
	}

	public String getFontFamily() {
		return style.getFontFamily();
	}

	public void setFontFamily(String fontFamily) {
		style.setFontFamily(fontFamily);
	}

	public String getFontStyle() {
		return style.getFontStyle();
	}

	public void setFontStyle(String fontStyle) {
		style.setFontStyle(fontStyle);
	}

	public String getFontVariant() {
		return style.getFontVariant();
	}

	public void setFontVariant(String fontVariant) {
		style.setFontVariant(fontVariant);
	}

	public String getFontWeight() {
		return style.getFontWeight();
	}

	public void setFontWeight(String fontWeight) {
		style.setFontWeight(fontWeight);
	}

	public String getFontSize() {
		return style.getFontSize();
	}

	public void setFontSize(String fontSize) {
		style.setFontSize(fontSize);
	}

	public String getTextUnderline() {
		return style.getTextUnderline();
	}

	public void setTextUnderline(String underline) throws ScriptException {
		try {
			style.setTextUnderline(underline);
		} catch (DOMException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	public String getTextOverline() {
		return style.getTextOverline();
	}

	public void setTextOverline(String overline) throws ScriptException {
		try {
			style.setTextOverline(overline);
		} catch (DOMException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	public String getTextLineThrough() {
		return style.getTextLineThrough();
	}

	public void setTextLineThrough(String through) throws ScriptException {
		try {
			style.setTextLineThrough(through);
		} catch (DOMException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	public String getBackgroundPositionX() {
		return style.getBackgroundPositionX();
	}

	public void setBackgroundPositionX(String x) throws ScriptException {
		try {
			style.setBackgroundPositionX(x);
		} catch (DOMException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	public String getBackgroundPositionY() {
		return style.getBackgroundPositionY();
	}

	public void setBackgroundPositionY(String y) throws ScriptException {
		try {
			style.setBackgroundPositionY(y);
		} catch (DOMException e) {
			throw new ScriptException(e.getLocalizedMessage());
		}
	}

	public CSSValue getProperty(int index) {
		return style.getProperty(index);
	}

	/**
	 * Get the text direction. Valid return types are LTR and RTL.
	 * 
	 * @author bidi_hcg
	 */
	public String getDirection() {
		return style.getDirection();
	}

	/**
	 * Set the text direction. Valid return types are LTR and RTL.
	 * 
	 * @author bidi_hcg
	 */
	public void setDirection(String dir) {
		style.setDirection(dir);
	}

	public String getDateLocale() {
		DataFormatValue value = style.getDataFormat();
		if (value == null) {
			return null;
		}
		return value.getDateTimeLocale();
	}

	public String getNumberLocale() {
		DataFormatValue value = style.getDataFormat();
		if (value == null) {
			return null;
		}
		return value.getNumberLocale();
	}

	public String getStringLocale() {
		DataFormatValue value = style.getDataFormat();
		if (value == null) {
			return null;
		}
		return value.getStringLocale();
	}

	public void setDateLocale(String locale) {
		DataFormatValue oldValue = style.getDataFormat();
		DataFormatValue value = DataFormatValue.createDataFormatValue(oldValue);
		style.setDataFormat(value);
		value.setDateTimeFormat(oldValue == null ? null : oldValue.getDateTimePattern(), locale);
	}

	public void setNumberLocale(String locale) {
		DataFormatValue oldValue = style.getDataFormat();
		DataFormatValue value = DataFormatValue.createDataFormatValue(oldValue);
		style.setDataFormat(value);
		value.setNumberFormat(oldValue == null ? null : oldValue.getNumberPattern(), locale);
	}

	public void setStringLocale(String locale) {
		DataFormatValue oldValue = style.getDataFormat();
		DataFormatValue value = DataFormatValue.createDataFormatValue(oldValue);
		style.setDataFormat(value);
		value.setStringFormat(oldValue == null ? null : oldValue.getStringPattern(), locale);
	}

}
