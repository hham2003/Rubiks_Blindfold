import java.util.HashMap;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Generates a series of letters used to solve the corners of the cube while
 *  blindfolded
 *
 *  @author Henry Ham
 *  @version (2021.12.11)
 */
public class BlindCorners
{
    //~ Fields ................................................................
    private CubeModel cube;
    private ScrambleScript script;
    private String sequence;
    private String nextLetter;
    private int[] currentCorner;
    private Map<int[], String> corners;
    private Map<String, int[]> cornerLocations;
    private String[][] cornerTrios;
    private int[] F;
    private int[] B;
    private int[] R;
    private int[] L;
    private int[] U;
    private int[] D;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created BlindCorners object.
     * 
     * @param scrambledCube Scrambled cube to generate a sequence for
     */
    public BlindCorners(CubeModel scrambledCube)
    {
        super();
        /*# Do any work to initialize your class here. */
        sequence = "";
        cube = scrambledCube;
        F = cube.getF();
        R = cube.getR();
        B = cube.getB();
        L = cube.getL();
        U = cube.getU();
        D = cube.getD();
        currentCorner = new int[]{L[0], B[2], U[0]};
        corners = new HashMap<>();
        corners.put(new int[]{0, 4, 5}, "A");
        corners.put(new int[]{0, 5, 3}, "B");
        corners.put(new int[]{0, 3, 2}, "C");
        corners.put(new int[]{0, 2, 4}, "D");
        corners.put(new int[]{4, 5, 0}, "E");
        corners.put(new int[]{4, 0, 2}, "F");
        corners.put(new int[]{4, 2, 1}, "G");
        corners.put(new int[]{4, 5, 1}, "H");
        corners.put(new int[]{2, 4, 0}, "I");
        corners.put(new int[]{2, 0, 3}, "J");
        corners.put(new int[]{2, 3, 1}, "K");
        corners.put(new int[]{2, 1, 4}, "L");
        corners.put(new int[]{3, 2, 0}, "M");
        corners.put(new int[]{3, 0, 5}, "N");
        corners.put(new int[]{3, 1, 5}, "O");
        corners.put(new int[]{3, 1, 2}, "P");
        corners.put(new int[]{5, 3, 0}, "Q");
        corners.put(new int[]{5, 0, 4}, "R");
        corners.put(new int[]{5, 1, 4}, "S");
        corners.put(new int[]{5, 3, 1}, "T");
        corners.put(new int[]{1, 4, 2}, "U");
        corners.put(new int[]{1, 2, 3}, "V");
        corners.put(new int[]{1, 5, 3}, "W");
        corners.put(new int[]{1, 4, 5}, "X");
        cornerLocations = new HashMap<>();
        cornerLocations.put("A", new int[]{U[0], L[0], B[2]});
        cornerLocations.put("B", new int[]{U[2], B[0], R[2]});
        cornerLocations.put("C", new int[]{U[8], R[0], F[2]});
        cornerLocations.put("D", new int[]{U[6], F[0], L[2]});
        cornerLocations.put("E", new int[]{L[0], B[2], U[0]});
        cornerLocations.put("F", new int[]{L[2], U[6], F[0]});
        cornerLocations.put("G", new int[]{L[8], F[6], D[0]});
        cornerLocations.put("H", new int[]{L[6], D[6], B[8]});
        cornerLocations.put("I", new int[]{F[0], L[2], U[6]});
        cornerLocations.put("J", new int[]{F[2], U[8], R[0]});
        cornerLocations.put("K", new int[]{F[8], R[6], D[2]});
        cornerLocations.put("L", new int[]{F[6], D[0], L[8]});
        cornerLocations.put("M", new int[]{R[0], F[2], U[8]});
        cornerLocations.put("N", new int[]{R[2], U[2], B[0]});
        cornerLocations.put("O", new int[]{R[8], B[6], D[8]});
        cornerLocations.put("P", new int[]{R[6], D[2], F[8]});
        cornerLocations.put("Q", new int[]{B[0], R[2], U[2]});
        cornerLocations.put("R", new int[]{B[2], U[0], L[0]});
        cornerLocations.put("S", new int[]{B[8], L[6], D[6]});
        cornerLocations.put("T", new int[]{B[6], D[8], R[8]});
        cornerLocations.put("U", new int[]{D[0], L[8], F[6]});
        cornerLocations.put("V", new int[]{D[2], F[8], R[6]});
        cornerLocations.put("W", new int[]{D[8], R[8], B[6]});
        cornerLocations.put("X", new int[]{D[6], B[8], L[6]});
        cornerTrios = new String[7][3];
        cornerTrios[0][0] = "B";
        cornerTrios[0][1] = "N";
        cornerTrios[0][2] = "Q";
        cornerTrios[1][0] = "C";
        cornerTrios[1][1] = "M";
        cornerTrios[1][2] = "J";
        cornerTrios[2][0] = "D";
        cornerTrios[2][1] = "I";
        cornerTrios[2][2] = "F";
        cornerTrios[3][0] = "U";
        cornerTrios[3][1] = "L";
        cornerTrios[3][2] = "G";
        cornerTrios[4][0] = "V";
        cornerTrios[4][1] = "K";
        cornerTrios[4][2] = "P";
        cornerTrios[5][0] = "W";
        cornerTrios[5][1] = "O";
        cornerTrios[5][2] = "T";
        cornerTrios[6][0] = "X";
        cornerTrios[6][1] = "S";
        cornerTrios[6][2] = "H";
    }


