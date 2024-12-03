package util;

import jakarta.persistence.*;
import config.SessaoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityLogListener {

    private static final Logger logger = LoggerFactory.getLogger(EntityLogListener.class);

    @PrePersist
    public void onPrePersist(Object entity) {
        registrarOperacao(entity, "INSERT");
    }

    @PreUpdate
    public void onPreUpdate(Object entity) {
        registrarOperacao(entity, "UPDATE");
    }

    @PreRemove
    public void onPreRemove(Object entity) {
        registrarOperacao(entity, "DELETE");
    }

    private void registrarOperacao(Object entity, String operacao) {
        SessaoUsuario sessao = SessaoUsuario.getInstance();

        String usuarioNome = sessao.getNome();
        String usuarioCpf = sessao.getCpf();
        String descricao = "Alteração na entidade: " + entity.toString();


        logger.info("Usuário: Nome={} | CPF={} | Operação={} | Descrição={}",
                    usuarioNome, usuarioCpf, operacao, descricao);
    }
}