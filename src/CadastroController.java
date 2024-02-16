import java.util.ArrayList;

public class CadastroController {
    private Cadastro model;
    private CadastrosView view;

    public CadastroController(Cadastro model, CadastrosView view) {
        this.model = model;
        this.view = view;
    }

    public void cadastrarUsuario(String RA, String senha) {
        Cadastro novoUsuario = new Cadastro(RA, senha);
        boolean sucesso = model.salvar(novoUsuario);

        if (sucesso) {
            view.mostrarMensagem("Usuário cadastrado com sucesso.");
        } else {
            view.mostrarMensagem("Erro ao cadastrar usuário.");
        }
    }

    public void exibirCadastrados() {
        ArrayList<Cadastro> cadastrados = model.obterCadastrados();
        view.mostrarCadastrados(cadastrados);
    }
}
