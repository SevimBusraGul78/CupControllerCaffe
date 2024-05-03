package com.IsteMYSql.Util;
import   java.sql.*;

public class VeritabaniUtil {
	static Connection conn=null;
	
	
	public static Connection Baglan() {
		try {
			//jdbc:mysql://ServerIPAdresi/db_ismi","kullanici","sifre"
			conn=DriverManager.getConnection("jdbc:mysql://localhost/caffeotomasyonu","root","sifre"); //tür olarak string değeri vermek zorundayız
		   return conn;
		
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null ;
		}
	}

}
