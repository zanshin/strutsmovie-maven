package movielist.form;

import movielist.business.BusinessDelegate;
import movielist.domain.Movie;
import movielist.map.ObjectNotFoundException;
import movielist.map.ServerFailureException;

public class MovieFormConverter {
	public static Movie toMovie(MovieForm movieForm)
		throws ServerFailureException, ObjectNotFoundException {
		BusinessDelegate bp = BusinessDelegate.getInstance();

		Movie m = new Movie();

		m.setComment(movieForm.getComment());
		m.setName(movieForm.getName());
		m.setRating(bp.getMovieRatingById(Integer.parseInt(movieForm.getRating())));

		try {
			m.setId(Integer.parseInt(movieForm.getId()));
		} catch (NumberFormatException e) {
			m.setId(-1);
		}

		m.setScale(Integer.parseInt(movieForm.getScale()));

		if ("on".equals(movieForm.getWorthSeeingAgain())) {
			m.setWorthSeeingAgain(true);
		} else {
			m.setWorthSeeingAgain(false);
		}

		return m;
	}

	public static void toMovieForm(Movie movie, MovieForm movieForm) {
		movieForm.setComment(movie.getComment());
		movieForm.setId(Integer.toString(movie.getId()));
		movieForm.setName(movie.getName());
		movieForm.setRating(Integer.toString(movie.getRating().getId()));
		movieForm.setScale(Integer.toString(movie.getScale()));
		if (movie.getWorthSeeingAgain()) {
			movieForm.setWorthSeeingAgain("on");
		} else {
			movieForm.setWorthSeeingAgain("off");
		}
	}
}