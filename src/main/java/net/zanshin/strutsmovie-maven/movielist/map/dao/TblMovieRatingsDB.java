package movielist.map.dao;

import movielist.map.ObjectNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TblMovieRatingsDB extends BaseDAO {

	public TblMovieRatingsDB() {
		super();
	}

	public void insert(TblMovieRatingsDBModel model) throws DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "insert into MovieRatings (id, description) values(?,?)";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, model.getId());
			statement.setString(2, model.getDescription());

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

	public void update(TblMovieRatingsDBModel model)
		throws ObjectNotFoundException, DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "update MovieRatings set description = ? where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, model.getDescription());
			statement.setInt(2, model.getId());

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

	public TblMovieRatingsDBModel getByPrimaryKey(TblMovieRatingsPK pk)
		throws ObjectNotFoundException, DatabaseException {
		TblMovieRatingsDBModel model = new TblMovieRatingsDBModel();
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select description from MovieRatings where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, pk.getId());

			ResultSet resultSet = statement.executeQuery();

			if (!resultSet.next()) {
				throw new ObjectNotFoundException("row does not exist");
			}

			model.setId(pk.getId());
			model.setDescription(resultSet.getString(1));

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
		TblMovieRatingsDBModel model;
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select id, description from MovieRatings";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				model = new TblMovieRatingsDBModel();

				model.setId(resultSet.getInt(1));
				model.setDescription(resultSet.getString(2));

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

	public void delete(TblMovieRatingsPK pk)
		throws ObjectNotFoundException, DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "delete from MovieRatings where id = ?";

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
}