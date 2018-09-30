package aspire.validators;

import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class UserNameValidator extends CompoundValidator<String> {
	
	public UserNameValidator() {
		add(StringValidator.lengthBetween(5, 10));
	}

}
