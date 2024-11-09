package com.exemplo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tarefas")
public class TarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static List<String> tarefas = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Lista de Tarefas</h1>");
        
        // Exibir tarefas
        out.println("<ul>");
        for (String tarefa : tarefas) {
            out.println("<li>" + tarefa + "</li>");
        }
        out.println("</ul>");
        
        // Formulário para adicionar nova tarefa
        out.println("<form method='POST' action='tarefas'>");
        out.println("Tarefa: <input type='text' name='tarefa' required>");
        out.println("<input type='submit' value='Adicionar'>");
        out.println("</form>");
        
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tarefa = request.getParameter("tarefa");
        if (tarefa != null && !tarefa.trim().isEmpty()) {
            tarefas.add(tarefa); // Adiciona a nova tarefa
        }
        response.sendRedirect("tarefas"); // Redireciona para a página de tarefas
    }
}

