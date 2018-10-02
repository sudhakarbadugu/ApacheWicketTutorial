package com.test;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class AddField extends WebPage {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public AddField(final PageReference pageRef, final ModalWindow modal) {
        setOutputMarkupId(true);
      //  Form<?> form = new Form("regi");
        WebMarkupContainer container = new WebMarkupContainer("hidebutton");
        container.setOutputMarkupPlaceholderTag(true);

        container.add(new AjaxLink("submitbutton") {

            @Override
            public MarkupContainer setDefaultModel(IModel model) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void onClick(AjaxRequestTarget target) {
                System.out.println("submit");
                container.setVisible(false);
                target.add(container);
            }
        });
        container.add(new AjaxLink("cancelbutton") {

            @Override
            public MarkupContainer setDefaultModel(IModel model) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void onClick(AjaxRequestTarget target) {
                modal.close(target);
            }
        });
        add(container);
        
    }

}
