package modelo;

public class Terreno extends Financiamento{
    private final String tipoZona;

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos, String tipoZona) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
        this.tipoZona = tipoZona;
    }

    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() * 1.02;
    }

    @Override
    public void mostrarDadosFinanc() {
        System.out.println("---- Dados do Financiamento: Terreno ----");
        super.mostrarDadosFinanc();
        System.out.println("Tipo de Zona: " + this.tipoZona);
    }
}
