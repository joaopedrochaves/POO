import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class CadastroCaminhoes extends JFrame {
    private JTextField modeloField, marcaField, cavalosField, anoField;
    private JButton cadastrarButton, listarButton;
    private JTextArea outputArea;
    private List<Carro> carros;
    public CadastroCaminhoes() {
        carros = new ArrayList<>();
        modeloField = new JTextField(20);
        marcaField = new JTextField(20);
        cavalosField = new JTextField(20);
        anoField = new JTextField(20);
        cadastrarButton = new JButton("Cadastrar");
        listarButton = new JButton("Listar");
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Modelo:"));
        inputPanel.add(modeloField);
        inputPanel.add(new JLabel("Marca:"));
        inputPanel.add(marcaField);
        inputPanel.add(new JLabel("Cavalos:"));
        inputPanel.add(cavalosField);
        inputPanel.add(new JLabel("Ano:"));
        inputPanel.add(anoField);
        inputPanel.add(cadastrarButton);
        inputPanel.add(listarButton);
        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Carros cadastrados:"));
        outputPanel.add(new JScrollPane(outputArea));
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarCarro();
            }
        });
        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarCarros();
            }
        });
        setTitle("Cadastro de Carros");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void cadastrarCarro() {
        String modelo = modeloField.getText();
        String marca = marcaField.getText();
        int cavalos = Integer.parseInt(cavalosField.getText());
        int ano = Integer.parseInt(anoField.getText());
        Carro carro = new Carro(modelo, marca, cavalos, ano);
        carros.add(carro);
        outputArea.append(carro.toString() + "\n");
        // Limpar campos após o cadastro
        modeloField.setText("");
        marcaField.setText("");
        cavalosField.setText("");
        anoField.setText("");
    }
    private void listarCarros() {
        outputArea.setText("");
        for (Carro carro : carros) {
            outputArea.append(carro.toString() + "\n");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroCarros();
            }
        });
    }
}
