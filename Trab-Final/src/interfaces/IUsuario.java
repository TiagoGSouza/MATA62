package interfaces;

import java.util.List;

import classes_negocio.Emprestimo;
import classes_negocio.Livro;
import classes_negocio.Reserva;

public interface IUsuario {
        public void realizarEmprestimo(Livro livro);
        public void devolverExemplar(Livro livro);
        public Reserva reservarLivro(Livro livro);
        public boolean existeExemplarEmAtraso();
        public int getEmprestimosAtivos();
        public List<Reserva> getReservas();
        public List<Emprestimo> getEmprestimos();
        public String getNome();
        public void removerReserva(Livro livro);
}
