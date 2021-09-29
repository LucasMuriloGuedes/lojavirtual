package lucasmurilo.example.lojavirtual.repositories;

import lucasmurilo.example.lojavirtual.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
