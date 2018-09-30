package com.test;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.test.validators.UserNameValidator;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String loginstatus;
	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		
		add(new Label("hello", "Hello world 24"));
		setDefaultModel(new CompoundPropertyModel(this));
		
		add(new FeedbackPanel("error"));
		
		Link<Void> link = new Link<Void>("l") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(Register.class);
				
			}
		};
		
		TextField<String> username=new TextField<String>("username",Model.of(""));
		PasswordTextField password=new PasswordTextField("password",Model.of(""));
		
		username.setRequired(true);
		password.setRequired(false);
		username.add(new UserNameValidator());
		
		Form<?> form = new Form("f1"){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
				String usernamevalue = username.getModelObject();
				PageParameters parameters=new PageParameters();
				
				String passwordvalue = password.getModelObject();
				
				parameters.add("username", usernamevalue);
				System.out.println("Form submitted." +usernamevalue);
				if("pushpa".equals(usernamevalue) && "suma".equals(passwordvalue)) {
					loginstatus="login successful";
				setResponsePage(SuccessPage.class,parameters);
				}
			}
		};
		
		add(link);
		form.add(new Label("loginstatus"));
		add(form);
		form.add(username);
		form.add(password);
		
		
	}
	
}
