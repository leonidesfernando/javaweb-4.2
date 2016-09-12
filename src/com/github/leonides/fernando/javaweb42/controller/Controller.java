package com.github.leonides.fernando.javaweb42.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(displayName="controller", value="/controller")
public class Controller extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String usuario = request.getParameter("usuario");
		final String senha = request.getParameter("senha");
		
		try{
			validaLogin(usuario, senha);
			request.setAttribute("usuario", usuario);
		    RequestDispatcher rd=request.getRequestDispatcher("/pages/home.jsp");  
		    rd.forward(request,response);
			
		}catch (IllegalStateException e) {
			 response.setContentType("text/html");  
			 PrintWriter out = response.getWriter();
			  out.print("<div style=\"background: #ffcccc;padding: 2 0 2 20;  border-radius: 20px;\"><ul style=\"color: red;\">" + e.getMessage()+ "</ul></div>");  
		      RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
		      rd.include(request,response);
		      out.close();	      
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	      rd.include(request,response);
	}
	
	private void validaLogin(String usuario, String senha) throws IllegalStateException{
		String mensagem = "";
		
		if(isNuloOuVazio(usuario)){
			mensagem += "<li>O usuário deve ser informado</li>";
		}
		
		if(isNuloOuVazio(senha)){
			mensagem += "<li>A senha deve ser informada</li>";
		}
		
		if((!isNuloOuVazio(usuario) && !"wpos".equals(usuario)) && (!isNuloOuVazio(senha) && !"123".equals(senha))){
			mensagem += "<li>Ops ... usuário e senha inválidos</li>";
		}
		
		if(!isNuloOuVazio(mensagem)){
			throw new IllegalStateException(mensagem);
		}
	}
	
	private boolean isNuloOuVazio(String txt){
		return txt == null || txt.isEmpty();
	}
	

}
