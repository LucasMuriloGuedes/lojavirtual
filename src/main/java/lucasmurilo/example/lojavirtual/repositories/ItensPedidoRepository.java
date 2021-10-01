package lucasmurilo.example.lojavirtual.repositories;

import lucasmurilo.example.lojavirtual.domain.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Integer> {
}
