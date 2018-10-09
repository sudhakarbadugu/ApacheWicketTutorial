package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class AddField extends Panel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    

    public AddField(String id, final ModalWindow modal) {
        super(id);
        setOutputMarkupId(true);
        Form<?> form = new Form("regi");
        form.add( new RequiredTextField("firstName"));
        WebMarkupContainer container = new WebMarkupContainer("hidebutton");
        container.setOutputMarkupPlaceholderTag(true);
        
        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        feedbackPanel.setOutputMarkupId(true);
        
        add(feedbackPanel);
        form.add(new AjaxButton("submitbutton") {

            @Override
            public MarkupContainer setDefaultModel(IModel model) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void onSubmit(AjaxRequestTarget target) {
                System.out.println("submit");
                container.setVisible(false);
                target.add(container);
            }
            @Override
            protected void onError(AjaxRequestTarget target) {
                target.add(feedbackPanel);
            }
            
        });
        AjaxButton cancel = new AjaxButton("cancelbutton") {

            @Override
            public MarkupContainer setDefaultModel(IModel model) {
                // TODO Auto-generated method stub
                return null;
                
            }
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                modal.close(target);                
            }
        };
        cancel.setDefaultFormProcessing(false);
        form.add(cancel);
        add(container);
        container.add(form);
        
        modal.setCloseButtonCallback(target -> {
            System.out.println("closebutton call back");
            container.setVisible(true);
            target.add(container);
            return true;
        });
        
        
    }
    
}


