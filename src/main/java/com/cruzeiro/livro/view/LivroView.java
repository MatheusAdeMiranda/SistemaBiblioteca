package com.cruzeiro.livro.view;

import java.util.List;
import com.cruzeiro.livro.model.entity.Livro;
public class LivroView {
    public void mostrarDetalhesLivro(Livro livro) {
        System.out.println("Detalhes do livro:");
        System.out.println("ID: " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("ISBN: " + livro.getISBN());
        System.out.println("Número de páginas: " + livro.getNumeroPaginas());
    }

    public void mostrarListaLivros(List<Livro> livros) {
        System.out.println("Lista de livros:");
        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo());
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
