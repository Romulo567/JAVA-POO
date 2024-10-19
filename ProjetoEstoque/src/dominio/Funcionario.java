package dominio;

public class Funcionario extends BaseFuncionario{
    
    public Funcionario(){
        super();
    }

    public Funcionario(int codigo, String nome, String cargo, double salario, String email, String telefone){
        super(codigo, nome, cargo, salario, email, telefone);
    }
}
