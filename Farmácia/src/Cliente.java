public class Cliente {
    String nome;
    String cpf;

    Cliente(String nome, String cpf){
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    @Override

    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCpf()+"\n";
    }

}
