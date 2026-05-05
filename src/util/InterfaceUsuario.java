package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner;

    public InterfaceUsuario(){
        this.scanner = new Scanner(System.in);
    }
    public double pedirValorImovel(){
        double valorImovel = 0;
        boolean valido = false;
        do {
            try {
                System.out.print("Digite o valor do Imóvel: R$ ");
                valorImovel = scanner.nextDouble();
                if (valorImovel <= 0) {
                    System.out.println("Valor do Imóvel é inválido. Deve ser positivo. Tente Novamente.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO! Entrada inválida. Digite apenas números.");
                scanner.next();
            }

        } while (!valido);
        return valorImovel;
    }

    public int pedirPrazoFinanciamento(){
        int prazoFinanc = 0;
        while(prazoFinanc <= 0){
            try {
                System.out.print("Digite o prazo de financiamento (em anos):  ");
                prazoFinanc = scanner.nextInt();
                if (prazoFinanc <= 0) {
                    System.out.println("Prazo inválido. Tente Novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO! Entrada inválida. Digite um número inteiro.");
                scanner.next(); // Limpa o "lixo" para não criar um loop infinito.
            }
        }
        return prazoFinanc;
    }

    public double pedirTaxaJurosAnual(){
        double taxaJuros = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Digite a taxa de juros anual (ex: 10.5): ");
                taxaJuros = scanner.nextDouble();
                if (taxaJuros >= 1000) {
                    System.out.println("Erro: Taxa de juros irreal. Digite um valor válido. Tente novamente.");
                } else if (taxaJuros <= 0) {
                    System.out.println("Erro: A taxa de juros deve ser maior do que zero. Tente novamente.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO! Entrada inválida. Digite apenas números.");
                scanner.next();
            }
        } while (!valido);
        return taxaJuros;
    }


    public double pedirAreaConstruida() {
        double area = 0;
        boolean valido = false;
        do {
            try {
                System.out.print("Digite a área construída (em m²): ");
                area = scanner.nextDouble();
                if (area <= 0) {
                    System.out.println("Valor inválido. Deve ser positivo.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO! Entrada inválida.");
                scanner.next();
            }
        } while (!valido);
        return area;
    }

    public double pedirTamanhoTerreno() {
        double tamanho = 0;
        boolean valido = false;
        do {
            try {
                System.out.print("Digite o tamanho do terreno (em m²): ");
                tamanho = scanner.nextDouble();
                if (tamanho <= 0) System.out.println("Valor inválido. Deve ser positivo.");
                else valido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERRO! Entrada inválida.");
                scanner.next();
            }
        } while (!valido);
        return tamanho;
    }
}