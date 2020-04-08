/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts210;

import com.app.uts.entity210.Purchase;
import com.app.uts.entity210.PurchaseRequest;



public class ConnectMysql {
    PurchaseRequest datasource = new PurchaseRequest();
   
        public static void main(String[] args) {
            //Pemanggilan method insert
            new ConnectMysql().testInsert();
           
            //Pemanggilan method update
          // new ConnectMysql().testUpdate();
    }
        
    //pembuatan method insert
    public void testInsert(){
        //pemanggilan kelas mahasiswa
        Purchase mhs = new Purchase();
        mhs.setidPr("43A87006180119");
        mhs.setdeskripsi("barang mentah");
        mhs.settanggal("8-4-2020");
        mhs.setrequestprt("kosmetik");
        mhs.settotalpr("5");
        boolean sukses = datasource.insert(mhs);
        //berhasil
        if (sukses) {
            System.out.println("Insert Data Berhasil!");
        }else{
            System.out.println("Insert Data Gagal!");
        }
    }
    
    //pembuatan method Update
    public void testUpdate(){
        //pemanggilan kelas getByID
        Purchase mhs = datasource.getByID("43A87006180119");
        mhs.setidPr("43a87555");
        boolean sukses = datasource.update(mhs);
        //berhasil
        if (sukses) {
            System.out.println("Update Data Berhasil!");
        }else{
            System.out.println("Update Data Gagal!");
        }
    }
}
