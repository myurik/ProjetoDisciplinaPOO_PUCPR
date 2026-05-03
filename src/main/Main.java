package main;

import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
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
        listaFinanc.add(new Casa(valorImovel, taxaJuros, prazoFinanc));
        System.out.println("Financiamento adicionado com sucesso!\n");

        // 2. Instanciando os demais 4 financiamentos chumbados no código (Totalizando 5)
        // Usamos as taxas como "0.10" (que representa 10%) para bater com o gabarito do professor
        listaFinanc.add(new Casa(500000, 0.10, 10));        // Casa do exemplo do prof
        listaFinanc.add(new Apartamento(500000, 0.10, 10)); // Apto do exemplo do prof
        listaFinanc.add(new Apartamento(300000, 0.08, 15)); // Apto aleatório
        listaFinanc.add(new Terreno(500000, 0.10, 10));     // Terreno do exemplo do prof

        System.out.println("[!] Demais financiamentos de exemplo foram carregados.");

        // 3. Saída
        System.out.println("\n=== Relatório Final ===");
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (int i = 0; i < listaFinanc.size(); i++) {
            Financiamento f = listaFinanc.get(i);

            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.pagamentoTotal();

            System.out.printf("Financiamento %d - valor do imóvel: R$ %.2f, valor do financiamento: R$ %.2f\n",
                    (i + 1), f.getValorImovel(), f.pagamentoTotal());
        }

        System.out.printf("\nTotal de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f\n",
                totalImoveis, totalFinanciamentos);

    }
}