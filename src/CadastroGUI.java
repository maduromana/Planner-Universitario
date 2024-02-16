import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class CadastroGUI extends javax.swing.JFrame {
    private static CadastroGUI janelaCadastro;
    Cadastro c = new Cadastro();
    private String RA;
   
    public CadastroGUI() {
        initComponents();
        setLocationRelativeTo(this);
        tfRACadastro.setDocument(new NumericDocument(7));

        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        btCadastrar.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastrar();
            }
        }, enterKey, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        cbVisualizarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pfSenhaCadastro.setEchoChar(cbVisualizarSenha.isSelected() ? '\0' : '•');
            }
        });
    }

    public String getRA() {
        return RA;
    }
    
    private static class NumericDocument extends PlainDocument {
        private int tamanhoMaximo;

        public NumericDocument(int tamanhoMaximo) {
            this.tamanhoMaximo = tamanhoMaximo;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }
            if ((getLength() + str.length()) <= tamanhoMaximo) {
                super.insertString(offs, str, a);
            }
        }
    }

    public void Cadastrar() {
        try {
            validarCampos();
            validarRACadastrado();
            
            Cadastro cadastra = new Cadastro();
            RA = tfRACadastro.getText();
            cadastra.setRA(RA);
            cadastra.setSenha(pfSenhaCadastro.getText());

            if (c.salvar(cadastra)) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                LoginGUI.criarJanelaLogin().setVisible(true);
                limparCampos();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário");
            }
        } catch (CamposVaziosException | RAJaCadastradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void validarCampos() throws CamposVaziosException {
        if (tfRACadastro.getText().isEmpty() || pfSenhaCadastro.getPassword().length == 0) {
            throw new CamposVaziosException("Todos os campos devem ser preenchidos.");
        }
    }
    private static class CamposVaziosException extends Exception {
        public CamposVaziosException(String message) {
            super(message);
        }
    }
    public static class RAJaCadastradoException extends Exception {
        public RAJaCadastradoException(String message) {
            super(message);
        }
    }
    public void validarRACadastrado() throws RAJaCadastradoException {
        String raDigitado = tfRACadastro.getText();
        for (Cadastro usuario : Cadastro.obterCadastrados()) {
            if (usuario.getRA().equals(raDigitado)) {
                throw new RAJaCadastradoException("RA já cadastrado. Escolha outro RA.");
            }
        }
    }

    public static CadastroGUI criarJanelaCadastro() {
        if (janelaCadastro == null) {
            janelaCadastro = new CadastroGUI();
            janelaCadastro.addWindowListener(new WindowAdapter() {
                public void WindowClosing(WindowEvent e) {
                    janelaCadastro = null;
                }
            });
        }
        return janelaCadastro;
    }

    public void limparCampos() {
        tfRACadastro.setText("");
        pfSenhaCadastro.setText("");
    }

    public void abrirJanelaLogin() {
        LoginGUI login = new LoginGUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfRACadastro = new javax.swing.JTextField();
        pfSenhaCadastro = new javax.swing.JPasswordField();
        btCadastrar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        cbVisualizarSenha = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("RA:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Senha:");

        tfRACadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRACadastroActionPerformed(evt);
            }
        });

        pfSenhaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSenhaCadastroActionPerformed(evt);
            }
        });

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        cbVisualizarSenha.setText("Visualizar senha ");
        cbVisualizarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVisualizarSenhaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Cadastrar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 153));
        jLabel1.setText("Meu planner ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbVisualizarSenha)
                    .addComponent(pfSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfRACadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfRACadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pfSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(cbVisualizarSenha)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        Cadastrar();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        LoginGUI.criarJanelaLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tfRACadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRACadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRACadastroActionPerformed

    private void pfSenhaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSenhaCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfSenhaCadastroActionPerformed

    private void cbVisualizarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVisualizarSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVisualizarSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JCheckBox cbVisualizarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfSenhaCadastro;
    private javax.swing.JTextField tfRACadastro;
    // End of variables declaration//GEN-END:variables
}
