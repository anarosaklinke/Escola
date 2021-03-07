/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.CursoAluno;
import service.AlunoService;
import service.CursoAlunoService;
import service.CursoService;
import service.ServiceFactory;

public class ConsultarCurso extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListaClientes
     */
    public ConsultarCurso() {
        initComponents();

        exibir();
    }

    public final void exibir() {

        AlunoService entity = ServiceFactory.getAlunoService();

        List<Aluno> aluno = entity.recuperaAluno();

        Aluno a;
        Object[][] dados = new Object[aluno.size()][3];

        for (int i = 0; i < aluno.size(); i++) {

            a = aluno.get(i);
            dados[i][1] = a.getNome();
            dados[i][0] = a.getCodAluno();
            dados[i][2] = false;
        }
        tabelaAluno = new JTable() {
            private static final long serialVersionUID = 1L;

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Boolean.class : super.getColumnClass(columnIndex);
            }

        };

        tabelaAluno.setModel(new DefaultTableModel(
                dados,
                new Object[]{
                    "Código do Aluno", "Nome", "Selecione"
                }
        ));

        jScrollPane2.setViewportView(tabelaAluno);

    }

    private void cadastrar() {

        CursoAlunoService entity = ServiceFactory.getCursoAlunoService();
        CursoService entity2 = ServiceFactory.getCursoService();
        AlunoService entity3 = ServiceFactory.getAlunoService();

        CursoAluno cursoAluno;
        long idCursoAluno, idCurso, idAluno;

        idCurso = entity2.idCodCurso(codCurso.getText());

        for (int i = 0; i < tabelaAluno.getRowCount(); i++) {
            if ((Boolean) tabelaAluno.getModel().getValueAt(i, 2)) {

                idCursoAluno = entity.recuperaUltimoId();
                if (idCursoAluno == -1) {
                    idCursoAluno = 1;
                } else {
                    idCursoAluno++;
                }
                idAluno = entity3.idCodAluno((String) tabelaAluno.getModel().getValueAt(tabelaAluno.getSelectedRow(), 0));

                cursoAluno = new CursoAluno(idCursoAluno);
                cursoAluno.setIdAluno(idAluno);
                cursoAluno.setIdCurso(idCurso);

                entity.save(cursoAluno);
            }
        }
        
        JOptionPane.showMessageDialog(null, "Alunos Cadastrados");
        
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        Atualizar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        codCurso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Usuário");

        tabelaAluno.setEnabled(false);
        tabelaAluno.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tabelaAluno);

        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar.setForeground(new java.awt.Color(0, 0, 204));
        Atualizar.setText("Cadastrar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Selecione Alunos para o Curso:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("<< Selecione Para Cadastrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_AtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    public javax.swing.JLabel codCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JTable tabelaAluno;
    // End of variables declaration//GEN-END:variables

}