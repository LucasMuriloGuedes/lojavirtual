package lucasmurilo.example.lojavirtual.config;

import lucasmurilo.example.lojavirtual.domain.Categoria;
import lucasmurilo.example.lojavirtual.domain.Produto;
import lucasmurilo.example.lojavirtual.repositories.CategoriaRepository;
import lucasmurilo.example.lojavirtual.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Eletrônico");
        Categoria cat3 = new Categoria(null, "Cama mesa e banho");
        Categoria cat4 = new Categoria(null, "Eletrodoméstico");
        Categoria cat5 = new Categoria(null, "Vestuário");
        Categoria cat6 = new Categoria(null, "Utensilios Domésticos");
        Categoria cat7 = new Categoria(null, "Ferramentas");

        Produto p1 = new Produto(null, "Notebook", 2500.00);
        Produto p2 = new Produto(null, "Mouse", 80.00);
        Produto p3 = new Produto(null, "Furadeira", 199.99);
        Produto p4 = new Produto(null, "Celular", 1999.99);
        Produto p5 = new Produto(null, "Tenis", 250.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2));
        cat2.getProdutos().addAll(Arrays.asList(p1, p2, p4));
        cat5.getProdutos().addAll(Arrays.asList(p5));
        cat7.getProdutos().addAll(Arrays.asList(p3));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().add(cat7);
        p4.getCategorias().add(cat2);
        p5.getCategorias().add(cat5);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));





    }
}
