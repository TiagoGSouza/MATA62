package classes_negocio;

import java.util.List;
import classes_negocio.*;

public class Livro {
  private List<Exemplar> listaExemplares;
  private List<Reserva> listaReservas;
  private int qtdReservas;
  private int qtdExemplares;

  public int getQtdReservas(){
    return this.qtdReservas;
  }

  public int getQtdExemplares(){
    return this.qtdExemplares;
  }

}
