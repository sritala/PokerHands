
package poker;

  /**
     * Pääohjelma metodi, joka huolehtii käsien tulostamisesta.  
     * HandDealer jakaa kolme kättä kolmelle pelaajalle.
     * Ohjelmassa on seuraavat yhdistelmät: pari, kaksi paria, suora sekä väri.
     */

public class Poker {

	public static void main(String[] args) {
		
		HandDealer dealer = new HandDealer();				
				dealer.deal();
				System.out.println(dealer.toString());
				System.out.println("Ensimmäisen pelaajan käsi: " + dealer.evaluateHand());
				System.out.println();
                                
                                dealer.deal();
				System.out.println(dealer.toString());
				System.out.println("Toisen pelaajan käsi: " + dealer.evaluateHand());
				System.out.println();
			
                                dealer.deal();
				System.out.println(dealer.toString());
				System.out.println("Kolmannen pelaajan käsi: " + dealer.evaluateHand());
				System.out.println();
			}		
	}


