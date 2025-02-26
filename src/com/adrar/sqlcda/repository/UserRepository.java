package com.adrar.sqlcda.repository;

import com.adrar.sqlcda.db.Bdd;
import com.adrar.sqlcda.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRepository {

    private static Connection connection = Bdd.getConnexion();

    public static User save(User adduser){
        User newUser = null;
        try{
            String sql = "INSERT INTO users(firstname,lastname,email,password) VALUE(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,adduser.getFirstname());
            preparedStatement.setString(2,adduser.getLastname());
            preparedStatement.setString(3,adduser.getEmail());
            preparedStatement.setString(4,adduser.getPassword());

            int nbrRows = preparedStatement.executeUpdate();
            if(nbrRows>0){
                newUser = new User();
                newUser.setFirstname(adduser.getFirstname());
                newUser.setLastname(adduser.getLastname());
                newUser.setEmail(adduser.getEmail());
                newUser.setPassword(adduser.getPassword());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return newUser;
    }
}
