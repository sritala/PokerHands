
package poker;

import java.util.Arrays;

  /**
     * Käsien jakamisesta vastaava luokka, joka samalla arvio pelaajien kädet. 
     * Max 5 korttia per käsi.
     */

public class HandDealer {
   
	private Cards[] hand;
	private Deck cardDeck;
	private int[] suits;
	private int[] faces;
	
	public HandDealer() {
		cardDeck = new Deck();
		cardDeck.shuffle();
		suits = new int[5];
		faces = new int[5];	
	}
        
        //Korttien jako 
	public void deal() {
		resetCounters();
		hand = new Cards[5];
		for(int cards = 0; cards < hand.length; cards++)
			hand[cards] = cardDeck.deal();
		
	}
        
        //Käsien arviointi
	public String evaluateHand() {
		for(int count = 0; count < hand.length; count++) {
			Cards card = hand[count];
			switch (card.getSuit()) {
			case "♥":
				suits[count] = 1;
				break;
			case "♠":
				suits[count] = 2;
				break;
			case "♦":
				suits[count] = 3;
				break;
			case "♣":
				suits[count] = 4;
				break;
			default:
				suits[count] = 0;
				
			}
			
			switch (card.getFace()) {
			case "Ässä":
				faces[count] = 1;
				break;
			case "2":
				faces[count] = 2;
				break;
			case "3":
				faces[count] = 3;
				break;
			case "4":
				faces[count] = 4;
				break;
			case "5":
				faces[count] = 5;
				break;
			case "6":
				faces[count] = 6;
				break;
			case "7":
				faces[count] = 7;
				break;
			case "8":
				faces[count] = 8;
				break;
			case "9":
				faces[count] = 9;
				break;
			case "10":
				faces[count] = 10;
				break;
			case "Jätkä":
				faces[count] = 11;
				break;
			case "Kuningatar":
				faces[count] = 12;
				break;
			case "Kuningas":
				faces[count] = 13;
				break;
			default:
				faces[count] = 0;
				
			}
		}
                //Järjestää maat ja arvot sekä palauttaa parin, kaksi paria, värin tai suoran.   
                
		Arrays.sort(suits);
		Arrays.sort(faces);
		
		String evaluations = "";
		if(pair() == true)
			evaluations = "Pari";
		
		if(twoPair() == true)
			evaluations = "Kaksi paria";
		
		if(flush() == true)
			evaluations = "Väri";
		
		if(stright() == true)
			evaluations = "Suora";
                
		return evaluations;
                	
	}
        
        //Yksi pari
	private boolean pair() {
		
		if(faces[0] == faces[1]
			|| faces[1] == faces[2]
			|| faces[2] == faces[3]
			|| faces[3] == faces[4])
			
			return true;
		else
			return false;
		
	}
        
        //Kaksi paria 
	private boolean twoPair() {
		if(faces[0] == faces[1]
			&& faces[2] == faces[3])
			return true;
		
		else if(faces[1] == faces[2]
				&& faces[3] == faces[4])
				return true;
		
			else if (faces[0] == faces[1]
					&& faces[3] == faces[4])
					return true;
				else 
					return false;
		
	}
        //Väri
	private boolean flush() {
	
		if (suits[0] == suits[1] 
			&& suits[1] == suits[2]
            && suits[2] == suits[3]
            && suits[3] == suits[4])
			return true;
		
		else
			return false;
				
	}
        //Suora
	private boolean stright() {
		
		if(faces[0] + 1 == faces[1]
			&& faces[1] + 1 == faces[2]
			&& faces[2] + 1 == faces[3]
			&& faces[3] + 1 == faces[4])
			return true;
		else
			return false;
		
	}
        
        //Asettaa kortit
	private void resetCounters() {
		for(int count = 0; count < 5; count++) {
			suits[count] = 0;
			faces[count] = 0;
		}
		
	}
        
        //Getterit
	public Cards[] getHand() {
		return hand;
	
	}
        
	public Deck getCardDeck() {
		return cardDeck;
	
	}
        
	public int[] getSuits() {
		return suits;
	
	}
        
	public int[] getFaces() {
		return faces;
	
	}
        
        //Setterit
	public void setHand(Cards[] hand) {
		this.hand = hand;
	
	}
        
	public void setCardDeck(Deck cardDeck) {
		this.cardDeck = cardDeck;
	
	}
        
	public void setSuits(int[] suits) {
		this.suits = suits;
	
	}
        
	public void setFaces(int[] faces) {
		this.faces = faces;
	
	} 

        //Palauttaa kortit
	@Override
	public String toString() {
		return "Kortit = " + Arrays.toString(hand);
             
	}
	
}