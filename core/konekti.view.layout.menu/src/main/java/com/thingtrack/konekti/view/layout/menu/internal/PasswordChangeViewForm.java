package com.thingtrack.konekti.view.layout.menu.internal;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

public class PasswordChangeViewForm extends CustomComponent {

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button cancelPasswordChangebutton;
	@AutoGenerated
	private Button applyPasswordChangebutton;
	@AutoGenerated
	private PasswordField confirmPasswordField;
	@AutoGenerated
	private PasswordField newPasswordField;
	@AutoGenerated
	private PasswordField currentPasswordField;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PasswordChangeViewForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("300px");
		mainLayout.setHeight("250px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("300px");
		setHeight("250px");
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1, "top:0.0px;left:0.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("100.0%");
		verticalLayout_1.setMargin(true);
		verticalLayout_1.setSpacing(true);
		
		// currentPasswordField
		currentPasswordField = new PasswordField();
		currentPasswordField.setCaption("Contraseña actual");
		currentPasswordField.setImmediate(false);
		currentPasswordField.setWidth("100.0%");
		currentPasswordField.setHeight("-1px");
		verticalLayout_1.addComponent(currentPasswordField);
		
		// newPasswordField
		newPasswordField = new PasswordField();
		newPasswordField.setCaption("Nueva Contraseña");
		newPasswordField.setImmediate(false);
		newPasswordField.setWidth("100.0%");
		newPasswordField.setHeight("-1px");
		verticalLayout_1.addComponent(newPasswordField);
		
		// confirmPasswordField
		confirmPasswordField = new PasswordField();
		confirmPasswordField.setCaption("Confirmar contraseña");
		confirmPasswordField.setImmediate(false);
		confirmPasswordField.setWidth("100.0%");
		confirmPasswordField.setHeight("-1px");
		verticalLayout_1.addComponent(confirmPasswordField);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_1.addComponent(horizontalLayout_1);
		verticalLayout_1.setExpandRatio(horizontalLayout_1, 1.0f);
		verticalLayout_1.setComponentAlignment(horizontalLayout_1,
				new Alignment(6));
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// applyPasswordChangebutton
		applyPasswordChangebutton = new Button();
		applyPasswordChangebutton.setCaption("Aplicar");
		applyPasswordChangebutton.setImmediate(false);
		applyPasswordChangebutton.setWidth("-1px");
		applyPasswordChangebutton.setHeight("-1px");
		horizontalLayout_1.addComponent(applyPasswordChangebutton);
		
		// cancelPasswordChangebutton
		cancelPasswordChangebutton = new Button();
		cancelPasswordChangebutton.setCaption("Cancelar");
		cancelPasswordChangebutton.setImmediate(false);
		cancelPasswordChangebutton.setWidth("-1px");
		cancelPasswordChangebutton.setHeight("-1px");
		horizontalLayout_1.addComponent(cancelPasswordChangebutton);
		
		return horizontalLayout_1;
	}

}