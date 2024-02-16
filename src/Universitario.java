import java.util.ArrayList;

public class Universitario {
    
    private String nome;
    private String RA;
    private String nascimento;
    private String ingressoUniversidade;
    private String periodoAtual;
    private int qtdMaterias;
    
    public Universitario(String nome, String nascimento, String ingressoUniversidade, String periodoAtual, int qtdMaterias){
        this.nome = nome;
        this.nascimento = nascimento;
        this.ingressoUniversidade = ingressoUniversidade;
        this.periodoAtual = periodoAtual;
        this.qtdMaterias = qtdMaterias;
    }
    public Universitario(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getIngressoUniversidade() {
        return ingressoUniversidade;
    }

    public void setIngressoUniversidade(String ingressoUniversidade) {
        this.ingressoUniversidade = ingressoUniversidade;
    }

    public String getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(String periodoAtual) {
        this.periodoAtual = periodoAtual;
    }

    public int getQtdMaterias() {
        return qtdMaterias;
    }

    public void setQtdMaterias(int qtdMaterias) {
        this.qtdMaterias = qtdMaterias;
    }
    
    private static ArrayList<Universitario> uni = new ArrayList<>();
    
    public boolean salvar(Universitario cadUni){
        if(cadUni != null){
            uni.add(cadUni);
            return true;
        }else{
        return false;
        }
    }
    public static ArrayList<Universitario> obterCadastrados() {
        return uni;
    }
}
