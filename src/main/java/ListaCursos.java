import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaCursos extends JFrame {

    private JPanel jPanel1;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTable tabela;
    private JLabel jLabel1;
    
    private DefaultTableModel tableModel;
    private ArrayList<String[]> listaCursos;

    public ListaCursos() {
        initComponents();
        carregarDados();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        tabela = new JTable();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));

        jButton1.setBackground(new java.awt.Color(2, 57, 119));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Criar Curso");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                criarCursoActionPerformed(evt);
            }
        });

        // Definindo o modelo da tabela
        tableModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Nome", "Departamento", "Coordenador", "Grade", "Professores", "Alunos"
            }
        );
        
        tabela.setModel(tableModel);
        tabela.setName(""); 
        tabela.setSelectionBackground(new java.awt.Color(242, 247, 251));
        tabela.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tabela.setShowHorizontalLines(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); 
        jLabel1.setForeground(new java.awt.Color(2, 57, 119));
        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel1.setText("Lista de Cursos");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 823, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Função para criar um novo curso
    private void criarCursoActionPerformed(ActionEvent evt) {
        // Aqui você poderia abrir um novo JFrame ou JDialog para inserir os dados
        // por enquanto, simularemos a criação de um novo curso
        String[] novoCurso = {"Novo Curso", "Departamento X", "Dr. Novo", "B", "10", "40"};
        adicionarCursoTabela(novoCurso);
    }

    // Carregar os dados de cursos simulados
    private void carregarDados() {
        listaCursos = new ArrayList<>();
        listaCursos.add(new String[]{"Engenharia de Software", "Computação", "Dr. Silva", "A", "5", "30"});
        listaCursos.add(new String[]{"Medicina", "Saúde", "Dr. Gomes", "B", "15", "50"});

        // Adicionando cursos na tabela
        for (String[] curso : listaCursos) {
            adicionarCursoTabela(curso);
        }
    }

    // Função para adicionar curso à tabela
    private void adicionarCursoTabela(String[] curso) {
        tableModel.addRow(curso);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCursos().setVisible(true);
            }
        });
    }
}
