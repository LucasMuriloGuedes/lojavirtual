package lucasmurilo.example.lojavirtual.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lucasmurilo.example.lojavirtual.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento implements Serializable {

    private Integer numeroParcelas;

    public PagamentoComCartao(){

    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
