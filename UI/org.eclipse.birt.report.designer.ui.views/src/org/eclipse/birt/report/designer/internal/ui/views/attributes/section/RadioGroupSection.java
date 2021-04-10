
package org.eclipse.birt.report.designer.internal.ui.views.attributes.section;

import org.eclipse.birt.report.designer.internal.ui.views.attributes.page.WidgetUtil;
import org.eclipse.birt.report.designer.internal.ui.views.attributes.provider.IDescriptorProvider;
import org.eclipse.birt.report.designer.internal.ui.views.attributes.widget.DescriptorToolkit;
import org.eclipse.birt.report.designer.internal.ui.views.attributes.widget.RadioGroupPropertyDescriptor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class RadioGroupSection extends Section {

	protected RadioGroupPropertyDescriptor radioGroup;

	public RadioGroupSection(String labelText, Composite parent, boolean isFormStyle) {
		super(labelText, parent, isFormStyle);
		// TODO Auto-generated constructor stub
	}

	public void createSection() {
		getLabelControl(parent);
		getRadioGroupControl(parent);
		getGridPlaceholder(parent);
	}

	public void layout() {
		GridData gd = (GridData) radioGroup.getControl().getLayoutData();
		if (getLayoutNum() > 0)
			gd.horizontalSpan = getLayoutNum() - 1 - placeholder;
		else
			gd.horizontalSpan = ((GridLayout) parent.getLayout()).numColumns - 1 - placeholder;
		if (width > -1) {
			gd.widthHint = width;
			gd.grabExcessHorizontalSpace = false;
		} else
			gd.grabExcessHorizontalSpace = fillRadioGroup;
	}

	protected RadioGroupPropertyDescriptor getRadioGroupControl(Composite parent) {
		if (radioGroup == null) {
			radioGroup = DescriptorToolkit.createRadioGroupPropertyDescriptor(isFormStyle);
			if (getProvider() != null) {
				radioGroup.setDescriptorProvider(getProvider());
			}
			radioGroup.createControl(parent);
			radioGroup.getControl().setLayoutData(new GridData());
			radioGroup.getControl().addDisposeListener(new DisposeListener() {

				public void widgetDisposed(DisposeEvent event) {
					radioGroup = null;
				}
			});
		} else {
			checkParent(radioGroup.getControl(), parent);
		}
		return radioGroup;
	}

	public RadioGroupPropertyDescriptor getRadioGroupControl() {
		return radioGroup;
	}

	IDescriptorProvider provider;

	public IDescriptorProvider getProvider() {
		return provider;
	}

	public void setProvider(IDescriptorProvider provider) {
		this.provider = provider;
		if (radioGroup != null)
			radioGroup.setDescriptorProvider(provider);
	}

	private int width = -1;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setInput(Object input) {
		assert (input != null);
		radioGroup.setInput(input);
	}

	private boolean fillRadioGroup = false;

	public boolean isFillRadioGroup() {
		return fillRadioGroup;
	}

	public void setFillRadioGroup(boolean fillRadioGroup) {
		this.fillRadioGroup = fillRadioGroup;
	}

	public void setFocus() {
		if (radioGroup != null) {
			radioGroup.getControl().setFocus();
		}
	}

	public void load() {
		if (radioGroup != null && !radioGroup.getControl().isDisposed())
			radioGroup.load();
	}

	public void reset() {
		if (radioGroup != null && !radioGroup.getControl().isDisposed()) {
			radioGroup.reset();
		}
	}

	public void setHidden(boolean isHidden) {
		if (displayLabel != null)
			WidgetUtil.setExcludeGridData(displayLabel, isHidden);
		if (radioGroup != null)
			radioGroup.setHidden(isHidden);
		if (placeholderLabel != null)
			WidgetUtil.setExcludeGridData(placeholderLabel, isHidden);
	}

	public void setVisible(boolean isVisible) {
		if (displayLabel != null)
			displayLabel.setVisible(isVisible);
		if (radioGroup != null)
			radioGroup.setVisible(isVisible);
		if (placeholderLabel != null)
			placeholderLabel.setVisible(isVisible);
	}
}