    //~ Methods ...............................................................
    /**
     * Print the sequence for corners
     */
    public void printSeq()
    {
        for (int i = 0; i < 20; i++)
        {
            this.getNextCorner();
        }
        System.out.println(script.makeItEasier());
        this.fixEnding();
        this.removeSolvedCorners();
        System.out.println(sequence);
    }
    /**
     * Get the next letter for the sequence
     * 
     * @return String value
     */
    public String getNextLetter()
    {
        return nextLetter;
    }
    /**
     * Get the sequence for the corners
     * 
     * @return String value
     */
    public String getSequence()
    {
        return sequence;
    }
    /**
     * Get the scrambled cube being used
     * 
     * @return CubeModel object
     */
    public CubeModel getCube()
    {
        return cube;
    }
    /**
     * Get the next corner in the sequence
     */
    public void getNextCorner()
    {
        for (int[] piece : corners.keySet())
        {
            if (piece[0] == currentCorner[0]
                && (piece[1] == currentCorner[1] || piece[1] == currentCorner[2])
                && (piece[2] == currentCorner[2] || piece[2] == currentCorner[1]))
            {
                if (corners.get(piece) != "A"
                    && corners.get(piece) != "E"
                    && corners.get(piece) != "R")
                {
                    nextLetter = corners.get(piece);
                    if (!this.checkForRepeat())
                    {
                        sequence += nextLetter;
                        this.updateCurrentCorner();
                        break;
                    }
                    else
                    {
                        sequence += nextLetter;
                        if (!this.findNewCorner())
                        {
                            this.findNewCorner();
                            this.updateCurrentCorner();
                        }
                    }
                }
                else
                {
                    this.findNewCorner();
                    this.updateCurrentCorner();
                }
            }
        }
    }
    /**
     * Update the current corner to the new corner
     */
    public void updateCurrentCorner()
    {
        for (String letter : cornerLocations.keySet())
        {
            if (letter.equals(nextLetter))
            {
                currentCorner = cornerLocations.get(letter);
            }
        }
    }
    /**
     * Find a new, unused corner to continue the sequence
     * 
     * @return Boolean value
     */
    public boolean findNewCorner()
    {
        boolean cornersDone = false;
        List seq = new ArrayList<String>();
        for (int i = 0; i < sequence.length(); i++)
        {
            seq.add(sequence.substring(i, i + 1));
        }
        if (!seq.contains("B") && !seq.contains("N") && !seq.contains("Q"))
        {
            nextLetter = "B";
        }
        else if (!seq.contains("C") && !seq.contains("J") && !seq.contains("M"))
        {
            nextLetter = "C";
        }
        else if (!seq.contains("D") && !seq.contains("I") && !seq.contains("F"))
        {
            nextLetter = "D";
        }
        else if (!seq.contains("U") && !seq.contains("L") && !seq.contains("G"))
        {
            nextLetter = "U";
        }
        else if (!seq.contains("V") && !seq.contains("K") && !seq.contains("P"))
        {
            nextLetter = "V";
        }
        else if (!seq.contains("W") && !seq.contains("O") && !seq.contains("T"))
        {
            nextLetter = "W";
        }
        else if (!seq.contains("X") && !seq.contains("S") && !seq.contains("H"))
        {
            nextLetter = "X";
        }
        else
        {
            cornersDone = true;
        }
        return cornersDone;
    }
    /**
     * Check if the current corner has already been used in the sequence
     * 
     * @return Boolean value
     */
    public boolean checkForRepeat()
    {
        boolean result = false;
        int index = -1;
        for (int i = 0; i < cornerTrios.length; i++)
        {
            for (int j = 0; j < cornerTrios[i].length; j++)
            {
                if (nextLetter.equals(cornerTrios[i][j]))
                {
                    index = i;
                    break;
                }
            }
        }
        List trio = new ArrayList<String>();
        for (int i = 0; i < cornerTrios[index].length; i++)
        {
            trio.add(cornerTrios[index][i]);
        }
        for (int i = 0; i < sequence.length(); i++)
        {
            String oneLetter = sequence.substring(i, i + 1);
            if (trio.contains(oneLetter))
            {
                result = true;
            }
        }
        return result;
    }
    /**
     * Remove same-letter pairs from the sequence that indicate a pre-solved
     * corner
     */
    public void removeSolvedCorners()
    {
        List<String> doubles = new ArrayList<>();
        for (int i = 1; i < sequence.length(); i++)
        {
            String first = sequence.substring(i - 1, i);
            String second = sequence.substring(i, i + 1);
            if (first.equals(second))
            {
                String both = first + second;
                doubles.add(both);
            }
        }
        for (int i = 0; i < doubles.size(); i++)
        {
            String pair = doubles.get(i);
            sequence = sequence.replace(pair, "");
        }
    }
    /**
     * Remove repeated letters from the end of the sequence
     */
    public void fixEnding()
    {
        String repeater = sequence.substring(sequence.length() - 1,
            sequence.length());
        String newSeq = "";
        for (int i = sequence.length() - 1; i >= 0; i--)
        {
            String check = sequence.substring(i - 1, i);
            if (!check.equals(repeater))
            {
                String redundant = sequence.substring(i + 1);
                newSeq = sequence.replace(redundant, "");
                break;
            }
        }
        boolean heChillin = false;
        String allButLast = newSeq.substring(0, newSeq.length() - 1);
        String[] trio = new String[3];
        for (int i = 0; i < cornerTrios.length; i++)
        {
            for (int j = 0; j < cornerTrios[i].length; j++)
            {
                if (repeater.equals(cornerTrios[i][j]))
                {
                    trio = cornerTrios[i];
                }
            }
        }
        for (int i = 0; i < trio.length; i++)
        {
            if (allButLast.contains(trio[i]))
            {
                heChillin = true;
            }
        }
        if (!heChillin)
        {
            newSeq = allButLast;
        }
        sequence = newSeq;
    }
}
