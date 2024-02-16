
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class DetalheDisciplinaGUI extends javax.swing.JPanel {
     private Disciplina disciplina;
 
    public DetalheDisciplinaGUI(Disciplina disciplina) {
        this.disciplina = disciplina;
        initComponents();
        exibirDetalhes();
        configurarOuvintes();
        
    }

    private void configurarOuvintes() {
        jCheckBox1.addItemListener((ItemEvent e) -> {
            if (jCheckBox1.isSelected()) {
                jCheckBox2.setSelected(false);
                ComboBoxDias1.setEnabled(true);
                ComboBoxDias2.setEnabled(false);
                limparCamposHorario();
                limparCamposSala();
            } else {
                ComboBoxDias1.setEnabled(false);
                limparCamposHorario();
                limparCamposSala();
            }
        });

        jCheckBox2.addItemListener((ItemEvent e) -> {
            if (jCheckBox2.isSelected()) {
                jCheckBox1.setSelected(false);
                ComboBoxDias1.setEnabled(true);
                ComboBoxDias2.setEnabled(true);
                limparCamposHorario();
                limparCamposSala();
            } else {
                ComboBoxDias2.setEnabled(false);
                limparCamposHorario();
                limparCamposSala();
            }
        });

        ComboBoxDias1.addActionListener((java.awt.event.ActionEvent evt) -> {
            exibirCamposDia(ComboBoxDias1, rotuloHorario1, campoHorario1, rotuloSala1, campoSala1);
        });

        ComboBoxDias2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirCamposDia(ComboBoxDias2, rotuloHorario2, campoHorario2, rotuloSala2, campoSala2);
            }
        });

        // Desabilitar ComboBoxes e campos inicialmente
        ComboBoxDias1.setEnabled(false);
        ComboBoxDias2.setEnabled(false);
        rotuloHorario1.setVisible(false);
        campoHorario1.setVisible(false);
        rotuloSala1.setVisible(false);
        campoSala1.setVisible(false);
        rotuloHorario2.setVisible(false);
        campoHorario2.setVisible(false);
        rotuloSala2.setVisible(false);
        campoSala2.setVisible(false);
        areaResumo.setVisible(false);
    }

    private void exibirDetalhes() {
        jLabel2.setText("Detalhe da disciplina:  " + (disciplina != null ? disciplina.getNome() : ""));
    }

    private void exibirCamposDia(
            javax.swing.JComboBox<String> comboBoxDias,
            javax.swing.JLabel rotuloHorario,
            javax.swing.JTextField campoHorario,
            javax.swing.JLabel rotuloSala,
            javax.swing.JTextField campoSala) {

        String diaSelecionado = (String) comboBoxDias.getSelectedItem();
        if (diaSelecionado != null && !diaSelecionado.isEmpty()) {
            rotuloHorario.setText("Horário de início da aula de " + diaSelecionado + ":");
            rotuloHorario.setVisible(true);
            campoHorario.setVisible(true);

            rotuloSala.setText("Sala:");
            rotuloSala.setVisible(true);
            campoSala.setVisible(true);
        } else {
            rotuloHorario.setVisible(false);
            campoHorario.setVisible(false);

            rotuloSala.setVisible(false);
            campoSala.setVisible(false);
        }
    }

    private void limparCamposHorario() {
        rotuloHorario1.setVisible(false);
        campoHorario1.setVisible(false);
        rotuloSala1.setVisible(false);
        campoSala1.setVisible(false);
        rotuloHorario2.setVisible(false);
        campoHorario2.setVisible(false);
        rotuloSala2.setVisible(false);
        campoSala2.setVisible(false);
    }

    private void limparCamposSala() {
        rotuloSala1.setVisible(false);
        campoSala1.setVisible(false);
        rotuloSala2.setVisible(false);
        campoSala2.setVisible(false);
    }
              
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        rotuloNomeProfessor = new javax.swing.JLabel();
        campoNomeProfessor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        ComboBoxDias1 = new javax.swing.JComboBox<>();
        ComboBoxDias2 = new javax.swing.JComboBox<>();
        rotuloHorario1 = new javax.swing.JLabel();
        rotuloHorario2 = new javax.swing.JLabel();
        rotuloSala1 = new javax.swing.JLabel();
        campoSala1 = new javax.swing.JTextField();
        rotuloSala2 = new javax.swing.JLabel();
        campoSala2 = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaResumo = new javax.swing.JTextArea();
        campoHorario1 = new javax.swing.JFormattedTextField();
        campoHorario2 = new javax.swing.JFormattedTextField();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        rotuloNomeProfessor.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rotuloNomeProfessor.setText("Nome professor(a): ");

        campoNomeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeProfessorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Aulas:");

        jCheckBox1.setText("Uma vez por semana ");

        jCheckBox2.setText("Duas vezes por semana ");

        ComboBoxDias1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira" , "Sexta-Feira"}));
        ComboBoxDias1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxDias1ActionPerformed(evt);
            }
        });

        ComboBoxDias2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira" , "Sexta-Feira"}));
        ComboBoxDias2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxDias2ActionPerformed(evt);
            }
        });

        rotuloHorario1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rotuloHorario1.setText("Horário de início da aula:");

        rotuloHorario2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rotuloHorario2.setText("Horário de início da aula:");

        rotuloSala1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rotuloSala1.setText("Sala:");

        rotuloSala2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rotuloSala2.setText("Sala:");

        campoSala2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSala2ActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        areaResumo.setEditable(false);
        areaResumo.setColumns(20);
        areaResumo.setRows(5);
        jScrollPane2.setViewportView(areaResumo);

        try {
            campoHorario1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoHorario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHorario1ActionPerformed(evt);
            }
        });

        try {
            campoHorario2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoHorario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHorario2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox1)
                                            .addComponent(ComboBoxDias1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboBoxDias2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCheckBox2)))
                                    .addComponent(rotuloHorario2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rotuloHorario1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rotuloSala2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(rotuloSala1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoSala1)
                                    .addComponent(campoSala2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rotuloNomeProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoNomeProfessor))
                            .addComponent(jScrollPane2))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloNomeProfessor)
                    .addComponent(campoNomeProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxDias2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxDias1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rotuloHorario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloSala1)
                    .addComponent(campoSala1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rotuloHorario2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSala2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloSala2)
                    .addComponent(campoHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxDias1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDias1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDias1ActionPerformed

    private void ComboBoxDias2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDias2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDias2ActionPerformed

    private void campoSala2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSala2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSala2ActionPerformed

    private void campoNomeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeProfessorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
     try{
            validarCampos();
            areaResumo.setVisible(true);
            StringBuilder resumo = new StringBuilder();
            resumo.append("Nome professor(a):").append(campoNomeProfessor.getText()).append("\n");
            
            if (jCheckBox1.isSelected() || jCheckBox2.isSelected()) {
            resumo.append("Aulas:\n");

            if (jCheckBox1.isSelected()) {
                resumo.append("- Uma vez por semana\n");
                resumo.append("  - Dia: ").append(ComboBoxDias1.getSelectedItem()).append("\n");
                resumo.append("  - Horário: ").append(campoHorario1.getText()).append("\n");
                resumo.append("  - Sala: ").append(campoSala1.getText()).append("\n");
            }

            if (jCheckBox2.isSelected()) {
                resumo.append("- Duas vezes por semana\n");
                resumo.append("  - Dia 1: ").append(ComboBoxDias1.getSelectedItem()).append("\n");
                resumo.append("  - Horário 1: ").append(campoHorario1.getText()).append("\n");
                resumo.append("  - Sala 1: ").append(campoSala1.getText()).append("\n");
                resumo.append("  - Dia 2: ").append(ComboBoxDias2.getSelectedItem()).append("\n");
                resumo.append("  - Horário 2: ").append(campoHorario2.getText()).append("\n");
                resumo.append("  - Sala 2: ").append(campoSala2.getText()).append("\n");
            }
        }
        areaResumo.setText(resumo.toString()) ;
            
        }catch (CamposNaoPreenchidosException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void campoHorario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHorario1ActionPerformed
        if (!horaValida(campoHorario1.getText())) {
            JOptionPane.showMessageDialog(this, "Formato de hora inválido. Use o formato HH:mm.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoHorario1.setValue(null); // Limpar o campo
        }
    }//GEN-LAST:event_campoHorario1ActionPerformed

    private void campoHorario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHorario2ActionPerformed
      if (!horaValida(campoHorario2.getText())) {
            JOptionPane.showMessageDialog(this, "Formato de hora inválido. Use o formato HH:mm.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoHorario2.setValue(null); // Limpar o campo
        } 
    }//GEN-LAST:event_campoHorario2ActionPerformed

private boolean horaValida(String hora) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false); 
            sdf.parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

private void validarCamposAula(javax.swing.JComboBox<String> comboBoxDias, javax.swing.JFormattedTextField campoHorario,javax.swing.JTextField campoSala) throws CamposNaoPreenchidosException {
        String diaSelecionado = (String) comboBoxDias.getSelectedItem();
        String horario = campoHorario.getText().trim();
        String sala = campoSala.getText().trim();

        if (diaSelecionado.isEmpty() || horario.isEmpty() || sala.isEmpty()) {
            throw new CamposNaoPreenchidosException("Preencha todos os campos para a aula.");
        }

        if (!horaValida(horario)) {
            throw new CamposNaoPreenchidosException("Formato de hora inválido. Use o formato HH:mm.");
        }
    }

public class CamposNaoPreenchidosException extends Exception {
        public CamposNaoPreenchidosException(String message) {
            super(message);
        }
    }
    
private void validarCampos() throws CamposNaoPreenchidosException {
        if (campoNomeProfessor.getText().trim().isEmpty()) {
            throw new CamposNaoPreenchidosException("Por favor, preencha o campo 'Nome professor(a)'.");
        }

        if (!(jCheckBox1.isSelected() || jCheckBox2.isSelected())) {
            throw new CamposNaoPreenchidosException("Selecione pelo menos uma opção de aula .");
        }

        if (jCheckBox1.isSelected()) {
            validarCamposAula(ComboBoxDias1, campoHorario1, campoSala1);
        }

        if (jCheckBox2.isSelected()) {
            validarCamposAula(ComboBoxDias1, campoHorario1, campoSala1);
            validarCamposAula(ComboBoxDias2, campoHorario2, campoSala2);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDias1;
    private javax.swing.JComboBox<String> ComboBoxDias2;
    private javax.swing.JTextArea areaResumo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField campoHorario1;
    private javax.swing.JFormattedTextField campoHorario2;
    private javax.swing.JTextField campoNomeProfessor;
    private javax.swing.JTextField campoSala1;
    private javax.swing.JTextField campoSala2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel rotuloHorario1;
    private javax.swing.JLabel rotuloHorario2;
    private javax.swing.JLabel rotuloNomeProfessor;
    private javax.swing.JLabel rotuloSala1;
    private javax.swing.JLabel rotuloSala2;
    // End of variables declaration//GEN-END:variables
}
