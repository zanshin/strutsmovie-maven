package movielist.business;

import movielist.domain.Movie;
import movielist.domain.MovieRating;
import movielist.map.*;

import java.util.List;

public class BusinessDelegate {

    /**
     * 
     * @uml.property name="instance"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private static BusinessDelegate instance = null;

    /**
     * 
     * @uml.property name="pm"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private PersistenceMap pm;

    /**
     * 
     * @uml.property name="instance"
     */
    public static synchronized BusinessDelegate getInstance()
        throws ServerFailureException {
        if (instance == null) {
            instance = new BusinessDelegate();
        }

        return instance;
    }

	private BusinessDelegate() throws ServerFailureException {
		super();
		try {
			pm = PersistenceMapFactory.getInstance().getMap();
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public void deleteAllMovies() throws ServerFailureException {
		try {
			pm.deleteAllMovies();
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public List getAllMovies() throws ServerFailureException {
		try {
			return pm.getAllMovies();
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public List getAllMovieRatings() throws ServerFailureException {
		try {
			return pm.getAllMovieRatings();
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public Movie getMovieById(int id)
		throws ServerFailureException, ObjectNotFoundException {
		try {
			return pm.getMovieById(id);
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public MovieRating getMovieRatingById(int id)
		throws ServerFailureException, ObjectNotFoundException {
		try {
			return pm.getMovieRatingById(id);
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public void addMovie(Movie m) throws ServerFailureException {
		try {
			pm.insertMovie(m);
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public void updateMovie(Movie m)
		throws ServerFailureException, ObjectNotFoundException {
		try {
			pm.updateMovie(m);
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public void deleteMovie(int id)
		throws ServerFailureException, ObjectNotFoundException {
		try {
			pm.deleteMovie(id);
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}

	public boolean validateUser(String userId, String password)
		throws ServerFailureException {
		try {
			return pm.validateUser(userId, password);
		} catch (MapException e) {
			throw new ServerFailureException(e.getMessage());
		}
	}
}