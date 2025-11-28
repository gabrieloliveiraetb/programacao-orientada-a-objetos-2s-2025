public class Moto extends Veiculo {
    private int cilindrada;
    private String partida;
    
    public Moto(String marca, String modelo, int ano, double preco, 
                int cilindrada, String partida) {
        super(marca, modelo, ano, preco);
        this.cilindrada = cilindrada;
        this.partida = partida;
    }
    
    public Moto() {}
    
    public int getCilindrada() { return cilindrada; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
    
    public String getPartida() { return partida; }
    public void setPartida(String partida) { this.partida = partida; }
    
    public double calcularIPVA() {
        double taxa = cilindrada > 300 ? 0.02 : 0.015;
        return getPreco() * taxa;
    }
    
    public String toString() {
        return super.toString() + 
               String.format(" | Cilindrada: %dcc | Partida: %s", cilindrada, partida);
    }
}