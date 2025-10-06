public class Emprestimo {
    private Pessoa pessoa;
    private Material material;
    private String dataEmprestimo;
    private String dataDevolucao;
    
    public void exibirDetalhes() {
        System.out.println("Data do Emprestimo: " + dataEmprestimo);
        System.out.println("Data de Devolucao: " + dataDevolucao);
        System.out.println("--- Informacoes da Pessoa ---");
        pessoa.exibirInfo();
        System.out.println("--- Descricao do Material ---");
        material.descricao();
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
    
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public String getDataDevolucao() {
        return dataDevolucao;
    }
    
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}