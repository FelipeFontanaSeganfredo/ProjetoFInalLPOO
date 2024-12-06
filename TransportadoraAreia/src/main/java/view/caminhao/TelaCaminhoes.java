/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.caminhao;

import view.caminhao.TelaEditarCaminhao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Caminhao;

/**
 *
 * @author User
 */
public class TelaCaminhoes extends javax.swing.JFrame {

    /**
     * Creates new form TelaCaminhoes
     */
    public TelaCaminhoes() {
        initComponents();
        carregarCaminhoes();  // Carrega os caminhões do banco de dados na tabela        
    }
    
    private void carregarCaminhoes() {
    // Criar um EntityManager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
    EntityManager em = emf.createEntityManager();

    try {
        // Consulta para pegar todos os caminhões cadastrados no banco
        List<Caminhao> caminhoes = em.createQuery("SELECT c FROM Caminhao c", Caminhao.class).getResultList();

        // Obter o modelo da tabela
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Limpar as linhas anteriores
        model.setRowCount(0);

        // Adicionar os caminhões ao modelo da tabela
        for (Caminhao caminhao : caminhoes) {
            model.addRow(new Object[]{
                caminhao.getId(),
                caminhao.getMotorista() != null ? caminhao.getMotorista().getNome() : "NULL",  // Exibe "NULL" se não houver motorista
                caminhao.getCarga() != null ? caminhao.getCarga() : "NULL"  // Exibe "NULL" se não houver carga
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar caminhões: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
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
        btnNovo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Caminhões");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Motorista", "Carga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2)))
                .addGap(39, 39, 39)
                .addComponent(btnExcluir)
                .addContainerGap(59, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(jButton2)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
         // Criar um novo EntityManager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
    EntityManager em = emf.createEntityManager();

    try {
        // Criar um novo caminhão
        Caminhao novoCaminhao = new Caminhao();
        novoCaminhao.setCarga(null);
        novoCaminhao.setMotorista(null);

        // Persistir o caminhão no banco de dados
        em.getTransaction().begin();
        em.persist(novoCaminhao);
        em.getTransaction().commit();

        // Adicionar o novo caminhão à tabela
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{novoCaminhao.getId(), "NULL", "NULL"});

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Caminhão novo criado!");
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        JOptionPane.showMessageDialog(this, "Erro ao criar novo caminhão: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Verificar se uma linha foi selecionada
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um caminhão para excluir.");
        return;
    }

    // Obter o ID do caminhão da linha selecionada
    int caminhaoId = (int) jTable1.getValueAt(selectedRow, 0);

    // Criar um EntityManager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
    EntityManager em = emf.createEntityManager();

    try {
        // Iniciar a transação
        em.getTransaction().begin();

        // Buscar o caminhão pelo ID
        Caminhao caminhao = em.find(Caminhao.class, caminhaoId);

        if (caminhao != null) {
            // Excluir o caminhão do banco de dados
            em.remove(caminhao);
            em.getTransaction().commit();

            // Remover a linha da tabela
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Caminhão excluído com sucesso.");
        } else {
            // Caso o caminhão não seja encontrado
            JOptionPane.showMessageDialog(this, "Caminhão não encontrado.");
        }
    } catch (Exception e) {
        // Em caso de erro, realizar rollback da transação
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        JOptionPane.showMessageDialog(this, "Erro ao excluir caminhão: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         TelaEditarCaminhao telaEditarCaminhao = new TelaEditarCaminhao();
         telaEditarCaminhao.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCaminhoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCaminhoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCaminhoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCaminhoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCaminhoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}