package aspire;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SuccessPage extends WebPage {

	public SuccessPage(final PageParameters parameters) {
		
		String username = "";
		
		
		if(parameters.get("username") !=null){
			username = parameters.get("username").toString();
		}
		add(new Label("f1", "Successfully logged in" + username));
	}
}
