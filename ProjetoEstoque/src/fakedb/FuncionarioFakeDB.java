package fakedb;

import java.util.ArrayList;

import dominio.Funcionario;

public class FuncionarioFakeDB extends BaseFuncionarioFakeDB<Funcionario>{

    @Override
    protected void preencherDados() {

       this.tabelaFuncionario = new ArrayList<>();
       if (this.tabelaFuncionario == null) {
            this.tabelaFuncionario = new ArrayList<>();
       }

       this.tabelaFuncionario.add(new Funcionario(1, "romulo", "gerente", 5000, "romulo@gmail.com", "6799998887"));
       this.tabelaFuncionario.add(new Funcionario(2, "joao", "auxiliar de limpeza", 2000, "joao@gmail.com", "6799222337"));
       this.tabelaFuncionario.add(new Funcionario(3, "luiz", "auxiliar de estoque", 3000, "luiz@gmail.com", "6799900434"));

    }
    

    public FuncionarioFakeDB(){
        super();
    }
}
