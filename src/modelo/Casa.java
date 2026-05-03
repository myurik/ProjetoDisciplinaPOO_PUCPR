package modelo;

public class Casa extends Financiamento{
    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos){
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
    }

    public double calcularPagamentoMensal(){
        double taxaSeguro = 80;
        return super.calcularPagamentoMensal() + taxaSeguro;
    }
}
