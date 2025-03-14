package com.project.domain;

import com.project.db.ConnectionException;
import com.project.db.DatabaseConnection;
import com.project.entities.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJDBC implements CarDAO {
    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public CarDaoJDBC(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    public  List<Car> getCarros(){
        List<Car>  carros = new ArrayList<>();
        conn = DatabaseConnection.getConnection();
        try{
            st = conn.prepareStatement("SELECT * FROM CARRO");
            rs = st.executeQuery();
            while (rs.next()){
               carros.add(instantiateCarro(rs));

            }


        }catch(SQLException error){
            throw new ConnectionException(error.getMessage());
        }
        finally {
            DatabaseConnection.closeStatement(st);
            DatabaseConnection.closeResultSet(rs);
        }
        return carros;
    }

    @Override
    public Car getid(Integer id) {
        conn = DatabaseConnection.getConnection();
        try {
            st = conn.prepareStatement("SELECT * FROM CARRO WHERE ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
               return  instantiateCarro(rs);
            }

        }catch(SQLException error){
            throw new ConnectionException(error.getMessage());
        }
        finally {
            DatabaseConnection.closeStatement(st);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public void deleteid(Integer id) {
        conn = DatabaseConnection.getConnection();
        try {
            st = conn.prepareStatement("DELETE FROM CARRO WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();

        }catch(SQLException error){
            throw new ConnectionException(error.getMessage());
        }
        finally {
            DatabaseConnection.closeStatement(st);
            DatabaseConnection.closeResultSet(rs);
        }

    }

    @Override
    public void update(Integer idEntity, Car newCarro) {
        conn = DatabaseConnection.getConnection();
        try{
            st = conn.prepareStatement("UPDATE CARRO SET nome=?, descricao=?, url_video=?," +
                    "latitude=?, longitude=?, tipo=?, url_foto=? Where id=?");
            configurePreparedStament(st, idEntity , newCarro);
            st.executeUpdate();

        }catch(SQLException error){
            throw new ConnectionException(error.getMessage());
        }
        finally {
            DatabaseConnection.closeStatement(st);
            DatabaseConnection.closeResultSet(rs);
        }

    }

    @Override
    public void created(Car newCarro) {
        conn = DatabaseConnection.getConnection();

        try{
            st = conn.prepareStatement("INSERT INTO CARRO (nome, descricao, url_video, latitude, longitude, tipo, url_foto)"+
                   " VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            configurePreparedStament(st,newCarro);
           int row = st.executeUpdate();
           if(row != 0){
              rs = st.getGeneratedKeys();
              if(rs.next()) {
                  // esse um consegue indica o id mais novo gerado pelo AUTO_INCREMENT DO SGBD
                  newCarro.setId(rs.getInt(1));
              }


           }

        }catch(SQLException error ){
            throw new ConnectionException(error.getMessage());

        }
        finally {
            DatabaseConnection.closeStatement(st);
            DatabaseConnection.closeResultSet(rs);
        }

    }

    private Car instantiateCarro(ResultSet rs) throws SQLException{
        Car c = new Car();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("nome"));
        c.setDescription(rs.getString("descricao"));
        c.setLatitude(rs.getString("latitude"));
        c.setLogitude(rs.getString("longitude"));
        c.setType(rs.getString("tipo"));
        c.setUrlVideo(rs.getString("url_video"));
        c.setUrlPhoto((rs.getString("url_foto")));
        return c;

    }
    // Achei melhor fazer uma sobrecarga para melhor organizacao do codigo.
    private void configurePreparedStament( PreparedStatement st, Integer id, Car newCarro) throws SQLException{
        st.setString(1,newCarro.getname());
        st.setString(2,newCarro.getDescription());
        st.setString(3,newCarro.getUrlVideo());
        st.setString(4,newCarro.getLatitude());
        st.setString(5,newCarro.getLogitude());
        st.setString(6,newCarro.getType());
        st.setString(7,newCarro.getUrlPhoto());
        st.setInt(8, id);


    }

    private void configurePreparedStament( PreparedStatement st,  Car newCarro) throws SQLException{
        st.setString(1,newCarro.getname());
        st.setString(2,newCarro.getDescription());
        st.setString(3,newCarro.getUrlVideo());
        st.setString(4,newCarro.getLatitude());
        st.setString(5,newCarro.getLogitude());
        st.setString(6,newCarro.getType());
        st.setString(7,newCarro.getUrlPhoto());



    }



}
