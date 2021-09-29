package lucasmurilo.example.lojavirtual.services;

import lucasmurilo.example.lojavirtual.domain.Categoria;
import lucasmurilo.example.lojavirtual.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }
}
