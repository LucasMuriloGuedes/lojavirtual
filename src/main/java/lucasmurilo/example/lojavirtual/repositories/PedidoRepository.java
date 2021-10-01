package lucasmurilo.example.lojavirtual.repositories;

import lucasmurilo.example.lojavirtual.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
