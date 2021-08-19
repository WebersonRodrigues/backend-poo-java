package src.model;

public class ContaInvestimento extends ContaBancaria implements IInvestimento {

    public ContaInvestimento(String agencia, String conta, Integer digito, Double saldoAbertura) {
        super(agencia, conta, digito, saldoAbertura);
    }

    @Override
    public void guardar(Double valor) {
     
        System.out.println("Guardando a 120% do CDI");
    }

    @Override
    public Double resgatar(Double valor) {
      
        return null;
    }
    
}
