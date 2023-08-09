/**
 * This enum will represent a suit of a card
 */
package cardwargame;

public enum Suit 
{
    HEARTS("Heart", "H"),
    SPADES("Spade", "S"),
    DIAMONDS("Diamond", "D"),
    CLUBS("Club", "C");

    /**
     * nameOfSuit is a string that will be used to display the name of the suit
     */
    private final String nameOfSuit;

    /**
     * symbolOfSuit is a string that will be used to display the symbol of the suit
     */
    private final String symbolOfSuit;

    /**
     * @param nameOfSuit   is a string that will be used to set the name of the suit
     * @param symbolOfSuit is a string that will be used to set the symbol of the suit
     */
    Suit(String nameOfSuit, String symbolOfSuit) 
    {
        this.nameOfSuit = nameOfSuit;
        this.symbolOfSuit = symbolOfSuit;
    }

    /**
     * Getter method for symbol of a suit
     * 
     * @return symbol of a suit
     */
    public String getSymbolOfSuit() 
    {
        return this.symbolOfSuit;
    }

    /**
     * Getter method for name of a suit
     * 
     * @return name of a suit
     */
    public String getNameOfSuit() 
    {
        return this.nameOfSuit;
    }

    /**
     * @return symbol of a suit
     */
    @Override
    public String toString() 
    {
        return this.getSymbolOfSuit();
    }

}
