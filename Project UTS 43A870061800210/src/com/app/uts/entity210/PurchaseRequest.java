/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity210;

import com.app.uts210.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PurchaseRequest {
    private Connection connection;
    
    //berisi fungsi atau method bisa melakukan operasi database
    public PurchaseRequest(){
        connection = ConnectionUtil.getConnection();
    }
    
    public List<Purchase> getALL(){
        List<Purchase> list = new ArrayList<>();
        String sql = "SELECT * FROM procurement";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Purchase mhs;
            while (rs.next()) {                
                mhs = new Purchase();
                mhs.setidPr(rs.getString("id"));
                mhs.setdeskripsi(rs.getString("deskripsi"));
                mhs.settanggal(rs.getString("tanggal"));
                mhs.setrequestprt(rs.getString("Request Pr"));
                mhs.settotalpr(rs.getString("total pr"));
                
                list.add(mhs);
            }
        } catch (Exception e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    //mengambil data tunggal / 1 id saja
    public Purchase getByID(String IdPr){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM procurement WHERE IdPr = ?";
        Purchase mhs = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, IdPr);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
                mhs = new Purchase();
                mhs.setidPr(rs.getString("id"));
                mhs.setdeskripsi(rs.getString("deskripsi"));
                mhs.settanggal(rs.getString("tanggal"));
                mhs.setrequestprt(rs.getString("Request Pr"));
                mhs.settotalpr(rs.getString("total pr"));
            }
        } catch (Exception e) {
        }
        return mhs;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(Purchase mhs){
        boolean status = false;
        String sql = "INSERT INTO procurement VALUES (?,?,?,?,?,)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, mhs.getidPr());
            statement.setString(2, mhs.getdeskripsi());
            statement.setString(3, mhs.gettanggal());
            statement.setString(4, mhs.getrequestprtt());
            statement.setString(5, mhs.gettotalpr());
          
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(Purchase mhs){
        boolean status = false;
        String sql = "UPDATE procurement SET idpr=?, Deskripsi=?, TanggalPR=?, RequestPrR=?, Total=? " +
                "WHERE IdPr=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            statement.setString(1, mhs.getidPr());
            statement.setString(2, mhs.getdeskripsi());
            statement.setString(3, mhs.getrequestprtt());
            statement.setString(4, mhs.gettanggal());
            statement.setString(5, mhs.gettotalpr());
            
           
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(Purchase mhs){
        boolean status = false;
        String sql = "DELETE FROM Procurement WHERE Idpr=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(6, mhs.getidPr());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
}
