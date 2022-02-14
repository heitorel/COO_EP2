import java.time.*;
import java.util.*;

public class MarcadorDeReuniao {
  Reuniao novaReuniao;

  /* onde cada participante é identificado com uma String e o início e fim da
   de java.time.LocalDateTime.*/
  public void indicaDisponibilidadeDe(
    String participante,
    LocalDateTime inicio,
    LocalDateTime fim
  ) {
    /* compara o inicio e o fim da disponibilidade um participante (recbido no argumento) com o inicio e o fim de uma reunião */
    /* verificando a legibilidade reuniao nos horarios passados como argumentos*/
    if (inicio.isAfter(fim)) {
      System.out.println("O inicio deve ser antes do final");
      return;
    }

    LocalDateTime inicioReuniao =
      novaReuniao.getInicioIntervalo().atStartOfDay();
    LocalDateTime fimReuniao =
      novaReuniao.getFinalIntervalo().atTime(23, 59, 59);

    if (inicio.isBefore(inicioReuniao) || fim.isAfter(fimReuniao)) {
      System.out.println(
        "O horario indicado nao esta no intervalo disponivel para a reuniao"
      );
      return;
    }

    ArrayList<Participante> Participantes = novaReuniao.getParticipantes();
    Participante participanteInformado = null;

    //procurando o participante recebido no argumento pelo email na lista de Participantes da reunião
    for (Participante part : Participantes) {
      if (part.getEmail().equals(participante)) {
        //Participante encontrado
        participanteInformado = part;
        break;
      }
    }

    if (participanteInformado != null) {
      //Participante existe -- Inclui um intervalo disponível dele
      participanteInformado.setDisponibilidade(inicio, fim);
    } else {
      System.out.println("Participante nao encontrado na lista da reuniao");
    }
  }

  //A definição dos participantes da reunião
  public void marcarReuniaoEntre(
    LocalDate dataInicial,
    LocalDate dataFinal,
    Collection<String> listaDeParticipantes
  ) {
    ArrayList<Participante> Participantes = new ArrayList<Participante>();

    for (String email : listaDeParticipantes) {
      Participantes.add(new Participante(email));
    }

    novaReuniao = new Reuniao(Participantes, dataInicial, dataFinal);
  }

  /*deve exibir um relatório com as escolhas realizadas e indicar em quais horários todos os participantes
  poderiam participar da reunião.*/
  public void mostraSobreposicao() {
    novaReuniao.mostraSobreposicao();
  }
}
