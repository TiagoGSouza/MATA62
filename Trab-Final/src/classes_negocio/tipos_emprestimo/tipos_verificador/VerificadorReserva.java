package classes_negocio.tipos_emprestimo.tipos_verificador;

import classes_negocio.Livro;
import classes_negocio.Reserva;
import interfaces.IUsuario;

public class VerificadorReserva {

    public boolean usuarioValido(IUsuario usuario, Livro livro){
        for (Reserva  reserva: usuario.getReservas()) {
            if(reserva.getLivro() == livro){
                return true;
            }
        }
        return false;
    }
}