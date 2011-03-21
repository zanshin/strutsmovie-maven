package movielist.form;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Locale;

public class LogonForm extends ActionForm {
	private String userId;
	private String password;
	private String language;

    /**
     * 
     * @uml.property name="userId"
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @uml.property name="password"
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @uml.property name="userId"
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @uml.property name="password"
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @uml.property name="language"
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @uml.property name="language"
     */
    public void setLanguage(String language) {
        this.language = language;
    }

	public ArrayList getLanguages() {
		ArrayList al = new ArrayList();

		al.add("English");
		al.add("Valley Girl");

		return al;
	}

	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request) {
		// set the language properly...
		if ("Valley Girl".equals(language)) {
			request.getSession().setAttribute(Action.LOCALE_KEY, new Locale("vg", ""));
		} else {
			request.getSession().setAttribute(Action.LOCALE_KEY, Locale.ENGLISH);
		}

		ActionErrors ae = new ActionErrors();

		if (userId == null || userId.length() == 0) {
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.userid.required"));
		}

		if (password == null || password.length() == 0) {
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.password.required"));
		}

		return ae;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// initialize the language properly...
		Locale l = (Locale) request.getSession().getAttribute(Action.LOCALE_KEY);
		
		if (l != null && l.getLanguage().equals("vg")) {
			language = "Valley Girl";
		} else {
			language = "English";
		}
	}
}