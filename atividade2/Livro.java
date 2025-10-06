public class Livro extends Material {
    private String edicao;
    
    public void descricao() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Ano de Publicacao: " + anoPublicacao);
        System.out.println("Edicao: " + edicao);
    }
    
    public String getEdicao() {
        return edicao;
    }
    
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
}