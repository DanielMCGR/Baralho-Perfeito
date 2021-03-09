import Deque.ArrayDeque;

import java.util.Arrays;

/**
 * Define o baralho de Cartas
 * <p>
 * Nota:
 *
 * @author Daniel Rocha
 * @author Teófilo Silva
 * @version 1.0
 * @see Carta
 */
public class Baralho {
    private final ArrayDeque<Carta> inicial;//Guarda o baralho inicial
    private ArrayDeque<Carta> conteudo;

    /**
     * Construtor básico, cria um baralho com 52 cartas (o valor normal)
     */
    public Baralho() {
        inicial = createBaralho(52);
        this.conteudo = createBaralho(52);
    }

    /**
     * Construtor do Baralho, cria um baralho com o número de cartas especificado
     */
    public Baralho(int numeroDeCartas) {
        inicial = createBaralho(numeroDeCartas);
        this.conteudo = createBaralho(numeroDeCartas);
    }

    /**
     * Devolve o conteúdo do baralho
     *
     * @return conteúdo do baralho
     */
    public ArrayDeque<Carta> getConteudo() {
        return this.conteudo;
    }

    /**
     * Calcula o número de in-shuffles necessários para
     * o baralho voltar ao estado original, e dá
     * a informação na consola
     */
    public void numInShuffle() {
        int contador = 1;
        boolean isOriginal = false;
        while (!isOriginal) {
            System.out.println("--embaralhar-- #" + contador);
            inShuffle();
            contador++;
            if (nextBaralho(conteudo, inicial)) {
                isOriginal = true;
            }
        }
        System.out.println("Foi necessario " + (contador - 1) + " in-shuffles para voltar ao baralho original");
    }

    /**
     * Realiza um inShuffle no baralho
     */
    public void inShuffle() {
        System.out.println("Baralho Original: " + getConteudo());
        ArrayDeque<Carta> copy = new ArrayDeque<Carta>(conteudo.size());
        copy = getConteudo();
        int size = copy.size();
        int sizeSup = 0;
        int sizeInf = 0;
        if (isPair(size)) {
            sizeSup = size / 2;
            sizeInf = size / 2;
        } else {
            size -= 1; //remove-se 1 para ficar par e depois adiciona-se em baixo,   ex: 15/2 = 8+7, mas 14/2 = 7+7 (adiciona-se 1) = 8+7
            sizeSup = size / 2;
            sizeInf = size / 2;
            sizeInf++;
        }
        ArrayDeque<Carta> metadeSup = new ArrayDeque<Carta>(sizeSup);
        ArrayDeque<Carta> metadeInf = new ArrayDeque<Carta>(sizeInf);
        for (int i = 0; i < sizeSup; i++) {
            metadeSup.addLast(copy.first());
            copy.removeFirst();
        }
        for (int i = 0; i < sizeInf; i++) {
            metadeInf.addLast(copy.first());
            copy.removeFirst();
        }
        System.out.println("Metade Superior " + metadeSup);
        System.out.println("Metade Inferior " + metadeInf);
        ArrayDeque<Carta> copymetadeSup = new ArrayDeque<Carta>(sizeSup);
        ArrayDeque<Carta> copymetadeInf = new ArrayDeque<Carta>(sizeInf);
        copymetadeSup = metadeSup;
        copymetadeInf = metadeInf;
        for (int i = 0; i < size; i++) {
            if (isPair(i)) {
                copy.addFirst(copymetadeSup.last());
                copymetadeSup.removeLast();
            } else {
                copy.addFirst(copymetadeInf.last());
                copymetadeInf.removeLast();
            }
        }
        System.out.println("Baralhado " + copy);

    }

