package com.project.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection {

    private static Connection conn  = null;
    public static Connection getConnection(){
        try {

            if (conn == null) {
                Properties props = createProperties();
                String url = props.getProperty("db_url");
                conn = DriverManager.getConnection(url, props);


            }
        }catch(SQLException error){
            throw new ConnectionException(error.getMessage());
            }
        return conn;
    }

    private static Properties createProperties() {
        String path = "//home//ricado//Documentos//estudo//" +
                "java//cat//src//main//java//com//project//db//db.properties";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Properties properties = new Properties();
            properties.load(br);
            return properties;

        } catch (IOException error) {
            throw new ConnectionException(error.getMessage());

        }
    }
        public static void closeStatement(Statement st){
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException error) {
                    throw new ConnectionException(error.getMessage());
                }
            }
        }

        public static void closeResultSet(ResultSet rs) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException error) {
                    throw new ConnectionException(error.getMessage());
                }
            }
        }

}




