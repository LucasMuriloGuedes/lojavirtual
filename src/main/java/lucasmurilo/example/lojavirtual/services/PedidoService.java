package lucasmurilo.example.lojavirtual.services;

import lucasmurilo.example.lojavirtual.domain.Pedido;
import lucasmurilo.example.lojavirtual.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll(){
        return repository.findAll();
    }
}
