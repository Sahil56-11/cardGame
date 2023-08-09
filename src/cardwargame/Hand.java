/**
 * This class will represent a hand of cards.
 */
package cardwargame;

import java.util.ArrayList;
import java.util.List;

public class Hand 
{
    /**
     * cardsOfGame is a list that will be used to store the cards of the game
     */
    private final List<CardGame> cardsOfGame;

    /**
     * Constructor of Hand class that will initialize the cardsOfGame
     */
    Hand() 
    {
        this.cardsOfGame = new ArrayList<>();
    }

    /**
     * @param otherCards is object of Hand
     */
    public void mergeCardsInHand(Hand otherCards) 
    {
        for (CardGame cardGame : otherCards.cardsOfGame) 
        {
            this.addCardToBottom(cardGame);
        }
    }

    /**
     * @param numberOfCards is the number of cards that will be removed from the deck
     * 
     * @return cards as a List Type
     */
    public List<CardGame> getCards(int numberOfCards) 
    {
        if (numberOfCards > this.handSize()) 
        {
            return null;
        }

        List<CardGame> openCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) 
        {
            openCards.add(this.cardsOfGame.remove(this.handSize() - 1));
        }

        return openCards;
    }

    /**
     * @param cardGame is object of CardGame
     */
    public void addCardToTop(CardGame cardGame) 
    {
        if (cardGame == null) 
        {
            throw new NullPointerException("Null cards cannot be added to deck of cards.");
        }
        cardsOfGame.add(cardGame);
    }

    /**
     * This function will add a card at the top of deck.
     * 
     * @param cardsOfGame is object of List
     */
    public void addCardsToTop(List<CardGame> cardsOfGame) 
    {
        this.cardsOfGame.addAll(cardsOfGame);
    }

    /**
     * This function will add a card at the bottom of deck.
     * 
     * @param cardGame is object of CardGame
     */
    public void addCardToBottom(CardGame cardGame) 
    {
        cardsOfGame.add(0, cardGame);
    }

    /**
     * This function will remove a card from the top of deck.
     * 
     * @return card from the end of the arrayList
     */
    public CardGame removeDeckTopCard() 
    {
        if (handSize() < 1) 
        {
            return null;
        }
        
        return cardsOfGame.remove(handSize() - 1);
    }

    /**
     * This function will remove a card from the bottom of deck.
     * 
     * @return card from the start of the arrayList
     */
    public CardGame removeDeckBottomCard() 
    {
        if (handSize() < 1) 
        {
            return null;
        }

        return cardsOfGame.remove(0);
    }

    /**
     * @return how many cards left in the deck
     */
    public int handSize() 
    {
        return cardsOfGame.size();
    }

}