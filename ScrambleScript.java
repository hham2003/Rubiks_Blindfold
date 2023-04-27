import java.util.*;
import java.util.Random;
//-------------------------------------------------------------------------
/**
 *  Generate a new 20 move scramble
 *
 *  @author Henry Ham
 *  @version (2021.12.02)
 */
public class ScrambleScript
{
    //~ Fields ................................................................

    private List<String> scramble;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created ScrambleScript object.
     */
    public ScrambleScript()
    {
        super();
        /*# Do any work to initialize your class here. */
        scramble = new ArrayList<>();
    }


    //~ Methods ...............................................................
    /**
     * Turn list of moves into string
     * 
     * @return String value
     */
    public String makeItEasier()
    {
        String easier = "";
        for (int i = 0; i < scramble.size(); i++)
        {
            easier += scramble.get(i) + " ";
        }
        return easier;
    }
    /**
     * Get the generated scramble
     * 
     * @return String list
     */
    public List<String> getScramble()
    {
        this.fillScramble();
        return scramble;
    }
    /**
     * Randomly choose a move to add to the scramble
     * 
     * @return String value
     */
    public String getOneMove()
    {
        Random rand = new Random();
        int x = rand.nextInt(18);
        String theMove = "";
        if (x == 0)
        {
            
            theMove = "R";
        }
        else if (x == 1)
        {
            
            theMove = "R'";
        }
        else if (x == 2)
        {
            
            theMove = "L";
        }
        else if (x == 3)
        {
            
            theMove = "L'";
        }
        else if (x == 4)
        {
            
            theMove = "F";
        }
        else if (x == 5)
        {
            
            theMove = "F'";
        }
        else if (x == 6)
        {
            
            theMove = "B";
        }
        else if (x == 7)
        {
            
            theMove = "B'";
        }
        else if (x == 8)
        {
            
            theMove = "D";
        }
        else if (x == 9)
        {
            
            theMove = "D'";
        }
        else if (x == 10)
        {
            
            theMove = "U";
        }
        else if (x == 11)
        {
            
            theMove = "U'";
        }
        else if (x == 12)
        {
            
            theMove = "R2";
        }
        else if (x == 13)
        {
            
            theMove = "L2";
        }
        else if (x == 14)
        {
            
            theMove = "F2";
        }
        else if (x == 15)
        {
  
            theMove = "B2";
        }
        else if (x == 16)
        {
  
            theMove = "D2";
        }
        else
        {
 
            theMove = "U2";
        }
        return theMove;
    }
    /**
     * Fill the scramble with moves
     */
    public void fillScramble()
    {
        for (int i = 0; i < 20; i++)
        {
            scramble.add(this.getOneMove());
        }
        while (this.checkRepeat())
        {
            this.checkRepeat();
        }
    }
    /**
     * Print scramble to the system
     */
    public void printScramble()
    {
        this.fillScramble();
        System.out.println(this.makeItEasier());
    }
    /**
     * Check if there is a repeated value in the scramble
     * 
     * @return Boolean value
     */
    public boolean checkRepeat()
    {
        boolean hasRepeat = false;
        List<String> justLetters = new ArrayList<>();
        for (int i = 0; i < scramble.size(); i++)
        {
            String move = scramble.get(i);
            String letter = move.substring(0, 1);
            justLetters.add(letter);
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < justLetters.size() - 1; i++)
        {
            String first = justLetters.get(i);
            String second = justLetters.get(i + 1);
            if (first.equals(second))
            {
                indexes.add(i + 1);
                hasRepeat = true;
            }
        }
        if (hasRepeat)
        {
            for (int i = 0; i < indexes.size(); i++)
            {
                int index = indexes.get(i);
                scramble.remove(index);
                scramble.add(index, this.getOneMove());
            }
        }
        return hasRepeat;
    }
}
