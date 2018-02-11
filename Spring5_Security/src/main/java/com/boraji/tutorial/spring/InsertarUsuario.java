package com.boraji.tutorial.spring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/InsertarUsuario")
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
		String telf = request.getParameter("telf");
		
	
		try {
			//CONEXION
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes","root","");
			
			
			//COMPROBAR SI EXISTE EL USUARIO
			PreparedStatement ps = conn.prepareStatement("select * from usuarios where mail=?");
			ps.setString(1, mail);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//INSERTAR USUARIO
				PreparedStatement ps2 = conn.prepareStatement("INSERT INTO usuarios(mail, pass, nombre, telf) VALUES (?, ?, ?, ?)");
				
				ps2.setString(1, mail);			
				ps2.setString(2, pass);
				ps2.setString(3, nombre);
				ps2.setString(4, telf);
				ps2.executeUpdate();
				
				response.sendRedirect("Index.jsp");
			} else {
				response.sendRedirect("UsuarioError.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
