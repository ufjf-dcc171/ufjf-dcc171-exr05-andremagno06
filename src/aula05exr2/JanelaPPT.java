/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05exr2;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Random;

/**
 *
 * @author ice
 */
public class JanelaPPT extends JFrame {

    private final JRadioButton rbPedra = new JRadioButton("Pedra", false);
    private final JRadioButton rbPapel = new JRadioButton("Papel", false);
    private final JRadioButton rbTesoura = new JRadioButton("Tesoura", false);
    private final JButton botao = new JButton("Ok");
    private final JLabel resultado = new JLabel("");
    private final JLabel jogada = new JLabel("");
    private final JLabel jogadaDaMaquina = new JLabel("");

    public JanelaPPT() throws HeadlessException {

        super("Pedra Papel Tesoura");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(rbPedra);
        add(rbPapel);
        add(rbTesoura);
        add(botao);
        add(resultado);
        add(jogada);
        add(jogadaDaMaquina);

        ButtonGroup bgEstilo = new ButtonGroup();
        bgEstilo.add(rbPedra);
        bgEstilo.add(rbPapel);
        bgEstilo.add(rbTesoura);

        botao.addActionListener(new BotaoClicado());

    }

    private class BotaoClicado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String jogada1 = null;
            String[] jogadaMaquina = {"Papel", "Pedra", "Tesoura"};
            String maquina = (jogadaMaquina[new Random().nextInt(jogadaMaquina.length)]);

            if (!rbPedra.isSelected() && !rbPapel.isSelected() && !rbTesoura.isSelected()) {
                resultado.setText("Voce não marcou a opçao pedra papel tesoura");

            } else if (rbPapel.isSelected()) {
                jogada1 = rbPapel.getText();

            } else if (rbPedra.isSelected()) {
                jogada1 = rbPedra.getText();
            } else if (rbTesoura.isSelected()) {
                jogada1 = rbTesoura.getText();
            }

            if (jogada1.equals(maquina)) {
                resultado.setText("Você Empatou!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            } else if (jogada1.equals("Papel") && maquina.equals("Pedra")) {
                resultado.setText("Você Ganhou!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            } else if (jogada1.equals("Papel") && maquina.equals("Tesoura")) {
                resultado.setText("Você Perdeu!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            } else if (jogada1.equals("Pedra") && maquina.equals("Tesoura")) {
                resultado.setText("Você Ganhou!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            } else if (jogada1.equals("Pedra") && maquina.equals("Papel")) {
                resultado.setText("Você Perdeu!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            } else if (jogada1.equals("Tesoura") && maquina.equals("Papel")) {
                resultado.setText("Você Ganhou!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            } else if (jogada1.equals("Tesoura") && maquina.equals("Pedra")) {
                resultado.setText("Você Perdeu!");
                jogada.setText(jogada1);
                jogadaDaMaquina.setText(maquina);
            }

        }

    }
}
