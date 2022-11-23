package com.mycompany.corejdbc.m3c1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductsComponent {

	public boolean tryConnection() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?user=root&password=password&serverTimezone=UTC");
		boolean isValid= conn.isValid(2);
		conn.close();
		
		return isValid;
    }

}

