package lucasmurilo.example.lojavirtual.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private Integer id;

    EstadoPagamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(EstadoPagamento x : EstadoPagamento.values()){
            if(x.equals(cod)){
                return x;
            }
        }
        throw new IllegalArgumentException("Código não encontrado! Cod: " + cod);
    }
}


