import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Participante{
  private String email;
  private LocalDateTime inicio, fim;
  private ArrayList<Disponibilidade> disponibilidade;

  public Participante(String email, LocalDateTime inicio, LocalDateTime fim) {
    this.email = email;
    this.inicio = inicio;
    this.fim = fim;
    this.disponibilidade = new ArrayList<Disponibilidade>();
  }

  public Participante(String email){
    this.email = email;
    this.disponibilidade = new ArrayList<Disponibilidade>();
  }

  public String getEmail() {
    return this.email;
  }

  public ArrayList<Disponibilidade> getDisponibilidade(){
    return this.disponibilidade;
  }

  public LocalDateTime getInicio() {
    return this.inicio;
  }

  public LocalDateTime getFim() {
    return this.fim;
  }

  public void setDisponibilidade(LocalDateTime inicio, LocalDateTime fim){
    Disponibilidade novaDisponibilidade = new Disponibilidade(inicio, fim);
    disponibilidade.add(novaDisponibilidade);
  }
}