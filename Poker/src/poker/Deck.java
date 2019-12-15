package poker;

import java.security.SecureRandom; 
import java.util.Arrays;

  /**
     * Korttipakasta vastaava luokka, joka huolehtii korttien sekoituksesta ja jaosta.  
     */

public class Deck {
    
private Cards[] cardDeck; 
	private int currentCard = 0; 
	private static final int NUMBER_OF_CARDS = 52; //Korttien määrä
	private static final SecureRandom randomNumbers = new SecureRandom(); //Korttien satunnaisuus
	
	public Deck() {
		
		cardDeck = new Cards[NUMBER_OF_CARDS];
		String[] suitArray = {"♥", "♠", "♦", "♣"}; //Maat
		String[] faceArray = {"Ässä", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jätkä", "Kuningatar", "Kuningas"};//Arvot
		
	    for (int suit = 0; suit < suitArray.length; suit++) {
	        for (int face = 0; face < faceArray.length; face++) {
	            cardDeck[currentCard] = new Cards(faceArray[face], suitArray[suit]);
	            currentCard++;
	        }
	    }
	}
     
	public void shuffle() { //Korttien sekoitus
		  currentCard = 0;
		  for(int first = 0; first < cardDeck.length; first++) {
				
			  int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
				
			  Cards hold = cardDeck[first];
			  cardDeck[first] = cardDeck[second];
			  cardDeck [second] = hold;  
			}
		
	}
	public Cards deal() { //Korttien jako
		if(currentCard < cardDeck.length)
			return cardDeck[currentCard++];
		else
			return null;
		
	}	
        
        //Getterit 
        
	public Cards[] getCardDeck() { //Hakee pakan
		return cardDeck;
	
	}
	public int getCurrentCard() { //Hakee kortin
		return currentCard;
	
	}
	public static int getNumberOfCards() { //Hakee korttien lukumäärän
		return NUMBER_OF_CARDS;
	
	}
	public static SecureRandom getRandomNumbers() { //Luo satunnaiset arvot korteille
		return randomNumbers;
	
	}
        
        //Setterit
        
	public void setCardDeck(Cards[] cardDeck) { //Asettaa pakan
		this.cardDeck = cardDeck;
	
	}
	public void setCurrentCard(int currentCard) { //Asettaa kortin
		
		if(currentCard >= 0)
			this.currentCard = currentCard;
		else
			this.currentCard = 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(cardDeck);
	}

}
