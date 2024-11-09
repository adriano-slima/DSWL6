package com.exemplo.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContadorAcessos extends HttpServlet {
    // Variável de instância para armazenar o contador de acessos
    private int contador = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Incrementa o contador a cada acesso
        contador++;

        // Configura o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Escreve a resposta HTML com o número de acessos
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Contador de Acessos</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Contador de Acessos</h1>");
        response.getWriter().println("<p>Este servlet foi acessado " + contador + " vezes.</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}

