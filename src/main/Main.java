package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario  = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanc = new ArrayList<>();

        System.out.println("=== Sistema de Simulação de Financiamentos ===");

        // 1. Coleta os dados dinâmicos para UM financiamento apenas (será uma Casa)
        System.out.println("Insira os dados para o primeiro financiamento (Casa):");
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanc = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaJurosAnual();
        double areaConstruida = interfaceUsuario.pedirAreaConstruida();
        double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();

        listaFinanc.add(new Casa(valorImovel, taxaJuros, prazoFinanc, areaConstruida, tamanhoTerreno));
        System.out.println("Financiamento adicionado com sucesso!\n");

        // 2. Instanciando os demais com dados inventados para os novos parâmetros
        listaFinanc.add(new Casa(500000, 0.10, 10, 250, 400));                  // Casa
        listaFinanc.add(new Apartamento(500000, 0.10, 10, 2, 12));              // Apto
        listaFinanc.add(new Apartamento(300000, 0.08, 15, 1, 5));               // Apto
        listaFinanc.add(new Terreno(500000, 0.10, 10, "Zona Residencial"));     // Terreno

        System.out.println("[!] Demais financiamentos de exemplo foram carregados.");

        // 3. Saída
        System.out.println("\n=== Relatório Final ===");
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento f : listaFinanc) {
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.pagamentoTotal();

            // Chamamos o metodo que criamos para mostrar os atributos específicos em ação!
            f.mostrarDadosFinanc();
            System.out.println(); // Pula uma linha para organizar visualmente
        }

        System.out.println("==============================================");
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalFinanciamentos);

    }
}