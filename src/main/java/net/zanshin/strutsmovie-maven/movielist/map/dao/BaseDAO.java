package movielist.map.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	Connection getConnection() {
		// todo...
		return null;
	}

	void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
                // todo...
			}
		}
	}

	void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
                // todo...
			}
		}
	}
}