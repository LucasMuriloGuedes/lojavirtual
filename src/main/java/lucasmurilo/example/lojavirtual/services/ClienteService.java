package lucasmurilo.example.lojavirtual.services;

import lucasmurilo.example.lojavirtual.domain.Cliente;
import lucasmurilo.example.lojavirtual.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }
}
