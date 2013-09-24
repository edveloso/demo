package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import modelo.CPF;

@FacesConverter(value = "cpfConv")
public class CpfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		CPF cpf = new CPF();
		if (null == arg2 || arg2.length() < 11 ) {
			throw new ConverterException(new FacesMessage("Erro Convers‹o",
					"erro ao converter CPF"));
		}
		if(!arg2.contains("\\.")){
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < arg2.length(); i++){
				
				if(i % 3 == 0 && i != 0 && i != 9  ){
					builder.append(".");
				}
				if(i % 9 == 0 && i != 0  ){
					builder.append("-");
				}
				builder.append(arg2.charAt(i));
			}
			cpf.setValue(builder.toString());
		}
		return cpf;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((CPF)arg2).getValue();
	}

}
