/**
 * This enum will represent a rank of a card
 */
package cardwargame;

public enum Rank 
{
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    /**
     * nameOfRank is a string that will be used to display the name of the rank
     */
    private final String nameOfRank;

    /**
     * valueOfRank is a integer that will be used to display the value of the rank
     */
    private final int valueOfRank;

    /**
     * @param nameOfRank  is a string that will be used to set the name of the rank
     * @param valueOfRank is a integer that will be used to set the value of the rank
     */
    Rank(String nameOfRank, int valueOfRank) 
    {
        this.nameOfRank = nameOfRank;
        this.valueOfRank = valueOfRank;
    }

    /**
     * Getter method for name of a rank
     * 
     * @return name of a rank
     */
    public String getNameOfRank() 
    {
        return this.nameOfRank;
    }

    /**
     * Getter method for value of a rank
     * 
     * @return value of a rank
     */
    public int getValueOfRank() 
    {
        return this.valueOfRank;
    }

    /**
     * @return name of a rank
     */
    @Override
    public String toString() 
    {
        if (this.getValueOfRank() > 10) 
        {
            return this.getNameOfRank().substring(0, 1);
        }
        
        return String.valueOf(this.getValueOfRank());
    }

}
