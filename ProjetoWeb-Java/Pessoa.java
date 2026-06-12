package CriseExistencial;

/**
 * Classe base (Superclasse) que implementa encapulamento
 * Todos herdam desta classe - HERANÇA
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private int idade;
    
    // Construtor
    public Pessoa(String nome, String cpf, String email, int idade) 
            throws IllegalArgumentException {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio!");
        }
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade inválida!");
        }
        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
    }
    
    // ENCAPULAMENTO - Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio!");
        }
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) throws IllegalArgumentException {
        if (cpf == null || cpf.length() < 11) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido!");
        }
        this.email = email;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) throws IllegalArgumentException {
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade inválida!");
        }
        this.idade = idade;
    }
    
    // POLIMORFISMO - Método abstrato (será implementado nas subclasses)
    public abstract String exibirFuncao();
    
    // POLIMORFISMO - Método concreto que pode ser sobrescrito
    public String exibirInformacoes() {
        return "Nome: " + nome + "\nIdade: " + idade + "\nEmail: " + email;
    }
}
