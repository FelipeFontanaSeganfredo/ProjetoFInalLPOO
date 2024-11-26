package com.mycompany.transportadoraareia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Usuario;
import view.JMainFrame;

/**
 *
 * @author User PC
 */
public class TransportadoraAreia {

    public static void main(String[] args) {
        // Configurar a fábrica de EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        EntityManager em = emf.createEntityManager();

        // Inserir usuários no banco de dados
        try {
            em.getTransaction().begin();

            // Criação de instâncias de usuários
            Usuario root = new Usuario();
            root.setCpf(null); // Root não possui CPF
            root.setTipo("administrador");
            root.setSenha(criptografarSenha("1234"));

            Usuario motorista1 = new Usuario();
            motorista1.setCpf("632.273.280-38");
            motorista1.setTipo("motorista");
            motorista1.setSenha(criptografarSenha("1234"));

            Usuario motorista2 = new Usuario();
            motorista2.setCpf("123.456.789-00");
            motorista2.setTipo("motorista");
            motorista2.setSenha(criptografarSenha("abcd"));

            // Persistir no banco
            em.persist(root);
            em.persist(motorista1);
            em.persist(motorista2);

            em.getTransaction().commit();
            System.out.println("Usuários inseridos com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

        // Inicializar a interface gráfica
        java.awt.EventQueue.invokeLater(() -> {
            new JMainFrame().setVisible(true);
        });
    }

    /**
     * Método para criptografar uma senha usando MD5.
     */
    private static String criptografarSenha(String senha) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            java.math.BigInteger no = new java.math.BigInteger(1, messageDigest);
            return no.toString(16); // Converte para hexadecimal
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }
}
