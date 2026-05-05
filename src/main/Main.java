package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario  = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanc = new ArrayList<>();

        System.out.println("=== Sistema de Simulação de Financiamentos ===");

        // 1. Coleta os dados dinâmicos para UM financiamento apenas (uma Casa)
        System.out.println("Insira os dados para o primeiro financiamento (Casa):");
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanc = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaJurosAnual();
        double areaConstruida = interfaceUsuario.pedirAreaConstruida();
        double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();

        listaFinanc.add(new Casa(valorImovel, taxaJuros, prazoFinanc, areaConstruida, tamanhoTerreno));
        System.out.println("Financiamento adicionado com sucesso!\n");

        // 2. Instanciando os demais com dados inventados.
        listaFinanc.add(new Casa(500000, 0.10, 10, 250, 400));
        listaFinanc.add(new Apartamento(500000, 0.10, 10, 2, 12));
        listaFinanc.add(new Apartamento(300000, 0.08, 15, 1, 5));
        listaFinanc.add(new Terreno(500000, 0.10, 10, "Zona Residencial"));

        System.out.println("[!] Demais financiamentos de exemplo foram carregados.");
        System.out.println("\n=== Relatório Final ===");
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        int contador = 1;
        for (Financiamento f : listaFinanc) {
            try {
                f.mostrarDadosFinanc();
                System.out.println("---");
                totalImoveis += f.getValorImovel();
                totalFinanciamentos += f.pagamentoTotal();
            } catch (Exception e) {
                System.out.println("---- Erro no Financiamento " + contador + " ----");
                System.out.println("BLOQUEADO: " + e.getMessage());
                System.out.println("---");
            }
            contador++;
        }
        System.out.println("==============================================");
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalFinanciamentos);

        // ===========

        // 1. SALVAR ARQUIVO DE TEXTO (Usando FileWriter, flush e close)
        System.out.println("\nSalvando dados em um arquivo de texto...");
        try {
            FileWriter escritor = new FileWriter("financiamentos.txt");

            for (Financiamento f : listaFinanc) {
                // Usa o toString() com StringBuilder que criamos e pula uma linha (\n)
                escritor.write(f.toString() + "\n");
            }

            escritor.flush(); // Força a gravação dos dados no disco
            escritor.close(); // Fecha o arquivo
            System.out.println(" O arquivo 'financiamentos.txt' foi criado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo de texto: " + e.getMessage());
        }

        // 2. LER ARQUIVO DE TEXTO (Usando BufferedReader e FileReader)
        System.out.println("\nLendo dados do arquivo de texto para comprovação...");
        try {
            BufferedReader in = new BufferedReader(new FileReader("financiamentos.txt"));
            String linha;

            // Lê linha por linha até encontrar o fim do arquivo (null)
            while ((linha = in.readLine()) != null) {
                System.out.println("Lido do arquivo: " + linha);
            }

            in.close(); // Fecha o leitor
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo de texto: " + e.getMessage());
        }

        // 3. SALVAR ARQUIVO SERIALIZADO (Fluxo de Bytes - ObjectOutputStream)
        System.out.println("\nSalvando objetos serializados em um arquivo .dat...");
        try {
            FileOutputStream arquivoOut = new FileOutputStream("financiamentos.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(arquivoOut);

            objOut.writeObject(listaFinanc); // Salva o ArrayList inteiro em bytes

            objOut.flush();
            objOut.close();
            arquivoOut.close();
            System.out.println("O arquivo 'financiamentos.dat' foi criado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao serializar objetos: " + e.getMessage());
        }

        // 4. LER ARQUIVO SERIALIZADO (Fluxo de Bytes - ObjectInputStream)
        System.out.println("\nLendo e comprovando objetos serializados...");
        try {
            FileInputStream arquivoIn = new FileInputStream("financiamentos.dat");
            ObjectInputStream objIn = new ObjectInputStream(arquivoIn);

            // Converte (Cast) os bytes lidos de volta para um ArrayList de Financiamento
            @SuppressWarnings("unchecked")
            ArrayList<Financiamento> listaRecuperada = (ArrayList<Financiamento>) objIn.readObject();

            objIn.close();
            arquivoIn.close();

            System.out.println("Objetos recuperados com sucesso! Comprovando os dados:");
            for (Financiamento f : listaRecuperada) {
                // Mostra o tipo da classe e os valores para provar que a estrutura de objetos sobreviveu
                System.out.println(f.getClass().getSimpleName() + " - Valor do Imóvel: " + f.getValorImovel());
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo serializado: " + e.getMessage());
        }
    }
}