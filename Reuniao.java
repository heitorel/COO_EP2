import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reuniao {

  private ArrayList<Participante> participantes;
  private ArrayList<Disponibilidade> listaInterseccoes;
  private LocalDate inicioIntervalo;
  private LocalDate finalIntervalo;
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public Reuniao(
    ArrayList<Participante> participantes,
    LocalDate inicioIntervalo,
    LocalDate finalIntervalo
  ) {
    this.participantes = participantes;
    this.inicioIntervalo = inicioIntervalo;
    this.finalIntervalo = finalIntervalo;
    this.listaInterseccoes = new ArrayList<>();
  }

  public ArrayList<Participante> getParticipantes() {
    return participantes;
  }

  public LocalDate getInicioIntervalo() {
    return inicioIntervalo;
  }

  public LocalDate getFinalIntervalo() {
    return finalIntervalo;
  }

  public ArrayList<Disponibilidade> getInterseccoes() {
    return listaInterseccoes;
  }

  public void setParticipantes(ArrayList<Participante> participantes) {
    this.participantes = participantes;
  }

  public void setInicioIntervalo(LocalDate inicioIntervalo) {
    this.inicioIntervalo = inicioIntervalo;
  }

  public void setFinalIntervalo(LocalDate finalIntervalo) {
    this.finalIntervalo = finalIntervalo;
  }

  public void defineInterseccoes(int index, LocalDateTime inicio, LocalDateTime fim) {
    Participante participante = participantes.get(index);
    ArrayList<Disponibilidade> listaIntervalos = participante.getDisponibilidade();
    LocalDateTime inicioPadrao = inicio;
    LocalDateTime fimPadrao = fim;

    for (Disponibilidade inicioAtual : listaIntervalos) {
      //Se houver uma interseccao, caso contrario o for nem incia
      if (
        inicioAtual.getInicio().isBefore(fim) &&
        inicioAtual.getFim().isAfter(inicio)
      ) {
        if (inicioAtual.getFim().isBefore(fim)) fim = inicioAtual.getFim();

        if (inicioAtual.getInicio().isAfter(inicio)) inicio =
          inicioAtual.getInicio();

        //Caso a lista não esteja cheia
        if (participantes.size() - 1 != index) {
          //Chama o método recursivamente enviando o proximo participante
          defineInterseccoes(index + 1, inicio, fim);
        } else {
          listaInterseccoes.add(new Disponibilidade(inicio, fim));
        }
      }
      inicio = inicioPadrao;
      fim = fimPadrao;
    }
  }

  public void mostraSobreposicao() {
    //Exibe os horários disponíveis inseridos pelos participantes
    for (Participante participante : participantes) {
      ArrayList<Disponibilidade> listaDisponibilidade = participante.getDisponibilidade();
      System.out.println("Participante: " + participante.getEmail());
      if (listaDisponibilidade != null) {
        for (Disponibilidade disponibilidade : listaDisponibilidade) {
          System.out.println(
            "De " +
            disponibilidade.getInicio().format(formatter) +
            " ate " +
            disponibilidade.getFim().format(formatter)
          );
        }
      }
      System.out.println("");
    }

    LocalDateTime InicioDisponibilidade = inicioIntervalo.atStartOfDay();
    LocalDateTime FimDisponibilidade = finalIntervalo.atTime(23, 59, 59);

    defineInterseccoes(0, InicioDisponibilidade, FimDisponibilidade);

    if (listaInterseccoes != null) {
      System.out.println("Lista de horarios disponiveis para todos: ");
      for (Disponibilidade interseccao : listaInterseccoes) {
        System.out.println("De " + interseccao.getInicio().format(formatter) + " ate " + interseccao.getFim().format(formatter));
      }
    } else {
      System.out.println("Nao ha interseccoes de horarios");
    }
  }
}
