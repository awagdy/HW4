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

public class ReadQuery {

    private Connection conn;
    private ResultSet results;

    public ReadQuery() {

        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String pass = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {
        try {
            String query = "Select * from cars";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getHTMLtable() {
        String table = "";
        table += "<table>";
        table += "<tr class=\"toprow\" >";
        table += "<th>";
        table += "Car ID";
        table += "</th>";
        table += "<th>";
        table += "Car Model";
        table += "</th>";
        table += "<th>";
        table += "Car Make";
        table += "</th>";
        table += "<th>";
        table += "Car Year";
        table += "</th>";
        table += "<th>";
        table += "Car Color";
        table += "</th>";
        table += "<th>";
        table += "Delete a Car from Database";
        table += "</th>";
        table += "</tr>";

        try {
            while (this.results.next()) {
                Cars car = new Cars();
                car.setCARID(this.results.getInt("CARID"));
                car.setCARMAKE(this.results.getString("CARMAKE"));
                car.setCARMODEL(this.results.getString("CARMODEL"));
                car.setCARYEAR(this.results.getInt("CARYEAR"));
                car.setCARCOLOR(this.results.getString("CARCOLOR"));

                table += "<tr class=\"rows\">";

                table += "<td>";
                table += car.getCARID();
                table += "</td>";

                table += "<td>";
                table += car.getCARMAKE();
                table += "</td>";

                table += "<td>";
                table += car.getCARMODEL();
                table += "</td>";

                table += "<td>";
                table += car.getCARYEAR();
                table += "</td>";

                table += "<td>";
                table += car.getCARCOLOR();
                table += "</td>";

                table += "<td>";
                table += "<a href=delete?CARID=" + car.getCARID() + "> Delete </a>";
                table += "</td>";

                table += "</tr>";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";

        return table;

    }
}
