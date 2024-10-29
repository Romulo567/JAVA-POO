package visao;

import java.util.ArrayList;
import dominio.Funcionario;
import servico.FuncionarioServico;
import java.util.InputMismatchException;
public class FuncionarioMenu extends BaseMenu{

    private FuncionarioServico srv;

    public FuncionarioMenu(){
        super();
        this.srv = new FuncionarioServico();
    }

    @Override
    public void ExibirMenu() {
        String opcao = "0";
        
        do{
            Util.LimparConsole();
            System.out.println("Cadastro de funcionarios: ");
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
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    Util.LimparConsole();
                    System.out.println("Opção inválida.");
                    System.out.print("Clique ENTER para continuar. ");
                    this.scanner.nextLine();
                    this.scanner.nextLine();
                    break;
        }
    }while(!opcao.equals("9"));
}

    @Override
    public void Listar() {
        Util.LimparConsole(); 
        ArrayList<Funcionario> lista = this.srv.Navegar();

        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
            System.out.println("Listando"); 
            for (Funcionario funcionario : lista) {
                this.Imprimir(funcionario);
            }
        }
        
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        ArrayList<Funcionario> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{

        System.out.println("Localizando");

        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
        try {
            System.out.print("Informe o codigo do funcionario: ");
            cod = this.scanner.nextInt();
            codigoValido = true; 
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Digite um número válido.");
            this.scanner.next(); 
        }
    }
        Funcionario cpFuncionario = this.srv.Ler(cod);

        if (cpFuncionario != null) {
            this.Imprimir(cpFuncionario);
        }
        else{
            System.out.println("ERRO!! Funcionario nao encontrado!!");
        }
    }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
        
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando funcionario...");

        System.out.print("Informe o nome: ");
        this.scanner.nextLine();
        String nome = this.scanner.nextLine();

        System.out.print("Informe o Cargo: ");
        String cargo = this.scanner.nextLine();
        
        double salario = 0.00;
        boolean SalarioValido = false;
        while(!SalarioValido){
            try {
                System.out.print("Informe o salario: ");
                salario = this.scanner.nextDouble();
                SalarioValido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Digite um numero valido.");
                this.scanner.next(); 
            }
        }

        System.out.print("Informe o email: ");
        this.scanner.nextLine();
        String email = this.scanner.nextLine();

        System.out.print("Informe o telefone: ");
        String telefone = this.scanner.nextLine();

        Funcionario cpFuncionario = new Funcionario();
        cpFuncionario.setNome(nome);
        cpFuncionario.setCargo(cargo);
        cpFuncionario.setSalario(salario);
        cpFuncionario.setEmail(email);
        cpFuncionario.setTelefone(telefone);

        if (this.srv.Adicionar(cpFuncionario) != null) {
            System.out.println("Funcionario adicionado com sucesso.");
        }else{
            System.out.println("ERRO!! Funcionario não adicionado.");
        }
        System.out.println("Clique ENTER para continuar..");
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        ArrayList<Funcionario> lista = this.srv.Navegar();

        if(lista.size() == 0){
            System.out.println("lista vazia");
            this.scanner.nextLine();
        }else{
        System.out.println("Atualizando...");

        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
        try {
            System.out.print("Informe o codigo do funcionario: ");
            cod = this.scanner.nextInt();
            codigoValido = true; 
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Digite um número válido.");
            this.scanner.next(); 
        }
    }

        Funcionario cpFuncionario = this.srv.Ler(cod);
        if (cpFuncionario != null) {
            
            System.out.print("Informe o novo cargo: ");
            this.scanner.nextLine();
            String cargo = this.scanner.nextLine();
            cpFuncionario.setCargo(cargo);

            double salario = 0.00;
            boolean SalarioValido = false;

            while(!SalarioValido){
            try {
                System.out.print("Informe o novo salario: ");
                salario = this.scanner.nextDouble();
                SalarioValido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Digite um numero valido.");
                this.scanner.next(); 
            }
        }
            
            cpFuncionario.setSalario(salario);

            System.out.print("Informe o novo email: ");
            this.scanner.nextLine();
            String email = this.scanner.nextLine();
            cpFuncionario.setEmail(email);

            System.out.print("Informe o novo telefone: ");
            String telefone = this.scanner.nextLine();
            cpFuncionario.setTelefone(telefone);

            if (this.srv.Editar(cpFuncionario) != null) {
                System.out.println("Atualizado com sucesso.");                
            }
            else{
                System.out.println("ERRO!! Atualizacao não realizada.");
            }            
        }
        else{
            System.out.println("ERRO!! Funcionario não encontrado.");
        }
    }
        System.out.print("Clique ENTER para continuar.");
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        ArrayList<Funcionario> lista = this.srv.Navegar();

        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{

        System.out.println("Removendo...");
        
        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
        try {
            System.out.print("Informe o codigo do funcionario a ser removido: ");
            cod = this.scanner.nextInt();
            codigoValido = true; 
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Digite um número válido.");
            this.scanner.next(); 
        }
    }
        Funcionario cpFuncionario = this.srv.Ler(cod); 
        
        if (cpFuncionario != null) {
            if (this.srv.Deletar(cod) != null) {
                System.out.println("Funcionario removido com sucesso.");                
            }   
        }else{
            System.out.println("ERRO!! Funcionario não encontrado.");
        }
    }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void Imprimir(Funcionario objeto){
        String mensagem = "";
        mensagem += "Codigo do Funcionario: " + objeto.getCodigo() + " | ";
        mensagem += "Nome: " + objeto.getNome() + " | ";
        mensagem += "Cargo: " + objeto.getCargo() + " | ";
        mensagem += "salario: " + objeto.getSalario() + " | ";
        mensagem += "email: " + objeto.getEmail() + " | ";
        mensagem += "telefone: " + objeto.getTelefone() + " | ";
        System.out.println(mensagem);
        System.out.println("================================================================================================================================");
        System.out.println();
    }
}
