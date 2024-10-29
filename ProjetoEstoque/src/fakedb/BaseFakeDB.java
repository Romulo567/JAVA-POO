package fakedb;
import java.util.ArrayList;

public abstract class BaseFakeDB<TDominio> {
    protected ArrayList<TDominio> tabela;
    protected ArrayList<TDominio> tabelaSubClasse;
    protected ArrayList<TDominio> tabelaProduto;


    public ArrayList<TDominio> getTabela(){
        return this.tabela;
    }

    public ArrayList<TDominio> getTabelaSubClasse(){
        return this.tabelaSubClasse;
    }

    public ArrayList<TDominio> getTabelaProduto(){
        return this.tabelaProduto;
    }
    //1 - metodos abstract nao podem ter codigo.
    //2 - metodos abstract que devem ser codificados nas classes filhas(reais)
    //3 - este metodo deve ser executado toda vez que a classe filha for instanciada.
    protected abstract void preencherDados();

    public BaseFakeDB(){
        this.preencherDados();
    }

    
}
