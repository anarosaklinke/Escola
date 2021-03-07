/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import model.Curso;
import service.CursoService;
import service.ServiceFactory;

/**
 *
 * @author PICHAU
 */
public class ListaCurso extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListaClientes
     */
    public ListaCurso() {
        initComponents();

        exibir();
    }

    public final void exibir() {
        CursoService entity = ServiceFactory.getCursoService();

        List<Curso> curso = entity.recuperaCurso();

        Curso c;
        String[][] dados = new String[curso.size()][3];

        for (int i = 0; i < curso.size(); i++) {

            c = curso.get(i);
            dados[i][1] = c.getDescricao();
            dados[i][2] = c.getEmenta();
            dados[i][0] = c.getCodCurso();
                    }
        tabelaCurso = new javax.swing.JTable();

        tabelaCurso.setModel(new javax.swing.table.DefaultTableModel(
                dados,
                new String[]{
                    "Código do Curso", "Descrição", "Ementa"
                }
        ));

        jScrollPane2.setViewportView(tabelaCurso);

    }




    private void cadastrar() {

        CadastrarCurso cad = new CadastrarCurso();
        getParent().add(cad);
        cad.setVisible(true);
    }

    private void alteraCurso() {
        if (tabelaCurso.getSelectedRow() != -1) {
            AlteraCurso alterar = new AlteraCurso();
            
            alterar.codCursoOld.setText((String) tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 0));
            alterar.codCurso.setText((String) tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 0));
            alterar.descricao.setText((String) tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 1));
            alterar.ementa.setText((String) tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 2));

            getParent().add(alterar);
            alterar.setVisible(true);
        }
    }

    private void excluirUsuario() {
        if (tabelaCurso.getSelectedRow() != -1) {
            ExcluirCurso exclui = new ExcluirCurso();
            exclui.codCurso.setText((String) tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 0));
            getParent().add(exclui);
            exclui.setVisible(true);
        }
    }
    
    private void selecionar() {
        if (tabelaCurso.getSelectedRow() != -1) {
            SelecionarAlunos selecionar = new SelecionarAlunos();
            
            selecionar.codCurso.setText((String) tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 0));

            getParent().add(selecionar);
            selecionar.setVisible(true);
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
        tabelaCurso = new javax.swing.JTable();
        Atualizar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        atualizar = new java.awt.Button();
        usuario = new javax.swing.JButton();
        Atualizar1 = new javax.swing.JButton();
        Atualizar2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Usuário");

        Excluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Excluir.setForeground(new java.awt.Color(204, 0, 51));
        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        tabelaCurso.setEnabled(false);
        tabelaCurso.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tabelaCurso);

        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar.setForeground(new java.awt.Color(0, 0, 204));
        Atualizar.setText("Atualizar Curso");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Lista de Cursos:");

        atualizar.setLabel("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(0, 0, 204));
        usuario.setText("Cadastrar Curso");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        Atualizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar1.setForeground(new java.awt.Color(0, 0, 204));
        Atualizar1.setText("Verificar Ementa");
        Atualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atualizar1ActionPerformed(evt);
            }
        });

        Atualizar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar2.setForeground(new java.awt.Color(0, 0, 204));
        Atualizar2.setText("Cadastro de Alunos");
        Atualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atualizar2ActionPerformed(evt);
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
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Atualizar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Atualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        excluirUsuario();
    }//GEN-LAST:event_ExcluirActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        // TODO add your handling code here:
        alteraCurso();
    }//GEN-LAST:event_AtualizarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        // TODO add your handling code here:
        exibir();
    }//GEN-LAST:event_atualizarActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_usuarioActionPerformed

    private void Atualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Atualizar1ActionPerformed

    private void Atualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atualizar2ActionPerformed
        // TODO add your handling code here:
        selecionar();
    }//GEN-LAST:event_Atualizar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton Atualizar1;
    private javax.swing.JButton Atualizar2;
    private javax.swing.JButton Excluir;
    private java.awt.Button atualizar;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JTable tabelaCurso;
    private javax.swing.JButton usuario;
    // End of variables declaration//GEN-END:variables

}