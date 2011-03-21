package movielist.form;

import movielist.business.BusinessDelegate;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class MovieForm extends ActionForm {
	private String name;
	private String comment;
	private String id;
	private String rating;
	private String scale;
	private String worthSeeingAgain;

	public MovieForm() {
		super();
	}

    /**
     * 
     * @uml.property name="name"
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @uml.property name="comment"
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @uml.property name="name"
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @uml.property name="comment"
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @uml.property name="id"
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @uml.property name="id"
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @uml.property name="rating"
     */
    public String getRating() {
        return rating;
    }

    /**
     * 
     * @uml.property name="rating"
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 
     * @uml.property name="scale"
     */
    public String getScale() {
        return scale;
    }

    /**
     * 
     * @uml.property name="scale"
     */
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * 
     * @uml.property name="worthSeeingAgain"
     */
    public String getWorthSeeingAgain() {
        return worthSeeingAgain;
    }

    /**
     * 
     * @uml.property name="worthSeeingAgain"
     */
    public void setWorthSeeingAgain(String worthSeeingAgain) {
        this.worthSeeingAgain = worthSeeingAgain;
    }

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();

		if (request.getParameter("delete") == null) {
			// if delete was not pressed - validate
			if (name == null || name.length() == 0) {
				ae.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("errors.movie.name.required"));
			}

			if (comment == null || comment.length() == 0) {
				ae.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("errors.movie.comment.required"));
			}

			int i;
			try {
				i = Integer.parseInt(scale);
			} catch (NumberFormatException e) {
				i = 0;
			}

			if (i < 1 || i > 10) {
				ae.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("errors.movie.scale.invalid"));
			}
		}

		// add the ratings to the request if validation failed
		if (!ae.empty()) {
			try {
				BusinessDelegate bp;
				bp = BusinessDelegate.getInstance();
				request.setAttribute("movieRatings", bp.getAllMovieRatings());
			} catch (Exception e) {
                // todo...
			}
		}

		return ae;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		worthSeeingAgain = "off";
	}
}