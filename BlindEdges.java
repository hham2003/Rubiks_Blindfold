import java.util.HashMap;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Generates the letter sequence to solve the edges of the cube blindfolded 
 *  when the cube is scrambled
 *
 *  @author Henry Ham
 *  @version (2021.12.06)
 */
public class BlindEdges
{
    //~ Fields ................................................................
    private String sequence;
    private CubeModel cube;
    private Map<int[], String> edges;
    private String nextLetter;
    private Map<String, int[]> edgeLocations;
    private int[] currentEdge;
    private Map<String, String> edgePairs;
    private int[] F;
    private int[] B;
    private int[] R;
    private int[] L;
    private int[] U;
    private int[] D;
    private ScrambleScript script;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Blind object.
     * 
     * @param scrambledCube Scrambled cube to generate a sequence for
     */
    public BlindEdges(CubeModel scrambledCube)
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
        currentEdge = new int[]{U[5], R[1]};
        edges = new HashMap<>();
        edges.put(new int[]{0, 5}, "A");
        edges.put(new int[]{0, 3}, "B");
        edges.put(new int[]{0, 2}, "C");
        edges.put(new int[]{0, 4}, "D");
        edges.put(new int[]{4, 0}, "E");
        edges.put(new int[]{4, 2}, "F");
        edges.put(new int[]{4, 1}, "G");
        edges.put(new int[]{4, 5}, "H");
        edges.put(new int[]{2, 0}, "I");
        edges.put(new int[]{2, 3}, "J");
        edges.put(new int[]{2, 1}, "K");
        edges.put(new int[]{2, 4}, "L");
        edges.put(new int[]{3, 0}, "M");
        edges.put(new int[]{3, 5}, "N");
        edges.put(new int[]{3, 1}, "O");
        edges.put(new int[]{3, 2}, "P");
        edges.put(new int[]{5, 0}, "Q");
        edges.put(new int[]{5, 4}, "R");
        edges.put(new int[]{5, 1}, "S");
        edges.put(new int[]{5, 3}, "T");
        edges.put(new int[]{1, 2}, "U");
        edges.put(new int[]{1, 3}, "V");
        edges.put(new int[]{1, 5}, "W");
        edges.put(new int[]{1, 4}, "X");
        edgeLocations = new HashMap<>();
        edgeLocations.put("A", new int[]{U[1], B[1]});
        edgeLocations.put("B", new int[]{U[5], R[1]});
        edgeLocations.put("C", new int[]{U[7], F[1]});
        edgeLocations.put("D", new int[]{U[3], L[1]});
        edgeLocations.put("E", new int[]{L[1], U[3]});
        edgeLocations.put("F", new int[]{L[5], F[3]});
        edgeLocations.put("G", new int[]{L[7], D[3]});
        edgeLocations.put("H", new int[]{L[3], B[5]});
        edgeLocations.put("I", new int[]{F[1], U[7]});
        edgeLocations.put("J", new int[]{F[5], R[3]});
        edgeLocations.put("K", new int[]{F[7], D[1]});
        edgeLocations.put("L", new int[]{F[3], L[5]});
        edgeLocations.put("M", new int[]{R[1], U[5]});
        edgeLocations.put("N", new int[]{R[5], B[3]});
        edgeLocations.put("O", new int[]{R[7], D[5]});
        edgeLocations.put("P", new int[]{R[3], F[5]});
        edgeLocations.put("Q", new int[]{B[1], U[1]});
        edgeLocations.put("R", new int[]{B[5], L[3]});
        edgeLocations.put("S", new int[]{B[7], D[7]});
        edgeLocations.put("T", new int[]{B[3], R[5]});
        edgeLocations.put("U", new int[]{D[1], F[7]});
        edgeLocations.put("V", new int[]{D[5], R[7]});
        edgeLocations.put("W", new int[]{D[7], B[7]});
        edgeLocations.put("X", new int[]{D[3], L[7]});
        edgePairs = new HashMap<>();
        edgePairs.put("A", "Q");
        edgePairs.put("B", "M");
        edgePairs.put("C", "I");
        edgePairs.put("D", "E");
        edgePairs.put("L", "F");
        edgePairs.put("J", "P");
        edgePairs.put("N", "T");
        edgePairs.put("H", "R");
        edgePairs.put("U", "K");
        edgePairs.put("V", "O");
        edgePairs.put("W", "S");
        edgePairs.put("X", "G");
        edgePairs.put("Q", "A");
        edgePairs.put("M", "B");
        edgePairs.put("I", "C");
        edgePairs.put("E", "D");
        edgePairs.put("F", "L");
        edgePairs.put("P", "J");
        edgePairs.put("T", "N");
        edgePairs.put("R", "H");
        edgePairs.put("K", "U");
        edgePairs.put("O", "V");
        edgePairs.put("S", "W");
        edgePairs.put("G", "X");
    }


    //~ Methods ...............................................................
    /**
     * Do the thing
     */
    public void generateSequence()
    {
        for (int i = 0; i < 20; i++)
        {
            this.checkEdge();
        }
        System.out.println(script.makeItEasier());
        this.fixEnding();
        this.removeSolvedEdges();
        System.out.println(sequence);
    }
    /**
     * Get the cube object involved
     * 
     * @return CubeModel object
     */
    public CubeModel getCube()
    {
        return cube;
    }
    /**
     * Get the sequence of letters
     * 
     * @return String value
     */
    public String getSequence()
    {
        return sequence;
    }
    /**
     * Get the current edge
     * 
     * @return Integer array
     */
    public int[] getCurrentEdge()
    {
        return currentEdge;
    }
    /**
     * Set custom value for nextLetter
     * 
     * @param letter Letter value
     */
    public void setNextLetter(String letter)
    {
        nextLetter = letter;
    }
    /**
     * Get the target letter
     * 
     * @return String value
     */
    public String getNextLetter()
    {
        return nextLetter;
    }
    /**
     * Update the current edge to the target associated with the target
     * letter
     */
    public void updateCurrentEdge()
    {
        for (String letter : edgeLocations.keySet())
        {
            if (letter.equals(nextLetter))
            {
                currentEdge = edgeLocations.get(letter);
            }
        }
    }
    /**
     * Main operator method of this class
     */
    public void checkEdge()
    {
        for (int[] piece : edges.keySet())
        {  
            if (piece[0] == currentEdge[0] && piece[1] == currentEdge[1])
            {
                if (edges.get(piece) != "B" && edges.get(piece) != "M")
                {
                    nextLetter = edges.get(piece);
                    if (!this.checkForRepeat())
                    {
                        sequence += nextLetter;
                        this.updateCurrentEdge();
                        break;
                    }
                    else
                    {
                        sequence += nextLetter;
                        if (!findNewEdge())
                        {
                            this.findNewEdge();
                            this.updateCurrentEdge();
                        }
                    }
                }
                else
                {
                    this.findNewEdge();
                    this.updateCurrentEdge();
                }
            }
        }
    }
    /**
     * Check if the current edge has already been used
     * 
     * @return Boolean value
     */
    public boolean checkForRepeat()
    {
        boolean result = false;
        String check = "";
        for (String letter : edgePairs.keySet())
        {
            if (nextLetter.equals(letter))
            {
                check = edgePairs.get(letter);
                break;
            }
        }
        for (int i = 0; i < sequence.length(); i++)
        {
            String oneLetter = sequence.substring(i, i + 1);
            if (oneLetter.equals(check) || oneLetter.equals(nextLetter))
            {
                result = true;
            }
        }
        return result;
    }
    /**
     * Find a new, unused edge to continue the sequence
     * 
     * @return Boolean value
     */
    public boolean findNewEdge()
    {
        boolean edgesDone = false;
        List seq = new ArrayList<String>();
        for (int i = 0; i < sequence.length(); i++)
        {
            seq.add(sequence.substring(i, i + 1));
        }
        if (!seq.contains("A") && !seq.contains("Q"))
        {
            nextLetter = "A";
        }
        else if (!seq.contains("C") && !seq.contains("I"))
        {
            nextLetter = "C";
        }
        else if (!seq.contains("D") && !seq.contains("E"))
        {
            nextLetter = "D";
        }
        else if (!seq.contains("L") && !seq.contains("F"))
        {
            nextLetter = "L";
        }
        else if (!seq.contains("J") && !seq.contains("P"))
        {
            nextLetter = "J";
        }
        else if (!seq.contains("N") && !seq.contains("T"))
        {
            nextLetter = "N";
        }
        else if (!seq.contains("H") && !seq.contains("R"))
        {
            nextLetter = "H";
        }
        else if (!seq.contains("U") && !seq.contains("K"))
        {
            nextLetter = "U";
        }
        else if (!seq.contains("V") && !seq.contains("O"))
        {
            nextLetter = "V";
        }
        else if (!seq.contains("W") && !seq.contains("S"))
        {
            nextLetter = "W";
        }
        else if (!seq.contains("X") && !seq.contains("G"))
        {
            nextLetter = "X";
        }
        else
        {
            edgesDone = true;
        }
        return edgesDone;
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
        if (allButLast.contains(repeater) 
            || allButLast.contains(edgePairs.get(repeater)))
        {
            heChillin = true;
        }
        if (!heChillin)
        {
            newSeq = allButLast;
        }
        sequence = newSeq;
    }
    /**
     * Remove same-letter pairs from the sequence that indicate a pre-solved
     * edge
     */
    public void removeSolvedEdges()
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
}
