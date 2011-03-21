package movielist.map.memory;

import movielist.domain.Movie;
import movielist.map.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MovieMemoryModel {
	private int lastId;
	private final List list;

    /**
     * 
     * @uml.property name="instance"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private static MovieMemoryModel instance = null;

    /**
     * 
     * @uml.property name="instance"
     */
    public static synchronized MovieMemoryModel getInstance() {
        if (instance == null) {
            instance = new MovieMemoryModel();
        }

        return instance;
    }

	private MovieMemoryModel() {
		super();
		list = new ArrayList();
	}

	public void insert(Movie aMovie) {
		synchronized (list) {
			aMovie.setId(++lastId);
			list.add(aMovie);
		}
	}
	public void update(Movie aMovie) throws ObjectNotFoundException {

        for (Object aList : list) {
            Movie m = (Movie) aList;

            if (m.getId() == aMovie.getId()) {
                synchronized (list) {
                    m.setName(aMovie.getName());
                    m.setComment(aMovie.getComment());
                    m.setRating(aMovie.getRating());
                    m.setScale(aMovie.getScale());
                    m.setWorthSeeingAgain(aMovie.getWorthSeeingAgain());
                    return;
                }
            }
        }

		throw new ObjectNotFoundException();
	}
	public void delete(int id) throws ObjectNotFoundException {
		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			Movie m = (Movie) iter.next();

			if (m.getId() == id) {
				synchronized (list) {
					iter.remove();
					return;
				}
			}
		}

		throw new ObjectNotFoundException();
	}
	public Movie getById(int id) throws ObjectNotFoundException {

        for (Object aList : list) {
            Movie m = (Movie) aList;

            if (m.getId() == id) {
                return m;
            }
        }

		throw new ObjectNotFoundException();
	}
	public List getAll() {
		return Collections.unmodifiableList(list);
	}
	public void deleteAll() {
		synchronized (list) {
			list.clear();
		}
	}
}