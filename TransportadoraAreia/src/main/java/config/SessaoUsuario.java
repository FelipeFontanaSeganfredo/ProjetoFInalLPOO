
package config;

public class SessaoUsuario {
    private static SessaoUsuario instancia;
    private int idUsuario;
    private String tipoUsuario;
    private String nome;
    private String cpf;

    // Construtor privado para Singleton
    private SessaoUsuario() {}

    public static SessaoUsuario getInstance() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void limparSessao() {
        idUsuario = 0;
        tipoUsuario = null;
        nome = null;
        cpf = null;
    }
}
