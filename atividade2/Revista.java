public class Revista extends Material {
    private String autor;
    
    public void descricao() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Ano de Publicacao: " + anoPublicacao);
        System.out.println("Autor: " + autor);
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
}