package movielist.action;

import movielist.business.BusinessDelegate;
import movielist.form.LogonForm;
import movielist.map.ServerFailureException;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TryLogonAction extends ErrorHandlingAction {
	private static String CLASS_NAME = TryLogonAction.class.getName();

	public ActionForward performMovieList(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException,  ServerFailureException {

		LogonForm lf = (LogonForm) form;

		BusinessDelegate bp;

		bp = BusinessDelegate.getInstance();

		if (!bp.validateUser(lf.getUserId(), lf.getPassword())) {
			ActionErrors ae = new ActionErrors();
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.logon.failed"));

			saveErrors(request, ae);
			return mapping.findForward("failure");
		}

		request.getSession().setAttribute("loggedIn", "Y");

		return mapping.findForward("displayMovies");
	}
}