
package controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
    private static final Logger logger = LoggerFactory.getLogger(LogManager.class);

    public static void registrarLog(String usuarioNome, String usuarioCpf, String operacao, String descricao) {
        logger.info("Usuário: Nome={} | CPF={} | Operação={} | Descrição={}",
                    usuarioNome, usuarioCpf, operacao, descricao);
    }
    

}
