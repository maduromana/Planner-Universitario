
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class DisciplinaGUI extends javax.swing.JPanel {

 private final ArrayList<Disciplina> listaDeDisciplina;
 
    public DisciplinaGUI() {
        this.listaDeDisciplina = new ArrayList<>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoNomeDisciplina = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaD = new javax.swing.JList<>();
        rotuloDisciplinas = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnDetalhes = new javax.swing.JButton();
        rotuloNomeDisciplina = new javax.swing.JLabel();
        btnCaderno = new javax.swing.JButton();

        campoNomeDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeDisciplinaActionPerformed(evt);
            }
        });

        listaD.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {" "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaD);

        rotuloDisciplinas.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        rotuloDisciplinas.setText("Disciplinas Matriculadas");

        btnAdicionar.setText("Adicionar disciplina");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnDetalhes.setText("Detalhes");
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });

        rotuloNomeDisciplina.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rotuloNomeDisciplina.setText("Nome da disciplina ");

        btnCaderno.setText("Caderno ");
        btnCaderno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadernoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCaderno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloDisciplinas)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdicionar)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloNomeDisciplina)
                            .addGap(18, 18, 18)
                            .addComponent(campoNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloNomeDisciplina)
                    .addComponent(campoNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotuloDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaderno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeDisciplinaActionPerformed

    }//GEN-LAST:event_campoNomeDisciplinaActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String nomeDisciplina = campoNomeDisciplina.getText();
    if (!nomeDisciplina.isEmpty()) {
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina);
        listaDeDisciplina.add(novaDisciplina);

        // Atualiza o modelo da JList
        DefaultListModel<String> disciplinasListModel = new DefaultListModel<>();
        for (Disciplina disciplina : listaDeDisciplina) {
            disciplinasListModel.addElement(disciplina.getNome());
        }
        listaD.setModel(disciplinasListModel);

        campoNomeDisciplina.setText("");
        JOptionPane.showMessageDialog(this, "Disciplina adicionada à lista.");
    }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
       int indiceSelecionado = listaD.getSelectedIndex();
    if (indiceSelecionado >= 0 && indiceSelecionado < listaDeDisciplina.size()) {
        Disciplina disciplinaSelecionada = listaDeDisciplina.get(indiceSelecionado);
        abrirDetalheDisciplina(disciplinaSelecionada);
    }
    }//GEN-LAST:event_btnDetalhesActionPerformed

    private void abrirDetalheDisciplina(Disciplina disciplina) {
    DetalheDisciplinaGUI detalheDisciplinaGUI = new DetalheDisciplinaGUI(disciplina);
    
    // Crie um JFrame para exibir a tela detalhada
    JFrame frame = new JFrame("Detalhes da Disciplina");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de detalhes
    frame.getContentPane().add(detalheDisciplinaGUI);
    frame.pack();
    frame.setLocationRelativeTo(this);
    frame.setVisible(true);
 
    }
      
    private void btnCadernoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadernoActionPerformed
int indiceSelecionado = listaD.getSelectedIndex();
    if (indiceSelecionado >= 0 && indiceSelecionado < listaDeDisciplina.size()) {
        Disciplina disciplinaSelecionada = listaDeDisciplina.get(indiceSelecionado);
        abrirCaderno(disciplinaSelecionada);
    }
    }//GEN-LAST:event_btnCadernoActionPerformed

private void abrirCaderno(Disciplina disciplina) {
   CadernoGUI cadernoGUI = new CadernoGUI(disciplina); 
    // Crie um JFrame para exibir a tela de caderno
    JFrame frame = new JFrame("Caderno da Disciplina");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de caderno
    frame.getContentPane().add(cadernoGUI);
    frame.pack();
    frame.setLocationRelativeTo(this);
    frame.setVisible(true);
}
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCaderno;
    private javax.swing.JButton btnDetalhes;
    private javax.swing.JTextField campoNomeDisciplina;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaD;
    private javax.swing.JLabel rotuloDisciplinas;
    private javax.swing.JLabel rotuloNomeDisciplina;
    // End of variables declaration//GEN-END:variables
}
