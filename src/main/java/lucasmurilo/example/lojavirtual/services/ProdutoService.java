package lucasmurilo.example.lojavirtual.services;

import lucasmurilo.example.lojavirtual.domain.Produto;
import lucasmurilo.example.lojavirtual.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }
}
