package lucasmurilo.example.lojavirtual.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instantePedido;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoDeEntrega;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItensPedido> itens = new HashSet<>();

    public Pedido(){

    }

    public Pedido(Integer id, Date instantePedido, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instantePedido = instantePedido;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Double getValorTotal(){
        double soma = 0.0;
        for (ItensPedido x : itens){
            soma += x.getSubTotal();
        }
        return soma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstantePedido() {
        return instantePedido;
    }

    public void setInstantePedido(Date instantePedido) {
        this.instantePedido = instantePedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<ItensPedido> getItens() {
        return itens;
    }
}
