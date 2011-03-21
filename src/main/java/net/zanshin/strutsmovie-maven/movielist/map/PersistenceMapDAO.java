package movielist.map;

import movielist.domain.Movie;
import movielist.domain.MovieRating;
import movielist.map.dao.*;

import java.util.ArrayList;
import java.util.List;

public class PersistenceMapDAO implements PersistenceMap {
	/**
	 * @see PersistenceMap#validateUser(String, String)
	 */
	public boolean validateUser(String userId, String password)
		throws MapException {
		boolean rc = false;

		try {
			TblUsersDB usersDb = new TblUsersDB();
			TblUsersDBModel userModel;
			userModel = usersDb.getByPrimaryKey(new TblUsersPK(userId));

			if (password.equals(userModel.getPassword())) {
				rc = true;
			}
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		} catch (ObjectNotFoundException e) {
            // todo...
		}

		return rc;
	}

	/**
	 * @see PersistenceMap#insertMovie(Movie)
	 */
	public void insertMovie(Movie aMovie) throws MapException {
		try {
			TblMoviesDB moviesDb = new TblMoviesDB();
			TblMoviesDBModel model = new TblMoviesDBModel();

			model.setComment(aMovie.getComment());
			model.setId(aMovie.getId());
			model.setName(aMovie.getName());
			model.setRating(aMovie.getRating().getId());
			model.setScale(aMovie.getScale());

			if (aMovie.getWorthSeeingAgain()) {
				model.setWorthSeeingAgain("Y");
			} else {
				model.setWorthSeeingAgain("N");
			}

			moviesDb.insert(model);
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}
	}

	/**
	 * @see PersistenceMap#updateMovie(Movie)
	 */
	public void updateMovie(Movie aMovie)
		throws MapException, ObjectNotFoundException {
		try {
			TblMoviesDB moviesDb = new TblMoviesDB();
			TblMoviesDBModel model = new TblMoviesDBModel();

			model.setComment(aMovie.getComment());
			model.setId(aMovie.getId());
			model.setName(aMovie.getName());
			model.setRating(aMovie.getRating().getId());
			model.setScale(aMovie.getScale());

			if (aMovie.getWorthSeeingAgain()) {
				model.setWorthSeeingAgain("Y");
			} else {
				model.setWorthSeeingAgain("N");
			}

			moviesDb.update(model);
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}
	}

	/**
	 * @see PersistenceMap#deleteMovie(int)
	 */
	public void deleteMovie(int id) throws MapException, ObjectNotFoundException {
		try {
			TblMoviesDB moviesDb = new TblMoviesDB();
			moviesDb.delete(new TblMoviesPK(id));
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}
	}

	/**
	 * @see PersistenceMap#getMovieById(int)
	 */
	public Movie getMovieById(int id)
		throws MapException, ObjectNotFoundException {
		Movie movie;

		try {
			TblMoviesDB moviesDb = new TblMoviesDB();
			TblMoviesDBModel movieModel;
			movieModel = moviesDb.getByPrimaryKey(new TblMoviesPK(id));

			movie = new Movie();

			movie.setComment(movieModel.getComment());
			movie.setId(movieModel.getId());
			movie.setName(movieModel.getName());
			movie.setRating(getMovieRatingById(movieModel.getRating()));
			movie.setScale(movieModel.getScale());

			if ("Y".equals(movieModel.getWorthSeeingAgain())) {
				movie.setWorthSeeingAgain(true);
			} else {
				movie.setWorthSeeingAgain(false);
			}
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}

		return movie;
	}

	/**
	 * @see PersistenceMap#getAllMovies()
	 */
	public List getAllMovies() throws MapException {
		List movies = new ArrayList();

		try {
			TblMoviesDB moviesDb = new TblMoviesDB();
			TblMoviesDBModel movieModel;
			Movie movie;
			List models = moviesDb.getList();

            for (Object model : models) {
                movieModel = (TblMoviesDBModel) model;

                movie = new Movie();

                movie.setComment(movieModel.getComment());
                movie.setId(movieModel.getId());
                movie.setName(movieModel.getName());
                movie.setRating(getMovieRatingById(movieModel.getRating()));
                movie.setScale(movieModel.getScale());

                if ("Y".equals(movieModel.getWorthSeeingAgain())) {
                    movie.setWorthSeeingAgain(true);
                } else {
                    movie.setWorthSeeingAgain(false);
                }

                movies.add(movie);
            }
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		} catch (ObjectNotFoundException e) {
			throw new MapException("Unknown Movie Rating while generating Movie List");
		}

		return movies;
	}

	/**
	 * @see PersistenceMap#deleteAllMovies()
	 */
	public void deleteAllMovies() throws MapException {
		try {
			TblMoviesDB moviesDb = new TblMoviesDB();
			moviesDb.deleteAll();
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}
	}

	/**
	 * @see PersistenceMap#getMovieRatingById(int)
	 */
	public MovieRating getMovieRatingById(int id)
		throws MapException, ObjectNotFoundException {
		MovieRating movieRating;

		try {
			TblMovieRatingsDB movieRatingsDb = new TblMovieRatingsDB();
			TblMovieRatingsDBModel movieRatingModel;
			movieRatingModel = movieRatingsDb.getByPrimaryKey(new TblMovieRatingsPK(id));

			movieRating = new MovieRating();

			movieRating.setId(movieRatingModel.getId());
			movieRating.setDescription(movieRatingModel.getDescription());
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}

		return movieRating;
	}

	/**
	 * @see PersistenceMap#getAllMovieRatings()
	 */
	public List getAllMovieRatings() throws MapException {
		List movieRatings = new ArrayList();

		try {
			TblMovieRatingsDB movieRatingsDb = new TblMovieRatingsDB();
			TblMovieRatingsDBModel movieRatingModel;
			MovieRating movieRating;
			List models = movieRatingsDb.getList();

            for (Object model : models) {
                movieRatingModel = (TblMovieRatingsDBModel) model;

                movieRating = new MovieRating();

                movieRating.setDescription(movieRatingModel.getDescription());
                movieRating.setId(movieRatingModel.getId());

                movieRatings.add(movieRating);
            }
		} catch (DatabaseException e) {
			throw new MapException(e.getMessage());
		}

		return movieRatings;
	}
}