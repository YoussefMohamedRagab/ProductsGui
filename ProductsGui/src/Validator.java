import java.sql.Date;
import java.time.LocalDate;

public class Validator {

	public boolean validate_price(String text) {
		if(text == null)
			return false;
		try {
			float result = Float.parseFloat(text);
			if(result >=0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validate_id(String text) {
		if(text == null)
			return false;
		try {
			float result = Integer.parseInt(text);
			if(result >=0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validate_model(String text) {
		if(text == null || text.length() == 0 || text.equalsIgnoreCase(" ") || text.length() >40)
			return false;
		
		return true;	
	}
	public boolean validate_type(String text) {
		if(text == null || text.length() == 0 || text.equalsIgnoreCase(" ") || text.length() >20)
			return false;
		
		return true;	
	}
	public boolean validate_date(LocalDate date) {
		
		return true;	
	}
	
	
	
}
