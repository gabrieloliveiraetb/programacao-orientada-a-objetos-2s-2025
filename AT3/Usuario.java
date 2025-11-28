package AT3;

public class Usuario extends Pessoa {
    private String telefone;
    private String endereco;
    
    public Usuario(int id, String nome, String email, String telefone, String endereco) {
        super(id, nome, email);
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void exibirInformacoes() {
        System.out.println("Usuario: " + getNome() + " | Email: " + getEmail() + 
                          " | Telefone: " + telefone);
    }
}
