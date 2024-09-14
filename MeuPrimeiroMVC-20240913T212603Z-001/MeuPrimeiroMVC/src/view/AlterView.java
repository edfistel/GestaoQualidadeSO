package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterView {
    JFrame frame = new JFrame("Digite o nome do usuário que deseja alterar");
    public AlterView(UserController controller){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        // Criação dos componentes
        JLabel usernameLabel = new JLabel("Nome de Usuário:");
        JTextField usernameField = new JTextField(20);
        JButton removeButton = new JButton("Pesquisar");

        // Painel de conteúdo
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(removeButton, gbc);

        frame.add(panel);

        // Ação do botão de remover
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user =  new User();
                user = controller.searchUserRep(usernameField.getText());
                if (user != null){
                    alterar(controller,user);
                    frame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "Usuário não encontrado",
                            "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Torna a janela visível
        frame.setVisible(true);
    }
    public void alterar(UserController controller, User user){
        JFrame frameAlter = new JFrame("Alterar");
        frameAlter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAlter.setSize(800, 600);
        frameAlter.setLocationRelativeTo(null);


        // Tamanho desejado para os campos e o botão
        Dimension preferredSize = new Dimension(200, 40); // Largura x Altura

        // Criação dos campos de entrada e rótulos
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(preferredSize);

        JLabel usernameLabel = new JLabel("Usuário:");
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(preferredSize);

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(preferredSize);

        JButton cadastrarButton = new JButton("Alterar");
        cadastrarButton.setPreferredSize(new Dimension(preferredSize.width, 40)); // Define o tamanho do botão

        // Criação do painel com GridBagLayout
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Adiciona os componentes ao painel com GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        cadastroPanel.add(nameLabel, gbc);

        gbc.gridy = 1;
        cadastroPanel.add(nameField, gbc);

        gbc.gridy = 2;
        cadastroPanel.add(usernameLabel, gbc);

        gbc.gridy = 3;
        cadastroPanel.add(usernameField, gbc);

        gbc.gridy = 4;
        cadastroPanel.add(passwordLabel, gbc);

        gbc.gridy = 5;
        cadastroPanel.add(passwordField, gbc);

        gbc.gridy = 6;
        cadastroPanel.add(cadastrarButton, gbc);

        // Adiciona o painel ao frame
        frameAlter.add(cadastroPanel);

        // Adiciona um ActionListener ao botão "Alterar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            user.setUserName(usernameField.getText());
            user.setName(nameField.getText());
            user.setPassword(passwordField.getText());

            //Verificar melhor as validações mais tarde

            if(!usernameField.getText().isEmpty() || !nameField.getText().isEmpty() || !passwordField.getText().isEmpty()) {
                if (controller.alter(user)) {
                    JOptionPane.showMessageDialog(frame,
                            "Usuário alterado com sucesso",
                            "", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    frameAlter.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Erro ao alterar o usuário",
                            "", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Preencha todos os campos",
                        "", JOptionPane.INFORMATION_MESSAGE);
            }

            }
        });
        frameAlter.setVisible(true);
    }
}
