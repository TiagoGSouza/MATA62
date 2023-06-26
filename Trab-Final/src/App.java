import java.time.LocalDate;
import java.util.Scanner;

import classes_negocio.Emprestimo;
import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.Reserva;
import classes_negocio.tipos_aluno.AlunoGrad;
import controllers.Console;
import interfaces.IUsuario;


public class App {

    public static void main(String[] args) throws Exception {

        Console c = new Console();
        c.programa();

    }
}
/*
        IUsuario aluno1 = new AlunoGrad("001", "Teste1");
        IUsuario aluno2 = new AlunoGrad("002", "Teste2");
        Livro livro = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6", "2000");
        Exemplar exemplar = new Exemplar(livro, "01");
        livro.addExemplar(exemplar);
        if(livro.existeExemplarDisponivel()){
            if(aluno1.realizarEmprestimo(livro)){
                System.out.println("Empréstimo realizado.");
            }
            System.out.println("Usuario: " + aluno1.getNome());
            System.out.println("Livro: " + livro.getTitulo());
        } else{
            System.out.println("Não existe exemplar disponivel.");
        }
        
        if(livro.existeExemplarDisponivel()){
            Reserva reserva = aluno1.reservarLivro(livro);
            livro.addReserva(reserva);
        } else{
            System.out.println("Não existe exemplar disponivel.");
        }
      if(livro.existeExemplarDisponivel()){
            if(aluno2.realizarEmprestimo(livro)){
                System.out.println("Empréstimo realizado.");
            }
        } else{
            System.out.println("Não existe exemplar disponivel.");
        }
        System.out.println("Usuario: " + aluno2.getNome());
        System.out.println("Livro: " + livro.getTitulo());
 
        System.out.println("Emprestimos: " + aluno1.getEmprestimosAtivos());
        for (Emprestimo emp : aluno1.getEmprestimos()) {
            System.out.println("Livro: " + emp.getExemplar().getLivro().getTitulo());
        }
*/ 
