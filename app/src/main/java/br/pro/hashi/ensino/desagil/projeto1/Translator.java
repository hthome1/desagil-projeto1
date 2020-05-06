/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;
    private char[] chars;
    private Node arvore;
    private int contador = 0;


    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        map = new HashMap<Character, Node>();
        chars = new char[]{' ', 'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h',
                            'v', 'f',' ', 'l', ' ', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', ' ', ' ',
                            '5', '4', ' ', '3', ' ', ' ', ' ', '2', ' ', ' ', '+', ' ', ' ', ' ', ' ', '1',
                            '6', '=', '/', ' ', ' ', ' ', ' ', ' ', '7', ' ', ' ', ' ', '8', ' ', '9', '0'};
        arvore = vecToTree(chars,root,null,map,0);
    }
    public Node vecToTree(char[] array, Node raiz, Node parent, HashMap<Character,Node> map, int i){
        if (i < array.length){
            raiz = new Node(array[i]);
            raiz.setParent(parent);
            raiz.setLeft(vecToTree(array, raiz.getLeft(), raiz, this.map, 2 * i + 1));
            raiz.setRight(vecToTree(array, raiz.getRight(), raiz, this.map, 2 * i + 2));

            map.put(raiz.getValue(), raiz);
        }
        return raiz;
    }
    


    public char morseToChar(String code) {
        for(char c : code.toCharArray()) {
            if (c == '.'){
                arvore = arvore.getLeft();
                contador +=1;
            }else{
                arvore = arvore.getRight();
                contador += 1;
            }
        }
        char valor = arvore.getValue();
        while(contador>0){
            arvore = arvore.getParent();
            contador -= 1;
        }

        return valor;
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        return " ";
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }
}
