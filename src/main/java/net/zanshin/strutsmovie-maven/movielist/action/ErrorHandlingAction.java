package movielist.action;

import movielist.map.ObjectNotFoundException;
import movielist.map.ServerFailureException;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ErrorHandlingAction extends Action {

	public final ActionForward perform(ActionMapping mapping,
									   ActionForm form,
									   HttpServletRequest request,
									   HttpServletResponse response)
		throws IOException, ServletException {

		try	{
			return performMovieList(mapping, form, request, response);
		} catch (ServerFailureException e) {
			request.setAttribute("movielist.exception", e);
			return mapping.findForward("generalError");
		} catch (ObjectNotFoundException e) {
			request.setAttribute("movielist.exception", e);
			return mapping.findForward("generalError");
		}
	}

	// template method that supports global error handling
	protected abstract ActionForward performMovieList(ActionMapping mapping,
												   ActionForm form,
												   HttpServletRequest request,
												   HttpServletResponse response)
		throws IOException,  ServerFailureException, ObjectNotFoundException;
}