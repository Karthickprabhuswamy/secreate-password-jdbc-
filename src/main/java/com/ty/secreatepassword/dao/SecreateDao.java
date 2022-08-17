package com.ty.secreatepassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ty.secreatepassword.dto.SecreatePassword;
import com.ty.secreatepassword.helper.ConnectionObject;
import com.ty.secreatepassword.helper.Encryption;

public class SecreateDao {

	public void saveAllPassword(List<SecreatePassword> password) {

		Connection connection = ConnectionObject.getConnection();

		String query = "INSERT INTO ty_storepassword.secrete VALUES(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			for (SecreatePassword secreate : password) {
				preparedStatement.setInt(1, secreate.getUserid());
				preparedStatement.setString(2, secreate.getName());
				preparedStatement.setString(3, Encryption.encrypt(secreate.getKey()));
				preparedStatement.setString(4, Encryption.encrypt(secreate.getPassword()));
				preparedStatement.setString(5, secreate.getDiscription());
				preparedStatement.addBatch();

			}
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public SecreateDao deletePassWordByKey(String key) {
		Connection connection = ConnectionObject.getConnection();

		String query = "delete from ty_storepassword.secrete where key ='" + key + "'";

		try {
			Statement statement = connection.createStatement();

			statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePassWords(String key, SecreatePassword secreate)

	{
		Connection connection = ConnectionObject.getConnection();

		String query = "Update from ty_storepassword.secreatepassword set key=?,name=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, secreate.getKey());
			preparedStatement.setString(2, secreate.getPassword());

			preparedStatement.addBatch();
			preparedStatement.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
