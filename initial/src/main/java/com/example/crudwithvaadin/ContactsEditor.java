package com.example.crudwithvaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class ContactsEditor extends VerticalLayout implements KeyNotifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6042475124561427169L;
	
	private ContactsRepository contactRepository ; 
	private Contact contact;
	
	TextField firstName = new TextField("First Name");
	TextField lastName = new TextField("Last Name");
	TextField mobile = new TextField("Mobile");
	TextField emailId = new TextField("Email");
	Checkbox status = new Checkbox(true);

	
	Button save = new Button("Save", VaadinIcon.CHECK.create());
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", VaadinIcon.TRASH.create());
	HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);
	Binder<Contact> binder = new Binder<>(Contact.class);
	private ChangeHandler changeHandler;
	
	
	
	@Autowired
	public ContactsEditor(ContactsRepository repository) {
		this.contactRepository = repository;

		add(emailId,firstName, lastName,mobile,status, actions);

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);

		save.getElement().getThemeList().add("primary");
		delete.getElement().getThemeList().add("error");

		addKeyPressListener(Key.ENTER, e -> save());

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		cancel.addClickListener(e -> editContact(contact));
		setVisible(false);
	}
	
	
	void delete() {
		contactRepository.delete(contact);
		changeHandler.onChange();
	}

	void save() {
		contactRepository.save(contact);
		changeHandler.onChange();
	}

	public interface ChangeHandler {
		void onChange();
	}
	
	public final void editContact(Contact c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			contact = contactRepository.findById(c.getId()).get();
		}
		else {
			contact = c;
		}
		cancel.setVisible(persisted);

		// Bind contact properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(contact);

		setVisible(true);

		// Focus first name initially
		emailId.focus();
	}
	
	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		changeHandler = h;
	}
	
	
}
