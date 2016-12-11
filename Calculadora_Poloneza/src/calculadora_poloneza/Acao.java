/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_poloneza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Carlos Fernandes
 */
public class Acao implements ActionListener {

    private final Frame frame;
    double postfix1;

    public Acao(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("CALCULAR".equals(e.getActionCommand())) {
            MetodosDaAcao metodosdaacao = new MetodosDaAcao(frame);
            metodosdaacao.calcular();
        }
        if ("Sair".equals(e.getActionCommand())) {
            System.exit(0);
        }
        if ("novo".equals(e.getActionCommand())) {
            MetodosDaAcao metodosdaacao = new MetodosDaAcao(frame);
            metodosdaacao.novo();
        }
        if ("sobre".equals(e.getActionCommand())) {
            MetodosDaAcao metodosdaacao = new MetodosDaAcao(frame);
            metodosdaacao.sobre();
        }
        if ("Desenvolvedores".equals(e.getActionCommand())) {
            MetodosDaAcao metodosdaacao = new MetodosDaAcao(frame);
            metodosdaacao.desenvolvedores();
        }
    }

}
