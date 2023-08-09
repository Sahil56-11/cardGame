/**
 * This class will represent a player in the game
 */
package cardwargame;

public class Player 
{
    /**
     * hand is a object of Hand class
     */
    private Hand hand;

    /**
     * nameOfPlayer is a string that will be used to display the name of the player
     * in the game
     */
    private String nameOfPlayer;

    /**
     * @param nameOfPlayer is a string that will be used to set the name of the player
     */
    Player(String nameOfPlayer) 
    {
        this.nameOfPlayer = nameOfPlayer;
    }

    /**
     * Getter method for hand of a player
     * 
     * @return hand cards of a player
     */
    public Hand getHand() 
    {
        return this.hand;
    }

    /**
     * Setter method for hand of a player
     * 
     * @param hand is object of Hand
     */
    public void setHand(Hand hand) 
    {
        this.hand = hand;
    }

    /**
     * Getter method for name of a player
     * 
     * @return name of a player
     */
    public String getNameOfPlayer() 
    {
        return this.nameOfPlayer;
    }

    /**
     * Setter method for name of a player
     * 
     * @param nameOfPlayer is a string that will be used to set the name of the player
     */
    public void setNameOfPlayer(String nameOfPlayer) 
    {
        this.nameOfPlayer = nameOfPlayer;
    }

}
