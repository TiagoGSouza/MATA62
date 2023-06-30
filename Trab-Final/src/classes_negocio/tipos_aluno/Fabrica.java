package classes_negocio.tipos_aluno;
import classes_negocio.tipos_emprestimo.EmprestimoAlunoGrad;
import interfaces.IVerificadorEmprestimo;

public class Fabrica {

    public static IVerificadorEmprestimo obterVerificadorEmprestimoAlunoGrad(){
        return new EmprestimoAlunoGrad();
    }

    public static int obterLimiteDeEmprestimosAlunoGrad() {
        return 3;
    }

}