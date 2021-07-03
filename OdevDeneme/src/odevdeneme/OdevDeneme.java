package odevdeneme;
import java.sql.Statement;
import java.lang.Object;
import java.lang.String;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class OdevDeneme {

    public static void Ekle()
    {
        Scanner scan= new Scanner(System.in,"iso-8859-9");
        System.out.print("ID :");
        int idx=scan.nextInt();
        System.out.print("Öğretmen :");
        int ogretmen=scan.nextInt();
        System.out.print("Yeni Ders Adi     :");
        String dersAdi = scan.next();
        System.out.print("Yeni Ders Kodu    :");
        String dersKod=scan.next();
        System.out.print("Derslik :");
        String drslik=scan.next();
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/db_derslik","root","1234");
            Statement stmt=con.createStatement(); 
            String sorgu=String.format("insert into tbl_ders values( %d, %d, '%s','%s','%s')", idx,ogretmen,dersAdi,dersKod,drslik);
            int ekleme = stmt.executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        }catch(Exception e){ System.out.println(e);}
        
            
    }

    public static void main(String[] args) {
//            public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/db_derslik","root","1234");  
        }catch(Exception e){ System.out.println(e);}
       
        
        Scanner scan= new Scanner(System.in,"iso-8859-9");

            System.out.println("*************");
            System.out.println("1.Ekle");
            System.out.println("*************");
            Ekle();

    }
    }
