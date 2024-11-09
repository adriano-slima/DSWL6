package com.exemplo.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Captura o parâmetro 'nome' da URL
        String nome = request.getParameter("nome");

        // Configura o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Escreve a resposta HTML
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Bem-vindo</title></head>");
        response.getWriter().println("<body>");
        if (nome != null && !nome.isEmpty()) {
            response.getWriter().println("<h1>Olá, " + nome + "!</h1>");
        } else {
            response.getWriter().println("<h1>Olá, visitante!</h1>");
        }
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
