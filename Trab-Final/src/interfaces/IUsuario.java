package interfaces;

import java.util.List;

import classes_negocio.Emprestimo;
import classes_negocio.Livro;
import classes_negocio.Reserva;

//precisei mudar o retorno da funcao de realizar emprestimo
public interface IUsuario {
        public boolean realizarEmprestimo(Livro livro);
        public boolean devolverExemplar(Livro livro);
        public Reserva reservarLivro(Livro livro);
        public boolean existeExemplarEmAtraso();
        public int getEmprestimosAtivos();
        public List<Reserva> getReservas();
        public List<Emprestimo> getEmprestimos();
        public String getNome();
        public void removerReserva(Livro livro);
        public String getCodigo();
        public String getExemplarEmprestado(Livro livro);
}
