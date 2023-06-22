import java.time.LocalDate;

import classes_negocio.Emprestimo;
import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.Reserva;
import classes_negocio.tipos_aluno.AlunoGrad;
import interfaces.IUsuario;


public class App {


    public static void main(String[] args) throws Exception {
        
        IUsuario aluno1 = new AlunoGrad("001", "Teste1");
        IUsuario aluno2 = new AlunoGrad("002", "Teste2");
        Livro livro = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6", "2000");
        Exemplar exemplar = new Exemplar(livro, "01");
        livro.addExemplar(exemplar);
        aluno1.realizarEmprestimo(livro);
        if(livro.existeExemplarDisponivel()){
            Reserva reserva = aluno2.reservarLivro(livro);
            livro.addReserva(reserva);
        } else{
            System.out.println("Não existe exemplar disponivel.");
        }
//        aluno2.realizarEmprestimo(livro);

        System.out.println("Emprestimos: " + aluno1.getEmprestimosAtivos());
        for (Emprestimo emp : aluno1.getEmprestimos()) {
            System.out.println("Livro: " + emp.getExemplar().getLivro().getTitulo());
        }
    }
}
