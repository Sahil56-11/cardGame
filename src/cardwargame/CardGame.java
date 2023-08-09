/**
 * This class will represent a single card of cards. In our game War will starts
 */
package cardwargame;

import java.util.Objects;

public class CardGame implements Comparable<CardGame> 
{
    /**
     * cardOfGame is a string that will be used to display the card in the game
     */
    private final String cardOfGame;

    /**
     * suit is a Enum type that will be used to display the suit of the card in the
     * game
     */
    private final Suit suit;

    /**
     * rank is a Enum type that will be used to display the rank of the card in the
     * game
     */
    private final Rank rank;

    /**
     * @param rank is object of Rank
     * @param suit is object of Suit
     */
    CardGame(Rank rank, Suit suit) 
    {
        // Check if rank or suit is null
        if (rank == null || suit == null) 
        {
            throw new NullPointerException();
        }
        this.suit = suit;
        this.rank = rank;
        this.cardOfGame = String.format("%s%s", rank.toString(), suit.getSymbolOfSuit());
    }

    /**
     * @return rank of a card object
     */
    public Rank getRankOfCard() 
    {
        return this.rank;
    }

    /**
     * @return value of a card object
     */
    public String getValueOfRank() 
    {
        return this.rank.toString();
    }

    /**
     * @return suit name of a card object
     */
    public Suit getSuitName() 
    {
        return this.suit;
    }

    /**
     * @return suit symbol of a card object
     */
    public String getSuitSymbol() 
    {
        return this.suit.getSymbolOfSuit();
    }

    /**
     * @return points of a card object
     */
    public Integer getPointsOfCard() 
    {
        return this.rank.getValueOfRank();
    }

    /**
     * @return full name of a card object
     */
    public String getInfoOfCard() 
    {
        return this.cardOfGame;
    }

    /**
     * @param cardGame is object of CardGame
     * 
     * @return true if value of two different card's rank are equal
     */
    @Override
    public int compareTo(CardGame cardGame) 
    {
        return this.getPointsOfCard().compareTo(cardGame.getPointsOfCard());
    }

    /**
     * @param cardGame is object of CardGame
     * 
     * @return true if two different card's suit are equal
     */
    public boolean checkIsSameSuit(CardGame cardGame) 
    {
        boolean isSameSuit = this.suit.equals(cardGame.suit);

        return isSameSuit;
    }

    /**
     * @param cardGame is object of CardGame
     * 
     * @return true if two different card's rank are equal
     */
    public boolean checkIsSameRank(CardGame cardGame) 
    {
        boolean isSameRank = this.rank.equals(cardGame.rank);

        return isSameRank;
    }

    /**
     * @param ob is object of CardGame
     * 
     * @return true if two different card's rank & suit are equal
     */
    @Override
    public boolean equals(Object ob) 
    {
        if (ob == null) 
        {
            return false;
        }
        if (!CardGame.class.isAssignableFrom(ob.getClass())) 
        {
            return false;
        }
        final CardGame additional = (CardGame) ob;

        return this.suit == additional.suit && this.rank == additional.rank;
    }

    /**
     * @return hash value of a card object
     */
    @Override
    public int hashCode() 
    {
        int hashValue = 3;
        hashValue = 89 * hashValue + Objects.hashCode(this.rank);
        hashValue = 89 * hashValue + Objects.hashCode(this.suit);

        return hashValue;
    }

    /**
     * @return full name of a card object
     */
    @Override
    public String toString() 
    {
        String nameOfRank = this.rank.getNameOfRank();
        String nameOfSuit = this.suit.getNameOfSuit();
        String fullCardName = nameOfRank + " of " + nameOfSuit;
        
        return fullCardName;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Game gameObj = new Game();
        gameObj.gamePlay();
    }
}
