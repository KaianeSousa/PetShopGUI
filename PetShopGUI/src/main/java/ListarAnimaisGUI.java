import repository.AnimalRepository;
import entities.Animal;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListarAnimaisGUI {

    public void mostrarTelaListarAnimais() {
        JFrame frame = new JFrame();
        frame.setTitle("Listar Animais");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        try {
            listarAnimais(panel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao buscar animais: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        JPanel buttonPanel = new JPanel();
        JButton botaoEditar = new JButton("Editar Animal");
        JButton botaoExcluir = new JButton("Excluir Animal");
        buttonPanel.add(botaoEditar);
        buttonPanel.add(botaoExcluir);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        botaoEditar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(frame, "Digite o nome do animal a ser editado:");
        });

        botaoExcluir.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(frame, "Digite o nome do animal a ser excluído:");
        });

        frame.setVisible(true);
    }

    public void listarAnimais(JPanel panel) throws SQLException {
        AnimalRepository animalRepository = new AnimalRepository();
        List<Animal> animais = animalRepository.buscarAnimais();

        if (animais != null && !animais.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Animal animal : animais) {
                sb.append(mostraAnimal(animal)).append("\n\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(700, 500));
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(panel, "Nenhum animal cadastrado ainda.", "Animais", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String mostraAnimal(Animal animal) {
        return  "Nome do animal: " + animal.getNome() + "\n" +
                "Raça: " + animal.getRaca() + "\n" +
                "Tipo: " + animal.getTipo() + "\n" +
                "Idade: " + animal.getIdade() + " anos" + "\n" +
                "__________________________________________________________________________________\n";
    }
}
