import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Criar e exibir a interface de login primeiro
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });
    }

    public static void exibirInterfacePrincipal() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Meu Planner");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTabbedPane tabbedPane = new JTabbedPane();
            // Adicona Dados do universitário como uma aba
            DadosUniversitarioGUI dadosUniversitario = new DadosUniversitarioGUI();
            tabbedPane.addTab("Dados Universitário", null, dadosUniversitario);

            // Adiciona gasto universitário como uma aba
            GastoUniversitarioGUI gastoUniversitario = new GastoUniversitarioGUI();
            tabbedPane.addTab("Gastos Mensais", null, gastoUniversitario);

            // Adiciona lista de tarefas como uma aba
            ListaTarefasGUI listaTarefa = new ListaTarefasGUI();
            tabbedPane.addTab("Lista de Tarefas", null, listaTarefa);

            // Adiciona Disciplina como uma aba
            DisciplinaGUI disciplina = new DisciplinaGUI();
            tabbedPane.addTab("Disciplinas", null, disciplina);

            // Adiciona Prova como uma aba
            ProvasGUI provas = new ProvasGUI();
            tabbedPane.addTab("Provas", null, provas);
            
            // Adicona Trabalho como uma aba
            TrabalhosGUI trabalho = new TrabalhosGUI();
            tabbedPane.addTab("Trabalhos", null, trabalho);

            frame.setContentPane(tabbedPane);

            frame.setSize(500, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
