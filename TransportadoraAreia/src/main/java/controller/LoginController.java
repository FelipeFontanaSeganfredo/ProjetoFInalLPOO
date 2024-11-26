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
     * Método para autenticar usuário (CPF ou "root") e senha.
     */
    public boolean autenticar(String login, String senha) {
        EntityManager em = emf.createEntityManager();
        try {
            Object[] resultado;

            // Consulta genérica para administrador (root) ou motorista (CPF)
            resultado = (Object[]) em.createQuery(
                    "SELECT u.tipo, u.senha FROM Usuario u WHERE (u.cpf = :cpf OR (:cpf = 'root' AND u.cpf IS NULL))")
                    .setParameter("cpf", login)
                    .getSingleResult();

            String tipoUsuario = (String) resultado[0];
            String senhaHash = (String) resultado[1];

            // Verifica se a senha informada corresponde à senha armazenada
            if (criptografarSenha(senha).equals(senhaHash)) {
                // Atualiza a sessão com os dados do usuário
                SessaoUsuario sessao = SessaoUsuario.getInstance();
                sessao.setTipoUsuario(tipoUsuario); // Atualiza o tipo (motorista ou administrador)
                return true;
            } else {
                // Senha incorreta
                return false;
            }
        } catch (NoResultException e) {
            // Nenhum usuário encontrado com o login fornecido
            return false;
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
    public boolean StatusAdm(String login) {
        return "root".equals(login);
    }
}
