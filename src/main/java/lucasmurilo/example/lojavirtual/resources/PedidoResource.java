package lucasmurilo.example.lojavirtual.resources;

import lucasmurilo.example.lojavirtual.domain.Pedido;
import lucasmurilo.example.lojavirtual.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
