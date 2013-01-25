package com.thingtrack.konekti.view.module.address.internal;

import org.vaadin.dialogs.ConfirmDialog;

import com.thingtrack.konekti.domain.Address;
import com.thingtrack.konekti.service.api.AddressService;
import com.thingtrack.konekti.view.addon.data.BindingSource;
import com.thingtrack.konekti.view.addon.ui.AbstractView;
import com.thingtrack.konekti.view.addon.ui.BoxToolbar;
import com.thingtrack.konekti.view.addon.ui.BoxToolbar.ClickAttachButtonListener;
import com.thingtrack.konekti.view.addon.ui.BoxToolbar.ClickFilterButtonListener;
import com.thingtrack.konekti.view.addon.ui.BoxToolbar.ClickPrintButtonListener;
import com.thingtrack.konekti.view.addon.ui.DataGridView;
import com.thingtrack.konekti.view.addon.ui.EditionToolbar.ClickAddButtonListener;
import com.thingtrack.konekti.view.addon.ui.EditionToolbar.ClickEditButtonListener;
import com.thingtrack.konekti.view.addon.ui.EditionToolbar.ClickNavigationEvent;
import com.thingtrack.konekti.view.addon.ui.EditionToolbar.ClickRemoveButtonListener;
import com.thingtrack.konekti.view.addon.ui.NavigationToolbar;
import com.thingtrack.konekti.view.addon.ui.NavigationToolbar.ClickRefreshButtonListener;
import com.thingtrack.konekti.view.addon.ui.WindowDialog;
import com.thingtrack.konekti.view.addon.ui.WindowDialog.DialogResult;
import com.thingtrack.konekti.view.kernel.IWorkbenchContext;
import com.thingtrack.konekti.view.kernel.ui.layout.IViewContainer;
import com.thingtrack.konekti.view.web.form.AddressViewForm;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.CustomTable;
import com.vaadin.ui.CustomTable.ColumnGenerator;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AddressView extends AbstractView implements
		ClickRefreshButtonListener, ClickAddButtonListener,
		ClickEditButtonListener, ClickRemoveButtonListener, ClickFilterButtonListener,
		ClickPrintButtonListener {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private DataGridView dgAddress;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private AddressService addressService;

	private BindingSource<Address> bsAddress = new BindingSource<Address>(Address.class, 0);

	private NavigationToolbar navigationToolbar;
	// private EditionToolbar editionToolbar;
	private BoxToolbar boxToolbar;

	private IWorkbenchContext context;
	private IViewContainer viewContainer;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public AddressView(IWorkbenchContext context, IViewContainer viewContainer) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		this.context = context;
		
		// set Slide View Services and ViewContainer to navigate
		this.viewContainer = viewContainer;
		this.addressService = AddressViewContainer.getAddressService();

		// initialize datasource views
		initView();
	}

	private void initView() {
		// initialize Slide View Organization View
		dgAddress.setImmediate(true);

		refreshBindindSource();

		// STEP 01: create grid view for slide Organization View
		try {
			dgAddress.setBindingSource(bsAddress);
			dgAddress.addGeneratedColumn(
					OrganizationCodeColumn.ORGANIZATION_CODE_COLUMN_ID,
					new OrganizationCodeColumn());
			dgAddress.setVisibleColumns(new String[] { "street", "number",
					"letter", "city", "zipCode", "province", "country", "fax",
					"email", "web",
					OrganizationCodeColumn.ORGANIZATION_CODE_COLUMN_ID });
			dgAddress.setColumnHeaders(new String[] { "Calle", "Número",
					"Letra", "Ciudad", "Código Postal", "Provincia", "País",
					"Fax", "Email", "Web", "Organización" });

			dgAddress.setColumnCollapsed("fax", true);
			dgAddress.setColumnCollapsed("email", true);
			dgAddress.setColumnCollapsed("web", true);
			dgAddress.setColumnCollapsed(
					OrganizationCodeColumn.ORGANIZATION_CODE_COLUMN_ID, true);
		} catch (Exception ex) {
			ex.getMessage();
		}

		// STEP 02: create toolbar for slide Employee Agent View
		navigationToolbar = new NavigationToolbar(0, bsAddress, viewContainer);
		boxToolbar = new BoxToolbar(2, bsAddress);
		
		boxToolbar.addListenerFilterButton(this);
		boxToolbar.addListenerPrintButton(this);
		
		navigationToolbar.addListenerRefreshButton(this);
		navigationToolbar.setUpButton(false);
		navigationToolbar.setDownButton(false);

		removeAllToolbar();

		addToolbar(navigationToolbar);
		addToolbar(boxToolbar);

	}

	private void refreshBindindSource() {
		try {
			bsAddress.removeAllItems();
			bsAddress.addAll(addressService.getAll());

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void refreshButtonClick(NavigationToolbar.ClickNavigationEvent event) {
		refreshBindindSource();

	}

	private void refreshDataGridView(Address addressSaved) {
		if (bsAddress.containsId(addressSaved)) {
			Address previousAddressn = bsAddress.prevItemId(addressSaved);
			bsAddress.removeItem(addressSaved);
			bsAddress.addItemAfter(previousAddressn, addressSaved);
		} else
			bsAddress.addItem(addressSaved);
	}

	@Override
	public void addButtonClick(ClickNavigationEvent event) {
		Address address = new Address();

		try {
			@SuppressWarnings("unused")
			WindowDialog<Address> windowDialog = new WindowDialog<Address>(
					getWindow(), "Nuevo Dirección", "Guardar",
					DialogResult.SAVE, "Cancelar", DialogResult.CANCEL,
					new AddressViewForm(), address,
					new WindowDialog.CloseWindowDialogListener<Address>() {
						public void windowDialogClose(
								WindowDialog<Address>.CloseWindowDialogEvent<Address> event) {
							if (event.getDialogResult() != WindowDialog.DialogResult.SAVE)
								return;

							try {
								Address savingAddress = event.getDomainEntity();

								Address savedAddress = addressService
										.save(savingAddress);

								// refresh binding source
								refreshDataGridView(savedAddress);

							} catch (Exception e) {
								e.printStackTrace();

							}
						}

					});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editButtonClick(ClickNavigationEvent event) {
		Address editingAddress = (Address) event.getRegister();

		try {
			@SuppressWarnings("unused")
			WindowDialog<Address> windowDialog = new WindowDialog<Address>(
					getWindow(), "Editor Dirección", "Guardar",
					DialogResult.SAVE, "Cancelar", DialogResult.CANCEL,
					new AddressViewForm(), editingAddress,
					new WindowDialog.CloseWindowDialogListener<Address>() {
						public void windowDialogClose(
								WindowDialog<Address>.CloseWindowDialogEvent<Address> event) {
							if (event.getDialogResult() != WindowDialog.DialogResult.SAVE)
								return;

							try {
								Address savingAddress = event.getDomainEntity();

								Address savedAddress = addressService
										.save(savingAddress);

								// refresh binding source
								refreshDataGridView(savedAddress);

							} catch (Exception e) {
								e.printStackTrace();

							}
						}

					});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteButtonClick(ClickNavigationEvent event) {
		final Address editingAddress = (Address) event.getRegister();

		if (editingAddress == null)
			return;

		ConfirmDialog.show(getWindow(), "Borrar Dirección", "¿Estás seguro?",
				"Si", "No", new ConfirmDialog.Listener() {

					public void onClose(ConfirmDialog dialog) {
						if (dialog.isConfirmed()) {
							try {
								addressService.delete(editingAddress);

								// refresh
								refreshBindindSource();

							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});

	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// dgEmployee
		dgAddress = new DataGridView();
		dgAddress.setImmediate(false);
		dgAddress.setWidth("100.0%");
		dgAddress.setHeight("100.0%");
		mainLayout.addComponent(dgAddress);
		mainLayout.setExpandRatio(dgAddress, 1.0f);

		return mainLayout;
	}

	private class OrganizationCodeColumn implements ColumnGenerator {

		static final String ORGANIZATION_CODE_COLUMN_ID = "organization_code_column-id";

		public Object generateCell(CustomTable source, Object itemId,
				Object columnId) {

			Label organizationCodeLabel = new Label();

			Address address = (Address) itemId;

			if (address.getOrganization() != null) {
				String code = address.getOrganization().getCode();

				organizationCodeLabel.setValue(code);
			}

			return organizationCodeLabel;
		}

	}

	@Override
	public void filterButtonClick(BoxToolbar.ClickNavigationEvent event) {
		dgAddress.setFilterBarVisible();
		
	}

	@Override
	public void printButtonClick(BoxToolbar.ClickNavigationEvent event) {
		try {
			dgAddress.print("Listado Direcciones");
		}
		catch (Exception e) {
			throw new RuntimeException("¡No se pudo imprimir el informe!", e);
		}
		
	}

}
