package com.test;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Register extends WebPage {
	private static final List<String> SEARCH_ENGINES = (List<String>) Arrays
			.asList(new String[] { "Google", "Bing", "Baidu" });
	private String selected = "Google";

	public Register(final PageParameters parameters) {
		/*add(new Label("f1", "Registered"));

		Form<?> form = new Form("regi") {

			protected void onSubmit() {

				setResponsePage(SuccessRegister.class);
			}

		};
		add(form);*/
		IModel selectModel = Model.of();
		DropDownChoice<String> listSites = new DropDownChoice<String>("managedBy", selectModel,
				SEARCH_ENGINES) {
			
		};
		add(listSites);
	ModalWindow modalWindow= new ModalWindow("modalwindow");
	    
	//modalWindow.setPageCreator(() -> new AddField(Register.this.getPageReference(), modalWindow));
	modalWindow.setContent(new AddField(modalWindow.getContentId(),modalWindow));
	//Label label= new Label(modalWindow.getContentId(),"modal window");
	//modalWindow.setContent(new AddField(modalWindow.getContentId()));
	modalWindow.setTitle("Add a new Rule");
	add(modalWindow);

		/*// The label that shows the result from the ModalWindow
		final Label resultLabel = new Label("resultlabel", "");
		resultLabel.setOutputMarkupId(true);
		add(resultLabel);

		SelectModalWindow selectmodalwindow = new SelectModalWindow("popup") {

			@Override
			void onCancel(AjaxRequestTarget target) {
				// Handle Cancel action
				resultLabel.setDefaultModelObject("Success");
				// target.addComponent(resultLabel);
				close(target);
			}

			@Override
			void onSelect(AjaxRequestTarget target, String selection) {
				// Handle Select action
				resultLabel.setDefaultModelObject("Success");
				// target.addComponent(resultLabel);
				close(target);
			}

		};
		add(selectmodalwindow);

		add(new AjaxLink("openMonitorLink") {

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				selectmodalwindow.show(target);
			}

		});

*/		
	listSites.setOutputMarkupId(true);
		listSites.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				System.out.println("on change:" + selected);
				modalWindow.show(target);
				
			}
		});
		listSites.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			    @Override
			    protected void onUpdate(AjaxRequestTarget target) {         
			                    // just add the container to see the results
			    	//target.add(AddMethod.class);
			    	//target.add(modalWindow);
			    	modalWindow.show(target);
			        System.out.println("OnUpdate+ selected");
			    }

			   });
	}
	
}