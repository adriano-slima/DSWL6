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

@WebServlet("/nomes")
public class NomesServlet extends HttpServlet {

    // Lista para armazenar nomes
    private static List<String> nomes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura o nome a ser removido da URL
        String nome = request.getParameter("nome");

        // Remove o nome, se existir
        if (nome != null && !nome.isEmpty()) {
            nomes.remove(nome);
        }

        // Configura o tipo de resposta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Exibe o formulário e a lista atualizada de nomes
        exibirFormulario(out);
        exibirNomes(out);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        if (nome != null && !nome.isEmpty()) {
            nomes.add(nome);
        }
        // Redireciona para doGet para exibir a lista atualizada
        doGet(request, response);
    }

    private void exibirFormulario(PrintWriter out) {
        out.println("<h1>Cadastro de Nomes</h1>");
        out.println("<form action='nomes' method='post'>");
        out.println("<label for='nome'>Nome:</label>");
        out.println("<input type='text' id='nome' name='nome' required>");
        out.println("<input type='submit' value='Adicionar'>");
        out.println("</form>");

        out.println("<h2>Remover Nome</h2>");
        out.println("<form action='nomes' method='get'>");
        out.println("<label for='remove'>Nome:</label>");
        out.println("<input type='text' id='remove' name='nome' required>");
        out.println("<input type='submit' value='Remover'>");
        out.println("</form>");
    }

    private void exibirNomes(PrintWriter out) {
        out.println("<h2>Nomes Cadastrados:</h2>");
        if (nomes.isEmpty()) {
            out.println("<p>Nenhum nome cadastrado.</p>");
        } else {
            out.println("<ul>");
            for (String n : nomes) {
                out.println("<li>" + n + "</li>");
            }
            out.println("</ul>");
        }
    }
}
