package repositorio;

import dominio.SubClasseProduto;
import fakedb.SubClasseProdutoFakeDB;

public class SubClasseProdutoRepositorio extends BaseRepositorio<SubClasseProduto> {
    
    private SubClasseProdutoFakeDB db;

    public SubClasseProdutoRepositorio(){
        this.db = new SubClasseProdutoFakeDB();
        this.dados = this.db.getTabelaSubClasse();
    }

    @Override
    public SubClasseProduto Read(int chave) {
        for (SubClasseProduto cpSub : dados) {
            if(cpSub.getCodigo() == chave){
                return cpSub;
            }
        }
        return null;
    }

    @Override
    public SubClasseProduto Edit(SubClasseProduto instancia) {
        SubClasseProduto cpSub = this.Read(instancia.getCodigo());
        if(cpSub != null){
            cpSub.setDescricao(instancia.getDescricao());
            return cpSub;
        }
        return null;
    }

    @Override
    public SubClasseProduto Add(SubClasseProduto instancia) {
        SubClasseProduto cpSub = this.dados.getLast();
        int proxSub = cpSub.getCodigo() + 1;
        instancia.setCodigo(proxSub);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public SubClasseProduto Delete(int chave) {
        SubClasseProduto cpSub = this.Read(chave);
        if(cpSub != null){
            this.dados.remove(cpSub);
            return cpSub;
        }else{
            return null;
        }
    }

    
}
