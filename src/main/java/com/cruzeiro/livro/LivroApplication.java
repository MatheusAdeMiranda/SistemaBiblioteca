package com.cruzeiro.livro;


import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cruzeiro.livro.config.DBConfig;
import com.cruzeiro.livro.controller.LivroController;
import com.cruzeiro.livro.model.dao.LivroDAO;
import com.cruzeiro.livro.view.LivroView;

@SpringBootApplication
public class LivroApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LivroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inicialização do Banco de Dados
		DBConfig.createTables();

		// Inicialização das dependências
		LivroView livroView = new LivroView();
		LivroDAO livroDAO = new LivroDAO();
		LivroController livroController = new LivroController(livroDAO);

		// Inicialização da CLI
		Scanner scanner = new Scanner(System.in);
		SistemaBiblioteca sistema = new SistemaBiblioteca(livroController, livroView, scanner);

		// Inicialização do sistema
		sistema.iniciar();
	}
}
