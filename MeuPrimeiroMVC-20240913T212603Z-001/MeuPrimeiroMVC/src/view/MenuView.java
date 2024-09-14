package view;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MenuView {
    // Construtor da classe MenuView
    public MenuView(UserController controller) {
        // Criação do JFrame (janela principal)
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Criação dos botões
        JButton botao1 = new JButton("Cadastrar");
        JButton botao2 = new JButton("Remover");
        JButton botao3 = new JButton("Listar");
        JButton botao4 = new JButton("Alterar");
        JButton botao5 = new JButton("Sair");

        // Define o tamanho preferido dos botões
        Dimension buttonSize = new Dimension(200, 50); // Largura x Altura
        botao1.setPreferredSize(buttonSize);
        botao2.setPreferredSize(buttonSize);
        botao3.setPreferredSize(buttonSize);
        botao4.setPreferredSize(buttonSize);
        botao5.setPreferredSize(buttonSize);

        // Adicionando ActionListener ao botão "Cadastrar"
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroView(controller);  // Abre a nova tela de cadastro
            }
        });
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveView(controller);
            }
        });
        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListView(controller);
            }
        });
        botao4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlterView(controller);
            }
        });
        botao5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            frame.dispose();

            }
        });

        // Criação do painel com GridBagLayout
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche a largura disponível

        // Centraliza os botões na tela
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os botões

        panelMenu.add(botao1, gbc);

        gbc.gridy = 1;
        panelMenu.add(botao2, gbc);

        gbc.gridy = 2;
        panelMenu.add(botao3, gbc);

        gbc.gridy = 3;
        panelMenu.add(botao4, gbc);

        gbc.gridy = 4;
        panelMenu.add(botao5, gbc);

        // Adiciona o painel com botões ao frame
        frame.add(panelMenu);

        // Torna a janela visível
        frame.setVisible(true);
    }
}