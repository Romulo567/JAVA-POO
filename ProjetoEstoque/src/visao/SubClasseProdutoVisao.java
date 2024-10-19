package visao;


import java.util.ArrayList;

import dominio.SubClasseProduto;
import servico.SubClasseProdutoServico;

public class SubClasseProdutoVisao {
    private SubClasseProdutoServico srv;

    public SubClasseProdutoVisao(){
        this.srv = new SubClasseProdutoServico();
    }

    public void Adicionar(SubClasseProduto cpSub){
        this.srv.Adicionar(cpSub);
    }

    public void Exibir(){
        ArrayList<SubClasseProduto> lista = this.srv.Navegar();
        System.out.println("==============================");
        for (SubClasseProduto cpSub : lista) {
            this.ImprimirPorLinha(cpSub);
        }
    }


    private void ImprimirPorLinha(SubClasseProduto cpSub) {
        String mensagem = "";
        mensagem += "Codigo da Classe mae: " + cpSub.getCodigoClasse() + " | ";
        mensagem += "Codigo da sub classe: " + cpSub.getCodigo() + " | ";
        mensagem += "Descricao: " + cpSub.getDescricao() + " | ";
        mensagem += "Data de inclusao: " + cpSub.getDataDeInclusao();
        System.out.println(mensagem);
        System.out.println("======================================================");
    }

    

    

}
