import java.util.ArrayList;

public class CadastrosView {
    public void mostrarCadastrados(ArrayList<Cadastro> cadastrados) {
        System.out.println("Usuários cadastrados:");

        for (Cadastro cad : cadastrados) {
            System.out.println("RA: " + cad.getRA() + ", Senha: " + cad.getSenha());
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
