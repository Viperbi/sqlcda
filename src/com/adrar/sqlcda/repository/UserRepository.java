package com.adrar.sqlcda.repository;

import com.adrar.sqlcda.db.Bdd;
import com.adrar.sqlcda.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static Connection connection = Bdd.getConnexion();

    public static User save(User adduser) {
        User newUser = null;
        try {
            String sql = "INSERT INTO users(firstname,lastname,email,password) VALUE(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, adduser.getFirstname());
            preparedStatement.setString(2, adduser.getLastname());
            preparedStatement.setString(3, adduser.getEmail());
            preparedStatement.setString(4, adduser.getPassword());

            int nbrRows = preparedStatement.executeUpdate();
            if (nbrRows > 0) {
                newUser = new User();
                newUser.setFirstname(adduser.getFirstname());
                newUser.setLastname(adduser.getLastname());
                newUser.setEmail(adduser.getEmail());
                newUser.setPassword(adduser.getPassword());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    public static boolean isExist(String email) {
        boolean getUser = false;
        try {
            String sql = "SELECT id FROM users WHERE email = ?";
            //préparer la requête
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //Bind le paramètre
            preparedStatement.setString(1, email);
            //récupérer le resultat de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            //Vérification du résultat
            while (resultSet.next()) {
                getUser = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getUser;
    }

    public static User findByEmail(String email) throws SQLException {
        User newUser = new User();
        if (isExist(email)) {
            String sql = "SELECT id,firstname,lastname,email FROM users WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            newUser.setFirstname(resultSet.getString(2));
            newUser.setLastname(resultSet.getString(3));
            newUser.setEmail(resultSet.getString(4));
            newUser.setId(resultSet.getInt(1));
        } else {
            System.out.println("Ce compte n'existe pas.");
            return null;
        }
        return newUser;
    }

    public static List<User> findAll() throws SQLException {
        List<User> liste = new ArrayList<User>();
        String sql = "SELECT id,firstname,lastname,email FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User newUser = new User();
            newUser.setFirstname(resultSet.getString(2));
            newUser.setLastname(resultSet.getString(3));
            newUser.setEmail(resultSet.getString(4));
            newUser.setId(resultSet.getInt(1));
            liste.add(newUser);
        }
        return liste;
    }

    public static User update(User u, String email) throws SQLException {
        try {
            if (isExist(email)) {
                String sql = "UPDATE id=?,firstname=?,lastname=?,email=?,password=? FROM users WHERE email = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, u.getId());
                preparedStatement.setString(2, u.getFirstname());
                preparedStatement.setString(3, u.getLastname());
                preparedStatement.setString(4, u.getEmail());
                preparedStatement.setString(5, u.getPassword());
                preparedStatement.setString(6, email);
                preparedStatement.executeUpdate();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
