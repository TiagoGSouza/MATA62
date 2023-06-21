package interfaces;

import java.util.List;

import classes_negocio.Emprestimo;
import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.Reserva;

public interface IUsuario {
        public void realizarEmprestimo(Exemplar exemplar);
        public void devolverExemplar(Exemplar exemplar);
        public void reservarLivro(Livro livro);
        public boolean existeExemplarEmAtraso();
        public int getEmprestimosAtivos();
        public List<Reserva> getReservas();
        public List<Emprestimo> getEmprestimos();
        public String getNome();
}
