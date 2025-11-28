package AT3;

import java.util.Date;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    
    public Emprestimo(int id, Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
    
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public void exibirInformacoes() {
        System.out.println("Emprestimo ID: " + id + " | Livro: " + livro.getTitulo() + 
                          " | Usuario: " + usuario.getNome() + 
                          " | Data: " + dataEmprestimo);
    }
}
