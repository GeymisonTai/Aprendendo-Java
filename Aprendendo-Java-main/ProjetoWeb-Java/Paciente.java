public class Paciente extends Pessoa {
    private String historicoMental;
    private String queixaPrincipal;
    private String statusAtendimento;
    private int numeroSessoes;
    
 public Paciente(String nome, String cpf, String email, int idade, String queixaPrincipal) 
            throws IllegalArgumentException {
        super(nome, cpf, email, idade);
        if (queixaPrincipal == null || queixaPrincipal.isEmpty()) {
            throw new IllegalArgumentException("Queixa principal não pode estar vazia!");
        }
        this.queixaPrincipal = queixaPrincipal;
        this.historicoMental = "Sem histórico registrado";
        this.statusAtendimento = "Aguardando primeira consulta";
        this.numeroSessoes = 0;
    }
    
public String getHistoricoMental() {
        return historicoMental;
    }
    
    public void setHistoricoMental(String historicoMental) throws IllegalArgumentException {
        if (historicoMental == null || historicoMental.isEmpty()) {
            throw new IllegalArgumentException("Histórico não pode estar vazio!");
        }
        this.historicoMental = historicoMental;
    }
    
    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }
    
    public void setQueixaPrincipal(String queixaPrincipal) throws IllegalArgumentException {
        if (queixaPrincipal == null || queixaPrincipal.isEmpty()) {
            throw new IllegalArgumentException("Queixa principal não pode estar vazia!");
        }
        this.queixaPrincipal = queixaPrincipal;
    }
    
    public String getStatusAtendimento() {
        return statusAtendimento;
    }
    
    public void setStatusAtendimento(String statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }
    
    public int getNumeroSessoes() {
        return numeroSessoes;
    }
    
    public void setNumeroSessoes(int numeroSessoes) throws IllegalArgumentException {
        if (numeroSessoes < 0) {
            throw new IllegalArgumentException("Número de sessões não pode ser negativo!");
        }
        this.numeroSessoes = numeroSessoes;
    }
    
    @Override
    public String exibirFuncao() {
        return "Paciente em atendimento psicológico";
    }
    
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + 
               "\nQueixa Principal: " + queixaPrincipal +
               "\nStatus: " + statusAtendimento +
               "\nNúmero de Sessões: " + numeroSessoes;
    }
    
 
    public void registrarSessao() throws IllegalArgumentException {
        try {
            numeroSessoes++;
            statusAtendimento = "Em atendimento";
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao registrar sessão: " + e.getMessage());
        }
    }
    

    public String descreverCriseExistencial() {
        return "Paciente: " + getNome() + "\n" +
               "Queixa: " + queixaPrincipal + "\n" +
               "Status: " + statusAtendimento;
    }
}
