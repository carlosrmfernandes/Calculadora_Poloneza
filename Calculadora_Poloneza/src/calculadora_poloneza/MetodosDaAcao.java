/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_poloneza;

import java.util.EmptyStackException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Fernandes
 */
public class MetodosDaAcao {

    private final Frame frame;
    double postfix1;

    public MetodosDaAcao(Frame frame) {
        this.frame = frame;
    }

    void calcular() {
        try {
            SetGet setget = new SetGet();
            setget.setJTexpresao(frame.JTexpresao.getText());
            Pilha expressao = new Pilha();
            String postfix = expressao.Posfixa(setget.JTexpresao);

            if (frame.JTexpresao.getText().length() > 0) {
                frame.jtNPRexpresao.setText(postfix);

                postfix1 = expressao.AvaliarExprecaoNPR(postfix);

                String postfix2 = Double.toString(postfix1);
                frame.resultado.setText(postfix2);

            } else {
                JOptionPane.showMessageDialog(null, "Digite uma Equação");
            }
        } catch (NumberFormatException e) {//Ocorre quando é um valor esperado é diferente do valor atual.

            JOptionPane.showMessageDialog(null, "Caracteres inválidos");

        } catch (EmptyStackException e) { //mostrnado k a pilha esta vasia 

            JOptionPane.showMessageDialog(null, "Expressão inválida");
        }

    }

    void sobre() {
        JOptionPane.showMessageDialog(null, "Versão 1.0"
                + "\nAtualizado");
    }

    void desenvolvedores() {
        JOptionPane.showMessageDialog(null, "@autores : "
                + "\n"
                + "\nCarlos Rafael Magalhães Fernandes"
                + "\nClayton Mariano de Andrade");
    }

    public void novo() {
        frame.JTexpresao.setText("");
        frame.jtNPRexpresao.setText("");
        frame.resultado.setText("");

    }

}
