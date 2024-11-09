package com.exemplo.web;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Captura o parâmetro 'username' enviado pelo formulário
        String username = request.getParameter("username");

        // Configura o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Escreve a resposta HTML
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Bem-vindo</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Bem-vindo, " + username + "!</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Resposta para requisições GET
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Método GET não suportado.");
    }
}