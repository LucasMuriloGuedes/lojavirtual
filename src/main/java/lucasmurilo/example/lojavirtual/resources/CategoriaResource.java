package lucasmurilo.example.lojavirtual.resources;

import lucasmurilo.example.lojavirtual.dtos.CategoriaDTO;
import lucasmurilo.example.lojavirtual.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> listDTO = service.findAll().stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id){
        CategoriaDTO objDTO = new CategoriaDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody CategoriaDTO obj){
        CategoriaDTO objDTO = new CategoriaDTO(service.create(obj));
        return ResponseEntity.ok().body(objDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@Valid@RequestBody CategoriaDTO obj, @PathVariable Integer id){
        CategoriaDTO objDTO = new CategoriaDTO(service.insert(obj, id));
        return ResponseEntity.ok().body(objDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
