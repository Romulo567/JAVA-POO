package visao;

import java.util.ArrayList;

import dominio.ClasseProduto;

import servico.ClasseProdutoServico;


public class ClasseProdutoVisao {

    private ClasseProdutoServico srv;

    public ClasseProdutoVisao(){
        this.srv = new ClasseProdutoServico();
    }

    public void Exibir(){
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        System.out.println("====================================");
        for (ClasseProduto cp : lista) {
            this.Imprimir(cp);
        }
    }

    public void ExibirPorLinha(){
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        System.out.println("====================================");
        for (ClasseProduto cp : lista) {
            this.ImprimirPorLinha(cp);
        }
    }

    public void Criar(ClasseProduto cp){
        this.srv.Adicionar(cp);
    }

    public void Editar(int chave, ClasseProduto alt){
        ClasseProduto cp = this.srv.Ler(chave);
        if(cp != null){
            cp.setDescricao(alt.getDescricao());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        ClasseProduto cp = this.srv.Ler(chave);
        if(cp != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("item nao localizado");
        }
    }
    
    private void Imprimir(ClasseProduto cp){
            System.out.println("Classe de Produto:");
            System.out.println("Codigo " + cp.getCodigo());
            System.out.println("Descricao: " + cp.getDescricao());
            System.out.println("Data de Inclusao: " + cp.getDataDeInclusao());
            System.out.println("----------------------------------------");
            System.out.println();
    }

    private void ImprimirPorLinha(ClasseProduto cp){
        String mensagem = "";
        mensagem += "Classe de Produto: ";
        mensagem += "Codigo " + cp.getCodigo() + " | ";
        mensagem += "Descricao: " + cp.getDescricao() + " | ";
        mensagem += "Data de Inclusao: " + cp.getDataDeInclusao();
        System.out.println(mensagem);
        System.out.println("----------------------------------------");
    }
}
