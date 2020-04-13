package com.curso.exemplo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Cidade;
import com.curso.exemplo.domain.Estado;
import com.curso.exemplo.domain.Produto;
import com.curso.exemplo.repositories.CategoriaRepository;
import com.curso.exemplo.repositories.CidadeRepository;
import com.curso.exemplo.repositories.EstadoRepository;
import com.curso.exemplo.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		
		Produto p1 = new Produto("Computador", 2000.0);
		Produto p2 = new Produto("Impressora", 800.0);
		Produto p3 = new Produto("Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade c1 = new Cidade("Uberlândia", est1);
		Cidade c2 = new Cidade("São Paulo", est2);
		Cidade c3 = new Cidade("Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1, c3));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
