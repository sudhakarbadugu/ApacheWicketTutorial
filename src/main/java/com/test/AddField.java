package com.test;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

public class AddField extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddField(String id) {
		super(id);
		setOutputMarkupId(true);
		Form<?> form = new Form("regi") {

			protected void onSubmit() {

				setResponsePage(SuccessRegister.class);
			}

		};
		add(form);
	}

}
