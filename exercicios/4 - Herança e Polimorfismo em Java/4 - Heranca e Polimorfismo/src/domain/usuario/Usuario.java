package domain.usuario;

public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private final boolean admin;

    public Usuario(String nome, String email, String senha, boolean admin){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isAdmin() {
        return admin;
    }

    public void realizarLogin(){
        System.out.println("Usuário foi logado!");
    };

    public void realizarLogoff(){
        System.out.println("Logoff foi realizado!");
    }

    public void alterarDados(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public void alterarSenha(String senha){
        this.senha = senha;
        System.out.println("Senha alterada!");
    }

}
