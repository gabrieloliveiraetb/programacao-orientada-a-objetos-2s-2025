public class SistemaOperacional {
    private Computador computador;

    public SistemaOperacional(Computador computador) {
        this.computador = computador;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public boolean executarPrograma(Programa p) {
        if (p.getSSDOcupado() > computador.getSSD()) {
            System.out.println("Erro: não há espaço suficiente no SSD para instalar o programa.\n");
            return false;
        }
        if (p.getMemoriaRAMAlocada() > computador.getMemoriaRAM()) {
            System.out.println("Erro: memória RAM insuficiente para executar o programa.\n");
            return false;
        }
        if (p.getNucleos() > computador.getNucleos()) {
            System.out.println("Erro: o programa requer mais núcleos do que o computador possui.\n");
            return false;
        }

        double tempoExecucao = (double) p.getQuantidadeOperacoes() /
                (computador.getOperacoesPorSegundo() * computador.getNucleos());

        System.out.println("Programa executado com sucesso!");
        System.out.println("Tempo de execução: " + tempoExecucao + " segundos\n");
        return true;
    }
}