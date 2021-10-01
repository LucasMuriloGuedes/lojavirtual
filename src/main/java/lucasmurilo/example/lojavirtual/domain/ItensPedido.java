package lucasmurilo.example.lojavirtual.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
public class ItensPedido implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private ItensPedidoPK id = new ItensPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItensPedido(){

    }

    public ItensPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getSubTotal(){
        return (preco - desconto) * quantidade;
    }

    public ItensPedidoPK getId() {
        return id;
    }

    public void setId(ItensPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        this.id.setPedido(pedido);
    }

    @JsonIgnore
    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        this.id.setProduto(produto);
    }
}
