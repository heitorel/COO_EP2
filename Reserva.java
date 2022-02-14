import java.util.*;
import java.time.*;

public class Reserva{
  private LocalDateTime dataInicial;
  private LocalDateTime dataFinal;
  private Sala sala;
  private ArrayList<Participante> Participantes;


  public Reserva(Sala sala, LocalDateTime dataInicial, LocalDateTime dataFinal) {
    this.dataInicial = dataInicial;
    this.dataFinal = dataFinal;
    this.sala = sala;
  }

  public Sala sala() {
    return sala;
  }

  public LocalDateTime getDataInicial() {
    return this.dataInicial;
  }

  public LocalDateTime getDataFinal() {
    return this.dataFinal;
  }

  public ArrayList<Participante> getParticipantes(){
    return this.Participantes;
  }
}