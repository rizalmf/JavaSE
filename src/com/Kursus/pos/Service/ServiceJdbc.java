/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Kursus.pos.Service;

import com.Kursus.Source.MysqlDataSource;
import com.Kursus.pos.DAO.PengajarDAO;
import com.Kursus.pos.model.Pengajar;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ngarambes
 */
public class ServiceJdbc {
    private Connection connection;
    private PengajarDAO pengajarDao;
    
    public void setDataSource(MysqlDataSource dataSource){
        try{
        connection = dataSource.getConnection();
        pengajarDao = new PengajarDAO();
        pengajarDao.setConnection(connection);
        } catch(ClassNotFoundException e){
            e.printStackTrace(); 
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public Pengajar save(Pengajar pengajar){
        try {
            connection.setAutoCommit(false);
            pengajarDao.save(pengajar);
            connection.commit();
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Menyimpan data Berhasil");
        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, "Menyimpan data Gagal");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return pengajar;
    }
    public Pengajar delete(Pengajar pengajar){
        try {
            connection.setAutoCommit(false);
            pengajarDao.delete(pengajar);
            connection.commit();
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Menghapus data Berhasil");
        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, "Menghapus data Gagal");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return pengajar;
    }
    public Pengajar update(Pengajar pengajar){
        try {
            connection.setAutoCommit(false);
            pengajarDao.update(pengajar);
            connection.commit();
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Mengubah data Berhasil");
        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, "Mengubah data Gagal");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return pengajar;
    }
    public Pengajar getPengajar(String id){
        try {
            return pengajarDao.getById(id);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;        
    }
    public List<Pengajar> getAll(){
        try {
            return pengajarDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Pengajar>();
    }
    
    
}
