package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner;

    public InterfaceUsuario(){
        this.scanner = new Scanner(System.in);
    }
    public double pedirValorImovel(){
        double valorImovel;
        do {
            System.out.print("Digite o valor do Imóvel: R$ ");
            valorImovel = scanner.nextDouble();
            if(valorImovel <= 0){
                System.out.println("Valor do Imóvel é inválido. Deve ser positivo. Tente Novamente.");
            }
        }
        while(valorImovel <= 0);
        return valorImovel;
    }

    public int pedirPrazoFinanciamento(){
        int prazoFinanc = 0;
        while(prazoFinanc <= 0){
            System.out.print("Digite o prazo de financiamento (em anos):  ");
            prazoFinanc = scanner.nextInt();
            if(prazoFinanc <= 0){
                System.out.println("Prazo inválido. Tente Novamente.");
            }
        }
        return prazoFinanc;
    }

    public double pedirTaxaJurosAnual(){
        double taxaJuros;
        do {
            System.out.print("Digite a taxa de juros anual (ex: 10.5): ");
            taxaJuros = scanner.nextDouble();
            if (taxaJuros >= 1000){
                System.out.println("Erro: Taxa de juros irreal. Digite um valor válido. Tente novamente.");
            }
            else if (taxaJuros <= 0){
                System.out.println("Erro: A taxa de juros deve ser maior do que zero. Tente novamente.");
            }
        }
        while(taxaJuros <= 0 || taxaJuros >= 1000);
        return taxaJuros;
    }

    public boolean pedirContinuar() {
        int opcao;
        do {
            System.out.print("Deseja simular outro financiamento? (1 - Sim / 2 - Não): ");
            opcao = scanner.nextInt();
        } while (opcao != 1 && opcao != 2);

        return opcao == 1; // Retorna true se ele digitar 1, e false se digitar 2
    }
}