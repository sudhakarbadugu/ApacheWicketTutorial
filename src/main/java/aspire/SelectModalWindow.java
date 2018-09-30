package aspire;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;

public abstract class SelectModalWindow extends ModalWindow {
    public SelectModalWindow(String id) {
        super(id);

        // Set sizes of this ModalWindow. You can also do this from the HomePage
        // but its not a bad idea to set some good default values.
        setInitialWidth(450);
        setInitialHeight(300);

        setTitle("Select something");

        // Set the content panel, implementing the abstract methods
        setContent(new SelectContentPanel(this.getContentId()){
            void onCancel(AjaxRequestTarget target) {
                SelectModalWindow.this.onCancel(target);
            }

            void onSelect(AjaxRequestTarget target, String selection) {
                SelectModalWindow.this.onSelect(target, selection);
            }
        });
    }

    abstract void onCancel(AjaxRequestTarget target);

    abstract void onSelect(AjaxRequestTarget target, String selection);

}