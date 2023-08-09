/**
 * This class will represent the result of the game
 */
package cardwargame;

public class Result 
{
    /**
     * This function will print the welcome message
     */
    public void welcome() 
    {
        System.out.println("It is Card War Game" +
                "\n\tIt has been automated and will be played until the deck is empty" +
                "\n\tYou have to enter the names of two players who will be playing this game\n");
    }

    /**
     * This function will print the header of the game
     * 
     * @param playerOne
     * @param playerTwo
     */
    public void Header(Player playerOne, Player playerTwo) 
    {
        String roundWinner = "Round Winner";
        String handCards = "Hand Cards";
        System.out.printf("\n%-20s   %-20s %-20s   %-20s %-20s \n\n", playerOne.getNameOfPlayer(), handCards,
                playerTwo.getNameOfPlayer(), handCards, roundWinner);
    }

    /**
     * This function will print the winner of the round
     * 
     * @param playerOne
     * @param cardOne
     * @param playerTwo
     * @param cardTwo
     * @param winnerOfRound
     */
    public void declareRoundWinner(Player playerOne, CardGame cardOne, Player playerTwo,
            CardGame cardTwo,
            String winnerOfRound) 
            {
        System.out.printf("%-20s   %-20s %-20s   %-20s The winner of this round is %s.\n", cardOne.toString(),
                playerOne.getHand().handSize(), cardTwo.toString(), playerTwo.getHand().handSize(),
                winnerOfRound);
    }

    /**
     * This function will print the war message when there is a war
     */
    public void declareWarRound() 
    {
        System.out.println("\n\nIt's a WAR! Due to a tie, war was started again.\n\n");
    }

    /**
     * This function will print draw message when there is a draw
     */
    public void declareDraw() 
    {
        System.out.printf("\nIt's a draw. Let's play again.\n\n");
    }

    /**
     * This function will print the winner of the game
     * 
     * @param player
     */
    public void declareWinner(Player player) 
    {
        System.out.printf("\nWinner of the game is %s !\n\n", player.getNameOfPlayer());
    }

}
