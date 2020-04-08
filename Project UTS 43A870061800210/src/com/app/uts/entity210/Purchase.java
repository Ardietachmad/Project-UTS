/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity210;


public class Purchase {

    //pembuatan variable
    private String Idpr;
    private String Deskripsi;
    private String TanggalPR;
    private String RequestPrR;
    private String Total;
    

    public Purchase() {
    }

    //pembuatan constructor
    public Purchase(String idPr, String deskripsi, String tanggal, String requestprt, String totalpr) {
        this.Idpr = idPr;
        this.Deskripsi = deskripsi;
        this.TanggalPR = tanggal;
        this.RequestPrR= requestprt;
        this.Total = totalpr;
       
    }

    //pembuatan getter dan setter untuk variable yang sudah dibuat
    public String getidPr() {
        return Idpr;
    }

    public void setidPr(String idPr) {
        this.Idpr = idPr;
    }

    public String getdeskripsi() {
        return Deskripsi;
    }

    public void setdeskripsi(String deskripsi) {
        this.Deskripsi = deskripsi;
    }

    public String gettanggal() {
        return TanggalPR;
    }

    public void settanggal(String tanggal) {
        this.TanggalPR = tanggal;
    }

    public String getrequestprtt() {
        return RequestPrR;
    }

    public void setrequestprt(String requestprt) {
        this.RequestPrR= requestprt;
    }

    public String gettotalpr() {
        return Total;
    }

    public void settotalpr(String totalpr) {
        this.Total = totalpr;
    }

   

    //pembuatan object untuk tampil data
    public Object getValue(int index) {
        switch (index) {
            case 0:
                return Idpr;
            case 1:
                return Deskripsi;
            case 2:
                return TanggalPR;
            case 3:
                return RequestPrR;
            case 4:
                return Total;

            default:
                return null;
        }
    }
}
