/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cars;

/**
 *
 * @author thewagdy
 */
public class ReadRecord {
    
    
    private Connection conn;
    private ResultSet results;
    private Cars car = new Cars();
    private int CARID;
    
    
    
    public ReadRecord(int CARID){
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String pass = props.getProperty("user.password");
        
       
        this.CARID = CARID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead(){
    
        try {
            //set up a string to hold our query
            String query ="SELECT * FROM Cars WHERE CARID = ?";
            
            //create a preparedstatement using our query string
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the prepared statement
            
            ps.setInt(1, CARID);
            
            //execute query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            car.setCARID(this.results.getInt("CARID"));
            car.setCARMAKE(this.results.getString("CARMAKE"));
            car.setCARMODEL(this.results.getString("CARMODEL"));
            car.setCARYEAR(this.results.getInt("CARYEAR"));
            car.setCARCOLOR(this.results.getString("CARCOLOR"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    public Cars getCAR(){
        return this.car;
    }
}
