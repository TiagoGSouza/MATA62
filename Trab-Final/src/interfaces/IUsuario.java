package interfaces;

import classes_negocio.Exemplar;
import classes_negocio.Livro;

public interface IUsuario {
        public void realizarEmprestimo(Exemplar exemplar);
        public void devolverExemplar(Exemplar exemplar);
        public void reservarLivro(Livro livro);
        public boolean existeExemplarEmAtraso();
}
