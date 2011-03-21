package movielist.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogonAction extends ErrorHandlingAction {
	public ActionForward performMovieList(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException {

		request.getSession().removeAttribute("loggedIn");

		return mapping.findForward("success");
	}
}