package com.register.conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Conexion {

    private String db = "user_db";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.cj.jdbc.Driver";
    Statement stmt = null;
    Connection con = null;

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    //Contructor
    public Conexion(String db) {
        this.db = db;
    }

    public Conexion() {
    }

    public Connection connect() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, password);
            System.out.println("Connected to: " + db);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Not connected to: " + db);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void stament(String query) {
        try {
            Statement stmt = con.createStatement();
            
            String sql = query;
            // String sql = "SELECT * FROM user";

            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Este usuario no esta dispible.");
            se.printStackTrace();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void verificar(String username,JLabel error) {
        
        boolean resultado = true;
        
        try {
            
            
            String sql = "select * from user where user = '"+username+"'";
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                resultado = false;
                
                entre:
                if(resultado == false){
                    error.setVisible(true);

                }
                
            }else{
                
               error.setVisible(false);
                
            }
            
            
            
            
        } catch (SQLException se) {
            se.printStackTrace();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
