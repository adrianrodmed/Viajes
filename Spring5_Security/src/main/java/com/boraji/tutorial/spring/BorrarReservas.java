package com.boraji.tutorial.spring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorrarReservas
 */
public class BorrarReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarReservas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idReserva = Integer.parseInt(request.getParameter("idReserva"));

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/viajes", "root", "");
			PreparedStatement pstmt2;
			pstmt2 = conn.prepareStatement("delete from reservas where idReserva=?");
			
			pstmt2.setInt(1, idReserva);
			pstmt2.execute();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}
