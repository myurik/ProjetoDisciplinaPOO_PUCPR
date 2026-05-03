package modelo;

public class Apartamento extends Financiamento{
    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos){
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
    }

    public double pagamentoTotal(){
        return getValorImovel() * (1 + (getTaxaJurosAnual() * getPrazoFinanciamento()));

    }

    public double calcularPagamentoMensal(){
        return pagamentoTotal() / (getPrazoFinanciamento() * 12);
    }
}
