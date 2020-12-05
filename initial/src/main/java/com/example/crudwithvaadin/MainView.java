package com.example.crudwithvaadin;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

/**
 * @author satishrathe
 *
 */
@Route
public class MainView extends VerticalLayout {

	private final ContactsRepository repo;
	final Grid<Contact> grid;
	private final ContactsEditor editor;
	final TextField filter;
	private final Button addNewBtn;

	
	
	public MainView(ContactsRepository repo,ContactsEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(Contact.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("New Contact", VaadinIcon.PLUS.create());
		
		
		
		add(new Button("Click me", e -> Notification.show("Hello, Welcome to the Contact Management")));// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		add(actions, grid, editor);

		grid.setHeight("300px");
		grid.setColumns("emailId", "firstName", "lastName","phoneNumber","status");
		grid.getColumnByKey("emailId").setWidth("150px").setFlexGrow(0);

		filter.setPlaceholder("Filter By Last Name");

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.EAGER);
		filter.addValueChangeListener(e -> listContacts(e.getValue()));

		// Connect selected Customer to editor or hide if none is selected
		grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editContact(e.getValue());
		});

		// Instantiate and edit new Customer the new button is clicked
		addNewBtn.addClickListener(e -> editor.editContact(new Contact("", "", "", 12345L, true)));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listContacts(filter.getValue());
		});

		// Initialize listing
		listContacts(null);
	}

	// tag::listCustomers[]
	void listContacts(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(repo.findAll());
		}
		else {
			grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
		}
	}
	// end::listCustomers[]
}
