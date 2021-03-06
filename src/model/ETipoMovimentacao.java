package src.model;

public enum ETipoMovimentacao {
    SAQUE("Saque"), 
    DEPOSITO("Deposito"), 
    TRANSFERENCIA("TransferĂȘncia"), 
    ABERTURA_DE_CONTA("Abertura de conta");

    private String valor;

    private ETipoMovimentacao(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
