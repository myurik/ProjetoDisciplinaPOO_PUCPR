package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento{
    private final double areaConstruida;
    private final double tamanhoTerreno;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    private boolean verificarJuros(double valorJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {
        if (valorAcrescimo > (valorJuros / 2)) {
            throw new AumentoMaiorDoQueJurosException("Taxa abusiva! O seguro de R$ " + valorAcrescimo + " ultrapassa 50% dos juros da parcela (R$ " + String.format("%.2f", valorJuros) + ").");
        }
        return true;
    }

    public double calcularPagamentoMensal(){
        double taxaSeguro = 80;
        double mensalidadeSemJuros = getValorImovel() / (getPrazoFinanciamento() * 12);
        double jurosDaMensalidade = mensalidadeSemJuros * (getTaxaJurosAnual() / 12);

        try {
            verificarJuros(jurosDaMensalidade, taxaSeguro);
            return super.calcularPagamentoMensal() + taxaSeguro;
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("\n ALERTA NO FINANCIAMENTO (CASA): " + e.getMessage());
            System.out.println(" Solução aplicada: O financiamento prosseguirá, mas o cliente foi isentado do seguro obrigatório.");

            // Como a taxa era abusiva, retorna o valor da mensalidade SEM somar os R$ 80
            return super.calcularPagamentoMensal();
        }
    }

    @Override
    public void mostrarDadosFinanc() {
        System.out.println("---- Dados do Financiamento: Casa ----");
        super.mostrarDadosFinanc(); // Chama a impressão genérica da classe mãe
        System.out.println("Área Construída: " + this.areaConstruida + " m²");
        System.out.println("Tamanho do Terreno: " + this.tamanhoTerreno + " m²");
    }
}
