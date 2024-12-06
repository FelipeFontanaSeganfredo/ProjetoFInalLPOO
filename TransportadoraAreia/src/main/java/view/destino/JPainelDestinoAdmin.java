/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.destino;

import dao.DestinoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Destino;

/**
 *
 * @author User PC
 */
public class JPainelDestinoAdmin extends javax.swing.JFrame {

    /**
     * Creates new form JPainelDestinoAdmin
     */
    public JPainelDestinoAdmin() {
        initComponents();
        atualizarTabela();
        configurarListeners(); // Configura os listeners no iníci
        setLocationRelativeTo(null);
    }
    
    private void configurarListeners() {
    // Listener para o ComboBox de filtros
    jComboBox1.addActionListener(evt -> {
        String criterio = (String) jComboBox1.getSelectedItem();
        filtrarTabela(criterio); // Aplica o filtro com base no critério selecionado
    });
}
    
    private void atualizarTabela() {
        try {
        DestinoDAO destinoDAO = new DestinoDAO();
        List<Destino> destinos = destinoDAO.listarTodos();
        atualizarTabelaComDados(destinos); // Reutiliza o método auxiliar
        destinoDAO.fechar();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    private void atualizarTabelaComDados(List<Destino> destinos) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Limpa a tabela antes de preencher

    for (Destino destino : destinos) {
        model.addRow(new Object[]{destino.getId(), destino.getNome(), destino.getDistancia()});
        }
    }

    
    
    private void filtrarTabela(String criterio) {
    try {
        // Inicializa o DAO
        DestinoDAO destinoDAO = new DestinoDAO();
        List<Destino> destinos;

        // Verifica o critério do combo box e filtra os registros
        switch (criterio) {
            case "Ordem Alfabética":
                destinos = destinoDAO.listarPorOrdemAlfabetica();
                break;
            case "Distância":
                destinos = destinoDAO.listarPorDistancia();
                break;
            default:
                destinos = destinoDAO.listarTodos();
                break;
        }

        // Atualiza a tabela com os resultados
        atualizarTabelaComDados(destinos);

        // Fecha o DAO
        destinoDAO.fechar();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao aplicar o filtro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BotaoEditar = new javax.swing.JButton();
        BotaoNovo = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Destinos");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Distância (km)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BotaoEditar.setText("Editar");
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        BotaoNovo.setText("Novo");
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Ordem Alfabética", "Distância" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ordenar por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                        .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(702, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotaoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(BotaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(477, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 129, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(92, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(475, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String criterio = (String) jComboBox1.getSelectedItem();
        if (criterio != null && !criterio.trim().isEmpty()) {
            filtrarTabela(criterio);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        JPainelDestinoAdminNovo NovaTela = new JPainelDestinoAdminNovo();
        
              // Adiciona um evento para atualizar a tabela quando a tela de edição for fechada
              NovaTela.addWindowListener(new java.awt.event.WindowAdapter() {
              @Override
              public void windowClosed(java.awt.event.WindowEvent e) {
              atualizarTabela(); // Atualiza a tabela ao fechar a tela de edição
           }
        });
        NovaTela.setVisible(true);
        
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            // Obtém o ID da linha selecionada
            Object valorId = jTable1.getValueAt(linhaSelecionada, 0);

            if (valorId instanceof Number) {
                Long id = ((Number) valorId).longValue();

                DestinoDAO service = new DestinoDAO();
                Destino destino = service.buscarPorId(id); // Busca o desino pelo ID

                if (destino != null) {
                    service.excluir(destino); // Exclui o destino do banco
                    javax.swing.JOptionPane.showMessageDialog(this, "Destino excluído com sucesso!");
                    atualizarTabela(); // Atualiza os dados exibidos na tabela
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Destino não encontrado.");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "ID inválido.");
            }
            } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um destino para excluir.");
    }                                         
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            // Obtém o ID da linha selecionada
            Object valorId = jTable1.getValueAt(linhaSelecionada, 0);

            if (valorId instanceof Integer) {
                Integer id = (Integer) valorId;

                // Abre a tela de edição, passando o ID selecionado
                JPainelDestinoAdminEditar telaEditar = new JPainelDestinoAdminEditar(id);

                // Adiciona um evento para atualizar a tabela quando a tela de edição for fechada
                telaEditar.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        atualizarTabela(); // Atualiza a tabela ao fechar a tela de edição
                    }
                });

                telaEditar.setVisible(true);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "ID inválido.");
            }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Selecione um destino para editar.");
        }
    }//GEN-LAST:event_BotaoEditarActionPerformed

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
            java.util.logging.Logger.getLogger(JPainelDestinoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPainelDestinoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPainelDestinoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPainelDestinoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPainelDestinoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}