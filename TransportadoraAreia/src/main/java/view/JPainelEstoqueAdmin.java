/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.List;
import model.Estoque;
import service.EstoqueService;

/**
 *
 * @author 20231PF.CC0010
 */
public class JPainelEstoqueAdmin extends javax.swing.JFrame {

    /**
     * Creates new form JPainelEstoqueAdmin
     */
    public JPainelEstoqueAdmin() {
        initComponents();
        atualizarTabela();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void atualizarTabela() {
    EstoqueService service = new EstoqueService();
    List<Estoque> estoque = service.listarTodos();

    String[] colunas = {"ID", "Nome", "Volume em estoque (m3)"};
    Object[][] dados = new Object[estoque.size()][3];

    for (int i = 0; i < estoque.size(); i++) {
        Estoque estoques = estoque.get(i);
        dados[i][0] = estoques.getId();
        dados[i][1] = estoques.getNome(); // Supondo que `Pessoa` tem `getNome()`
        dados[i][2] = estoques.getVolume();
    }
    jTable1.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estoque");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        BotaoEditar.setText("Editar");
        BotaoEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoEditarMouseClicked(evt);
            }
        });

        BotaoNovo.setText("Novo");
        BotaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoNovoMouseClicked(evt);
            }
        });
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoExcluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoEditar)
                    .addComponent(BotaoNovo)
                    .addComponent(BotaoExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(550, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseClicked
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            // Obtém o ID da linha selecionada
            Object valorId = jTable1.getValueAt(linhaSelecionada, 0);

            if (valorId instanceof Integer) {
                Integer id = (Integer) valorId;

                // Abre a tela de edição, passando o ID selecionado
                JPainelEstoqueAdminEditar telaEditar = new JPainelEstoqueAdminEditar(id);

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
                javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
        }
    }//GEN-LAST:event_BotaoEditarMouseClicked

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoNovoMouseClicked
        JPainelEstoqueAdminNovo telaNovo = new JPainelEstoqueAdminNovo();

        // Adiciona um evento para atualizar a tabela ao fechar a janela de adição
        telaNovo.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                atualizarTabela(); // Atualiza a tabela ao fechar a tela de adição
            }
        });

        telaNovo.setVisible(true);
    }//GEN-LAST:event_BotaoNovoMouseClicked

    private void BotaoExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirMouseClicked
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            // Obtém o ID da linha selecionada
            Object valorId = jTable1.getValueAt(linhaSelecionada, 0);

            if (valorId instanceof Number) {
                Long id = ((Number) valorId).longValue();

                EstoqueService service = new EstoqueService();
                Estoque item = service.buscarPorId(id); // Busca o cliente pelo ID

                if (item != null) {
                    service.excluir(item); // Exclui o cliente do banco
                    javax.swing.JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
                    atualizarTabela(); // Atualiza os dados exibidos na tabela
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Item não encontrado.");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "ID inválido.");
            }
            } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um item para excluir.");
    }//GEN-LAST:event_BotaoExcluirMouseClicked
}
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
            java.util.logging.Logger.getLogger(JPainelEstoqueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPainelEstoqueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPainelEstoqueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPainelEstoqueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPainelEstoqueAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}