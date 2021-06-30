package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.DbConnection;
import com.dto.Schemes;
import com.dto.Taxes;
import com.dto.Users;

public class Database {
	public int register(Users user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "insert into UserTable values(?,?,?,?,?,?,?)";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getMobileNo());
			preparedStatement.setString(4, user.getState());
			preparedStatement.setString(5, user.getCity());
			preparedStatement.setString(6, user.getAadharNo());
			preparedStatement.setString(7, user.getPassword());

			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return 0;
	}

	public Users getUser(String userName, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String SELECT = "select * from UserTable where userName=? and password=?";
		connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				Users user = new Users();
				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				return user;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public Users getProfile(String userName, String email,String mobileNo,String state,String city,String aadharNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String SELECT = "select * from UserTable where userName=?";
		connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, userName);

			ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
			if(resultSet.next()){
				Users user = new Users();
				user.setUserName(resultSet.getString(1));
				user.setEmail(resultSet.getString(2));
				user.setMobileNo(resultSet.getString(3));
				user.setState(resultSet.getString(4));
				user.setCity(resultSet.getString(5));
				user.setAadharNo(resultSet.getString(6));
				return user;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Schemes> getSchemes() {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		con = DbConnection.getConnection();
		String SELECT = "select * from SchemesTable";
		List<Schemes> arrayList = new ArrayList<Schemes>();
		try {
			preparedStatement = con.prepareStatement(SELECT);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Schemes scheme = new Schemes();
				scheme.setSchemeName(rs.getString(1));
				scheme.setDescription(rs.getString(2));
				scheme.setImageFileName(rs.getString(3));
				arrayList.add(scheme);
			}
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int uploadScheme(Schemes scheme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "insert into SchemesTable values(?,?,?)";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, scheme.getSchemeName());
			preparedStatement.setString(2, scheme.getDescription());
			preparedStatement.setString(3, scheme.getImageFileName());

			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return 0;
	}
	public int deleteScheme(String schemeName,String description,String imageFileName) {
		Connection con = null;
		PreparedStatement pst = null;
		String DELETE="delete from SchemesTable where schemeName = ? and description = ? and imageFileName = ?";
	
			con = DbConnection.getConnection();
			try {
				pst = con.prepareStatement(DELETE);
				pst.setString(1, schemeName);
				pst.setString(2, description);
				pst.setString(3, imageFileName);
				int x = pst.executeUpdate();
				return x;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}
	public Schemes getSchemeDetails(String schemeName, String description,String imageFileName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SELECT = "select * from SchemesTable where schemeName=? and description=? and imageFileName=?";
		connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			System.out.println("dao : " + schemeName);
			System.out.println("dao1 : " + description);
			System.out.println("dao2 : " + imageFileName);
			preparedStatement.setString(1, schemeName);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, imageFileName);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				Schemes scheme = new Schemes();
				scheme.setSchemeName(resultSet.getString(1));
				scheme.setDescription(resultSet.getString(2));
				scheme.setImageFileName(resultSet.getString(3));
				return scheme;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public int update(Schemes scheme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		System.out.println("in update method" + scheme);
		String UPDATE = "UPDATE SchemesTable set description=? where schemeName=?";
		System.out.println(UPDATE);
		connection = DbConnection.getConnection();

		try{
			preparedStatement = connection.prepareStatement(UPDATE);
			System.out.println("in update method" + scheme.getSchemeName() + " " + scheme.getDescription() + " " + scheme.getImageFileName());
			preparedStatement.setString(2, scheme.getSchemeName());
			preparedStatement.setString(1, scheme.getDescription());
			//preparedStatement.setString(3, scheme.getImageFileName());
			result = preparedStatement.executeUpdate();
			System.out.println(result + "updated rows");
			return result;

		}catch(SQLException e){
			e.printStackTrace();
		}

		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int updateUser(Users user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		System.out.println("in update method" + user);
		String UPDATE = "UPDATE UserTable set email=?,mobileNo=?,state=?,city=?,aadharNo=? where userName=?";
		System.out.println(UPDATE);
		connection = DbConnection.getConnection();

		try{
			preparedStatement = connection.prepareStatement(UPDATE);
			//System.out.println("in update method" + scheme.getSchemeName() + " " + scheme.getDescription() + " " + scheme.getImageFileName());
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getMobileNo());
			preparedStatement.setString(3, user.getState());
			preparedStatement.setString(4, user.getCity());
			preparedStatement.setString(5, user.getAadharNo());
			preparedStatement.setString(6, user.getUserName());
			result = preparedStatement.executeUpdate();
			System.out.println(result + "updated rows");
			return result;

		}catch(SQLException e){
			e.printStackTrace();
		}

		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int registerTax(Taxes tax) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "insert into TaxTable values(?,?,?,?,?)";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, tax.getUserName());
			preparedStatement.setString(2, tax.getEmail());
			preparedStatement.setString(3, tax.getMobileNo());
			preparedStatement.setString(4, tax.getTaxName());
			preparedStatement.setString(5, tax.getAmount());

			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return 0;
	}
	public List<Taxes> getTaxes() {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		con = DbConnection.getConnection();
		String SELECT = "select * from TaxTable";
		List<Taxes> arrayList = new ArrayList<Taxes>();
		try {
			preparedStatement = con.prepareStatement(SELECT);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Taxes tax = new Taxes();
				tax.setUserName(rs.getString(1));
				tax.setEmail(rs.getString(2));
				tax.setMobileNo(rs.getString(3));
				tax.setTaxName(rs.getString(4));
				tax.setAmount(rs.getString(5));
				arrayList.add(tax);
			}
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
