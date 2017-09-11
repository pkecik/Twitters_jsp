package twitter.validators;

import static twitter.enums.ValidationErrors.EMPTY_MESSAGE;
import static twitter.enums.ValidationErrors.EMPTY_USER_NAME;

import java.util.ArrayList;
import java.util.List;

public class TwitterMessageValidator {

	public List<String> validate(String userName, String message) {
		List<String> errors = new ArrayList<String>();
		
		if (!(userName!=null && !userName.equals(""))) {
		    errors.add(EMPTY_USER_NAME.getValue());
		}
		
		if (!(message!=null && !message.equals(""))) {
			errors.add(EMPTY_MESSAGE.getValue());
		}
		return errors;
	}
}
