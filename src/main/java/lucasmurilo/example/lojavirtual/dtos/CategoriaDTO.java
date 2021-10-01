package lucasmurilo.example.lojavirtual.dtos;

import lucasmurilo.example.lojavirtual.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "O campo NOME é requerido!")
    @Length(min = 3, max = 30, message = "O Campo nome deve ter entre 3 e 30 caracter")
    private String nome;

    public CategoriaDTO(){

    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
