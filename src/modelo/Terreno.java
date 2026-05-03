package modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos){
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
    }

    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() * 1.02;
    }
}
