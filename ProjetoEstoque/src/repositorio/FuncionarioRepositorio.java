package repositorio;

import dominio.Funcionario;
import fakedb.FuncionarioFakeDB;

public class FuncionarioRepositorio extends BaseRepositorio<Funcionario> {

    private FuncionarioFakeDB dbFuncionario;
    
    public FuncionarioRepositorio() {
        this.dbFuncionario = new FuncionarioFakeDB();
        this.dados = dbFuncionario.getTabelaFuncionario();
    }

    @Override
    public Funcionario Read(int chave) {
        for (Funcionario funcionario : dados) {
            if(funcionario.getCodigo() == chave){
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public Funcionario Edit(Funcionario instancia) {
        Funcionario cpFuncionario = this.Read(instancia.getCodigo());
        if(cpFuncionario != null){
            cpFuncionario.setCargo(instancia.getCargo());
            cpFuncionario.setSalario(instancia.getSalario());
            cpFuncionario.setEmail(instancia.getEmail());
            cpFuncionario.setTelefone(instancia.getTelefone());
            return cpFuncionario;
        }else{
            return null;
        }
    }

    @Override
    public Funcionario Add(Funcionario instancia) {
        int proxChave;
        if (this.dados.size() == 0) {
            proxChave = 1;
        }else{
            Funcionario cpFuncionario = this.dados.getLast();
            proxChave = cpFuncionario.getCodigo() + 1;
        }
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);

        return instancia;
    }

    @Override
    public Funcionario Delete(int chave) {
        Funcionario cpFuncionario = this.Read(chave);
        if(cpFuncionario != null){
            this.dados.remove(cpFuncionario);
            return cpFuncionario;
        }else{
            return null;
        }
    }
    

}
