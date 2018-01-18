/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Kursus.pos.DAO;

import com.Kursus.pos.model.Pengajar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngarambes
 */
public class PengajarDAO {
    private Connection connection;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllStatement;
    
    private final String insertQuery = "insert into pengajar values(?, ?, ?, ?, ?)";
    private final String updateQuery = "update pengajar set nama=? ,nomor_hp=?, usia=?, gaji=? where id=?";
    private final String deleteQuery = "delete from pengajar where id=?";
    private final String getByIdQuery= "select * from pengajar where id=?";
    private final String getAllQuery = "select * from pengajar";
    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = connection;
        insertStatement = this.connection.prepareStatement(insertQuery);
        updateStatement = this.connection.prepareStatement(updateQuery);
        deleteStatement = this.connection.prepareStatement(deleteQuery);
        getByIdStatement= this.connection.prepareStatement(getByIdQuery);
        getAllStatement = this.connection.prepareStatement(getAllQuery);
    }
    public Pengajar save(Pengajar pengajar)throws SQLException{ 
        insertStatement.setString(1, pengajar.getId()); 
        insertStatement.setString(2, pengajar.getNama()); 
        insertStatement.setString(3, pengajar.getNomor_hp()); 
        insertStatement.setInt(4, pengajar.getUsia()); 
        insertStatement.setInt(5, pengajar.getGaji()); 
        insertStatement.executeUpdate();  
        return pengajar;
    }
    public Pengajar update(Pengajar pengajar) throws SQLException{
        updateStatement.setString(1, pengajar.getNama());
        updateStatement.setString(2, pengajar.getNomor_hp());
        updateStatement.setInt(3, pengajar.getUsia());;
        updateStatement.setInt(4, pengajar.getGaji());
        updateStatement.setString(5, pengajar.getId());
        updateStatement.executeUpdate();
        return pengajar;
    }
    public Pengajar delete(Pengajar pengajar) throws SQLException{
        deleteStatement.setString(1, pengajar.getId());
        deleteStatement.executeUpdate();
        return pengajar;
    }
    public Pengajar getById(String id) throws SQLException{
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();
        if (rs.next()) {
            Pengajar pengajar = new Pengajar();
            pengajar.setId(rs.getString("id"));
            pengajar.setNama(rs.getString("nama"));
            pengajar.setNomor_hp(rs.getString("nomor_hp"));
            pengajar.setUsia(rs.getInt("usia"));
            pengajar.setGaji(rs.getInt("gaji"));
            return pengajar;
        }
        return null;
    }
    public List<Pengajar> getAll() throws SQLException{
        ResultSet rs = getAllStatement.executeQuery();
        List<Pengajar> listPengajar = new ArrayList<Pengajar>();
        while (rs.next()) {
            Pengajar pengajar = new Pengajar();
            pengajar.setId(rs.getString("id"));
            pengajar.setNama(rs.getString("nama"));
            pengajar.setNomor_hp(rs.getString("nomor_hp"));
            pengajar.setUsia(rs.getInt("usia"));
            pengajar.setGaji(rs.getInt("gaji"));
            listPengajar.add(pengajar);
            }
        return listPengajar;
    }
}
