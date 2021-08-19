package src.model;

public class ContaCorrente extends ContaBancaria implements IInvestimento {

    public ContaCorrente(String agencia, String conta, Integer digito, Double saldoAbertura) {
        super(agencia, conta, digito, saldoAbertura);
    }

    @Override
    public void guardar(Double valor) {
     
        System.out.println("Guardando a 110% do CDI");
    }

    @Override
    public Double resgatar(Double valor) {
       
        return null;
    }
    
}
