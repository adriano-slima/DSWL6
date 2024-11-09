package com.exemplo.web;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArmazenarNomes extends HttpServlet {
    // ArrayList para armazenar os nomes
    private ArrayList<String> nomes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Captura o parâmetro 'nome' da URL
        String nome = request.getParameter("nome");
        
        // Adiciona o nome à lista se não for nulo
        if (nome != null && !nome.trim().isEmpty()) {
            nomes.add(nome);
        }

        // Configura o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Escreve a resposta HTML com todos os nomes armazenados
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Lista de Nomes</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Nomes Armazenados</h1>");
        response.getWriter().println("<ul>");
        for (String n : nomes) {
            response.getWriter().println("<li>" + n + "</li>");
        }
        response.getWriter().println("</ul>");
        response.getWriter().println("<p>Para adicionar um nome, use: /addNome?nome=SeuNome</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
