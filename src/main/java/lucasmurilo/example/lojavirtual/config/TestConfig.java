package lucasmurilo.example.lojavirtual.config;

import lucasmurilo.example.lojavirtual.domain.*;
import lucasmurilo.example.lojavirtual.domain.enums.EstadoPagamento;
import lucasmurilo.example.lojavirtual.domain.enums.TipoCliente;
import lucasmurilo.example.lojavirtual.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mmm");

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

        Estado est1 = new Estado(null, "Mato Grosso");
        Estado est2 = new Estado(null, "Mato Grosso do Sul");

        Cidade cid1 = new Cidade(null, "Cuiabá", est1);
        Cidade cid2 = new Cidade(null, "Sorriso", est1);
        Cidade cid3 = new Cidade(null, "Campo Grande", est2);

        est1.getCidades().addAll(Arrays.asList(cid1, cid2));
        est1.getCidades().addAll(Arrays.asList(cid3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        Cliente cli1 = new Cliente(null, "Maressa de Oliveira", "maressa@gmail.com", "000.255.666-00","(65) 95458-5544", TipoCliente.PESSOAFISICA);
        Cliente cli2 = new Cliente(null, "Anna Paula", "anaPaula@gmail.com", "555.666.777-11","(65) 99985-4477", TipoCliente.PESSOAFISICA);

        Endereco end1 = new Endereco(null, "Rua projetada", "151", "Proximo ao parque das águas", "Parque das Águas", "78075-725", cid1, cli1);
        Endereco end2 = new Endereco(null, "Rua Jaú", "1897", "Próximo ao Burguer King", "Centro", "78000-000", cid1, cli2);

        cli1.getEnderecos().add(end1);
        cli2.getEnderecos().add(end2);

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));

        Pedido ped1 = new Pedido(null, sdf.parse("29/08/2021 11:24"), cli1, end1);
        Pedido ped2 = new Pedido(null, sdf.parse("27/09/2021 17:39"), cli2, end2);

        Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        Pagamento pgt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("27/09/2021 17:35"), sdf.parse("30/09/2021 17:35"));

        ItensPedido it1 = new ItensPedido(ped1, p1, 200.00, 2, 2500.00);
        ItensPedido it2 = new ItensPedido(ped1, p4, 00.0, 1, 1999.99);
        ItensPedido it3 = new ItensPedido(ped2, p2, 00.0, 3, 80.00);

        ped1.getItens().addAll(Arrays.asList(it1, it2));
        ped1.setPagamento(pagt1);
        ped2.getItens().add(it3);
        ped2.setPagamento(pgt2);

        p1.getItens().add(it1);
        p2.getItens().add(it3);
        p3.getItens().add(it2);

        pagamentoRepository.saveAll(Arrays.asList(pagt1, pgt2));

        itensPedidoRepository.saveAll(Arrays.asList(it1, it2, it3));
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));





    }
}
