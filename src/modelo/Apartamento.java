package modelo;

public class Apartamento extends Financiamento{
    private final int vagasGaragem;
    private final int numeroAndar;

    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos, int vagasGaragem, int numeroAndar) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double pagamentoTotal(){
        return getValorImovel() * (1 + (getTaxaJurosAnual() * getPrazoFinanciamento()));

    }

    public double calcularPagamentoMensal(){
        return pagamentoTotal() / (getPrazoFinanciamento() * 12);
    }


    @Override
    public void mostrarDadosFinanc() {
        System.out.println("---- Dados do Financiamento: Apartamento ----");
        super.mostrarDadosFinanc();
        System.out.println("Vagas na Garagem: " + this.vagasGaragem);
        System.out.println("Andar: " + this.numeroAndar);
    }

    @Override
    public String toString() {
        String sb = super.toString() + "," +
                this.vagasGaragem + "," +
                this.numeroAndar;
        return sb;
    }
}
