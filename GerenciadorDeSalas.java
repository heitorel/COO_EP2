//completa s/ teste
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class GerenciadorDeSalas {
  List<Sala> salas = new ArrayList<Sala>();
  Collection<Reserva> reservas = new ArrayList<Reserva>();
  DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  /* que deve receber o nome da sala, a capacidade máxima da sala, e uma descrição;*/
  public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao) {
    Sala novaSala = new Sala(nome, capacidadeMaxima,  descricao);
    //adiciona a sala a lista de salas
    salas.add(novaSala);
  }
  
  /*que deve receber  o nome da sala a ser removida;*/
  public void removeSalaChamada(String nomeDaSala) {

    for (Sala sala : salas) {
      if (nomeDaSala.equals(sala.getNome())) {
        salas.remove(sala); //remive a sala da lista de salas
        return;
      }
    }
  }

  /*que deve devolver uma instância de List com objetos do tipo Sala; */
  public List<Sala> listaDeSalas() {
    return salas; //retorna lista de salas
  }

  /*que deve receber uma instância de Sala;*/
  public void adicionaSala(Sala novaSala) {
    salas.add(novaSala); 
  }

  /* que recebe um nome de sala, um LocalDateTime que indica o início da reserva e um outro LocalDateTime para indicar o final da reserva. O método deve devolver uma instância de Reserva;*/
  public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {

    //verifica se a sala esta na lista de salas 
    Sala salaReservada = null;
    for (Sala sala: salas) {
      salaReservada = sala;
      break;
    }

    Reserva novaReserva = new Reserva(salaReservada, dataInicial, dataFinal); //instancia uma novaReserva

    reservas.add(novaReserva); //adiciona a nova reserva a colecao de reservas 
    
    return novaReserva;
  }

  
  /*que recebe um objeto do tipo Reserva e cancela esta reserva;*/
  public void cancelaReserva(Reserva cancelada) {
    reservas.remove(cancelada);
  }

  /*que devolve uma Collection de objetos Reserva que representam as reservas da 
 respectiva sala.*/
  public Collection<Reserva> reservasParaSala(String nomeSala) {
    return reservas;
  }
  
  /*que recebe uma String com o nome da sala e imprime todas as suas reservas */
  public void imprimeReservasDaSala(String nomeSala) {

    int count = 0;
    //itera a colecao de reservas
    for (Reserva res : reservas) {
      if (res.sala().getNome() == nomeSala) { //se encontrar a sala nas salas reservadas
        System.out.println ("Inicio: " + res.getDataInicial().format(formatador));
        System.out.println ("Fim: " + res.getDataFinal().format(formatador));
        count++; //sala foi impressa
      }
    }

    if (count == 0) {
      System.out.println ("Essa sala nao possui reservas");
    }
  }
}