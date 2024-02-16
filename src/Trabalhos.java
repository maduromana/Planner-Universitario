
import java.util.Date;

public class Trabalhos {
    
    private final String nome;
    private final Date dataEntrega;
    private final String descricao; 
    
    public Trabalhos(String nome, Date dataEntrega, String descricao){
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.descricao = descricao; 
    }
    
    public String getNome(){
        return nome;
    }
        
    public Date getDataEntrega(){
        return dataEntrega;
    }
    
    public String getDescricao(){
        return descricao; 
    }
}
