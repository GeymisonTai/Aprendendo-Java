package CriseExistencial;

/**
 * Classe Psiquiatra - HERANÇA de Pessoa
 * Profissional médico especializado em saúde mental
 */
public class Psiquiatra extends Pessoa {
    private String numConselhoCRM;
    private String estaSpecializado;
    private int anosExperiencia;
    private int pacientesAtendidos;
    private String medicacoesDisponiveis;
    
    // Construtor
    public Psiquiatra(String nome, String cpf, String email, int idade, 
                      String numConselhoCRM, String estaSpecializado, int anosExperiencia) 
            throws IllegalArgumentException {
        super(nome, cpf, email, idade);
        if (numConselhoCRM == null || numConselhoCRM.isEmpty()) {
            throw new IllegalArgumentException("Número CRM não pode estar vazio!");
        }
        if (anosExperiencia < 0) {
            throw new IllegalArgumentException("Anos de experiência não pode ser negativo!");
        }
        
        this.numConselhoCRM = numConselhoCRM;
        this.estaSpecializado = estaSpecializado != null ? estaSpecializado : "Psiquiatria Geral";
        this.anosExperiencia = anosExperiencia;
        this.pacientesAtendidos = 0;
        this.medicacoesDisponiveis = "Antidepressivos, Ansiolíticos, Estabilizadores de Humor";
    }
    
    // ENCAPULAMENTO - Getters e Setters
    public String getNumConselhoCRM() {
        return numConselhoCRM;
    }
    
    public void setNumConselhoCRM(String numConselhoCRM) throws IllegalArgumentException {
        if (numConselhoCRM == null || numConselhoCRM.isEmpty()) {
            throw new IllegalArgumentException("Número CRM não pode estar vazio!");
        }
        this.numConselhoCRM = numConselhoCRM;
    }
    
    public String getEstaSpecializado() {
        return estaSpecializado;
    }
    
    public void setEstaSpecializado(String estaSpecializado) throws IllegalArgumentException {
        if (estaSpecializado == null || estaSpecializado.isEmpty()) {
            throw new IllegalArgumentException("Especialização não pode estar vazia!");
        }
        this.estaSpecializado = estaSpecializado;
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
    
    public String getMedicacoesDisponiveis() {
        return medicacoesDisponiveis;
    }
    
    public void setMedicacoesDisponiveis(String medicacoesDisponiveis) throws IllegalArgumentException {
        if (medicacoesDisponiveis == null || medicacoesDisponiveis.isEmpty()) {
            throw new IllegalArgumentException("Medicações não podem estar vazias!");
        }
        this.medicacoesDisponiveis = medicacoesDisponiveis;
    }
    
    // POLIMORFISMO - Implementação do método abstrato
    @Override
    public String exibirFuncao() {
        return "Psiquiatra especializado em crises existenciais e transtornos mentais";
    }
    
    // POLIMORFISMO - Sobrescrita de método da superclasse
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + 
               "\nCRM: " + numConselhoCRM +
               "\nEspecialização: " + estaSpecializado +
               "\nExperiência: " + anosExperiencia + " anos" +
               "\nPacientes Atendidos: " + pacientesAtendidos;
    }
    
    /**
     * Método para registrar atendimento de um paciente
     */
    public String avaliarPaciente(Paciente paciente) throws IllegalArgumentException {
        try {
            if (paciente == null) {
                throw new IllegalArgumentException("Paciente não pode ser nulo!");
            }
            
            paciente.registrarSessao();
            pacientesAtendidos++;
            
            return "Psiquiatra " + getNome() + " avaliando " + paciente.getNome() + 
                   "\nHistórico: " + paciente.getHistoricoMental();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro ao avaliar paciente: " + e.getMessage());
        }
    }
    
    /**
     * Método para prescrever medicação
     */
    public String prescreverMedicacao(Paciente paciente, String medicacao) throws IllegalArgumentException {
        try {
            if (paciente == null) {
                throw new IllegalArgumentException("Paciente não pode ser nulo!");
            }
            if (medicacao == null || medicacao.isEmpty()) {
                throw new IllegalArgumentException("Medicação não pode estar vazia!");
            }
            if (!medicacoesDisponiveis.toLowerCase().contains(medicacao.toLowerCase())) {
                throw new IllegalArgumentException("Medicação não está no repertório disponível!");
            }
            
            return "Prescrição para " + paciente.getNome() + ": " + medicacao + 
                   "\nPsiquiatra: " + getNome() + "\nUso: Conforme orientado";
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro na prescrição: " + e.getMessage());
        }
    }
    
    /**
     * Método para dar aconselhamento profundo
     */
    public String aconselharSobreCrise(Paciente paciente) throws IllegalArgumentException {
        try {
            if (paciente == null) {
                throw new IllegalArgumentException("Paciente não pode ser nulo!");
            }
            
            return "Aconselhamento médico para " + paciente.getNome() + ":\n" +
                   "Sua crise existencial é uma oportunidade de crescimento.\n" +
                   "Aqui oferecemos suporte profissional completo.\n" +
                   "Medicações estarão disponíveis se necessário.";
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro no aconselhamento: " + e.getMessage());
        }
    }
    
    /**
     * Método para relatório de diagnóstico
     */
    public String gerarRelatorioDiagnostico(Paciente paciente) throws IllegalArgumentException {
        try {
            if (paciente == null) {
                throw new IllegalArgumentException("Paciente não pode ser nulo!");
            }
            
            String relatorio = "=== RELATÓRIO DE DIAGNÓSTICO ===\n";
            relatorio += "Paciente: " + paciente.getNome() + "\n";
            relatorio += "Psiquiatra: " + getNome() + "\n";
            relatorio += "Queixa Principal: " + paciente.getQueixaPrincipal() + "\n";
            relatorio += "Sessões Realizadas: " + paciente.getNumeroSessoes() + "\n";
            relatorio += "Status: " + paciente.getStatusAtendimento() + "\n";
            relatorio += "Medicações: " + medicacoesDisponiveis + "\n";
            relatorio += "================================";
            
            return relatorio;
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}

