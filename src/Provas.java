import java.util.Date;

public class Provas {
    
    private final String nome;
    private final Date data;
    private final Date hora;
    
    public Provas(String nome, Date data, Date hora){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }
    
    public String getNome(){
        return nome;
    }
        
    public Date getData(){
        return data;
    }
    public Date getHora(){
        return hora;
    }
}
