package lucasmurilo.example.lojavirtual.repositories;

import lucasmurilo.example.lojavirtual.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
