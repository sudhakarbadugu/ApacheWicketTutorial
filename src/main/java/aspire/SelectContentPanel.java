package aspire;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class SelectContentPanel extends Panel {

    public SelectContentPanel(String id) {
        super(id);

        // Create the form, to use later for the buttons
        Form form = new Form("form");
        add(form);



        // Add some example 'selection' methods, to show as example
        // You can also use a full fledged form, I left that as an
        // exercise for the reader :-)
        add(new AjaxLink("selectionLink"){
            public void onClick(AjaxRequestTarget target) {
                onSelect(target, new String("Selected something using the link."));
            }

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				// TODO Auto-generated method stub
				return null;
			}
        });

        form.add(new AjaxButton("selectionButton"){
            protected void onSubmit(AjaxRequestTarget target, Form form) {
                onSelect(target, new String("Selected something using the button."));
            }
        });



        // Add a cancel / close button.
        form.add(new AjaxButton("close") {
            public void onSubmit(AjaxRequestTarget target, Form form) {
                onCancel(target);
            }
        });

    }

    abstract void onCancel(AjaxRequestTarget target);

    abstract void onSelect(AjaxRequestTarget target, String selection);

}
