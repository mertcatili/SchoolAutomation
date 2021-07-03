
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mert
 */
public class Ekleme {

    public static Statement dbState() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/db_derslik", "root", "1234");
            Statement stmt = connection.createStatement();
            return stmt;
        } catch (Exception e) {
            System.out.println("Database Bağlantısı Kurulurken bir hata oluştu...");
            return null;
        }
    }
    public void DersEkle(int ogr, String dersAdi, String dersKod, String derslik) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList liste = new ArrayList();
            String sorgu1 = String.format("select * from tbl_ders");
            ResultSet ekleme1 = dbState().executeQuery(sorgu1);
            while (ekleme1.next()) {
                liste.add(ekleme1.getString("ID"));
            }
            int deger = liste.size();
            String sorgu = String.format("insert into tbl_ders values( %d, %d, '%s','%s','%s')", (deger+ 1), ogr, dersAdi, dersKod, derslik);
            int ekleme = dbState().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void OgretmenEkle(String ogretmenAdi) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList liste = new ArrayList();
            String sorgu1 = String.format("select * from tbl_ogretmen");
            ResultSet ekleme1 = dbState().executeQuery(sorgu1);
            while (ekleme1.next()) {
                liste.add(ekleme1.getString("ID"));
            }
            int deger = liste.size();
            String sorgu = String.format("insert into tbl_ogretmen values( %d, '%s')", (deger + 1), ogretmenAdi);
            int ekleme = dbState().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void OgrenciEkle(String ogrenciAdi) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList liste = new ArrayList();
            String sorgu1 = String.format("select * from tbl_ogrenci");
            ResultSet ekleme1 = dbState().executeQuery(sorgu1);
            while (ekleme1.next()) {
                liste.add(ekleme1.getString("ID"));
            }
            int deger = liste.size();
            String sorgu = String.format("insert into tbl_Ogrenci values( %d, '%s')", (deger + 1), ogrenciAdi);
            int ekleme = dbState().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void DersSec(int ders, int ogr) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList liste = new ArrayList();
            String sorgu1 = String.format("select * from tbl_sinif");
            ResultSet ekleme1 = dbState().executeQuery(sorgu1);
            while (ekleme1.next()) {
                liste.add(ekleme1.getString("ID"));
            }
            int deger = liste.size();
            String sorgu = String.format("insert into tbl_sinif values( %d, %d, %d)", (deger + 1), ders, ogr);
            int ekleme = dbState().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }
}
