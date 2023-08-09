/**
 * This class will represent a deck of cards.
 */
package cardwargame;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck 
{
    /**
     * cardsInGame is a list that will be used to store the cards of the game
     */
    private final List<CardGame> cardsInGame = new ArrayList<>();

    /**
     * Constructor of Deck class that will initialize the cardsInGame
     */
    Deck() 
    {
        generateDeck();
    }

    /**
     * This function will generate the deck of cards
     */
    private void generateDeck() 
    {
        for (Suit suit : Suit.values()) 
        {
            for (Rank rank : Rank.values()) 
            {
                cardsInGame.add(new CardGame(rank, suit));
            }
        }
    }

    /**
     * This function will shuffle the deck of cards
     */
    public void shuffleDeck() 
    {
        Collections.shuffle(this.cardsInGame);
    }

    /**
     * @return cards as a List Type
     */
    public List<CardGame> getCardsOfGame() 
    {
        return this.cardsInGame;
    }

    /**
     * @return size of the deck
     */
    public int getCountOfCards() 
    {
        return this.cardsInGame.size();
    }

    /**
     * @return true if deck is empty else false
     */
    public CardGame dealTopCard() 
    {
        int size = this.cardsInGame.size() - 1;

        return this.cardsInGame.remove(size);
    }

    /**
     * This function will add a card at the top of deck.
     * 
     * @param cardGame is object of CardGame
     * 
     * @return true if card is added else false
     */
    public void addCardToBottom(CardGame cardGame) 
    {
        this.cardsInGame.add(0, cardGame);
    }

    /**
     * @return arranged cards as a string
     */
    @Override
    public String toString() 
    {
        String arrangedCards = this.cardsInGame.toString();
        
        return arrangedCards;
    }
}
