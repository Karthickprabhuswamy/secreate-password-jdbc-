package com.ty.secreatepassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.secreatepassword.dto.SecreatePassword;
import com.ty.secreatepassword.dto.User;
import com.ty.secreatepassword.helper.ConnectionObject;
import com.ty.secreatepassword.helper.Decryption;
import com.ty.secreatepassword.helper.Encryption;

public class UserDao {

	public void saveAllUsers(List<User> user) {

		Connection connection = ConnectionObject.getConnection();

		String query = "INSERT INTO ty_storepassword.user VALUES(?,?,?,?)";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			for (User user2 : user) {
				preparedStatement.setInt(1, user2.getId());
				preparedStatement.setString(2, user2.getName());
				preparedStatement.setString(3, Encryption.encrypt(user2.getEmail()));
				preparedStatement.setString(4, Encryption.encrypt(user2.getPassword()));

				preparedStatement.addBatch();

			}
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public User getUserById(int id) {

		Connection connection = ConnectionObject.getConnection();

		String query = "SELECT * FROM ty_storepassword.user WHERE id=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				User user = new User();

				user.setId(res.getInt(1));
				user.setName(res.getString(2));
				user.setEmail(res.getString(3));
				user.setPassword(Decryption.decrypt(res.getString(4)));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUser() {

		Connection connection = ConnectionObject.getConnection();

		String sql = "Select * From ty_storepassword.user ";

		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet res = statement.executeQuery(sql);

			ArrayList<User> arrayList = new ArrayList<User>();

			while (res.next()) {

				User user = new User();

				user.setId(res.getInt(1));
				user.setName(res.getString(2));
				user.setEmail(res.getString(3));
				user.setPassword(res.getString(4));

				arrayList.add(user);
			}

			return arrayList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<SecreatePassword> getSecretePasswordbyId(int id) {

		if (getUserById(id) != null) {

			Connection connection = ConnectionObject.getConnection();

			String sql = "Select * From ty_storepassword.secrete where userid="+id+"";

			Statement statement;
			try {
				statement = connection.createStatement();

				ResultSet res = statement.executeQuery(sql);

				List<SecreatePassword> arrayList = new ArrayList<SecreatePassword>();

				while (res.next()) {

					SecreatePassword password = new SecreatePassword();

					password.setUserid(res.getInt(1));
					password.setName(res.getString(2));
					password.setKey(res.getString(3));
					password.setPassword(Decryption.decrypt(res.getString(4)));
					password.setDiscription(res.getString(5));

					arrayList.add(password);
				}

				return arrayList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

}
