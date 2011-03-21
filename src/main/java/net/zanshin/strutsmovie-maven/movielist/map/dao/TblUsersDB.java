package movielist.map.dao;

import movielist.map.ObjectNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TblUsersDB extends BaseDAO {
	public TblUsersDB() {
		super();
	}

	public void insert(TblUsersDBModel model) throws DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "insert into Users (userId, password) values(?,?)";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, model.getUserId());
			statement.setString(2, model.getPassword());

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

	public void update(TblUsersDBModel model)
		throws ObjectNotFoundException, DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "update users set password = ? where userId = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, model.getPassword());
			statement.setString(2, model.getUserId());

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

	public TblUsersDBModel getByPrimaryKey(TblUsersPK pk)
		throws ObjectNotFoundException, DatabaseException {
		TblUsersDBModel model = new TblUsersDBModel();
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select password from MovieRatings where userId = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, pk.getUserId());

			ResultSet resultSet = statement.executeQuery();

			if (!resultSet.next()) {
				throw new ObjectNotFoundException("row does not exist");
			}

			model.setUserId(pk.getUserId());
			model.setPassword(resultSet.getString(1));

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
		TblUsersDBModel model;
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select userId, password from Users";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				model = new TblUsersDBModel();

				model.setUserId(resultSet.getString(1));
				model.setPassword(resultSet.getString(2));

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

	public void delete(TblUsersPK pk)
		throws ObjectNotFoundException, DatabaseException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "delete from Users where userId = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, pk.getUserId());

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