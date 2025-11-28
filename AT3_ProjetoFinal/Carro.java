public class Carro extends Veiculo {
    private int portas;
    private String tipoCombustivel;
    
    public Carro(String marca, String modelo, int ano, double preco, 
                 int portas, String tipoCombustivel) {
        super(marca, modelo, ano, preco);
        this.portas = portas;
        this.tipoCombustivel = tipoCombustivel;
    }
    
    public Carro() {}
    
    public int getPortas() { return portas; }
    public void setPortas(int portas) { this.portas = portas; }
    
    public String getTipoCombustivel() { return tipoCombustivel; }
    public void setTipoCombustivel(String tipoCombustivel) { 
        this.tipoCombustivel = tipoCombustivel; 
    }
    
    public double calcularIPVA() {
        double taxa = "Flex".equalsIgnoreCase(tipoCombustivel) ? 0.03 : 0.04;
        return getPreco() * taxa;
    }
    
    public String toString() {
        return super.toString() + 
               String.format(" | Portas: %d | Combustivel: %s", portas, tipoCombustivel);
    }
}