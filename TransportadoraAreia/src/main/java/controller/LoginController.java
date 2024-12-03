package controller;

import config.SessaoUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginController {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");

    /**
 * Método para autenticar usuário (CPF e senha) e salvar dados de login na sessão.
 */
public boolean autenticar(String cpf, String senha) {
    EntityManager em = emf.createEntityManager();
    try {
        Object[] resultado = null;

        // Verifica se o CPF pertence a um administrador
        try {
            resultado = (Object[]) em.createQuery(
                    "SELECT a.id, 'admin', a.nome, a.cpf, a.senha FROM Administrador a WHERE a.cpf = :cpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Ignora o erro e continua verificando na tabela Motorista
        }

        // Se não foi encontrado em Admin, verifica na tabela Motorista
        if (resultado == null) {
            try {
                resultado = (Object[]) em.createQuery(
                        "SELECT m.id, 'motorista', m.nome, m.cpf, m.senha FROM Motorista m WHERE m.cpf = :cpf")
                        .setParameter("cpf", cpf)
                        .getSingleResult();
            } catch (NoResultException e) {
                // Nenhum usuário encontrado
                return false;
            }
        }

        // Extraindo os dados do resultado
        int idUsuario = (int) resultado[0];
        String tipoUsuario = (String) resultado[1];
        String nomeUsuario = (String) resultado[2];
        String cpfUsuario = (String) resultado[3];
        String senhaHash = (String) resultado[4];

        // Verifica se a senha informada corresponde à senha armazenada
        if (criptografarSenha(senha).equals(senhaHash)) {
            // Atualiza a sessão com os dados do usuário
            SessaoUsuario sessao = SessaoUsuario.getInstance();
            sessao.setIdUsuario(idUsuario); // Atualiza o ID do usuário
            sessao.setTipoUsuario(tipoUsuario); // Atualiza o tipo (motorista ou administrador)
            sessao.setNome(nomeUsuario); // Atualiza o nome do usuário
            sessao.setCpf(cpfUsuario); // Atualiza o CPF do usuário
            return true;
        } else {
            // Senha incorreta
            return false;
        }
    } finally {
        em.close();
    }
}


    /**
     * Método para criptografar uma senha usando MD5.
     */
    public String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            return no.toString(16); // Converte para hexadecimal
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }

    /**
     * Método para verificar se o usuário é administrador.
     */
    public boolean isAdmin(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            // Verifica se o CPF pertence a um administrador
            long count = em.createQuery(
                    "SELECT COUNT(a) FROM Administrador a WHERE a.cpf = :cpf", Long.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();

            return count > 0;
        } finally {
            em.close();
        }
    }
}
