package repositorio;

import dominio.Produto;
import fakedb.ProdutoFakeDB;

public class ProdutoRepositorio extends BaseRepositorio<Produto>{

    private ProdutoFakeDB db;

    public ProdutoRepositorio(){
        this.db = new ProdutoFakeDB();
        this.dados = this.db.getTabelaProduto();
    }

    @Override
    public Produto Read(int chave) {
        for (Produto cpProd : dados) {
            if(cpProd.getCodigo() == chave){
                return cpProd;
            }
        }
        return null;
    }

    @Override
    public Produto Edit(Produto instancia) {
        Produto cpProd = this.Read(instancia.getCodigo());
        if(cpProd != null){
            cpProd.setDescricao(instancia.getDescricao());
            return cpProd;
        }
        return null;
    }

    @Override
    public Produto Add(Produto instancia) {
        Produto cpProd = this.dados.getLast();
        int proxProd = cpProd.getCodigo() + 1;
        instancia.setCodigo(proxProd);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Produto Delete(int chave) {
        Produto cpProd = this.Read(chave);
        if(cpProd != null){
            this.dados.remove(cpProd);
            return cpProd;
        }else{
            return null;
        }
    }
    
}
