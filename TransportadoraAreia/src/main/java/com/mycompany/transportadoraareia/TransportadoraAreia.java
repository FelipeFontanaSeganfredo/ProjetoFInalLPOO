package com.mycompany.transportadoraareia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
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

        try {
            em.getTransaction().begin();

            // Inserir usuários se não existirem
            inserirUsuarioSeNaoExistir(em, null, "administrador", "1234"); // Root
            inserirUsuarioSeNaoExistir(em, "632.273.280-38", "motorista", "1234"); // Motorista 1
            inserirUsuarioSeNaoExistir(em, "123.456.789-00", "motorista", "abcd"); // Motorista 2

            em.getTransaction().commit();
            System.out.println("Verificação e inserção de usuários concluída!");
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
     * Método para inserir um usuário se ele não existir no banco de dados.
     */
    private static void inserirUsuarioSeNaoExistir(EntityManager em, String cpf, String tipo, String senha) {
        try {
            // Verificar se o usuário já existe
            Usuario usuarioExistente = em.createQuery(
                    "SELECT u FROM Usuario u WHERE (:cpf IS NULL AND u.cpf IS NULL) OR u.cpf = :cpf", Usuario.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();

            System.out.println("Usuário já existe: " + (cpf == null ? "root" : cpf));
        } catch (NoResultException e) {
            // Usuário não existe, criar e persistir
            Usuario novoUsuario = new Usuario();
            novoUsuario.setCpf(cpf);
            novoUsuario.setTipo(tipo);
            novoUsuario.setSenha(criptografarSenha(senha));
            em.persist(novoUsuario);
            System.out.println("Usuário inserido: " + (cpf == null ? "root" : cpf));
        }
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
