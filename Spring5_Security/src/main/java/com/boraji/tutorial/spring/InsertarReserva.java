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
 * Servlet implementation class InsertarReserva
 */
public class InsertarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		int idDestino = Integer.parseInt(request.getParameter("idDestino"));
		int numPlazas = Integer.parseInt(request.getParameter("numPlazas"));
		float precioTotal = Integer.parseInt(request.getParameter("precioTotal"));
		
	
		try {
			//CONEXION
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes","root","");
			
			
			//INSERTAR USUARIO
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reservas(idUsuario, idDestino, numPlazas, precioTotal) VALUES (?, ?, ?, ?)");
			ps.setInt(1, idUsuario);
			ps.setInt(2, idDestino);
			ps.setFloat(4, numPlazas);
			ps.setFloat(4, precioTotal);
			ps.executeUpdate();
			response.sendRedirect("ReservaHecha.jsp");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
