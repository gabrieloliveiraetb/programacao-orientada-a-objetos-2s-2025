public abstract class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;
    
    public Veiculo(String marca, String modelo, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }
    
    public Veiculo() {}
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    public abstract double calcularIPVA();
    
    public String toString() {
        return String.format("ID: %d | %s %s | Ano: %d | Preco: R$ %.2f | IPVA: R$ %.2f", 
                           id, marca, modelo, ano, preco, calcularIPVA());
    }
}