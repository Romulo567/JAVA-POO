package visao;


import java.util.ArrayList;
import dominio.SubClasseProduto;
import servico.SubClasseProdutoServico;

public class SubClasseProdutoVisao {
    private SubClasseProdutoServico srv;

    public SubClasseProdutoVisao(){
        this.srv = new SubClasseProdutoServico();
    }


    public void Exibir(){
        ArrayList<SubClasseProduto> lista = this.srv.Navegar();
        System.out.println("==============================");
        for (SubClasseProduto cpSub : lista) {
            this.ImprimirPorLinha(cpSub);
        }
    }

     public void ExibirPorLinha(){
        ArrayList<SubClasseProduto> lista = this.srv.Navegar();
        System.out.println("====================================");
        for (SubClasseProduto cpSub : lista) {
            this.ImprimirPorLinha(cpSub);
        }
    }

    public void Criar(SubClasseProduto cpSub){
        this.srv.Adicionar(cpSub);
    }

    public void Editar(int chave, SubClasseProduto alt){
        SubClasseProduto cpSub = this.srv.Ler(chave);
        if(cpSub != null){
            cpSub.setDescricao(alt.getDescricao());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        SubClasseProduto cpSub = this.srv.Ler(chave);
        if(cpSub != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("item nao localizado");
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
