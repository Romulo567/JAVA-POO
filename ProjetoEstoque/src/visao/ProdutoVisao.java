package visao;

import java.util.ArrayList;

import dominio.Produto;
import servico.ProdutoServico;

public class ProdutoVisao {
    private ProdutoServico srv;

    public ProdutoVisao(){
        this.srv = new ProdutoServico();
    }

    public void Adicionar(Produto cpProd){
        this.srv.Adicionar(cpProd);
    }

    public void Exibir(){
        ArrayList<Produto> lista = this.srv.Navegar();
        for (Produto cpProd : lista) {
            this.Imprimir(cpProd);
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
}
