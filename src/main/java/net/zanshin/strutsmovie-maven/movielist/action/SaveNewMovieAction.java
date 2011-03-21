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

public class SaveNewMovieAction extends LoggedOnAction {
	public ActionForward performLoggedIn(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws
			ServerFailureException,
			ObjectNotFoundException {

		BusinessDelegate bp;
		MovieForm mf = (MovieForm) form;

		bp = BusinessDelegate.getInstance();

		Movie m = MovieFormConverter.toMovie(mf);

		bp.addMovie(m);

		return mapping.findForward("displayMovies");
	}
}