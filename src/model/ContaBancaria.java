package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import src.util.UtilData;

public abstract class ContaBancaria {
    private String agencia;
    private String conta;
    private Integer digito;
    private Double saldo;
    private ArrayList<Movimentacao> movimentacoes;

    private final Double VALOR_MINIMO = 10.0;
    
    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoAbertura) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoAbertura;

        // Instancio o array de movimentações.
        // Se não instanciar o array, vai dar uma exception de NullPointerException.
        this.movimentacoes = new ArrayList<Movimentacao>();

        // Crio uma movimentação para a abertura de conta.
        Movimentacao movimentacao = new Movimentacao(saldoAbertura, ETipoMovimentacao.ABERTURA_DE_CONTA);

        // Adiciono a primeira movimentação no meu array de movimentações.
        this.movimentacoes.add(movimentacao);

    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public Double sacar(Double valor){

        removerValorDoSaldo(valor);
        
        this.movimentacoes.add(new Movimentacao(valor, ETipoMovimentacao.SAQUE));

        return valor;
    }

    public void depositar(Double valor){

        adicionarValorAoSaldo(valor);

        this.movimentacoes.add(new Movimentacao(valor, ETipoMovimentacao.DEPOSITO));
    }
  
    public void transferir(Double valor, ContaBancaria contaDestino){
        removerValorDoSaldo(valor); 
        contaDestino.depositar(valor);

        this.movimentacoes.add(new Movimentacao(valor, ETipoMovimentacao.TRANSFERENCIA));
    }

    private void removerValorDoSaldo(Double valor){

        if(valor > this.saldo){
            throw new InputMismatchException("Saldo insulficiente.");
        }

        this.saldo -= valor;
    }

    private void adicionarValorAoSaldo(Double valor){

        if(valor < this.VALOR_MINIMO){
            throw new InputMismatchException("O valor minimo de deposito e transferência é R$"+ this.VALOR_MINIMO);
        }

        this.saldo += valor;
    }

    public void receberTransferencia(Double valor){

        adicionarValorAoSaldo(valor);

        this.movimentacoes.add(new Movimentacao(valor, ETipoMovimentacao.TRANSFERENCIA));
    }

    public void imprimirExtrato(){

        System.out.println("*********************************");
        System.out.println("******* Extrato Bancário ********");
        System.out.println("*********************************");
        System.out.println();

        System.out.println("Gerado em: " + UtilData.converterDateParaData(new Date()));
        System.out.println();

        for(Movimentacao movimentacao : this.movimentacoes){
            System.out.println(movimentacao);
        }
        System.out.println();
        System.out.println("Saldo de R$" + this.saldo);

        System.out.println();
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println();
    }


}
