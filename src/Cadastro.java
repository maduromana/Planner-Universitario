import java.util.ArrayList;

public class Cadastro {
    private String RA;
    private String senha;

    public Cadastro(String RA, String senha) {
        this.RA = RA;
        this.senha = senha;
    }

    public Cadastro() {
    }

    public String getRA() {
        return RA;
    }

    public String getSenha() {
        return senha;
    }

    void setRA(String RA) {
        this.RA = RA;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private static ArrayList<Cadastro> cadastro = new ArrayList<>();

    public static boolean verificarLogin(String RA, String senha) {
        for (Cadastro usuario : cadastro) {
            if (usuario.getRA().equals(RA) && usuario.getSenha().equals(senha)) {
                return true;  // Credenciais encontradas, login válido
            }
        }
        return false;  // Credenciais não encontradas, login inválido
    }

    public boolean salvar(Cadastro cad) {
        if (cad != null) {
            cadastro.add(cad);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Cadastro> obterCadastrados() {
        return cadastro;
    }
}