    /**
     * Realiza um outShuffle no baralho
     */
    public void outShuffle() {
        System.out.println("Baralho Original: " + getConteudo());
        ArrayDeque<Carta> copy = new ArrayDeque<Carta>(conteudo.size());
        copy = getConteudo();
        int size = copy.size();
        int sizeSup = 0;
        int sizeInf = 0;
        if (isPair(size)) {
            sizeSup = size / 2;
            sizeInf = size / 2;
        } else {
            size -= 1; //remove-se 1 para ficar par e depois adiciona-se em baixo,   ex: 15/2 = 8+7, mas 14/2 = 7+7 (adiciona-se 1) = 8+7
            sizeSup = size / 2;
            sizeInf = size / 2;
            sizeInf++;
        }
        ArrayDeque<Carta> metadeSup = new ArrayDeque<Carta>(sizeSup);
        ArrayDeque<Carta> metadeInf = new ArrayDeque<Carta>(sizeInf);
        for (int i = 0; i < sizeSup; i++) {
            metadeSup.addLast(copy.first());
            copy.removeFirst();
        }
        for (int i = 0; i < sizeInf; i++) {
            metadeInf.addLast(copy.first());
            copy.removeFirst();
        }
        System.out.println("Metade Superior " + metadeSup);
        System.out.println("Metade Inferior " + metadeInf);
        ArrayDeque<Carta> copymetadeSup = new ArrayDeque<Carta>(sizeSup);
        ArrayDeque<Carta> copymetadeInf = new ArrayDeque<Carta>(sizeInf);
        copymetadeSup = metadeSup;
        copymetadeInf = metadeInf;
        for (int i = 0; i < size; i++) {
            if (isPair(i)) {
                copy.addFirst(copymetadeInf.last());
                copymetadeInf.removeLast();
            } else {
                copy.addFirst(copymetadeSup.last());
                copymetadeSup.removeLast();
            }
        }
        System.out.println("Baralhado " + copy);

    }

    /**
     * Calcula o número de out-shuffles necessários para
     * o baralho voltar ao estado original, e dá
     * a informação na consola
     */
    public void numOutShuffle() {
        int contador = 1;
        boolean isOriginal = false;
        while (!isOriginal) {
            System.out.println("--embaralhar-- #" + contador);
            outShuffle();
            contador++;
            if (nextBaralho(conteudo, inicial)) {
                isOriginal = true;
            }
        }
        System.out.println("Foi necessario " + (contador - 1) + " out-shuffles para voltar ao baralho original");
    }

    /**
     * Define a função toString() do baralho para facilitar o seu uso
     *
     * @return Conteúdo do baralho como string
     */
    @Override
    public String toString() {
        return conteudo.toString();
    }

    /**
     * Verifica se um número é par
     *
     * @param num número a verificar
     * @return se o número é par
     */
    public boolean isPair(int num) {
        return num % 2 == 0;
    }

    /**
     * Cria um baralho com X cartar. Se o número for
     * menor que 52 é mantida a ordem original mas o
     * tamanho reduzido. Se maior que 52 o número de cartar
     * fica em 52 (pois um baralho não terá mais que 52 cartas)
     *
     * @param total Nº de cartas
     * @return Baralho com X cartas
     */
    private static ArrayDeque<Carta> createBaralho(int total) {
        ArrayDeque<Carta> def = new ArrayDeque<Carta>(total);
        int contagem = 0;
        for (int i = 0; i < 13; i++) {
            Carta carta = new Carta(Naipe.COPAS, i + 1);
            def.addLast(carta);
            contagem++;
            if (contagem == total) return def;
        }
        for (int i = 0; i < 13; i++) {
            Carta carta = new Carta(Naipe.ESPADAS, i + 1);
            def.addLast(carta);
            contagem++;
            if (contagem == total) return def;
        }
        for (int i = 0; i < 13; i++) {
            Carta carta = new Carta(Naipe.OUROS, i + 1);
            def.addLast(carta);
            contagem++;
            if (contagem == total) return def;
        }
        for (int i = 0; i < 13; i++) {
            Carta carta = new Carta(Naipe.PAUS, i + 1);
            def.addLast(carta);
            contagem++;
            if (contagem == total) return def;
        }
        return def;
    }

    /**
     * Compara dois baralhos e verifica se são iguais
     *
     * @param first primeiro baralho
     * @param second segundo baralho
     * @return se são ou não iguais
     */
    public boolean nextBaralho(ArrayDeque<Carta> first, ArrayDeque<Carta> second) {
        return first.toString().equals(second.toString());
    }

    /**
     * Método não implementado (não necessário à conclusão do trabalho)
     *
     * @param posicao null
     * @param messagens null
     */
    public void moveTopo(int posicao, boolean messagens) {
        throw new UnsupportedOperationException("Método não implementado!");
    }
}