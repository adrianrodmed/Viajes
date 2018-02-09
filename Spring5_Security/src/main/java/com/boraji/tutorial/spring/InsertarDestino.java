package com.boraji.tutorial.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/InsertarDestino")
public class InsertarDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarDestino() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String plazasdisponibles = request.getParameter("plazasdisponibles");
		String destino = request.getParameter("destino");
		Date fecha = request.getParameter("fecha");
		float precio = Integer.parseInt(request.getParameter("precio"));
		
	
		try {
			//CONEXION
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes","root","");
			
			
			//INSERTAR USUARIO
			PreparedStatement ps = conn.prepareStatement("INSERT INTO destinos(plazasdisponibles, destino, fecha, precio) VALUES (?, ?, ?, ?)");
			ps.setString(1, plazasdisponibles);
			ps.setString(2, destino);			
			ps.setDate(3, fecha);
			ps.setFloat(4, precio);
			ps.executeUpdate();
			response.sendRedirect("Destinos.jsp");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
