package lucasmurilo.example.lojavirtual.repositories;

import lucasmurilo.example.lojavirtual.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
