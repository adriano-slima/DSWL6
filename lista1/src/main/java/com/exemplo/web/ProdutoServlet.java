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

@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {

    // Lista para armazenar produtos
    private List<Produto> produtos = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura os dados do formulário
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));

        // Cria um novo produto e adiciona à lista
        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        // Redireciona para o método doGet para exibir a lista de produtos
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura o tipo de resposta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Exibe o formulário
        out.println("<h1>Cadastro de Produtos</h1>");
        out.println("<form action='produto' method='post'>");
        out.println("<label for='nome'>Nome do Produto:</label>");
        out.println("<input type='text' id='nome' name='nome' required>");
        out.println("<br>");
        out.println("<label for='preco'>Preço:</label>");
        out.println("<input type='number' id='preco' name='preco' step='0.01' required>");
        out.println("<br>");
        out.println("<input type='submit' value='Cadastrar'>");
        out.println("</form>");

        // Exibe a lista de produtos
        out.println("<h2>Produtos Cadastrados:</h2>");
        if (produtos.isEmpty()) {
            out.println("<p>Nenhum produto cadastrado.</p>");
        } else {
            out.println("<ul>");
            for (Produto produto : produtos) {
                out.println("<li>" + produto.getNome() + " - R$ " + produto.getPreco() + "</li>");
            }
            out.println("</ul>");
        }
    }

    // Classe interna para representar um Produto
    private class Produto {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }
    }
}

