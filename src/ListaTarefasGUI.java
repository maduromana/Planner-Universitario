

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

class Tarefa {

    private String nome;
    private boolean concluida;

    public Tarefa(String nome) {
        this.nome = nome;
        this.concluida = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean estaConcluida() {
        return concluida;
    }

    public void marcarComoConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}

public class ListaTarefasGUI extends javax.swing.JPanel {

    private final ArrayList<Tarefa> listaDeTarefas = new ArrayList<>();

    public ListaTarefasGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();
        campoTarefa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTarefas = new javax.swing.JList<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Lista de Tarefas ");

        btnAdicionar.setText("Adicionar Tarefa");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnConcluir.setText("Concluir Tarefa");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        campoTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTarefaActionPerformed(evt);
            }
        });

        listaTarefas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {" "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaTarefas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoTarefa)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
         String nomeTarefa = campoTarefa.getText();
        if (!nomeTarefa.isEmpty()) {
            Tarefa novaTarefa = new Tarefa(nomeTarefa);
            listaDeTarefas.add(novaTarefa);
            atualizarListaDeTarefas();
            campoTarefa.setText("");
            JOptionPane.showMessageDialog(this, "Tarefa adicionada à lista.");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void campoTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTarefaActionPerformed

    }//GEN-LAST:event_campoTarefaActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        int indiceSelecionado = listaTarefas.getSelectedIndex();
        if (indiceSelecionado >= 0 && indiceSelecionado < listaDeTarefas.size()) {
            Tarefa tarefaSelecionada = listaDeTarefas.get(indiceSelecionado);
            tarefaSelecionada.marcarComoConcluida(true);
            atualizarListaDeTarefas();
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

 private void atualizarListaDeTarefas() {
    DefaultListModel<String> model = new DefaultListModel<>();

    for (Tarefa tarefa : listaDeTarefas) {
        String status = tarefa.estaConcluida() ? "[x]" : "[ ]";
        model.addElement(status + " " + tarefa.getNome());
    }

    listaTarefas.setModel(model); // Substitui o modelo da lista pelo novo modelo
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JTextField campoTarefa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaTarefas;
    // End of variables declaration//GEN-END:variables


}
