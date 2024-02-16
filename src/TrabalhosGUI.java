
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class TrabalhosGUI extends javax.swing.JPanel {

    private final ArrayList<Trabalhos> listaTrabalhos = new ArrayList<>();

    public TrabalhosGUI() {
        initComponents();
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ftfDataProva = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taConteudoProva = new javax.swing.JTextArea();
        tfNomeDisciplina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btAdicionarProva = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabelaTrabalhos = new javax.swing.JTable();

        try {
            ftfDataProva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDataProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfDataProvaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Trabalhos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Descrição do trabalho:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Nome da Disciplina:");

        taConteudoProva.setColumns(10);
        taConteudoProva.setLineWrap(true);
        taConteudoProva.setRows(5);
        jScrollPane2.setViewportView(taConteudoProva);

        tfNomeDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeDisciplinaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("Data de entrega:");

        btAdicionarProva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAdicionarProva.setText("Adicionar");
        btAdicionarProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarProvaActionPerformed(evt);
            }
        });

        tbTabelaTrabalhos.setAutoCreateRowSorter(true);
        tbTabelaTrabalhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbTabelaTrabalhos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome da Disciplina", "Data de entrega",  "Descrição do trabalho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTabelaTrabalhos.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tbTabelaTrabalhos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(ftfDataProva, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(tfNomeDisciplina))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(186, 186, 186))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAdicionarProva)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftfDataProva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btAdicionarProva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ftfDataProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfDataProvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfDataProvaActionPerformed

    private void tfNomeDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeDisciplinaActionPerformed

    private void btAdicionarProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarProvaActionPerformed
    String nomeDisciplina = tfNomeDisciplina.getText();
        String dataProvaStr = ftfDataProva.getText();
        String descricaoTrabalho = taConteudoProva.getText();

        try {
            if (nomeDisciplina.isEmpty() || dataProvaStr.isEmpty() || descricaoTrabalho.isEmpty()) {
                throw new CamposVaziosException("Todos os campos devem ser preenchidos.");
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataProva = dateFormat.parse(dataProvaStr);

            Trabalhos trabalho = new Trabalhos(nomeDisciplina, dataProva, descricaoTrabalho);
            listaTrabalhos.add(trabalho);

            // Atualizar a tabela
            atualizarTabela();
            limparCampos();
        } catch (CamposVaziosException ex) {
            // Exibir mensagem de erro personalizada
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar trabalho.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAdicionarProvaActionPerformed

    class CamposVaziosException extends Exception {
        public CamposVaziosException(String message) {
            super(message);
        }
    }
    
    public void limparCampos(){
        tfNomeDisciplina.setText("");
        ftfDataProva.setText("");
        taConteudoProva.setText("");        
    }
    
    private void atualizarTabela() {
    DefaultTableModel model = (DefaultTableModel) tbTabelaTrabalhos.getModel();
    model.setRowCount(0); // Limpar a tabela

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    for (Trabalhos trabalho : listaTrabalhos) {
        Object[] row = {
            trabalho.getNome(),
            dateFormat.format(trabalho.getDataEntrega()),
            trabalho.getDescricao(),
            
        };
        model.addRow(row);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarProva;
    private javax.swing.JFormattedTextField ftfDataProva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taConteudoProva;
    private javax.swing.JTable tbTabelaTrabalhos;
    private javax.swing.JTextField tfNomeDisciplina;
    // End of variables declaration//GEN-END:variables
}
