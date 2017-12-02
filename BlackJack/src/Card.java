public class Card implements Comparable {
    //Symbolic constants

    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;
    int Rank;
    int Suit;
    boolean Faceup;


    /**
     * Construct a card of the given rank, suit and
     * whether it is faceup or facedown.  The rank is
     * an integer from 2 to 14. Numbered cards (2 to 10)
     * have a rank equal to their number. Jack, Queen,
     * King and Ace have the ranks 11, 12, 13, and 14
     * respectively.  The suit is an integer from
     * 0 to 3 for Clubs, Diamonds, Hearts and Spades
     * respectively.
     * @param rank
     * @param suit
     * @param faceUp
     */
    public Card(int rank, int suit, boolean faceUp) {
        Rank=rank;
        Suit=suit;
        Faceup=faceUp;
         
        //FIX THIS (fixed)
    }

    /**
     * @return the faceUp
     */
    public boolean isFaceUp() {
        return Faceup; //FIX THIS (fixed)
    }

    /**
     * @param faceUp the faceUp to set
     */
    public void setFaceUp(boolean faceUp) {
    Faceup=faceUp;
        //FIX THIS (fixed)
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return Rank; //FIX THIS (fixed)
    }

    /**
     * @return the suit
     */
    public int getSuit() {
        return Suit;//FIX THIS (fixed)
    }

    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof Card)) {
            return false;
        }
        Card c = (Card) ob;
        if (this.getRank()==c.getRank() && this.getSuit()==c.getSuit())
        {return true;}
        else
        {return false;}//FIX THIS (fixed)
    }

    @Override
    public int hashCode() {//DO NOT MODIFY
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }

    public int compareTo(Object obj) {//DO NOT MODIFY
        return compareTo((Card) obj);
    }

    public int compareTo(Card c) {
       if (this.getRank()<c.getRank())
         {return -1;}
       else
         {if (this.getRank()>c.getRank()) 
            {return +1;}
         else
            {
            if (this.getSuit()<c.getSuit())
                {return -1;}
            else
                {if (this.getSuit()>c.getSuit())
                     {return +1;}
                else
                     {return 0;}
                }
            }
         }
       //FIX THIS (fixed)
    }

    /**
     * Return the rank as a String.  For example,
     * the 3 of Hearts produces the String "3".
     * The King of Diamonds produces the
     * String "King".
     * @return the rank String
     */
    public String getRankString() {
        if (this.getRank()<= 10)
             {return ""+this.getRank();}
        else
             {if (this.getRank()==11)
                  {return "Jack";} 
             else 
                  {if(this.getRank()==12)
                     {return "Queen";}
                  else 
                     {if(this.getRank()==13)
                         {return "King";}
                     else
                         {return "Ace";}
                     } 
                  }
             }
                
                //FIX THIS(fixed)
    
    }

    /**
     * Return the suit as a String: "Clubs",
     * "Diamonds", "Hearts" or "Spades".
     * @return the suit String
     */
    public String getSuitString() {
        if (this.getSuit()==0)
          {return"Clubs";}
        else 
          {if (this.getSuit()==1)
              {return"Diamonds";}
          else
              {if (this.getSuit()==2)
                  {return"Hearts";}
               else 
                  {return"Spades";}
              }
          }
        //FIX THIS(fixed)
    }

    /**
     * Return "?" if the card is facedown; otherwise,
     * the rank and suit of the card.
     * @return the String representation
     */
    @Override
    public String toString() {
       if (this.Faceup==false)
         {return "?";}
       else
         {return""+this.getRankString()+this.getSuitString();}
       //FIX THIS
    }

    public static void main(String[] args) {
        //Create 5 of clubs
        Card club5 = new Card(5, 0, true);
        System.out.println("club5: " + club5);
        Card spadeAce = new Card(14, SPADE, true);
        System.out.println("spadeAce: " + spadeAce);
        System.out.println("club5 compareTo spadeAce: " +
                club5.compareTo(spadeAce));
        System.out.println("club5 compareTo club5: " +
                club5.compareTo(club5));
        System.out.println("club5 equals spadeAce: " +
                club5.equals(spadeAce));
        System.out.println("club5 equals club5: " +
                club5.equals(club5));
    }
}


