package com.exemplo.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/acesso")
public class AcessoServlet extends HttpServlet {

    // HashMap para armazenar contadores de acessos por usuário
    private HashMap<String, Integer> contadorAcessos = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o nome do usuário da URL
        String nomeUsuario = request.getParameter("nome");

        // Se o nome do usuário não for fornecido, exibir uma mensagem de erro
        if (nomeUsuario == null || nomeUsuario.isEmpty()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Erro: Nome de usuário não fornecido!</h1>");
            return;
        }

        // Atualizar o contador de acessos para o usuário
        contadorAcessos.put(nomeUsuario, contadorAcessos.getOrDefault(nomeUsuario, 0) + 1);

        // Preparar a resposta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Contador de Acessos</h1>");
        out.println("<p>Usuário: " + nomeUsuario + "</p>");
        out.println("<p>Acessos: " + contadorAcessos.get(nomeUsuario) + "</p>");
    }
}
