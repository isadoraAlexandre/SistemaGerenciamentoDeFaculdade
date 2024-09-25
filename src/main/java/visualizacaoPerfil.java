import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class visualizacaoPerfil extends JFrame {
    private JPanel mainPanel;
    private JPanel formPanel;

    private JTextField txtNome, txtUsuario, txtCpf, txtDataNascimento, txtMatricula, txtTelefone, 
                       txtRua, txtNumero, txtBairro, txtCidade, txtEstado, txtCep;

    private JButton btnEditar;

    public visualizacaoPerfil() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Perfil do Aluno");
        setSize(400, 600); // Tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel externo com padding azul quase branco
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(242, 247, 251)); // Azul quase branco
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
        outerPanel.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Mudança para GridLayout

        // Adicionando um JScrollPane para tornar o painel externo rolável
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem

        // Labels e Campos de Texto
        formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Grid com 1 coluna e espaçamento

        // Labels e Campos de Texto
        formPanel.add(createLabel("Nome:"));
        txtNome = createTextField();
        formPanel.add(txtNome);

        formPanel.add(createLabel("Usuário (Email):"));
        txtUsuario = createTextField();
        formPanel.add(txtUsuario);

        formPanel.add(createLabel("CPF:"));
        txtCpf = createTextField();
        formPanel.add(txtCpf);

        formPanel.add(createLabel("Data de Nascimento:"));
        txtDataNascimento = createTextField();
        formPanel.add(txtDataNascimento);

        formPanel.add(createLabel("Matrícula:"));
        txtMatricula = createTextField();
        formPanel.add(txtMatricula);

        formPanel.add(createLabel("Telefone:"));
        txtTelefone = createTextField();
        formPanel.add(txtTelefone);

        formPanel.add(createLabel("Rua:"));
        txtRua = createTextField();
        formPanel.add(txtRua);

        formPanel.add(createLabel("Número:"));
        txtNumero = createTextField();
        formPanel.add(txtNumero);

        formPanel.add(createLabel("Bairro:"));
        txtBairro = createTextField();
        formPanel.add(txtBairro);

        formPanel.add(createLabel("Cidade:"));
        txtCidade = createTextField();
        formPanel.add(txtCidade);

        formPanel.add(createLabel("Estado:"));
        txtEstado = createTextField();
        formPanel.add(txtEstado);

        formPanel.add(createLabel("CEP:"));
        txtCep = createTextField();
        formPanel.add(txtCep);

        // Botão
        btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(28, 39, 95));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editarAluno();
            }
        });

        // Adiciona o formPanel ao mainPanel
        mainPanel.add(formPanel);
        mainPanel.add(btnEditar); // Adiciona o botão abaixo do formPanel

        // Adiciona o scrollPane ao painel externo
        outerPanel.add(scrollPane, BorderLayout.CENTER);

        add(outerPanel); // Adiciona o painel externo à janela
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(28, 39, 95)); // Azul escuro
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(161, 202, 227)); // Azul claro
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1), // Borda leve
            BorderFactory.createEmptyBorder(5, 5, 5, 5) // Espaçamento interno
        ));

        // Sombra leve
        textField.setOpaque(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(Color.BLACK);
        textField.setPreferredSize(new Dimension(350, 40)); // Aumenta a largura dos campos

        // Criando um painel para aplicar o sombreado
        JTextField shadowPanel = new JTextField(); // Alterado para JPanel
        shadowPanel.setBackground(new Color(242, 247, 251)); // Azul quase branco
        shadowPanel.setLayout(new BorderLayout());
        shadowPanel.add(textField, BorderLayout.CENTER);

        return shadowPanel; // Retorna o painel com sombra
    }

    private void editarAluno() {
        // Ação para editar os dados do aluno
        JOptionPane.showMessageDialog(this, "Dados do aluno editados!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            visualizacaoPerfil frame = new visualizacaoPerfil();
            frame.setVisible(true);
        });
    }
}
