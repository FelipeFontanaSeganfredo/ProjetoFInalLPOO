/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author User PC
 */
public class LoginController {
    public boolean autenticar(String usuario, String senha) {
        // Implementar a verificação no banco de dados
        return ("root".equals(usuario) && "1234".equals(senha) || ("1234".equals(senha) && "motorista".equals(usuario)));
    }
    public boolean StatusAdm (String usuario)
    {
        return usuario.equals("root");
    }
}
