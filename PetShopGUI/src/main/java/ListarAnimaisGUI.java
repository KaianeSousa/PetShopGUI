import repository.AnimalRepository;
import entities.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ListarAnimaisGUI {
    
    private AnimalRepository animalRepository = new AnimalRepository();
    private List<Animal> animais;
    private JFrame frame;
    private JPanel painelBotoes;
    private JButton botaoExcluir;
    private JButton botaoEditar;

    public void mostrarTelaListarAnimais() {
        
        frame = new JFrame();
        frame.setTitle("Listar Animais");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            listarAnimais();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao buscar animais: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        frame.setVisible(true);
    }

    public void listarAnimais() throws SQLException {
        animais = animalRepository.buscarAnimais();

        frame.getContentPane().removeAll();
        frame.repaint();

        if (animais != null && !animais.isEmpty()) {
            painelBotoes = new JPanel();
            botaoExcluir = new JButton("Excluir");
            botaoEditar = new JButton("Editar");

            JComboBox<String> animalComboBox = new JComboBox<>();
            for (int i = 0; i < animais.size(); i++) {
                animalComboBox.addItem("Animal " + (i + 1) + ": " + animais.get(i).getNome());
            }

            JTextArea textArea = new JTextArea();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            atualizarListaAnimais(textArea);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(700, 400));

            botaoExcluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selecionarIndice = animalComboBox.getSelectedIndex();
                    if (selecionarIndice != -1) {
                        Animal animalSelecionado = animais.get(selecionarIndice);
                        try {
                            animalRepository.removerAnimal(animalSelecionado);
                            animais.remove(selecionarIndice);
                            animalComboBox.removeItemAt(selecionarIndice);
                            JOptionPane.showMessageDialog(frame, "Animal removido com sucesso.");
                            atualizarListaAnimais(textArea);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(frame, "Erro ao remover animal: " + ex.getMessage(),
                                    "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Nenhum animal cadastrado.");
                    }
                }
            });

            botaoEditar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selecionarIndice = animalComboBox.getSelectedIndex();
                    if (selecionarIndice != -1) {
                        Animal animalSelecionado = animais.get(selecionarIndice);
                        editarAnimal(animalSelecionado, animalComboBox, selecionarIndice, textArea);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Nenhum animal cadastrado.");
                    }
                }
            });

            painelBotoes.add(animalComboBox);
            painelBotoes.add(botaoExcluir);
            painelBotoes.add(botaoEditar);

            frame.getContentPane().setBackground(Color.decode("#F0F8FF"));

            frame.setLayout(new BorderLayout());
            frame.add(painelBotoes, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum animal cadastrado ainda.", "Animais", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String mostraAnimal(Animal animal, int indice) {

        return  "Animal " + (indice + 1) + ": \n" +
                "Nome: " + animal.getNome() + "\n" +
                "Raça: " + animal.getRaca() + "\n" +
                "Tipo: " + animal.getTipo() + "\n" +
                "Idade: " + animal.getIdade() + " anos" + "\n" +
                "_______________________________________________________________________________________\n";
    }

    private void editarAnimal(Animal animal, JComboBox<String> comboBox, int selecionarIndice, JTextArea textArea) {

        JTextField campoNome = new JTextField(animal.getNome());
        JTextField campoRaca = new JTextField(animal.getRaca());
        JTextField campoTipo = new JTextField(animal.getTipo());
        JTextField campoIdade = new JTextField(String.valueOf(animal.getIdade()));

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);
        panel.add(new JLabel("Tipo:"));
        panel.add(campoTipo);
        panel.add(new JLabel("Raça:"));
        panel.add(campoRaca);
        panel.add(new JLabel("Idade:"));
        panel.add(campoIdade);

        int result = JOptionPane.showConfirmDialog(null, panel, "Editar Animal",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String novoNome = campoNome.getText();
            String novaRaca = campoRaca.getText();
            String novoTipo = campoTipo.getText();
            String novaIdade = campoIdade.getText();

            if (novoNome.isEmpty() || novaRaca.isEmpty() || novoTipo.isEmpty() || novaIdade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            animal.setNome(novoNome);
            animal.setRaca(novaRaca);
            animal.setTipo(novoTipo);
            animal.setIdade(novaIdade);

            try {
                animalRepository.atualizarAnimal(animal);
                atualizarLista(comboBox, animal, selecionarIndice);
                JOptionPane.showMessageDialog(null, "Animal atualizado com sucesso.");
                atualizarListaAnimais(textArea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar animal: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void atualizarLista(JComboBox<String> lista, Animal animal, int index) {
        lista.removeItemAt(index);
        lista.insertItemAt("Animal " + (index + 1) + ": " + animal.getNome(), index);
    }

    private void atualizarListaAnimais(JTextArea atualizarListaAnimais) {
        atualizarListaAnimais.setText("");

        for (int i = 0; i < animais.size(); i++) {
            atualizarListaAnimais.append(mostraAnimal(animais.get(i), i));
        }
    }
}
