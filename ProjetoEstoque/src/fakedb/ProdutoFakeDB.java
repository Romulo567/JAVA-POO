package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Produto;

public class ProdutoFakeDB extends BaseFakeDB<Produto> {

    @Override
    protected void preencherDados() {
        
        this.tabelaProduto = new ArrayList<>();
        this.tabelaProduto.add(new Produto(1, "colchao mole", LocalDate.now(), 1, 20.50));
        this.tabelaProduto.add(new Produto(2, "tilapia", LocalDate.now(), 2, 17.50));
        this.tabelaProduto.add(new Produto(3, "coca", LocalDate.now(), 3, 9.99));
        this.tabelaProduto.add(new Produto(4, "cerveja skol", LocalDate.now(), 4, 6.75));
    }

    public ProdutoFakeDB(){
        super();
    }
}
