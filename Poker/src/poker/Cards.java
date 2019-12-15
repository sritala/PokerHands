package poker;

public class Cards {

    /**
     * Korteista vastaava luokka. 
     * Kortit sisältävät maan sekä arvon. 
     */
    
    private final String face; //Arvot(Ässä, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jätkä, Kuningatar, Kuningas)
    private final String suit; //Maat (hertta, risti, ruutu, pata)

    public Cards(String face, String suit) {

        this.face = face;
        this.suit = suit;
    }

    public String getFace() {

        return face;
    }

    public String getSuit() {

        return suit;
    }

    //Palauttaa arvon sekä maan
    @Override
    public String toString() {
        return face + suit;

    }
}
