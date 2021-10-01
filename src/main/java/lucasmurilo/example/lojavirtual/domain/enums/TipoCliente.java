package lucasmurilo.example.lojavirtual.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(1),
    PESSOAJURIDICA(2);

    private int cod;

    TipoCliente(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public static TipoCliente toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(TipoCliente x : TipoCliente.values()){
            if(cod == x.getCod()){
                return x;
            }
        }

        throw new IllegalArgumentException("Código não encontrado: " + cod);
    }
}
