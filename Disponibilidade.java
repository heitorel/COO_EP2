//completa
import java.time.LocalDateTime;

public class Disponibilidade {
    private LocalDateTime inicio;
    private LocalDateTime fim;
    
    public Disponibilidade(LocalDateTime inicio, LocalDateTime fim){
        this.inicio = inicio;
        this.fim = fim;
    }
        
    public LocalDateTime getInicio(){
        return this.inicio;
    }
    
    public LocalDateTime getFim(){
        return this.fim;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
    
}