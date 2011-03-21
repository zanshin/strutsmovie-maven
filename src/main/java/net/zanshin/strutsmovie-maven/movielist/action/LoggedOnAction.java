package movielist.action;

import movielist.map.ObjectNotFoundException;
import movielist.map.ServerFailureException;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class LoggedOnAction extends ErrorHandlingAction {

	public final ActionForward performMovieList(ActionMapping mapping,
									   ActionForm form,
									   HttpServletRequest request,
									   HttpServletResponse response)
		throws IOException,  ServerFailureException, ObjectNotFoundException {

        // not sure why this is here any more - 3.19.2011
		// String s = (String) request.getSession().getAttribute("loggedIn");
		// s = request.getSession().getId();

		if ("Y".equals(request.getSession().getAttribute("loggedIn"))) {
			return performLoggedIn(mapping, form, request, response);
		} else {
			return mapping.findForward("logoff");
		}
	}

	// template method called if, and only if, the user is logged in properly
	protected abstract ActionForward performLoggedIn(ActionMapping mapping,
												  ActionForm form,
												  HttpServletRequest request,
												  HttpServletResponse response)
		throws   ServerFailureException, ObjectNotFoundException;
}