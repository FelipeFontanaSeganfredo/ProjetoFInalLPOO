package com.mycompany.transportadoraareia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import model.Administrador;
import model.Motorista;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import view.JMainFrame;

/**
 * Classe principal para inicializar o sistema da transportadora.
 */
public class TransportadoraAreia {

    public static void main(String[] args) {
        // Configurar a fábrica de EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Inserir administrador e motorista se não existirem
            inserirAdministradorSeNaoExistir(em, 
                "000.000.000-00", "Cássio Cismoski", "admin@empresa.com", "1234"); // Administrador
            inserirMotoristaSeNaoExistir(em, 
                "111.111.111-11", "João da Silva", "joao@transportes.com", "987654321", "1234"); // Motorista 1

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
     * Método para inserir um administrador se ele não existir no banco de dados.
     */
    private static void inserirAdministradorSeNaoExistir(EntityManager em, String cpf, String nome, String email, String senha) {
        try {
            // Verificar se o administrador já existe
            Administrador adminExistente = em.createQuery(
                    "SELECT a FROM Administrador a WHERE a.cpf = :cpf", Administrador.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();

            System.out.println("Administrador já existe: " + cpf);
        } catch (NoResultException e) {
            // Administrador não existe, criar e persistir
            Administrador novoAdmin = new Administrador();
            novoAdmin.setCpf(cpf);
            novoAdmin.setNome(nome);
            novoAdmin.setEmail(email);
            novoAdmin.setSenha(criptografarSenha(senha));
            em.persist(novoAdmin);
            System.out.println("Administrador inserido: " + cpf);
        }
    }

    /**
     * Método para inserir um motorista se ele não existir no banco de dados.
     */
    private static void inserirMotoristaSeNaoExistir(EntityManager em, String cpf, String nome, String email, String telefone, String senha) {
        try {
            // Verificar se o motorista já existe
            Motorista motoristaExistente = em.createQuery(
                    "SELECT m FROM Motorista m WHERE m.cpf = :cpf", Motorista.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();

            System.out.println("Motorista já existe: " + cpf);
        } catch (NoResultException e) {
            // Motorista não existe, criar e persistir
            Motorista novoMotorista = new Motorista();
            novoMotorista.setCpf(cpf);
            novoMotorista.setNome(nome);
            novoMotorista.setEmail(email);
            novoMotorista.setTelefone(telefone);
            novoMotorista.setSenha(criptografarSenha(senha));
            em.persist(novoMotorista);
            System.out.println("Motorista inserido: " + cpf);
        }
    }

    /**
     * Método para criptografar uma senha usando MD5.
     */
    private static String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            return no.toString(16); // Converte para hexadecimal
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }
}
