/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_poloneza;

/**
 *
 * @author Carlos Fernandes
 */
import java.util.Stack;

/*
Stack é uma subclasse de Vector que implementa uma 
pilha padrão de última entrada, primeira saída
 */
public class Pilha {

    /* Verifica se op1 tem prioridade maior que op2, onde op1 é um operador a
      esquerda e op2 um operador a direita.
     */
    private boolean Precedencia(char op1, char op2) {
        switch (op1) {
            case '+':
                return op2 != '+';
            case '-':
                return op2 != '-';
            case '*':
                return op2 == '^';
            case '/':
                return op2 == '(';
            case '^':
                return op2 == '(';
            case '(':
                return true;
            default:
                return false;
        }
    }

    public String Posfixa(String infixa) {

        Stack<String> operador = new Stack<String>();// array de String de operadore 
        StringBuffer posfixa = new StringBuffer(infixa.length());// conta a string de forma rapitada

        String[] analizar = infixa.split("(?<=\\+)|(?=\\+)|" /*split()
                                                                  usado para dividir uma string em pequenos pedaços. 
                                                                  Para isso, seu método retorna um array de strings */
                + "(?<=\\-)|(?=\\-)|"
                + "(?<=\\*)|(?=\\*)|"
                + "(?<=\\/)|(?=\\/)|"
                + "(?<=\\^)|(?=\\^)|"
                + "(?<=\\()|(?=\\()|"
                + "(?<=\\))|(?=\\))|"
                + "(?<=\\s)|(?=\\s)"
        );

        for (int i = 0; i < analizar.length; i++) {

            String sinal = analizar[i];
            //pula para outro sinal caso esse seja vasio
            if (sinal.length() == 0 || sinal.length() == 1 && sinal.charAt(0) == ' ') {
                continue;
            }

            char s = sinal.charAt(0);

            if ((sinal.length() == 1) && "+-*/^()".indexOf(s) >= 0) {//retorna o indecie en sequencia de caraceter

                while (!operador.empty() && !Precedencia((operador.peek()).charAt(0), s)) {
                    //empty() verifica se a pilha esta vasia
                    //peek()   olhar o objeto no topo dessa pilha sem removê-lo da pilha.

                    posfixa.append(" ").append(operador.pop());
                    //append concatena o vario tipo de String para o final do objecto  
                }

                if (s == ')') {

                    String operado1 = operador.pop();
                    while (operado1.charAt(0) != '(') {
                        posfixa.append(" ").append(operado1);//vai contacter a strinfo e remove da pilha 
                        operado1 = operador.pop();//operador1 recebe o operador removido do topo da pilha
                    }
                } else {
                    operador.push(sinal);//inseri no topo da pilha
                }
            } else {
                posfixa.append(" ").append(sinal);//concatena a string
            }
        }

        while (!operador.empty()) {
            posfixa.append(" ").append(operador.pop());
        }

        return posfixa.toString();

    }

    double AvaliarExprecaoNPR(String expressao) {
        Stack<Double> stack = new Stack<Double>(); //vetor de real
        /*
        trim()
        Este método retorna uma cópia da seqüência de caracteres
        com espaço em branco
        
        split()
        usado para dividir uma string em pequenos pedaços. 
        Para isso, seu método retorna um array de strings
         */

        for (String simbolo : expressao.trim().split("\\s")) { // percorre todo arrays 

            if ("+-*/^()".indexOf(simbolo.charAt(0)) >= 0) {
                /*
        indexOf()
        Este método retorna o índice dentro dessa seqüência de caracteres
        
                charAt()
        Esse método retorna o caractere localizado no índice especificado String.
                 */

                double segundoOperador = stack.pop(); //pop () é usado para remover o objeto no topo dessa pilha 
                double primeiroOperador = stack.pop();//pop () é usado para remover o objeto no topo dessa pilha 

                if (simbolo.equals("*")) {
                    stack.push(primeiroOperador * segundoOperador);//Para colocar um objeto no topo da pilha, chame push()
                } else if (simbolo.equals("/")) {
                    stack.push(primeiroOperador / segundoOperador);
                } else if (simbolo.equals("-")) {
                    stack.push(primeiroOperador - segundoOperador);
                } else if (simbolo.equals("+")) {
                    stack.push(primeiroOperador + segundoOperador);
                } else if (simbolo.equals("^")) {
                    stack.push(Math.pow(primeiroOperador, segundoOperador));
                }

            } else {
                stack.push(Double.parseDouble(simbolo));
            }
        }

        return stack.pop();//O método pop () é usado para remover o 
        //objeto no topo dessa pilha e retorna esse objeto como o valor dessa função

    }

}
