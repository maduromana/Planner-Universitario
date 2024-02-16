import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CadastroUniversitarioGUI extends javax.swing.JFrame {
    private static CadastroUniversitarioGUI janelaCadastroUni;
    Universitario u = new Universitario();
    private Cadastro cadastro;
    private boolean editandoNascimento = false;
    private boolean editandoIngresso = false;
    
    public CadastroUniversitarioGUI() {
        initComponents();
        RACadastro();
        setLocationRelativeTo(this);
        
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        btCadastrar.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarUni();
               
            }
        }, enterKey, JComponent.WHEN_IN_FOCUSED_WINDOW);
        try{
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            dataMask.setValidCharacters("0123456789");
            ftfNascimentoCadastroUni.setFormatterFactory(new DefaultFormatterFactory(dataMask));
        } catch(java.text.ParseException ex){
            ex.printStackTrace();
        }
        ftfNascimentoCadastroUni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (editandoNascimento) {
                    validarFormatoNascimento();
                }
            }
        });
        ftfNascimentoCadastroUni.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                editandoNascimento = true;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                editandoNascimento = true;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                editandoNascimento = true;
            }
        });
        ftfIngressoCadastroUni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (editandoIngresso) {
                    validarFormatoIngresso();
                }
            }
        });
        ftfIngressoCadastroUni.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                editandoIngresso = true;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                editandoIngresso = true;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                editandoIngresso = true;
            }
        });
    }
    
    private void validarFormatoNascimento(){
        String nascimento = ftfNascimentoCadastroUni.getText();
        if(!nascimento.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")){
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato DD/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
            ftfNascimentoCadastroUni.setValue(null); // Limpar o campo
        }
    }
     private void validarFormatoIngresso() {
        String ingresso = ftfIngressoCadastroUni.getText();

        // Verifica se a data está no formato correto (DD/MM/YYYY)
        if (!ingresso.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato DD/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
            ftfIngressoCadastroUni.setValue(null);
        }
    }
     private void RACadastro() {
        Iterator<Cadastro> iterator = Cadastro.obterCadastrados().iterator();

        while (iterator.hasNext()) {
            cadastro = iterator.next();
        }

        if (cadastro != null) {
            exibirRA();
        }
    }
    public void exibirRA(){
        if(cadastro != null){
            lbRA.setText(cadastro.getRA());
        }
    }
    public static CadastroUniversitarioGUI criarjanelaCadastroUni(){
        if(janelaCadastroUni == null){
            janelaCadastroUni = new CadastroUniversitarioGUI();
            janelaCadastroUni.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    janelaCadastroUni = null;
                }
            });
        }
        return janelaCadastroUni;
    }
    
   public class CamposNaoPreenchidosException extends Exception {
        public CamposNaoPreenchidosException(String message) {
            super(message);
        }
    }
    
    private void validarCampos() throws CamposVaziosException {
        if (tfNomeCadastroUni.getText().isEmpty() || ftfIngressoCadastroUni.getText().isEmpty() || ftfNascimentoCadastroUni.getText().isEmpty()) {
            throw new CamposVaziosException("Todos os campos devem ser preenchidos.");
        }
    }
    private static class CamposVaziosException extends Exception {
        public CamposVaziosException(String message) {
            super(message);
        }
    }
    
    
    public void CadastrarUni(){
        try{
            validarCampos();
            Universitario cadastraUni = new Universitario();
            if(u.salvar(cadastraUni)){

                cadastraUni.setNome(tfNomeCadastroUni.getText());        
                cadastraUni.setNascimento(ftfNascimentoCadastroUni.getText());
                cadastraUni.setIngressoUniversidade(ftfIngressoCadastroUni.getText());
                String periodo = (String) cbPeriodoCadastroUni.getSelectedItem();
                cadastraUni.setPeriodoAtual(periodo);
                cadastraUni.setQtdMaterias((int) spQtdMateriasCadastroUni.getValue());
                boasVindas();
                dispose();
                Principal.exibirInterfacePrincipal();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar dados");  
            }
        }catch(CamposVaziosException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
                 
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfNomeCadastroUni = new javax.swing.JTextField();
        ftfNascimentoCadastroUni = new javax.swing.JFormattedTextField();
        ftfIngressoCadastroUni = new javax.swing.JFormattedTextField();
        cbPeriodoCadastroUni = new javax.swing.JComboBox<>();
        spQtdMateriasCadastroUni = new javax.swing.JSpinner();
        btFechar = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        lbRA = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Informações importantes");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("RA:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Ingresso na faculdade:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Período atual no sistema:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("Data de nascimento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setText("Matérias matriculadas:");

        try {
            ftfNascimentoCadastroUni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfIngressoCadastroUni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbPeriodoCadastroUni.setMaximumRowCount(10);
        cbPeriodoCadastroUni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º", "2º", "3º", "4º", "5º", "6º", "7º", "8º", "9º", "10º" }));
        cbPeriodoCadastroUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPeriodoCadastroUniActionPerformed(evt);
            }
        });

        spQtdMateriasCadastroUni.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lbRA.setText("RA");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 153));
        jLabel8.setText("Meu planner ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(spQtdMateriasCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbPeriodoCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbRA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ftfNascimentoCadastroUni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(ftfIngressoCadastroUni, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(tfNomeCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbRA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftfNascimentoCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfIngressoCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbPeriodoCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spQtdMateriasCadastroUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
     
        CadastrarUni();
     
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void cbPeriodoCadastroUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPeriodoCadastroUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPeriodoCadastroUniActionPerformed
 private void boasVindas() {
    JOptionPane.showMessageDialog(this,
            "Dados cadastrados com sucesso\n"+
            "Seja bem-vindo(a) ao seu planner pessoal",
            "Boas-vindas",
            JOptionPane.INFORMATION_MESSAGE);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btFechar;
    private javax.swing.JComboBox<String> cbPeriodoCadastroUni;
    private javax.swing.JFormattedTextField ftfIngressoCadastroUni;
    private javax.swing.JFormattedTextField ftfNascimentoCadastroUni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbRA;
    private javax.swing.JSpinner spQtdMateriasCadastroUni;
    private javax.swing.JTextField tfNomeCadastroUni;
    // End of variables declaration//GEN-END:variables
}
