package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroView {
    public CadastroView(UserController controller) {

        JFrame framecadastro = new JFrame("Cadastro");
        framecadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framecadastro.setSize(800, 600);
        framecadastro.setLocationRelativeTo(null);

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

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setPreferredSize(new Dimension(preferredSize.width, 40)); // Define o tamanho do botão

        // Criação do painel com GridBagLayout
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes
        gbc.anchor = GridBagConstraints.CENTER;

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
        framecadastro.add(cadastroPanel);

        // Adiciona um ActionListener ao botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();

                //Verificar melhor essas validações mais tarde

                user.setName(nameField.getText());
                user.setUserName(usernameField.getText());
                user.setPassword(passwordField.getText());

                if(user.getName().isEmpty() || user.getUserName().isEmpty() || user.getPassword().isEmpty()){
                    JOptionPane.showMessageDialog(framecadastro,
                            "Preencha todos os campos",
                            "Erro", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    if(controller.searchUserRep(user.getUserName()) != null){
                        JOptionPane.showMessageDialog(framecadastro,
                                "Erro, Login ja cadastrado",
                                "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }else{

                        JOptionPane.showMessageDialog(framecadastro,
                                "Usuário cadastrado com sucesso",
                                "", JOptionPane.INFORMATION_MESSAGE);

                        controller.addUser(user);
                        framecadastro.dispose();
                    }
                }
            }
        });
        // Torna a janela de cadastro visível
        framecadastro.setVisible(true);
    }
}
