import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LoginGUI extends javax.swing.JFrame {
    private static LoginGUI janelaLogin;    
    
    public LoginGUI() {
        initComponents();
         setLocationRelativeTo(this);
        tfRALogin.setDocument(new NumericDocument(7));
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        btLogin.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarLogin();
                tfRALogin.requestFocus();
                limparCampos();
            }
        }, enterKey, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
         cbVisualizarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle a visibilidade da senha
                pfSenhaLogin.setEchoChar(cbVisualizarSenha.isSelected() ? '\0' : '•');
            }
        });
    }
    private static class NumericDocument extends PlainDocument{
        private int tamanhoMaximo;
        
        public NumericDocument(int tamanhoMaximo){
            this.tamanhoMaximo = tamanhoMaximo;
        }
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }
            // Verifica se o comprimento total não excede maxLength
            if ((getLength() + str.length()) <= tamanhoMaximo) {
                super.insertString(offs, str, a);
            }
        }
    }
    
    public static LoginGUI criarJanelaLogin(){
        if(janelaLogin == null){
            janelaLogin = new LoginGUI();
            janelaLogin.addWindowListener(new WindowAdapter(){
                public void WindowClosing(WindowEvent e){
                    janelaLogin = null;
                }
            });
        }
        return janelaLogin;
    }
    
    private void verificarLogin(){
        String RA = tfRALogin.getText();
        String senha = new String(pfSenhaLogin.getPassword());
        
        try {
            if(Cadastro.obterCadastrados().isEmpty()){
                limparCampos();
                throw new RANaoCadastradoException("Não há usuários cadastrados.");
            }
            if (Cadastro.verificarLogin(RA, senha)) {
                boasVindasPrimeiraVez();
                CadastroUniversitarioGUI.criarjanelaCadastroUni().setVisible(true);
                limparCampos();
                dispose();
            } else {
                throw new CredenciaisInvalidasException("Credenciais incorretas. Tente novamente.");
            }
            
        } catch (CredenciaisInvalidasException | RANaoCadastradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            limparCampos();
        }
    }
    
    private static class CredenciaisInvalidasException extends Exception {
        public CredenciaisInvalidasException(String message) {
            super(message);
        }
    }
    private static class RANaoCadastradoException extends Exception {
        public RANaoCadastradoException(String message) {
            super(message);
        }
    }
    
  
    private void boasVindasPrimeiraVez() {
    JOptionPane.showMessageDialog(this,
            "Bem-vindo ao Planner! Parece que é a sua primeira vez por aqui.\n"
            + "Por favor, forneça algumas informações antes de começarmos.",
            "Boas-vindas",
            JOptionPane.INFORMATION_MESSAGE);
}
    
    public void limparCampos(){
        tfRALogin.setText("");
        pfSenhaLogin.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfRALogin = new javax.swing.JTextField();
        pfSenhaLogin = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        btTelaCadastro = new javax.swing.JButton();
        cbVisualizarSenha = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 153));
        jLabel1.setText("Meu planner ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("RA:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Senha:");

        tfRALogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRALoginActionPerformed(evt);
            }
        });

        pfSenhaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSenhaLoginActionPerformed(evt);
            }
        });

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btTelaCadastro.setText("Cadastrar");
        btTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTelaCadastroActionPerformed(evt);
            }
        });

        cbVisualizarSenha.setText("Visualizar senha");
        cbVisualizarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVisualizarSenhaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbVisualizarSenha)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel2)
                                    .addGap(40, 40, 40)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pfSenhaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(tfRALogin, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel4)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfRALogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(pfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbVisualizarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTelaCadastroActionPerformed
        CadastroGUI.criarJanelaCadastro().setVisible(true);
        dispose();
    }//GEN-LAST:event_btTelaCadastroActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        verificarLogin();
    }//GEN-LAST:event_btLoginActionPerformed

    private void tfRALoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRALoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRALoginActionPerformed

    private void pfSenhaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSenhaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfSenhaLoginActionPerformed

    private void cbVisualizarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVisualizarSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVisualizarSenhaActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btTelaCadastro;
    private javax.swing.JCheckBox cbVisualizarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfSenhaLogin;
    private javax.swing.JTextField tfRALogin;
    // End of variables declaration//GEN-END:variables
}
