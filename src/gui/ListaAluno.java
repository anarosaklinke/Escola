/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.CursoAluno;
import service.AlunoService;
import service.CursoAlunoService;
import service.ServiceFactory;

public class ListaAluno extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListaClientes
     */
    public ListaAluno() {
        initComponents();

        exibir();
    }

    public final void exibir() {
        AlunoService entity = ServiceFactory.getAlunoService();

        List<Aluno> aluno = entity.recuperaAluno();

        Aluno a;
        String[][] dados = new String[aluno.size()][2];

        for (int i = 0; i < aluno.size(); i++) {

            a = aluno.get(i);
            dados[i][1] = a.getNome();
            dados[i][0] = a.getCodAluno();
        }
        tabelaAluno = new javax.swing.JTable();

        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
                dados,
                new String[]{
                    "Código do Aluno", "Nome"
                }
        ));

        jScrollPane2.setViewportView(tabelaAluno);

    }

    private void cadastrar() {

        CadastrarAluno cad = new CadastrarAluno();
        getParent().add(cad);
        cad.setVisible(true);
    }

    private void alteraAluno() {
        if (tabelaAluno.getSelectedRow() != -1) {
            AlteraAluno alterar = new AlteraAluno();

            alterar.codAlunoOld.setText((String) tabelaAluno.getModel().getValueAt(tabelaAluno.getSelectedRow(), 0));
            alterar.codAluno.setText((String) tabelaAluno.getModel().getValueAt(tabelaAluno.getSelectedRow(), 0));
            alterar.nome.setText((String) tabelaAluno.getModel().getValueAt(tabelaAluno.getSelectedRow(), 1));

            getParent().add(alterar);
            alterar.setVisible(true);
        }
    }

    private void excluirUsuario() {

        CursoAlunoService entity = ServiceFactory.getCursoAlunoService();
        AlunoService entity2 = ServiceFactory.getAlunoService();

        String codAluno = (String) tabelaAluno.getModel().getValueAt(tabelaAluno.getSelectedRow(), 0);

        long idCurso = entity2.idCodAluno(codAluno);

        List<CursoAluno> aluno = entity.recuperaAluno(idCurso);

        if (aluno.isEmpty()) {

            if (tabelaAluno.getSelectedRow() != -1) {
                ExcluirAluno exclui = new ExcluirAluno();
                exclui.codAluno.setText(codAluno);
                getParent().add(exclui);
                exclui.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aluno Cadastrado em Cursos - Não Pode Ser Excluido");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        Atualizar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        atualizar = new java.awt.Button();
        usuario = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Alunos");

        Excluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Excluir.setForeground(new java.awt.Color(204, 0, 51));
        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        tabelaAluno.setEnabled(false);
        tabelaAluno.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tabelaAluno);

        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar.setForeground(new java.awt.Color(0, 0, 204));
        Atualizar.setText("Atualizar Aluno");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Lista de Aluno:");

        atualizar.setLabel("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(0, 0, 204));
        usuario.setText("Cadastrar Aluno");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Atualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(325, 325, 325))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        excluirUsuario();
    }//GEN-LAST:event_ExcluirActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        // TODO add your handling code here:
        alteraAluno();
    }//GEN-LAST:event_AtualizarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        // TODO add your handling code here:
        exibir();
    }//GEN-LAST:event_atualizarActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_usuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton Excluir;
    private java.awt.Button atualizar;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JTable tabelaAluno;
    private javax.swing.JButton usuario;
    // End of variables declaration//GEN-END:variables

}
