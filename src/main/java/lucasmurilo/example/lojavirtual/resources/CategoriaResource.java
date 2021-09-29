package lucasmurilo.example.lojavirtual.resources;

import lucasmurilo.example.lojavirtual.domain.Categoria;
import lucasmurilo.example.lojavirtual.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
