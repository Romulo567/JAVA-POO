package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.SubClasseProduto;

public class SubClasseProdutoFakeDB extends BaseFakeDB<SubClasseProduto>{

    @Override
    protected void preencherDados() {
        
        this.tabelaSubClasse = new ArrayList<>();
        this.tabelaSubClasse.add(new SubClasseProduto(1, "bovino", LocalDate.now(), 1));
        this.tabelaSubClasse.add(new SubClasseProduto(2, "peixe", LocalDate.now(), 1));
        this.tabelaSubClasse.add(new SubClasseProduto(3, "refrigerante", LocalDate.now(), 2));
        this.tabelaSubClasse.add(new SubClasseProduto(4, "bebida alcoolica", LocalDate.now(), 2));

    }
    
    public SubClasseProdutoFakeDB(){
        super();
    }


}
