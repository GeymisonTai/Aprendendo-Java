
/**
 * Classe Psicólogo - HERANÇA de Pessoa
 * Profissional que atende pacientes com crises existenciais
 */
public class Psicologo extends Pessoa {
    private String numConselho;
    private String especializacao;
    private int anosExperiencia;
    private int pacientesAtendidos;
    
    // Construtor
    public Psicologo(String nome, String cpf, String email, int idade, 
                     String numConselho, String especializacao, int anosExperiencia) 
            throws IllegalArgumentException {
        super(nome, cpf, email, idade);
        if (numConselho == null || numConselho.isEmpty()) {
            throw new IllegalArgumentException("Número do conselho não pode estar vazio!");
        }
        if (anosExperiencia < 0) {
            throw new IllegalArgumentException("Anos de experiência não pode ser negativo!");
        }
        
        this.numConselho = numConselho;
        this.especializacao = especializacao != null ? especializacao : "Geral";
        this.anosExperiencia = anosExperiencia;
        this.pacientesAtendidos = 0;
    }
    
    // ENCAPULAMENTO - Getters e Setters
    public String getNumConselho() {
        return numConselho;
    }
    
    public void setNumConselho(String numConselho) throws IllegalArgumentException {
        if (numConselho == null || numConselho.isEmpty()) {
            throw new IllegalArgumentException("Número do conselho não pode estar vazio!");
        }
        this.numConselho = numConselho;
    }
    
    public String getEspecializacao() {
        return especializacao;
    }
    
    public void setEspecializacao(String especializacao) throws IllegalArgumentException {
        if (especializacao == null || especializacao.isEmpty()) {
            throw new IllegalArgumentException("Especialização não pode estar vazia!");
        }
        this.especializacao = especializacao;
    }
    
    public int getAnosExperiencia() {
        return anosExperiencia;
    }
    
    public void setAnosExperiencia(int anosExperiencia) throws IllegalArgumentException {
        if (anosExperiencia < 0) {
            throw new IllegalArgumentException("Anos de experiência não pode ser negativo!");
        }
        this.anosExperiencia = anosExperiencia;
    }
    
    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }
    
    // POLIMORFISMO - Implementação do método abstrato
    @Override
    public String exibirFuncao() {
        return "Psicólogo especializado em crises existenciais";
    }
    
    // POLIMORFISMO - Sobrescrita de método da superclasse
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + 
               "\nConselho: " + numConselho +
               "\nEspecialização: " + especializacao +
               "\nExperiência: " + anosExperiencia + " anos" +
               "\nPacientes Atendidos: " + pacientesAtendidos;
    }
    
    /**
     * Método para registrar atendimento de um paciente
     */
    public String atenderPaciente(Paciente paciente) throws IllegalArgumentException {
        try {
            if (paciente == null) {
                throw new IllegalArgumentException("Paciente não pode ser nulo!");
            }
            
            paciente.registrarSessao();
            pacientesAtendidos++;
            
            return "Psicólogo " + getNome() + " iniciando sessão com " + 
                   paciente.getNome() + "\nQueixa: " + paciente.getQueixaPrincipal();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro ao atender paciente: " + e.getMessage());
        }
    }
    
    /**
     * Método para dar uma orientação sobre crise existencial
     */
    public String orientarSobreCrise() {
        return "Orientação do Psicólogo " + getNome() + ":\n" +
               "A crise existencial é uma fase importante de reflexão pessoal.\n" +
               "Juntos, exploraremos seus sentimentos e buscaremos o significado da vida.";
    }
    
    /**
     * Método para avaliar o progresso do paciente
     */
    public String avaliarProgresso(Paciente paciente) throws IllegalArgumentException {
        try {
            if (paciente == null) {
                throw new IllegalArgumentException("Paciente não pode ser nulo!");
            }
            
            int sessoes = paciente.getNumeroSessoes();
            String avaliacao;
            
            if (sessoes < 3) {
                avaliacao = "Fase inicial de tratamento";
            } else if (sessoes < 10) {
                avaliacao = "Progresso positivo detectado";
            } else {
                avaliacao = "Bom progresso - continuar tratamento";
            }
            
            return "Avaliação de " + paciente.getNome() + ": " + avaliacao;
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro na avaliação: " + e.getMessage());
        }
    }
}
