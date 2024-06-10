import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorDeCaminhoes extends JFrame {
    private JTextField txtNomeMotorista, txtcnhMotorista,txtPlaca, txtQuilometragemTotal, txtQuilometragemUltimaCorrida, txtQuilometragemAdicional, txtTrajeto, txtMercadoria;
    private JButton btnSalvar;
    private JTextArea outputArea;

    public GerenciadorDeCaminhoes() {
        // Inicialização dos campos de texto
        txtNomeMotorista = new JTextField(20);
        txtcnhMotorista = new JTextField(20);
        txtPlaca = new JTextField(20);
        txtQuilometragemTotal = new JTextField(20);
        txtQuilometragemUltimaCorrida = new JTextField(20);
        txtQuilometragemAdicional = new JTextField(20);
        txtTrajeto = new JTextField(20);
        txtMercadoria = new JTextField(20);
        btnSalvar = new JButton("Salvar");
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Painel de entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(9, 2));
        inputPanel.add(new JLabel("Nome do Motorista:"));
        inputPanel.add(txtNomeMotorista);
        inputPanel.add(new JLabel("CNH do Motorista:"));
        inputPanel.add(txtcnhMotorista);
        inputPanel.add(new JLabel("Placa do Caminhão: "));
        inputPanel.add(txtPlaca);
        inputPanel.add(new JLabel("Quilometragem Total:"));
        inputPanel.add(txtQuilometragemTotal);
        inputPanel.add(new JLabel("Quilometragem da Última Corrida:"));
        inputPanel.add(txtQuilometragemUltimaCorrida);
        inputPanel.add(new JLabel("Quilometragem Adicional:"));
        inputPanel.add(txtQuilometragemAdicional);
        inputPanel.add(new JLabel("Trajeto:"));
        inputPanel.add(txtTrajeto);
        inputPanel.add(new JLabel("Mercadoria:"));
        inputPanel.add(txtMercadoria);
        inputPanel.add(btnSalvar);

        // Painel de saída de dados
        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Dados coletados:"));
        outputPanel.add(new JScrollPane(outputArea));

        // Adiciona os painéis à janela principal
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);

        // Ação do botão salvar
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarDados();
            }
        });

        setTitle("Gerenciador de Caminhões");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void salvarDados() {
        try {
            String nomeMotorista = txtNomeMotorista.getText();
            String cnhMotorista = txtcnhMotorista.getText();
            String placa = txtPlaca.getText();
            int quilometragemTotal = Integer.parseInt(txtQuilometragemTotal.getText());
            int quilometragemUltimaCorrida = Integer.parseInt(txtQuilometragemUltimaCorrida.getText());
            int quilometragemAdicional = Integer.parseInt(txtQuilometragemAdicional.getText());
            String trajeto = txtTrajeto.getText();
            String mercadoria = txtMercadoria.getText();

            // Cálculo da quilometragem atualizada
            quilometragemTotal += quilometragemAdicional;

            // Exibição dos dados coletados
            outputArea.append("Motorista: " + nomeMotorista + "\n");
            outputArea.append("CNH: " + cnhMotorista + "\n");
            outputArea.append("Placa: " + placa + "\n");
            outputArea.append("Quilometragem total: " + quilometragemTotal + "\n");
            outputArea.append("Quilometragem última corrida: " + quilometragemUltimaCorrida + "\n");
            outputArea.append("Quilometragem adicional: " + quilometragemAdicional + "\n");
            outputArea.append("Trajeto: " + trajeto + "\n");
            outputArea.append("Mercadoria transportada: " + mercadoria + "\n\n");

            // Limpar campos após salvar
            txtNomeMotorista.setText("");
            txtcnhMotorista.setText("");
            txtPlaca.setText("");
            txtQuilometragemTotal.setText("");
            txtQuilometragemUltimaCorrida.setText("");
            txtQuilometragemAdicional.setText("");
            txtTrajeto.setText("");
            txtMercadoria.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos para quilometragem.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GerenciadorDeCaminhoes();
            }
        });
        
        Scanner scanner = new Scanner(System.in);

        // Declaração de variáveis
        String nomeMotorista;
        String cnhMotorista;
        String placa;
        int quilometragemTotal;
        int quilometragemUltimaCorrida;
        int quilometragemAdicional;
        String trajeto;
        String mercadoria;

        // Coleta de dados do motorista
        System.out.println("Digite o nome do motorista:");
        nomeMotorista = scanner.nextLine();

        // Coleta de dados do caminhão
        System.out.println("Digite a CNH do motorista:");
        cnhMotorista = scanner.nextLine();

        System.out.println("Digite a placa do caminhão:");
        placa = scanner.nextLine();

        System.out.println("Digite a quilometragem total do caminhão:");
        quilometragemTotal = scanner.nextInt();

        // Coleta de dados da última corrida
        System.out.println("Digite a quilometragem da última corrida:");
        quilometragemUltimaCorrida = scanner.nextInt();

        // Coleta de dados da corrida atual
        System.out.println("Digite a quilometragem adicional da corrida atual:");
        quilometragemAdicional = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer do scanner

        System.out.println("Digite o trajeto da corrida atual:");
        trajeto = scanner.nextLine();

        System.out.println("Digite a mercadoria transportada:");
        mercadoria = scanner.nextLine();

        // Cálculo da quilometragem atualizada
        quilometragemTotal += quilometragemAdicional;

        // Exibição dos dados coletados
        System.out.println("\nDados coletados:");
        System.out.println("Motorista: " + nomeMotorista);
        System.out.println("CNH: " + cnhMotorista);
        System.out.println("placa do caminhão: " + placa);
        System.out.println("Quilometragem total: " + quilometragemTotal);
        System.out.println("Quilometragem última corrida: " + quilometragemUltimaCorrida);
        System.out.println("Quilometragem adicional: " + quilometragemAdicional);
        System.out.println("Endereço: " + trajeto);
        System.out.println("Mercadoria transportada: " + mercadoria);
    }

    // Função para validar e coletar entrada inteira
    private static int validarEntradaInt(Scanner scanner, String mensagem) {
        int valor;
        do {
            System.out.print(mensagem);
            try {
                valor = scanner.nextInt();
                break; // Entrada válida, sair do loop
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite novamente.");
                scanner.nextLine(); // Limpar buffer do scanner
            }
        } while (true);
        return valor;
    }
}
