package com.exemplo.web;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SalvarComentario extends HttpServlet {
    // ArrayList para armazenar os comentários
    private ArrayList<String> comentarios = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Captura o parâmetro 'comentario' do formulário
        String comentario = request.getParameter("comentario");
        
        // Adiciona o comentário à lista se não for nulo
        if (comentario != null && !comentario.trim().isEmpty()) {
            comentarios.add(comentario);
        }

        // Configura o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Escreve a resposta HTML com todos os comentários armazenados
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Comentários</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Comentários Enviados</h1>");
        response.getWriter().println("<ul>");
        for (String c : comentarios) {
            response.getWriter().println("<li>" + c + "</li>");
        }
        response.getWriter().println("</ul>");
        response.getWriter().println("<a href='comentarios.html'>Voltar</a>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}

