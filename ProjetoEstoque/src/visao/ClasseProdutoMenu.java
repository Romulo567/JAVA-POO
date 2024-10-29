package visao;

import dominio.ClasseProduto;
import servico.ClasseProdutoServico;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.InputMismatchException;
=======
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
import java.time.LocalDate;

public class ClasseProdutoMenu extends BaseMenu{
    
    private ClasseProdutoServico srv;

    public ClasseProdutoMenu(){
        super();
        this.srv = new ClasseProdutoServico();
    }

    @Override
    public void ExibirMenu() {

<<<<<<< HEAD
        String opcao = "0";
        
        do{
            Util.LimparConsole();
            System.out.println("Classe de Produtos: ");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = this.scanner.next();

            switch (opcao) {
                case "1":
                    this.Listar();
                    break;
                
                case "2":
                    this.Localizar();
                    break;
                        
                case "3":
                    this.Adicionar();
                    break;
                    
                case "4":
                    this.Atualizar();
                    break;
                        
                case "5":
                    this.Remover();
                    break;
                    
                case "9":
=======
        int opcao = 0;

        while (opcao != 9) {
            Util.LimparConsole();
            System.out.println("CADASTRO DE CLASSES DE PRODUTO");
            System.out.println("""
                1 - Listar
                2 - Localizar
                3 - Adicionar
                4 - Atualizar
                5 - Remover
                9 - Sair
                """);
                System.out.print("Selecione uma opção: ");
            opcao = this.scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.Listar();
                    break;

                case 2:
                    this.Localizar();
                    break;

                case 3:
                    this.Adicionar();
                    break;

                case 4:
                    this.Atualizar();
                    break;

                case 5:
                    this.Remover();
                    break;

                case 9:
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
                    System.out.println("Saindo...");
                    break;
                    
                default:
<<<<<<< HEAD
                    Util.LimparConsole();
                    System.out.println("Opção inválida.");
                    System.out.print("Clique ENTER para continuar. ");
                    this.scanner.nextLine();
                    this.scanner.nextLine();
                    break;
        }
    }while(!opcao.equals("9"));
}
=======
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4

    @Override
    public void Listar() {
        Util.LimparConsole();
<<<<<<< HEAD
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
            System.out.println("Listando");
            for (ClasseProduto produto : lista) {
                this.Imprimir(produto);
        }
    }
=======
        System.out.println("Listando");  

        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        for (ClasseProduto produto : lista) {
            this.Imprimir(produto);
        }
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
<<<<<<< HEAD
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
            System.out.println("Localizando");
            int cod = 0;
            boolean codigoValido = false;

            while (!codigoValido) {
            try {
                System.out.print("Informe o codigo da classe: ");
                cod = this.scanner.nextInt();
                codigoValido = true; 
            } catch (InputMismatchException e) {
                System.out.println("ERRO!! Digite um número válido.");
                this.scanner.next(); 
        }
    }
=======
        System.out.println("Localizando");

        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
        ClasseProduto cp = this.srv.Ler(cod);

        if (cp != null) {
            this.Imprimir(cp);
        }
        else{
<<<<<<< HEAD
            System.out.println("ERRO!! Classe de Produto não encontrada!");
        }
    }
=======
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
        }

>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
<<<<<<< HEAD
        System.out.println("Adicionando...");
=======
        System.out.println("Adicionando");
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4

        System.out.printf("Informe a descrição: ");
        String descricao = this.scanner.next();

        ClasseProduto cp = new ClasseProduto();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());

<<<<<<< HEAD
=======
        //ClasseProduto cpnovo = this.srv.Adicionar(cp);
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4

        if(this.srv.Adicionar(cp) != null){
            System.out.println("Classe de Produto adicionada com sucesso!");
        }
        else{
<<<<<<< HEAD
            System.out.println("ERRO! classe nao adicionada.");
=======
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não adicionada!!
                    ==================
                    """);
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
        }

        System.out.println("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
<<<<<<< HEAD
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
            this.scanner.nextLine();
        }else{
        System.out.println("Atualizando");

        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
            try {
                System.out.print("Informe o codigo da classe: ");
                cod = this.scanner.nextInt();
                codigoValido = true; 
            } catch (InputMismatchException e) {
                System.out.println("ERRO!! Digite um número válido.");
                this.scanner.next(); 
            }
        }
=======
        System.out.println("Atualizando");

        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4

        ClasseProduto cp = this.srv.Ler(cod);

        if (cp != null) {
            System.out.println("Informe a nova descrição: ");
            String descricao = this.scanner.next();
            cp.setDescricao(descricao);

<<<<<<< HEAD
            if(this.srv.Editar(cp) != null){
                System.out.println("Alteração realizada com sucesso!");
            }
            else{
                System.out.println("ERRO!! Atualizacao não realizada.");
            }
        }
        else{
            System.out.println("ERRO!! classe não encontrado."); 
    }
}
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    
=======
            if(this.srv.Editar(cp) != null){//se devolveu diferente de nulo é pq deu certo
                System.out.println("Alteração realizada com sucesso!");
            }
            else{
                System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                       não alterada!!
                    ==================
                    """);
            }
        }
        else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);

        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
}

    @Override
    public void Remover() {
        Util.LimparConsole();
<<<<<<< HEAD
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
        System.out.println("Removendo"); 
        
        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
        try {
            System.out.print("Informe o codigo da classe a ser removido: ");
            cod = this.scanner.nextInt();
            codigoValido = true; 
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Digite um número válido.");
            this.scanner.next(); 
        }
    }
=======
        System.out.println("Removendo"); 
        
        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4

        ClasseProduto cp = this.srv.Ler(cod);

        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Removido com sucesso!");
            }
            else{
<<<<<<< HEAD
                System.out.println("ERRO!! Classe não encontrada.");
            }
        }
    }
=======
                System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
            }
        }

>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    
    private void Imprimir(ClasseProduto objeto){
        String mensagem = "";
        mensagem += "Codigo do Produto: " + objeto.getCodigo() + " | ";
        mensagem += "Descricao: " + objeto.getDescricao() + " | ";
        mensagem += "Data de inclusão: " + objeto.getDataDeInclusao() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
