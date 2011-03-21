package movielist.action;

import movielist.business.BusinessDelegate;
import movielist.map.ServerFailureException;
import org.apache.log4j.Category;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearListAction extends LoggedOnAction {
	private static final String CLASS_NAME = ClearListAction.class.getName();

	public ActionForward performLoggedIn(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws   ServerFailureException {

		Category cat = Category.getInstance(CLASS_NAME + ".performLoggedIn");

		cat.debug("Entering...");

		BusinessDelegate.getInstance().deleteAllMovies();

		cat.debug("Exiting...");

		return mapping.findForward("displayMovies");
	}
}