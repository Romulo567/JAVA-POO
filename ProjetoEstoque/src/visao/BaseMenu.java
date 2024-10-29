package visao;
<<<<<<< HEAD

import java.util.Scanner;

=======
import java.util.Scanner;


>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
public abstract class BaseMenu {
    protected Scanner scanner;

    public BaseMenu(){
<<<<<<< HEAD
        this.scanner = new Scanner(System.in); 
=======
        this.scanner = new Scanner(System.in); //inicializando scanner
>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
    }

    public abstract void ExibirMenu();

    public abstract void Listar();

    public abstract void Localizar();

    public abstract void Adicionar();

    public abstract void Atualizar();

    public abstract void Remover();
<<<<<<< HEAD
}
=======
}


>>>>>>> 6dc55885ac0efceae0f17149947731b35ded9ee4
