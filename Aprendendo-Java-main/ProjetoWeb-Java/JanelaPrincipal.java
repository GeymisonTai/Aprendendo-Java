import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI Principal - Interface gráfica para o sistema de crise existencial
 * Implementa os conceitos de Herança, Polimorfismo, Encapulamento e Tratamento de Exceções
 */
public class JanelaPrincipal extends JFrame {
    private JTabbedPane abas;
    private List<Paciente> pacientes;
    private List<Psicologo> psicologos;
    private List<Psiquiatra> psiquiatras;
    
    public JanelaPrincipal() {
        // Configuração da janela
        setTitle("Sistema de Crise Existencial - Atendimento Psicológico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Inicializar listas
        pacientes = new ArrayList<>();
        psicologos = new ArrayList<>();
        psiquiatras = new ArrayList<>();
        
        // Criar abas
        abas = new JTabbedPane();
        
        abas.addTab("Pacientes", criarAbaPacientes());
        abas.addTab("Psicólogos", criarAbaPsicologos());
        abas.addTab("Psiquiatras", criarAbaPsiquiatras());
        abas.addTab("Consultas", criarAbaConsultas());
        
        add(abas);
        setVisible(true);
    }
    
    /**
     * Cria a aba para gerenciar pacientes
     */
    private JPanel criarAbaPacientes() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de entrada
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(4, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Novo Paciente"));
        
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblQueixa = new JLabel("Queixa Principal:");
        JTextField txtQueixa = new JTextField();
        
        painelEntrada.add(lblNome);
        painelEntrada.add(txtNome);
        painelEntrada.add(lblCpf);
        painelEntrada.add(txtCpf);
        painelEntrada.add(lblEmail);
        painelEntrada.add(txtEmail);
        painelEntrada.add(lblQueixa);
        painelEntrada.add(txtQueixa);
        
        // Área de texto para exibir pacientes
        JTextArea textAreaPacientes = new JTextArea(10, 40);
        textAreaPacientes.setEditable(false);
        textAreaPacientes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textAreaPacientes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Pacientes Registrados"));
        
        // Botão para adicionar paciente
        JButton btnAdicionar = new JButton("Adicionar Paciente");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    String cpf = txtCpf.getText();
                    String email = txtEmail.getText();
                    String queixa = txtQueixa.getText();
                    int idade = 30; // Valor padrão
                    
                    // TRATAMENTO DE EXCEÇÕES
                    if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || queixa.isEmpty()) {
                        JOptionPane.showMessageDialog(null, 
                            "Todos os campos são obrigatórios!", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    Paciente paciente = new Paciente(nome, cpf, email, idade, queixa);
                    pacientes.add(paciente);
                    
                    // Limpar campos
                    txtNome.setText("");
                    txtCpf.setText("");
                    txtEmail.setText("");
                    txtQueixa.setText("");
                    
                    // Atualizar lista
                    atualizarListaPacientes(textAreaPacientes);
                    JOptionPane.showMessageDialog(null, 
                        "Paciente adicionado com sucesso!", 
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Erro: " + ex.getMessage(), 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Painel superior
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());
        painelSuperior.add(painelEntrada, BorderLayout.NORTH);
        painelSuperior.add(btnAdicionar, BorderLayout.SOUTH);
        
        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);
        
        return painel;
    }
    
    /**
     * Cria a aba para gerenciar psicólogos
     */
    private JPanel criarAbaPsicologos() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de entrada
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(5, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Novo Psicólogo"));
        
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblConselho = new JLabel("Conselho:");
        JTextField txtConselho = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblEspecializacao = new JLabel("Especialização:");
        JTextField txtEspecializacao = new JTextField();
        JLabel lblExperiencia = new JLabel("Anos de Experiência:");
        JTextField txtExperiencia = new JTextField();
        
        painelEntrada.add(lblNome);
        painelEntrada.add(txtNome);
        painelEntrada.add(lblConselho);
        painelEntrada.add(txtConselho);
        painelEntrada.add(lblEmail);
        painelEntrada.add(txtEmail);
        painelEntrada.add(lblEspecializacao);
        painelEntrada.add(txtEspecializacao);
        painelEntrada.add(lblExperiencia);
        painelEntrada.add(txtExperiencia);
        
        // Área de texto
        JTextArea textAreaPsicologos = new JTextArea(10, 40);
        textAreaPsicologos.setEditable(false);
        textAreaPsicologos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textAreaPsicologos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Psicólogos Registrados"));
        
        // Botão
        JButton btnAdicionar = new JButton("Adicionar Psicólogo");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    String conselho = txtConselho.getText();
                    String email = txtEmail.getText();
                    String especializacao = txtEspecializacao.getText();
                    int experiencia = Integer.parseInt(txtExperiencia.getText());
                    int idade = 35;
                    String cpf = "12345678900";
                    
                    // TRATAMENTO DE EXCEÇÕES
                    if (nome.isEmpty() || conselho.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, 
                            "Campos obrigatórios vazios!", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    Psicologo psicologo = new Psicologo(nome, cpf, email, idade, 
                                                        conselho, especializacao, experiencia);
                    psicologos.add(psicologo);
                    
                    txtNome.setText("");
                    txtConselho.setText("");
                    txtEmail.setText("");
                    txtEspecializacao.setText("");
                    txtExperiencia.setText("");
                    
                    atualizarListaPsicologos(textAreaPsicologos);
                    JOptionPane.showMessageDialog(null, 
                        "Psicólogo adicionado com sucesso!", 
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Anos de experiência deve ser um número!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Erro: " + ex.getMessage(), 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());
        painelSuperior.add(painelEntrada, BorderLayout.NORTH);
        painelSuperior.add(btnAdicionar, BorderLayout.SOUTH);
        
        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);
        
        return painel;
    }
    
    /**
     * Cria a aba para gerenciar psiquiatras
     */
    private JPanel criarAbaPsiquiatras() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de entrada
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(5, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Novo Psiquiatra"));
        
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblCRM = new JLabel("CRM:");
        JTextField txtCRM = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblEspecializacao = new JLabel("Especialização:");
        JTextField txtEspecializacao = new JTextField();
        JLabel lblExperiencia = new JLabel("Anos de Experiência:");
        JTextField txtExperiencia = new JTextField();
        
        painelEntrada.add(lblNome);
        painelEntrada.add(txtNome);
        painelEntrada.add(lblCRM);
        painelEntrada.add(txtCRM);
        painelEntrada.add(lblEmail);
        painelEntrada.add(txtEmail);
        painelEntrada.add(lblEspecializacao);
        painelEntrada.add(txtEspecializacao);
        painelEntrada.add(lblExperiencia);
        painelEntrada.add(txtExperiencia);
        
        // Área de texto
        JTextArea textAreaPsiquiatras = new JTextArea(10, 40);
        textAreaPsiquiatras.setEditable(false);
        textAreaPsiquiatras.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textAreaPsiquiatras);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Psiquiatras Registrados"));
        
        // Botão
        JButton btnAdicionar = new JButton("Adicionar Psiquiatra");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    String crm = txtCRM.getText();
                    String email = txtEmail.getText();
                    String especializacao = txtEspecializacao.getText();
                    int experiencia = Integer.parseInt(txtExperiencia.getText());
                    int idade = 40;
                    String cpf = "98765432100";
                    
                    // TRATAMENTO DE EXCEÇÕES
                    if (nome.isEmpty() || crm.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, 
                            "Campos obrigatórios vazios!", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    Psiquiatra psiquiatra = new Psiquiatra(nome, cpf, email, idade, 
                                                           crm, especializacao, experiencia);
                    psiquiatras.add(psiquiatra);
                    
                    txtNome.setText("");
                    txtCRM.setText("");
                    txtEmail.setText("");
                    txtEspecializacao.setText("");
                    txtExperiencia.setText("");
                    
                    atualizarListaPsiquiatras(textAreaPsiquiatras);
                    JOptionPane.showMessageDialog(null, 
                        "Psiquiatra adicionado com sucesso!", 
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Anos de experiência deve ser um número!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Erro: " + ex.getMessage(), 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());
        painelSuperior.add(painelEntrada, BorderLayout.NORTH);
        painelSuperior.add(btnAdicionar, BorderLayout.SOUTH);
        
        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);
        
        return painel;
    }
    
    /**
     * Cria a aba de consultas e atendimentos
     */
    private JPanel criarAbaConsultas() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Área de texto para resultados
        JTextArea textAreaConsultas = new JTextArea(15, 60);
        textAreaConsultas.setEditable(false);
        textAreaConsultas.setFont(new Font("Monospaced", Font.PLAIN, 11));
        JScrollPane scrollPane = new JScrollPane(textAreaConsultas);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Consultas Realizadas"));
        
        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        painelBotoes.setBorder(BorderFactory.createTitledBorder("Ações"));
        
        // Botão para ver todos os pacientes
        JButton btnVerPacientes = new JButton("Ver Todos Pacientes");
        btnVerPacientes.addActionListener(e -> {
            textAreaConsultas.setText("");
            for (Paciente p : pacientes) {
                textAreaConsultas.append(p.exibirInformacoes());
                textAreaConsultas.append("\n" + p.descreverCriseExistencial());
                textAreaConsultas.append("\n" + p.exibirFuncao());
                textAreaConsultas.append("\n" + "=".repeat(50) + "\n");
            }
            if (pacientes.isEmpty()) {
                textAreaConsultas.setText("Nenhum paciente registrado.");
            }
        });
        
        // Botão para ver todos psicólogos
        JButton btnVerPsicologos = new JButton("Ver Todos Psicólogos");
        btnVerPsicologos.addActionListener(e -> {
            textAreaConsultas.setText("");
            for (Psicologo psi : psicologos) {
                textAreaConsultas.append(psi.exibirInformacoes());
                textAreaConsultas.append("\n" + psi.exibirFuncao());
                textAreaConsultas.append("\n" + psi.orientarSobreCrise());
                textAreaConsultas.append("\n" + "=".repeat(50) + "\n");
            }
            if (psicologos.isEmpty()) {
                textAreaConsultas.setText("Nenhum psicólogo registrado.");
            }
        });
        
        // Botão para ver todos psiquiatras
        JButton btnVerPsiquiatras = new JButton("Ver Todos Psiquiatras");
        btnVerPsiquiatras.addActionListener(e -> {
            textAreaConsultas.setText("");
            for (Psiquiatra psiq : psiquiatras) {
                textAreaConsultas.append(psiq.exibirInformacoes());
                textAreaConsultas.append("\n" + psiq.exibirFuncao());
                textAreaConsultas.append("\n" + psiq.aconselharSobreCrise(pacientes.isEmpty() ? null : pacientes.get(0)));
                textAreaConsultas.append("\n" + "=".repeat(50) + "\n");
            }
            if (psiquiatras.isEmpty()) {
                textAreaConsultas.setText("Nenhum psiquiatra registrado.");
            }
        });
        
        painelBotoes.add(btnVerPacientes);
        painelBotoes.add(btnVerPsicologos);
        painelBotoes.add(btnVerPsiquiatras);
        
        painel.add(painelBotoes, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);
        
        return painel;
    }
    
    /**
     * Atualiza a lista de pacientes na interface
     */
    private void atualizarListaPacientes(JTextArea textArea) {
        textArea.setText("");
        if (pacientes.isEmpty()) {
            textArea.setText("Nenhum paciente registrado.");
            return;
        }
        for (Paciente p : pacientes) {
            textArea.append(p.exibirInformacoes());
            textArea.append("\n" + "=".repeat(50) + "\n");
        }
    }
    
    /**
     * Atualiza a lista de psicólogos na interface
     */
    private void atualizarListaPsicologos(JTextArea textArea) {
        textArea.setText("");
        if (psicologos.isEmpty()) {
            textArea.setText("Nenhum psicólogo registrado.");
            return;
        }
        for (Psicologo psi : psicologos) {
            textArea.append(psi.exibirInformacoes());
            textArea.append("\n" + "=".repeat(50) + "\n");
        }
    }
    
    /**
     * Atualiza a lista de psiquiatras na interface
     */
    private void atualizarListaPsiquiatras(JTextArea textArea) {
        textArea.setText("");
        if (psiquiatras.isEmpty()) {
            textArea.setText("Nenhum psiquiatra registrado.");
            return;
        }
        for (Psiquiatra psiq : psiquiatras) {
            textArea.append(psiq.exibirInformacoes());
            textArea.append("\n" + "=".repeat(50) + "\n");
        }
    }
    
    /**
     * Método main para iniciar a aplicação
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal();
            }
        });
    }
}
