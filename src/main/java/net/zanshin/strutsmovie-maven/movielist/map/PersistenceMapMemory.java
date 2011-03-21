package movielist.map;

import movielist.domain.Movie;
import movielist.domain.MovieRating;
import movielist.map.memory.LogonMemoryModel;
import movielist.map.memory.MovieMemoryModel;
import movielist.map.memory.MovieRatingMemoryModel;

import java.util.List;

public class PersistenceMapMemory implements PersistenceMap {
	public void insertMovie(Movie aMovie) {
		MovieMemoryModel.getInstance().insert(aMovie);
	}

	public void updateMovie(Movie aMovie) throws ObjectNotFoundException {
		MovieMemoryModel.getInstance().update(aMovie);
	}

	public void deleteMovie(int id) throws ObjectNotFoundException {
		MovieMemoryModel.getInstance().delete(id);
	}

	public Movie getMovieById(int id) throws ObjectNotFoundException {
		return MovieMemoryModel.getInstance().getById(id);
	}

	public List getAllMovies() {
		return MovieMemoryModel.getInstance().getAll();
	}

	public void deleteAllMovies() {
		MovieMemoryModel.getInstance().deleteAll();
	}

	public MovieRating getMovieRatingById(int id) throws ObjectNotFoundException {
		return MovieRatingMemoryModel.getInstance().getById(id);
	}

	public List getAllMovieRatings() {
		return MovieRatingMemoryModel.getInstance().getAll();
	}

	public boolean validateUser(String userId, String password) {
		return LogonMemoryModel.validateUser(userId, password);
	}
}