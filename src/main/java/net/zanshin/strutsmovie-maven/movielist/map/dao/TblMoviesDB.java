package movielist.map.dao;

import movielist.map.ObjectNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TblMoviesDB extends BaseDAO {
	public TblMoviesDB() {
		super();
	}

	public void insert(TblMoviesDBModel model) throws DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql =
			"insert into Movies (id, name, comment, rating, scale, worthSeeingAgain) values(?,?,?,?,?,?)";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, model.getId());
			statement.setString(2, model.getName());
			statement.setString(3, model.getComment());
			statement.setInt(4, model.getRating());
			statement.setInt(5, model.getScale());
			statement.setString(6, model.getWorthSeeingAgain());

			int rowCount = statement.executeUpdate();

			if (rowCount != 1) {
				throw new DatabaseException("Error adding row");
			}
		} catch (SQLException e) {
			throw new DatabaseException("SQL Exception on Insert");
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	public void update(TblMoviesDBModel model)
		throws ObjectNotFoundException, DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql =
			"update Movies set name = ?, comment = ?, rating = ?, scale = ?, worthSeeingAgain = ? where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, model.getName());
			statement.setString(2, model.getComment());
			statement.setInt(3, model.getRating());
			statement.setInt(4, model.getScale());
			statement.setString(5, model.getWorthSeeingAgain());
			statement.setInt(6, model.getId());

			int rowCount = statement.executeUpdate();

			if (rowCount != 1) {
				if (rowCount == 0) {
					throw new ObjectNotFoundException("Error updating row");
				} else {
					throw new DatabaseException("Error updating row");
				}
			}
		} catch (SQLException e) {
			throw new DatabaseException("SQL Exception on Update");
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	public TblMoviesDBModel getByPrimaryKey(TblMoviesPK pk)
		throws ObjectNotFoundException, DatabaseException {
		TblMoviesDBModel model = new TblMoviesDBModel();
		Connection connection = null;
		PreparedStatement statement = null;
		String sql =
			"select name, comment, rating, scale, worthSeeingAgain from Movies where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, pk.getId());

			ResultSet resultSet = statement.executeQuery();

			if (!resultSet.next()) {
				throw new ObjectNotFoundException("row does not exist");
			}

			model.setId(pk.getId());
			model.setName(resultSet.getString(1));
			model.setComment(resultSet.getString(2));
			model.setRating(resultSet.getInt(3));
			model.setScale(resultSet.getInt(4));
			model.setWorthSeeingAgain(resultSet.getString(5));

			resultSet.close();
		} catch (SQLException e) {
			throw new DatabaseException("SQL Exception on Select");
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}

		return model;
	}

	public List getList() throws DatabaseException {
		ArrayList al = new ArrayList();
		TblMoviesDBModel model;
		Connection connection = null;
		PreparedStatement statement = null;
		String sql =
			"select id, name, comment, rating, scale, worthSeeingAgain from Movies";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				model = new TblMoviesDBModel();

				model.setId(resultSet.getInt(1));
				model.setName(resultSet.getString(2));
				model.setComment(resultSet.getString(3));
				model.setRating(resultSet.getInt(4));
				model.setScale(resultSet.getInt(5));
				model.setWorthSeeingAgain(resultSet.getString(6));

				al.add(model);
			}

			resultSet.close();
		} catch (SQLException e) {
			throw new DatabaseException("SQL Exception on Select");
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}

		return al;
	}

	public void delete(TblMoviesPK pk)
		throws ObjectNotFoundException, DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "delete from Movies where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, pk.getId());

			int rowCount = statement.executeUpdate();

			if (rowCount != 1) {
				if (rowCount == 0) {
					throw new ObjectNotFoundException("Error deleting row");
				} else {
					throw new DatabaseException("Error deleting row");
				}
			}
		} catch (SQLException e) {
			throw new DatabaseException("SQL Exception on Delete");
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	public void deleteAll() throws DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "delete from Movies";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("SQL Exception on Delete All");
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
	}
}