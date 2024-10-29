package visao;

import java.util.ArrayList;
import dominio.Produto;
import servico.ProdutoServico;

public class ProdutoVisao {
    private ProdutoServico srv;

    public ProdutoVisao(){
        this.srv = new ProdutoServico();
    }

    public void Exibir(){
        ArrayList<Produto> lista = this.srv.Navegar();
        System.out.println("====================================");
        for (Produto cpProd : lista) {
            this.Imprimir(cpProd);
        }
    }

    public void ExibirPorLinha(){
        ArrayList<Produto> lista = this.srv.Navegar();
        System.out.println("====================================");
        for (Produto cpProduto : lista) {
            this.ImprimirPorLinha(cpProduto);
        }
    }

    public void Criar(Produto cpProduto){
        this.srv.Adicionar(cpProduto);
    }

    public void Editar(int chave, Produto alt){
        Produto cpProduto = this.srv.Ler(chave);
        if(cpProduto != null){
            cpProduto.setDescricao(alt.getDescricao());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Produto cpProduto = this.srv.Ler(chave);
        if(cpProduto != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("item nao localizado");
        }
    }

    private void Imprimir(Produto cpProd){
        String mensagem = "";
        mensagem += "Codigo da Sub Classe: " + cpProd.getCodigoSubClasse() + " | ";
        mensagem += "Codigo do Produto: " + cpProd.getCodigo() + " | ";
        mensagem += "Descricao: " + cpProd.getDescricao() + " | ";
        mensagem += "Data de inclusão: " + cpProd.getDataDeInclusao() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

    private void ImprimirPorLinha(Produto cpProduto){
        String mensagem = "";
        mensagem += "Produto: ";
        mensagem += "Codigo " + cpProduto.getCodigo() + " | ";
        mensagem += "Descricao: " + cpProduto.getDescricao() + " | ";
        mensagem += "Data de Inclusao: " + cpProduto.getDataDeInclusao();
        System.out.println(mensagem);
        System.out.println("----------------------------------------");
    }
}
