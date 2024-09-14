package view;

import controller.UserController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListView {
    static DefaultListModel<String> listModel = new DefaultListModel<>();
    JPanel listPanel = new JPanel();
    public ListView(UserController controller) {
        JFrame frameListagem = new JFrame("Usuários");
        frameListagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameListagem.setSize(800, 600);
        frameListagem.setLocationRelativeTo(null);

        JList<String> userList = new JList<>(listModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite selecionar apenas um item

        // Criação do painel para a lista
        listPanel.setLayout(new BorderLayout());

        // Adiciona a lista ao painel dentro de um JScrollPane
        listPanel.add(new JScrollPane(userList), BorderLayout.CENTER);

        // Adiciona o painel ao frame
        frameListagem.add(listPanel);

        controller.listAll();

        // Adiciona um WindowListener para limpar a lista ao fechar a janela
        frameListagem.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                listModel.clear(); // Limpa a lista ao fechar a janela
                frameListagem.dispose(); // Fecha a janela
            }
        });

        // Torna a janela de listagem visível
        frameListagem.setVisible(true);
    }
    public static void listar(String nome, String username, int id) {
        listModel.addElement("\n");
        listModel.addElement("Id: " + id);
        listModel.addElement("Nome: " + nome);
        listModel.addElement("Usuário: " + username);
   }
}