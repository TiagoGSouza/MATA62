package classes_negocio;

import java.util.ArrayList;
import java.util.List;

public class Livro {
  private List<Exemplar> listaExemplares;
  private List<Reserva> listaReservas;
  private int qtdReservas;
  private int qtdExemplares;
  private String codigo;
  private String titulo;
  private String editora;
  private String autores;
  private String edicao;
  private String anoPublicacao;

  public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublicacao){
    this.codigo = codigo;
    this.titulo = titulo;
    this.editora = editora;
    this.autores = autores;
    this.edicao = edicao;
    this.anoPublicacao = anoPublicacao;
    this.listaExemplares = new ArrayList<>();
    this.listaReservas = new ArrayList<>();
    this.qtdReservas=0;
    this.qtdExemplares=0;
  }

  public int getQtdReservas(){
    return this.qtdReservas;
  }

  public int getQtdExemplares(){
    return this.qtdExemplares;
  }
  
  public void addExemplar(Exemplar exemplar){
    this.listaExemplares.add(exemplar);
    this.qtdExemplares += 1;
  }
  
  public Exemplar getExemplarDisponivel(){
    for (Exemplar exemplar : listaExemplares) {
      if(exemplar.getDisponibilidade()){
        return exemplar;
      }
    }
    return null;
  }

  public String getTitulo(){
    return this.titulo;
  }

  public void addReserva(Reserva reserva){
    this.listaReservas.add(reserva);
    this.qtdReservas += 1;
  }

  public boolean existeExemplarDisponivel(){
    for (Exemplar exemplar : listaExemplares) {
      if (exemplar.getDisponibilidade())
        return true;
    }
    return false;
  }

  public boolean existeExemplarNaoReservado(){
    if(this.qtdExemplares <= qtdReservas){
      return false;
    }
    return true;
  }

  public String getCodigo(){
    return this.codigo;
  }

  public void setExemplarDisponivel(String codigoExemplar){
    for (Exemplar exemplar : listaExemplares) {
      if(exemplar.getCodigo().equals(codigoExemplar)){
        exemplar.setDisponibilidade(true);
      }      
    }
  }

  public List<Reserva> getReservas(){
    return this.listaReservas;
  }

  public List<Exemplar> getExemplares(){
    return this.listaExemplares;
  }

}

