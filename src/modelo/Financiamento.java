package modelo;

public class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos){
        this.valorImovel =  valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
    }

    public double calcularPagamentoMensal(){
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
    }

    public double pagamentoTotal(){
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public void mostrarDadosFinanc(){
        System.out.println("---- Dados do Financiamento ----");
        System.out.println("Valor do Imóvel: R$ " + getValorImovel());
        System.out.println("Prazo do Financiamento: " + getPrazoFinanciamento());
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%");
        System.out.printf("Pagamento Mensal: R$ %.2f\n", calcularPagamentoMensal());
        System.out.printf("Pagamento Total: R$ %.2f\n", pagamentoTotal());
    }
}
