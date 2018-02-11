package com.boraji.tutorial.spring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String descripcionCorta = request.getParameter("descripcionCorta");
		float precio = Integer.parseInt(request.getParameter("precio"));
		String categoria = request.getParameter("categoria");
		int plazas = Integer.parseInt(request.getParameter("plazas"));
		String fecha = request.getParameter("fecha");
		String foto = request.getParameter("foto");
		
	
		try {
			//CONEXION
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes","root","");
			
			
			//INSERTAR USUARIO
			PreparedStatement ps = conn.prepareStatement("INSERT INTO destinos(nombre, descripcion, descripcionCorta, precio, categoria, plazas, fecha, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, nombre);
			ps.setString(2, descripcion);			
			ps.setString(3, descripcionCorta);
			ps.setFloat(4, precio);
			ps.setString(5, categoria);
			ps.setInt(6, plazas);
			ps.setString(7, fecha);
			ps.setString(8, foto);
			ps.executeUpdate();
			response.sendRedirect("Destinos.jsp");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
