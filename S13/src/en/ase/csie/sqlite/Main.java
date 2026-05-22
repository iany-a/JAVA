package en.ase.csie.sqlite;

import java.sql.*;
import java.util.Scanner;

public class Main {
    //execute returns Boolean
    //executeUpdate returns an Integer
    //executeQuery returns a ResultSet
    public static void createTable(Connection connection){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS BRANDS");
            statement.executeUpdate("CREATE TABLE BRANDS(ID INTEGER PRIMARY KEY, NAME TEXT, " +
                    "FOUNDINGYEAR INTEGER, REVENUE REAL)");
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void select(Connection connection){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BRANDS");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("NAME"));
                System.out.println(resultSet.getInt("FOUNDINGYEAR"));
                System.out.println(resultSet.getFloat("REVENUE"));
                System.out.println("___________________________");
            }
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void insert(Connection connection){
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO BRANDS VALUES(0, 'Maydup Naem', 1924, 500000)");
            statement.execute("INSERT INTO BRANDS VALUES(1, 'John Java', 1969, 43050)");
            //Scanner scanner= new Scanner(System.in);
            //String name = scanner.nextLine();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO BRANDS VALUES(2, ?, ?, 5000000)");
            preparedStatement.setString(1, "Nike");
            preparedStatement.setInt(2, 1956);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //no NEW keyword for Connection connection
        try (Connection connection = DriverManager.getConnection("JDBC:sqlite:test.db")) {
            connection.setAutoCommit(false); //all commands will be auto-commited in the DB
            createTable(connection);
            insert(connection);
            select(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
