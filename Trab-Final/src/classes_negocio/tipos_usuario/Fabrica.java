package classes_negocio.tipos_usuario;
import classes_negocio.tipos_emprestimo.VerificadorEmprestimoAluno;
import classes_negocio.tipos_emprestimo.VerificadorEmprestimoProfessor;
import interfaces.IVerificadorEmprestimo;

public class Fabrica {

    public static IVerificadorEmprestimo obterVerificadorEmprestimoAluno(){
        return new VerificadorEmprestimoAluno();
    }

    public static IVerificadorEmprestimo obterVerificadorEmprestimoProfessor() {
        return new VerificadorEmprestimoProfessor();
    }
}