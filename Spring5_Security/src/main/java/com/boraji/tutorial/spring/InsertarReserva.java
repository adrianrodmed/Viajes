package com.boraji.tutorial.spring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		int iddestino = Integer.parseInt(request.getParameter("iddestino"));
		int numeroplazas = Integer.parseInt(request.getParameter("numeroplazas"));
		float preciototal = Integer.parseInt(request.getParameter("preciototal"));
		
	
		try {
			//CONEXION
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes","root","");
			
			
			//INSERTAR USUARIO
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reservas(plazasdisponibles, destino, fecha, precio) VALUES (?, ?, ?, ?)");
			ps.setInt(1, idusuario);
			ps.setInt(2, iddestino);
			ps.setFloat(4, numeroplazas);
			ps.setFloat(4, preciototal);
			ps.executeUpdate();
			response.sendRedirect("ReservaHecha.jsp");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
