package movielist.action;

import movielist.business.BusinessDelegate;
import movielist.domain.Movie;
import movielist.form.MovieForm;
import movielist.form.MovieFormConverter;
import movielist.map.ObjectNotFoundException;
import movielist.map.ServerFailureException;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeMovieAction extends LoggedOnAction {
	private static String CLASS_NAME = ChangeMovieAction.class.getName();

	public ActionForward performLoggedIn(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws
			ServerFailureException,
			ObjectNotFoundException {

		int id;
		BusinessDelegate bp;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			throw new ObjectNotFoundException ("Invalid Movie ID");
		}

		bp = BusinessDelegate.getInstance();

		Movie m = bp.getMovieById(id);
		MovieFormConverter.toMovieForm(m, (MovieForm) form);

		request.setAttribute("movieRatings", bp.getAllMovieRatings());

		return mapping.findForward("success");
	}
}