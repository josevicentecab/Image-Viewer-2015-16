/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author josevicentecabanas
 */
public class ReaderBD {
    public static ArrayList<String> read () throws ClassNotFoundException, SQLException {
      ArrayList<String> array = new ArrayList<>();
      Class.forName("org.sqlite.JDBC");
      Connection c = DriverManager.getConnection("jdbc:sqlite:/Users/josevicentecabanas/Documents/Proyectos Netbeans/Kata4-bd/Libs/Mail");
      System.out.println("Opened database successfully");
      
       Statement stmt = c.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM MAIL");
      
      
      while (rs.next()){
          System.out.println("NAME = " + rs.getString("NAME"));
          array.add(rs.getString("Name"));
      }
      
      rs.close();
      stmt.close();
      c.close();
      return array;
    }
}
