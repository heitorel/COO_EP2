//completa
public class Sala {
  private int capacidade;
  private String nome;
  private String local;
  private String observacoes;

  public Sala(String nome, int capacidade, String observacoes){
    this.nome = nome;
    this.capacidade = capacidade;
    this.observacoes = observacoes;
  }

  public Sala(String nome, String local, String observacoes, int capacidade) {
    this.capacidade = capacidade;
    this.nome = nome;
    this.local = local;
    this.observacoes = observacoes;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public String getNome() {
    return this.nome;
  }

  public int getCapacidade() {
    return this.capacidade;
  }

  public String getObservacoes() {
    return this.observacoes;
  }

  public String getLocal() {
    return this.local;
  }
}