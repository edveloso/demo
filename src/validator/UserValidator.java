package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("usrVal")
public class UserValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		if(arg2 == null || !((String)arg2).matches("[a-zA-Z ]*")){
			throw new ValidatorException(
					new FacesMessage("Erro de Validação", "campo só pode conter letras!"));
		}
		
	}

	
	
}
