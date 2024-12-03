/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author User PC
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
    private static final Logger logger = LoggerFactory.getLogger(LogManager.class);

    public static void registrarLog(String usuarioNome, String usuarioCpf, String operacao, String descricao) {
        logger.info("Usuário: Nome={} | CPF={} | Operação={} | Descrição={}",
                    usuarioNome, usuarioCpf, operacao, descricao);
    }
}
