package fakedb;
import java.util.ArrayList;

public abstract class BaseFuncionarioFakeDB<TDominio> {

    protected ArrayList<TDominio> tabelaFuncionario;

    public ArrayList<TDominio> getTabelaFuncionario() {
        return this.tabelaFuncionario;
    }

    protected abstract void preencherDados();

    public BaseFuncionarioFakeDB() {
        this.preencherDados();
    }

    
    
}