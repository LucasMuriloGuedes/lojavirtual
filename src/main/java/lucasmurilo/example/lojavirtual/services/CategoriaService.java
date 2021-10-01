package lucasmurilo.example.lojavirtual.services;

import lucasmurilo.example.lojavirtual.domain.Categoria;
import lucasmurilo.example.lojavirtual.dtos.CategoriaDTO;
import lucasmurilo.example.lojavirtual.repositories.CategoriaRepository;
import lucasmurilo.example.lojavirtual.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Categoria não encontrada! Verifique o id: " + id
        ));
    }

    public Categoria create(@Valid CategoriaDTO obj) {
        Categoria newObj = new Categoria(null, obj.getNome());
        return repository.save(newObj);
    }

    public Categoria insert(CategoriaDTO obj, Integer id) {
        Categoria categoria = findById(id);
        categoria.setNome(obj.getNome());
        return repository.save(categoria);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);

    }
}