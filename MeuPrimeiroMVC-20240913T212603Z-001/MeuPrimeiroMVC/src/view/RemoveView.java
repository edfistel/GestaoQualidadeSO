package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveView {
    public RemoveView(UserController controller) {
        // Criação do JFrame (janela de remoção)
        JFrame frameRemove = new JFrame("Remover Usuário");
        frameRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRemove.setSize(400, 200);
        frameRemove.setLocationRelativeTo(null);

        // Criação dos componentes
        JLabel usernameLabel = new JLabel("Nome de Usuário:");
        JTextField usernameField = new JTextField(20);
        JButton removeButton = new JButton("Remover");

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

        frameRemove.add(panel);

        // Ação do botão de remover                                                                   Lembrar de rever este método do botão (Possiveis bugs de validação)
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usernameField.getText() != null){
                    User user = new User();
                    user = controller.searchUserRep(usernameField.getText());
                    if (user != null){
                       int option = JOptionPane.showConfirmDialog(null,"Deseja remover este usuário? \n\n  Nome: " + user.getName() + "\n  Login: " + user.getUserName());
                        switch (option){
                            case 0:
                                controller.remove(usernameField.getText());
                                JOptionPane.showMessageDialog(frameRemove,
                                        "Usuário removido com Sucesso!",
                                        "", JOptionPane.INFORMATION_MESSAGE);
                                frameRemove.dispose();
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(frameRemove,
                                        "Usuário não removido!",
                                        "", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case 2:
                                break;
                            default:
                        }
                    }else{
                        JOptionPane.showMessageDialog(frameRemove,
                                "Usuário não encontrado",
                                "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        // Torna a janela visível
        frameRemove.setVisible(true);
    }
}
