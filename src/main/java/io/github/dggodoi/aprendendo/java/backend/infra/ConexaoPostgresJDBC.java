/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dggodoi.aprendendo.java.backend.infra;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @ kmx
 */
public class ConexaoPostgresJDBC implements ConexaoJDBC {

    private Connection con = null;
    
    public ConexaoPostgresJDBC() throws SQLException,ClassNotFoundException{
        Class.forName("org.postgresql.Driver");        
        this.con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","kamuxsql");
        this.con.setAutoCommit(false);
        
                   }

    public Connection getConnection() {
     return  this.con;
    }

    public void close() {
      if(this.con != null){
          try{
              this.con.close();
          }
          catch(SQLException ex){
             // Logger.getLogger(ConexaoPostgresJDBC.class).log(Level.SEVERE,null,ex);
          }
      }
    }

    public void commit() throws SQLException {
       this.con.commit();
       this.close();
    }

    public void rollback() {
      if(this.con != null){
          try{
              this.con.rollback();
          }
          catch(SQLException ex){
              //Logger.getLogger(ConexaoPostgresJDBC.class).log(Level.SEVERE,null,ex);
          }
          finally{
              this.close();
          }
      }
    }
    
}
