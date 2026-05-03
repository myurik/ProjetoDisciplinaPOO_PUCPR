package modelo;

public class Casa extends Financiamento{
    private final double areaConstruida;
    private final double tamanhoTerreno;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamentoAnos, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamentoAnos);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double calcularPagamentoMensal(){
        double taxaSeguro = 80;
        return super.calcularPagamentoMensal() + taxaSeguro;
    }

    @Override
    public void mostrarDadosFinanc() {
        System.out.println("---- Dados do Financiamento: Casa ----");
        super.mostrarDadosFinanc(); // Chama a impressão genérica da classe mãe
        System.out.println("Área Construída: " + this.areaConstruida + " m²");
        System.out.println("Tamanho do Terreno: " + this.tamanhoTerreno + " m²");
    }
}
}
