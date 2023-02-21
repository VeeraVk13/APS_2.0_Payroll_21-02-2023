package utillity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import constant.APS_contsant;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class db_connection{
    static Logger log = Logger.getLogger(db_connection.class);

    @Test
    public void name() throws ClassNotFoundException {

        String connectionUrl = APS_contsant.connectionUrl;
        String driver = APS_contsant.DBdriver;
        Connection connection = null;
        Statement statement = null;
        ResultSet Rs = null;

        try {
            Class.forName(driver);

            connection = DriverManager.getConnection(connectionUrl);
            log.info("connection established");
            statement = connection.createStatement();
            String SQL = "select * from Persons";

            Rs = statement.executeQuery(SQL);
            while (Rs.next()) {
                System.out.println(Rs.getString(1) + " " + Rs.getString(2) + " " + Rs.getString(3) + " " + Rs.getString(4) + " " + Rs.getString(5));

            }

        } catch (SQLException e) {
            log.error("error" + e);

        }
    }

}
