/**
 * Define o que é uma carta, para ser usada no Baralho
 *
 * @author Daniel Rocha
 * @author Teófilo Silva
 * @version 1.0
 * @see Naipe
 * @see Baralho
 */

public class Carta {
    private Naipe naipe; // naipe da carta
    private int valor = 0; // o valor da carta

    /**
     * Construtor básico para a Carta
     *
     * @param n Naipe
     * @param v Valor (0 a 12)
     */
    public Carta(Naipe n, int v){
        setNaipe(n);
        setValor(v);
    }

    /**
     * Define o Naipe da carta
     *
     * @param oNaipe Naipe a definir
     */
    private void setNaipe(Naipe oNaipe){
        naipe = oNaipe; }

    /**
     * Devolve o naipe da carta como uma constante do enumerador Naipe.
     *
     * @return O naipe da carta.
     * */
    public Naipe getNaipe(){
        return naipe; }

    /**
     * Define o valor (nº) da carta
     *
     * @param oValor valor da carta
     */
    private void setValor (int oValor){
        valor = oValor; }

    /**
     * Devolve o valor da carta como inteiro.
     *
     * @return o valor da carta.
     */
    public int getValor(){
        return valor; }

    /**
     * Devolve as informações sobre a carta numa String
     *
     * @return as informações da Carta
     */
    public String toString(){
        char naipeCar = ' '; // Versão com caracter para o naipe
        switch (naipe) {
            case ESPADAS:
                naipeCar = 'E';
                break;
            case PAUS:
                naipeCar = 'P';
                break;
            case COPAS:
                naipeCar = 'C';
                break;
            case OUROS:
                naipeCar = 'O';
                break;
        }
        String valorString = "" + valor;
        return "[" + naipeCar + " " + valorString + "]";
    }
}
