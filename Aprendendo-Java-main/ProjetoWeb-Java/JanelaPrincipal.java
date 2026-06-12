
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Thread-safe execution para GUI do Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Inicializa a janela principal da aplicação
                    exibirMensagemInicial();
                    
                    // Abre a interface gráfica principal
                    new JanelaPrincipal();
                    
                } catch (Exception e) {
                    System.err.println("Erro ao iniciar a aplicação: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Exibe mensagem de inicialização no console
     */
    private static void exibirMensagemInicial() {
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("     SISTEMA DE CRISE EXISTENCIAL - ATENDIMENTO PSICOLÓGICO");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println();
        System.out.println("Bem-vindo ao Sistema de Gestão de Pacientes!");
        System.out.println();
        System.out.println("Este sistema implementa os seguintes conceitos de POO:");
        System.out.println("  ✓ HERANÇA: Classes especializadas (Paciente, Psicologo, Psiquiatra)");
        System.out.println("  ✓ ENCAPULAMENTO: Atributos privados com getters/setters");
        System.out.println("  ✓ POLIMORFISMO: Métodos abstratos e sobrescritos");
        System.out.println("  ✓ TRATAMENTO DE EXCEÇÕES: Validações e exceções customizadas");
        System.out.println("  ✓ INTERFACE GRÁFICA: Implementada com Swing (JFrame, JPanel, etc)");
        System.out.println();
        System.out.println("Funcionalidades:");
        System.out.println("  • Registrar pacientes com suas queixas principais");
        System.out.println("  • Registrar psicólogos com sua especialização");
        System.out.println("  • Registrar psiquiatras com sua licença CRM");
        System.out.println("  • Visualizar informações de todos os profissionais e pacientes");
        System.out.println("  • Gerar relatórios de consultas e atendimentos");
        System.out.println();
        System.out.println("Iniciando a interface gráfica...");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println();
    }
    
    /**
     * Método para exemplo de uso com dados de teste
     * Este método demonstra como usar as classes sem a GUI
     */
    public static void exemploDeUsoConsole() {
        System.out.println("\n>>> EXEMPLO DE USO VIA CONSOLE <<<\n");
        
        try {
            // Criando pacientes
            System.out.println("--- Criando Pacientes ---");
            Paciente paciente1 = new Paciente("João Silva", "12345678901", 
                                             "joao@email.com", 28, 
                                             "Ansiedade e depressão");
            System.out.println(paciente1.exibirInformacoes());
            System.out.println(paciente1.descreverCriseExistencial());
            System.out.println("Função: " + paciente1.exibirFuncao());
            System.out.println();
            
            Paciente paciente2 = new Paciente("Maria Santos", "98765432101", 
                                             "maria@email.com", 35, 
                                             "Crise de identidade");
            System.out.println(paciente2.exibirInformacoes());
            System.out.println(paciente2.descreverCriseExistencial());
            System.out.println();
            
            // Criando psicólogos
            System.out.println("--- Criando Psicólogos ---");
            Psicologo psicologo1 = new Psicologo("Dr. Carlos", "11111111111", 
                                                 "carlos@email.com", 42, 
                                                 "CRP-12345", "Psicologia Clínica", 8);
            System.out.println(psicologo1.exibirInformacoes());
            System.out.println("Função: " + psicologo1.exibirFuncao());
            System.out.println(psicologo1.orientarSobreCrise());
            System.out.println();
            
            // Criando psiquiatras
            System.out.println("--- Criando Psiquiatras ---");
            Psiquiatra psiquiatra1 = new Psiquiatra("Dra. Ana", "22222222222", 
                                                    "ana@email.com", 45, 
                                                    "CRM-54321", "Psiquiatria Geral", 12);
            System.out.println(psiquiatra1.exibirInformacoes());
            System.out.println("Função: " + psiquiatra1.exibirFuncao());
            System.out.println();
            
            // Simulando atendimentos
            System.out.println("--- Atendimentos ---");
            System.out.println(psicologo1.atenderPaciente(paciente1));
            System.out.println();
            System.out.println(psiquiatra1.avaliarPaciente(paciente2));
            System.out.println();
            
            // Prescrições
            System.out.println("--- Prescrições Médicas ---");
            System.out.println(psiquiatra1.prescreverMedicacao(paciente1, "Antidepressivos"));
            System.out.println();
            
            // Relatórios
            System.out.println("--- Relatório de Diagnóstico ---");
            System.out.println(psiquiatra1.gerarRelatorioDiagnostico(paciente1));
            System.out.println();
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
