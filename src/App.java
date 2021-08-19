package src;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.model.ContaBancaria;
import src.model.ContaCorrente;
import src.model.ContaInvestimento;
import src.model.ContaPoupanca;
import src.model.ETipoMovimentacao;
import src.model.Movimentacao;
import src.util.UtilData;

public class App {
    public static void main(String[] args) {
        System.out.println("Aprendendo POO");

        // Criação da contas
        ContaCorrente contaAnaClara = new ContaCorrente("0001", "7542", 5, 1000.0);
        ContaPoupanca contaRaphael = new ContaPoupanca("0001", "7543", 6, 100.0);
        ContaPoupanca contaWeberson = new ContaPoupanca("0001", "7544", 7, 100.0);
        ContaInvestimento contaTiago = new ContaInvestimento("0001", "7545", 7, 100.0);

        // Movimentações conta Weberson
        // Saque para pagar o Bolero
        var valorBoleto = contaWeberson.sacar(50.0);

        // Deposito do cliente
        contaWeberson.depositar(10000.0);

        // Weberson encontrou o tiago e fez o convite.
        contaWeberson.transferir(5000.0, contaTiago);

        // Andandno na rua encontrou a Ana Clara
        contaWeberson.transferir(3000.0, contaAnaClara);

        // Pagando pizza para a galera.
        var pizzaBistro = contaAnaClara.sacar(350.0);

        // Simulando a ação do usuario de imprimir extrato.
        contaWeberson.imprimirExtrato();
        contaTiago.imprimirExtrato();
        contaAnaClara.imprimirExtrato();

     
    }
}