
package view.motorista;

import dao.MotoristaDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Motorista;

public class TelaMotorista extends javax.swing.JFrame {

    public TelaMotorista() {
        initComponents();
        atualizarTabela();
    }
    
    public void atualizarTabela() {
    try {
        // Obter os motoristas do banco de dados
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        List<Motorista> motoristas = motoristaDAO.listarTodos();
        motoristaDAO.fechar();

        // Criar um modelo para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tbMotoristas.getModel();
        modeloTabela.setRowCount(0); // Limpar a tabela

        // Preencher a tabela com os dados
        for (Motorista motorista : motoristas) {
            modeloTabela.addRow(new Object[]{
                motorista.getId(),
                motorista.getNome(),
                motorista.getCnh(),
                motorista.getSalario()
            });
        }
    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + ex.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMotoristas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Motorista");

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Criar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbMotoristas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CNH", "Salário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbMotoristas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMotoristasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMotoristas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 143, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TelaNovoMotorista telaNovoMotorista = new TelaNovoMotorista(this);
        telaNovoMotorista.setVisible(true);
        atualizarTabela();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbMotoristasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMotoristasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMotoristasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try {
        // Verificar se há uma linha selecionada
        int linhaSelecionada = tbMotoristas.getSelectedRow();
        if (linhaSelecionada == -1) {
            throw new IllegalArgumentException("Selecione um motorista na tabela para excluir.");
        }

        // Obter o ID do motorista da linha selecionada
        DefaultTableModel modeloTabela = (DefaultTableModel) tbMotoristas.getModel();
        int motoristaId = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

        // Confirmar exclusão
        int confirmacao = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja excluir este motorista?",
            "Confirmar Exclusão",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == javax.swing.JOptionPane.YES_OPTION) {
            // Excluir motorista do banco de dados
            MotoristaDAO motoristaDAO = new MotoristaDAO();
            Motorista motorista = motoristaDAO.buscarPorId(motoristaId);
            if (motorista != null) {
                motoristaDAO.excluir(motorista);
            }
            motoristaDAO.fechar();

            // Atualizar tabela
            atualizarTabela();

            // Mostrar mensagem de sucesso
            javax.swing.JOptionPane.showMessageDialog(this, "Motorista excluído com sucesso!");
        }
    } catch (Exception ex) {
        // Exibir mensagem de erro
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao excluir motorista: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        // Obter a linha selecionada
        int linhaSelecionada = tbMotoristas.getSelectedRow();
        if (linhaSelecionada == -1) {
            throw new IllegalArgumentException("Selecione um motorista na tabela para editar.");
        }

        // Obter o ID do motorista selecionado
        int motoristaId = (int) tbMotoristas.getValueAt(linhaSelecionada, 0);

        // Buscar motorista no banco de dados
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        Motorista motorista = motoristaDAO.buscarPorId(motoristaId);
        motoristaDAO.fechar();

        // Abrir a tela de edição
        TelaEditarMotorista telaEditar = new TelaEditarMotorista(this, motorista);
        telaEditar.setVisible(true);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao editar motorista: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMotorista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMotoristas;
    // End of variables declaration//GEN-END:variables
}
