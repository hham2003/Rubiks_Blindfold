import java.util.HashMap;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Combine the sequences from BlindEdges and BlindCorners to give the full
 *  blindfolded-solving sequence
 *
 *  @author Henry Ham
 *  @version (2021.12.22)
 */
public class BlindSequence
{
    //~ Fields ................................................................
    private BlindEdges edges;
    private BlindCorners corners;
    private ScrambleScript script;
    private CubeModel cube;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created BlindSequence object.
     */
    public BlindSequence()
    {
        super();
        /*# Do any work to initialize your class here. */
        script = new ScrambleScript();
        List scramble = script.getScramble();
        cube = new CubeModel();
        cube.readScramble(scramble);
        edges = new BlindEdges(cube);
        corners = new BlindCorners(cube);
    }
    public static void main(String[] args) {
        BlindSequence seq = new BlindSequence();
        seq.generateSequence();
    }

    //~ Methods ...............................................................

    /**
     * Print the scramble and both sequences for solving the cube
     */
    public void generateSequence()
    {
        for (int i = 0; i < 20; i++)
        {
            edges.checkEdge();
            corners.getNextCorner();
        }
        edges.fixEnding();
        edges.removeSolvedEdges();
        corners.fixEnding();
        corners.removeSolvedCorners();
        System.out.println(script.makeItEasier());
        System.out.println(edges.getSequence());
        if (this.hasParity())
        {
            System.out.println("RUR'F'RU2R'U2R'FRURU2R'U'");
        }
        System.out.println(corners.getSequence());
    }
    /**
     * Check if the sequence has parity
     * 
     * @return Boolean value
     */
    public boolean hasParity()
    {
        boolean result = true;
        String check = edges.getSequence();
        int length = check.length();
        if (length % 2 == 0)
        {
            result = false;
        }
        return result;
    }
}
