import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import javax.swing.text.DefaultFormatterFactory;

public class ProvasGUI extends javax.swing.JPanel {
    private final DefaultTableModel TabelaProvas;
    private boolean editandoHora = false;
    private boolean editandoData = false;

    public ProvasGUI() {
        initComponents();    
        TabelaProvas = (DefaultTableModel) tbTabelaProvas.getModel();
        try {
            MaskFormatter horaMask = new MaskFormatter("##:##");
            horaMask.setValidCharacters("0123456789");
            ftfHoraProva.setFormatterFactory(new DefaultFormatterFactory(horaMask));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            dataMask.setValidCharacters("0123456789");
            ftfDataProva.setFormatterFactory(new DefaultFormatterFactory(dataMask));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfHoraProva.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (editandoHora) {
                    validarFormatoHora();
                }
            }
        });
        ftfDataProva.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (editandoData) {
                    validarFormatoData();
                }
            }
        });
        ftfHoraProva.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                editandoHora = true;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                editandoHora = true;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                editandoHora = true;
            }
        });
        ftfDataProva.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                editandoData = true;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                editandoData = true;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                editandoData = true;
            }
        });
    }
    private void validarFormatoData() {
        String data = ftfDataProva.getText();

        // Verifica se a data está no formato correto (DD/MM/YYYY)
        if (!data.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato DD/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
            ftfDataProva.setValue(null); // Limpar o campo
        }
    }
    private void validarFormatoHora() {
        String hora = ftfHoraProva.getText();

        // Verifica se a hora está no formato correto (HH:mm)
        if (!hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            JOptionPane.showMessageDialog(this, "Formato de hora inválido. Use o formato HH:mm.", "Erro", JOptionPane.ERROR_MESSAGE);
            ftfHoraProva.setValue(null); // Limpar o campo
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfNomeDisciplina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btAdicionarProva = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabelaProvas = new javax.swing.JTable();
        ftfDataProva = new javax.swing.JFormattedTextField();
        ftfHoraProva = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taConteudoProva = new javax.swing.JTextArea();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Nome da Disciplina:");

        tfNomeDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeDisciplinaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("Data da Prova:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Horário da Prova:");

        btAdicionarProva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAdicionarProva.setText("Adicionar");
        btAdicionarProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarProvaActionPerformed(evt);
            }
        });

        tbTabelaProvas.setAutoCreateRowSorter(true);
        tbTabelaProvas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbTabelaProvas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome da Disciplina", "Data da Prova", "Hora da Prova", "Conteúdo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTabelaProvas.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tbTabelaProvas);

        try {
            ftfDataProva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfHoraProva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfHoraProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfHoraProvaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Provas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Conteúdo da Prova:");

        taConteudoProva.setColumns(10);
        taConteudoProva.setLineWrap(true);
        taConteudoProva.setRows(5);
        jScrollPane2.setViewportView(taConteudoProva);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ftfHoraProva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfNomeDisciplina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ftfDataProva, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdicionarProva))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ftfHoraProva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdicionarProva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeDisciplinaActionPerformed

    private void btAdicionarProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarProvaActionPerformed
        salvarProva();
    }//GEN-LAST:event_btAdicionarProvaActionPerformed

    private void ftfHoraProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfHoraProvaActionPerformed
     
    }//GEN-LAST:event_ftfHoraProvaActionPerformed
    private boolean isValidHoraFormat(String hora) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false); // Não permitir conversões automáticas
            sdf.parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
 public class CamposNaoPreenchidosException extends Exception {
        public CamposNaoPreenchidosException(String message) {
            super(message);
        }
    }

    private boolean camposPreenchidos() throws CamposNaoPreenchidosException {
        if (tfNomeDisciplina.getText().isEmpty() ||
            ftfDataProva.getText().isEmpty() ||
            ftfHoraProva.getText().isEmpty() ||
            taConteudoProva.getText().isEmpty()) {
            throw new CamposNaoPreenchidosException("Todos os campos devem ser preenchidos.");
        } else {
            return true;
        }
    }

    private void AdicionarNaTabela(String nome, String data, String hora, String conteudo){
        Object[] rowData = {nome, data, hora, conteudo};
        TabelaProvas.addRow(rowData);
    }
    private void limparCampos(){
        tfNomeDisciplina.setText("");
        ftfDataProva.setText("");
        ftfHoraProva.setText("");
        taConteudoProva.setText("");
    }
    
private void salvarProva(){
        try {
            if (camposPreenchidos()) {
                AdicionarNaTabela(tfNomeDisciplina.getText(), ftfDataProva.getText(), ftfHoraProva.getText(), taConteudoProva.getText());
                JOptionPane.showMessageDialog(null, "   Prova cadastrada com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar prova");
            }
        } catch (CamposNaoPreenchidosException e) {
          JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarProva;
    private javax.swing.JFormattedTextField ftfDataProva;
    private javax.swing.JFormattedTextField ftfHoraProva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taConteudoProva;
    private javax.swing.JTable tbTabelaProvas;
    private javax.swing.JTextField tfNomeDisciplina;
    // End of variables declaration//GEN-END:variables
}
