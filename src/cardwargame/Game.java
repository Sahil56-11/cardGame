/**
 * This class will represent a game sequence of the game
 */
package cardwargame;

import java.util.List;
import java.util.Scanner;

public class Game 
{
    /**
     * gameResult is a object of Result class
     */
    private static final Result gameResult = new Result();

    /**
     * deck is a object of Deck class
     */
    private Deck deck;

    /**
     * playerOne is a object of Player class
     */
    private Player playerOne;

    /**
     * playerTwo is a object of Player class
     */
    private Player playerTwo;

    /**
     * This function will start the game
     */
    public void gamePlay() 
    {
        // Print welcome message
        gameResult.welcome();

        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);

        // Take input name of player one
        System.out.print("Enter first player name : ");
        String playerOneName = input.nextLine();
        this.playerOne = new Player(playerOneName);

        // Take input name of player two
        System.out.print("\nEnter second player name : ");
        String playerTowName = input.nextLine();
        this.playerTwo = new Player(playerTowName);

        // Start the game
        deck = new Deck();

        // Shuffle the deck
        deck.shuffleDeck();

        // Set hand of player one
        playerOne.setHand(new Hand());

        // Set hand of player two
        playerTwo.setHand(new Hand());

        // Deal cards to player one
        dealCardsInGame(playerOne.getHand());

        // Deal cards to player two
        dealCardsInGame(playerTwo.getHand());

        // Print header of the game
        gameResult.Header(playerOne, playerTwo);

        // maxRounds is a integer that will be used to store the maximum number of
        // rounds
        int maxRounds = 26;
        Player winnerPlayer = null;

        // Check if there is a war
        while (isWar(playerOne, playerTwo, null)) 
        {
            maxRounds--;
            if (playerOne.getHand().handSize() == 0) 
            {
                winnerPlayer = playerTwo;
                break;
            } 
            else if (playerTwo.getHand().handSize() == 0) 
            {
                winnerPlayer = playerOne;
                break;
            }

            if (maxRounds < 0) 
            {
                break;
            }
        }

        // Check if there is a winner
        if (winnerPlayer != null) 
        {    
        }

        // Check if there is a draw
        else if (playerOne.getHand().handSize() > playerTwo.getHand().handSize()) 
        {
            winnerPlayer = playerOne;
        }

        // Check if there is a draw
        else if (playerTwo.getHand().handSize() > playerOne.getHand().handSize()) 
        {
            winnerPlayer = playerTwo;
        }

        // Declare the draw of the game
        else 
        {
            gameResult.declareDraw();
            return;
        }

        // Declare the winner of the game
        gameResult.declareWinner(winnerPlayer);
    }

    /**
     * This function will deal cards in the game
     * 
     * @param hand
     */
    public void dealCardsInGame(Hand hand) 
    {
        for (int i = 0; i < 26; i++) 
        {
            hand.addCardToTop(deck.dealTopCard());
        }
    }

    /**
     * This function will check if there is a war
     * 
     * @param playerOne
     * @param playerTwo
     * @param hand
     * 
     * @return true if there is a war
     */
    public boolean isWar(Player playerOne, Player playerTwo, Hand hand) 
    {
        CardGame playerOneFaceUpCard = playerOne.getHand().removeDeckTopCard();

        // Check if player one face up card is null
        if (playerOneFaceUpCard == null) 
        {
            return false;
        }

        CardGame playerTwoFaceUpCard = playerTwo.getHand().removeDeckTopCard();

        // Check if player two face up card is null
        if (playerTwoFaceUpCard == null) 
        {
            return false;
        }

        // Check if hand is null
        if (hand == null) 
        {
            hand = new Hand();
        }

        hand.addCardToTop(playerOneFaceUpCard);
        hand.addCardToTop(playerTwoFaceUpCard);

        int resultRound = playerOneFaceUpCard.compareTo(playerTwoFaceUpCard);
        switch (resultRound) 
        {
            // Check if there is a war
            case 0:
                gameResult.declareWarRound();

                List<CardGame> warPlayerOnePan = playerOne.getHand().getCards(3);
                if (warPlayerOnePan == null) 
                {
                    return false;
                }
                hand.addCardsToTop(warPlayerOnePan);

                List<CardGame> warPlayerTwoPan = playerTwo.getHand().getCards(3);
                if (warPlayerTwoPan == null) 
                {
                    return false;
                }
                hand.addCardsToTop(warPlayerTwoPan);

                return isWar(playerOne, playerTwo, hand);

            // Check if there is a winner
            case 1:
                playerOne.getHand().mergeCardsInHand(hand);
                gameResult.declareRoundWinner(playerOne, playerOneFaceUpCard, playerTwo, playerTwoFaceUpCard,
                        playerOne.getNameOfPlayer());
                break;

            // Check if there is a winner
            case -1:
                playerTwo.getHand().mergeCardsInHand(hand);
                gameResult.declareRoundWinner(playerOne, playerOneFaceUpCard, playerTwo, playerTwoFaceUpCard,
                        playerTwo.getNameOfPlayer());
                break;
        }

        return true;
    }
}