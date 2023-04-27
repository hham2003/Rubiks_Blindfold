import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Model of a Rubik's Cube using arrays to represent faces and integers to
 *  represent colors
 *
 *  @author Henry Ham
 *  @version (2021.12.02)
 */
public class CubeModel
{
    //~ Fields ................................................................
    private int[] F;
    private int[] B;
    private int[] R;
    private int[] L;
    private int[] U;
    private int[] D;
    private ScrambleScript script;
    private String strF;
    private String strB;
    private String strR;
    private String strL;
    private String strU;
    private String strD;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created CubeModel object.
     */
    public CubeModel()
    {
        super();
        /*# Do any work to initialize your class here. */
        F = new int[9];
        B = new int[9];
        R = new int[9];
        L = new int[9];
        U = new int[9];
        D = new int[9];
        script = new ScrambleScript();
        strF = "";
        strR = "";
        strB = "";
        strL = "";
        strU = "";
        strD = "";
    }


    //~ Methods ...............................................................
    /**
     * Set custom values for F face
     * 
     * @param a Color1
     * @param b Color2
     *  @param c Color3
     * @param d Color4
     * @param e Color5
     * @param f Color6
     * @param g Color7
     * @param h Color8
     * @param i Color9
     */
    public void customF(int a, int b, int c, int d, int e, int f, int g,
        int h, int i)
    {
            F[0] = a;
            F[1] = b;
            F[2] = c;
            F[3] = d;
            F[4] = e;
            F[5] = f;
            F[6] = g;
            F[7] = h;
            F[8] = i;
    }
    /**
     * Set custom values for R face
     * 
     * @param a Color1
     * @param b Color2
     * @param c Color3
     * @param d Color4
     * @param e Color5
     * @param f Color6
     * @param g Color7
     * @param h Color8
     * @param i Color9
     */
    public void customR(int a, int b, int c, int d, int e, int f, int g,
        int h, int i)
    {
            R[0] = a;
            R[1] = b;
            R[2] = c;
            R[3] = d;
            R[4] = e;
            R[5] = f;
            R[6] = g;
            R[7] = h;
            R[8] = i;
    }
    /**
     * Set custom values for B face
     * 
     * @param a Color1
     * @param b Color2
     * @param c Color3
     * @param d Color4
     * @param e Color5
     * @param f Color6
     * @param g Color7
     * @param h Color8
     * @param i Color9
     */
    public void customB(int a, int b, int c, int d, int e, int f, int g,
        int h, int i)
    {
            B[0] = a;
            B[1] = b;
            B[2] = c;
            B[3] = d;
            B[4] = e;
            B[5] = f;
            B[6] = g;
            B[7] = h;
            B[8] = i;
    }
    /**
     * Set custom values for L face
     * 
     * @param a Color1
     * @param b Color2
     * @param c Color3
     * @param d Color4
     * @param e Color5
     * @param f Color6
     * @param g Color7
     * @param h Color8
     * @param i Color9
     */
    public void customL(int a, int b, int c, int d, int e, int f, int g,
        int h, int i)
    {
            L[0] = a;
            L[1] = b;
            L[2] = c;
            L[3] = d;
            L[4] = e;
            L[5] = f;
            L[6] = g;
            L[7] = h;
            L[8] = i;
    }
    /**
     * Set custom values for U face
     * 
     * @param a Color1
     * @param b Color2
     * @param c Color3
     * @param d Color4
     * @param e Color5
     * @param f Color6
     * @param g Color7
     * @param h Color8
     * @param i Color9
     */
    public void customU(int a, int b, int c, int d, int e, int f, int g,
        int h, int i)
    {
            U[0] = a;
            U[1] = b;
            U[2] = c;
            U[3] = d;
            U[4] = e;
            U[5] = f;
            U[6] = g;
            U[7] = h;
            U[8] = i;
    }
    /**
     * Set custom values for D face
     * 
     * @param a Color1
     * @param b Color2
     * @param c Color3
     * @param d Color4
     * @param e Color5
     * @param f Color6
     * @param g Color7
     * @param h Color8
     * @param i Color9
     */
    public void customD(int a, int b, int c, int d, int e, int f, int g,
        int h, int i)
    {
            D[0] = a;
            D[1] = b;
            D[2] = c;
            D[3] = d;
            D[4] = e;
            D[5] = f;
            D[6] = g;
            D[7] = h;
            D[8] = i;
    }
    /**
     * Print the scrambled state of the cube
     */
    public void printScrambledCube()
    {
        List idk = script.getScramble();
        System.out.println();
        String wtf = script.makeItEasier();
        System.out.println(wtf);
        System.out.println();
        this.readScramble(idk);
        String faceF = "F: ";
        String faceR = "R: ";
        String faceB = "B: ";
        String faceL = "L: ";
        String faceU = "U: ";
        String faceD = "D: ";
        for (int i = 0; i < 9; i++)
        {
            faceF += F[i] + " ";
            faceR += R[i] + " ";
            faceB += B[i] + " ";
            faceL += L[i] + " ";
            faceU += U[i] + " ";
            faceD += D[i] + " ";
        }
        System.out.println(faceF);
        System.out.println(faceR);
        System.out.println(faceB);
        System.out.println(faceL);
        System.out.println(faceU);
        System.out.println(faceD);
    }
    /**
     * Populates arrays with values representing a solved cube
     * 
     * This will always be called first to initialize a cube
     */
    public void setToSolved()
    {
        for (int i = 0; i < 9; i++)
        {
            F[i] = 2;
            B[i] = 5;
            R[i] = 3;
            L[i] = 4;
            U[i] = 0;
            D[i] = 1;
        }
    }
    /**
     * Get the state of the F face
     * 
     * @return Integer array
     */
    public int[] getF()
    {
        return F;
    }
    /**
     * Get the state of the B face
     * 
     * @return Integer array
     */
    public int[] getB()
    {
        return B;
    }
    /**
     * Get the state of the R face
     * 
     * @return Integer array
     */
    public int[] getR()
    {
        return R;
    }
    /**
     * Get the state of the L face
     * 
     * @return Integer array
     */
    public int[] getL()
    {
        return L;
    }
    /**
     * Get the state of the U face
     * 
     * @return Integer array
     */
    public int[] getU()
    {
        return U;
    }
    /**
     * Get the state of the D face
     * 
     * @return Integer array
     */
    public int[] getD()
    {
        return D;
    }
    /**
     * Read and execute a scramble
     * 
     * @param scramble ScrambleScript to be read
     */
    public void readScramble(List<String> scramble)
    {
        this.setToSolved();
        for (int i = 0; i < scramble.size(); i++)
        {
            String move = scramble.get(i);
            if (move.equals("R"))
            {
                this.moveR();
            }
            else if (move.equals("R'"))
            {
                this.moveRp();
            }
            else if (move.equals("L"))
            {
                this.moveL();
            }
            else if (move.equals("L'"))
            {
                this.moveLp();
            }
            else if (move.equals("F"))
            {
                this.moveF();
            }
            else if (move.equals("F'"))
            {
                this.moveFp();
            }
            else if (move.equals("B"))
            {
                this.moveB();
            }
            else if (move.equals("B'"))
            {
                this.moveBp();
            }
            else if (move.equals("U"))
            {
                this.moveU();
            }
            else if (move.equals("U'"))
            {
                this.moveUp();
            }
            else if (move.equals("D"))
            {
                this.moveD();
            }
            else if (move.equals("D'"))
            {
                this.moveDp();
            }
            else if (move.equals("R2"))
            {
                this.moveR();
                this.moveR();
            }
            else if (move.equals("L2"))
            {
                this.moveL();
                this.moveL();
            }
            else if (move.equals("F2"))
            {
                this.moveF();
                this.moveF();
            }
            else if (move.equals("B2"))
            {
                this.moveB();
                this.moveB();
            }
            else if (move.equals("U2"))
            {
                this.moveU();
                this.moveU();
            }
            else if (move.equals("D2"))
            {
                this.moveD();
                this.moveD();
            }
            //this.printScrambledCube();
        }
    }
    /**
     * One R turn of the cube
     */
    public void moveR()
    {
        int a = D[2];
        int b = D[5];
        int c = D[8];
        int d = U[8];
        int e = U[5];
        int f = U[2];
        int g = F[2];
        int h = F[5];
        int i = F[8];
        int j = B[6];
        int k = B[3];
        int l = B[0];
        int m = R[0];
        int n = R[1];
        int o = R[2];
        int p = R[3];
        int q = R[5];
        int r = R[6];
        int s = R[7];
        int t = R[8];
        
        F[2] = a;
        F[5] = b;
        F[8] = c;
        B[0] = d;
        B[3] = e;
        B[6] = f;
        U[2] = g;
        U[5] = h;
        U[8] = i;
        D[2] = j;
        D[5] = k;
        D[8] = l;
        R[2] = m;
        R[8] = o;
        R[6] = t;
        R[0] = r;
        R[5] = n;
        R[7] = q;
        R[3] = s;
        R[1] = p;
    }
    /**
     * One R' turn of the cube
     */
    public void moveRp()
    {
        int a = D[2];
        int b = D[5];
        int c = D[8];
        int d = U[8];
        int e = U[5];
        int f = U[2];
        int g = F[2];
        int h = F[5];
        int i = F[8];
        int j = B[6];
        int k = B[3];
        int l = B[0];
        int m = R[0];
        int n = R[1];
        int o = R[2];
        int p = R[3];
        int q = R[5];
        int r = R[6];
        int s = R[7];
        int t = R[8];
        
        F[2] = f;
        F[5] = e;
        F[8] = d;
        B[0] = c;
        B[3] = b;
        B[6] = a;
        U[2] = j;
        U[5] = k;
        U[8] = l;
        D[2] = g;
        D[5] = h;
        D[8] = i;
        R[2] = t;
        R[8] = r;
        R[6] = m;
        R[0] = o;
        R[1] = q;
        R[5] = s;
        R[7] = p;
        R[3] = n;
    }
    /**
     * One L turn of the cube
     */
    public void moveL()
    {
        int a = U[0];
        int b = U[3];
        int c = U[6];
        int d = D[0];
        int e = D[3];
        int f = D[6];
        int g = B[2];
        int h = B[5];
        int i = B[8];
        int j = F[0];
        int k = F[3];
        int l = F[6];
        int m = L[0];
        int n = L[1];
        int o = L[2];
        int p = L[3];
        int q = L[5];
        int r = L[6];
        int s = L[7];
        int t = L[8];
        
        F[0] = a;
        F[3] = b;
        F[6] = c;
        B[2] = f;
        B[5] = e;
        B[8] = d;
        U[0] = i;
        U[3] = h;
        U[6] = g;
        D[0] = j;
        D[3] = k;
        D[6] = l;
        L[0] = r;
        L[2] = m;
        L[8] = o;
        L[6] = t;
        L[1] = p;
        L[5] = n;
        L[7] = q;
        L[3] = s;
    }
    /**
     * One L' turn of the cube
     */
    public void moveLp()
    {
        int a = U[0];
        int b = U[3];
        int c = U[6];
        int d = D[0];
        int e = D[3];
        int f = D[6];
        int g = B[2];
        int h = B[5];
        int i = B[8];
        int j = F[0];
        int k = F[3];
        int l = F[6];
        int m = L[0];
        int n = L[1];
        int o = L[2];
        int p = L[3];
        int q = L[5];
        int r = L[6];
        int s = L[7];
        int t = L[8];
        
        F[0] = d;
        F[3] = e;
        F[6] = f;
        B[2] = c;
        B[5] = b;
        B[8] = a;
        U[0] = j;
        U[3] = k;
        U[6] = l;
        D[0] = i;
        D[3] = h;
        D[6] = g;
        L[0] = o;
        L[2] = t;
        L[8] = r;
        L[6] = m;
        L[1] = q;
        L[5] = s;
        L[7] = p;
        L[3] = n;
    }
    /**
     * One U turn of the cube
     */
    public void moveU()
    {
        int a = R[0];
        int b = R[1];
        int c = R[2];
        int d = L[0];
        int e = L[1];
        int f = L[2];
        int g = B[0];
        int h = B[1];
        int i = B[2];
        int j = F[0];
        int k = F[1];
        int l = F[2];
        int m = U[0];
        int n = U[1];
        int o = U[2];
        int p = U[3];
        int q = U[5];
        int r = U[6];
        int s = U[7];
        int t = U[8];
        
        F[0] = a;
        F[1] = b;
        F[2] = c;
        B[0] = d;
        B[1] = e;
        B[2] = f;
        R[0] = g;
        R[1] = h;
        R[2] = i;
        L[0] = j;
        L[1] = k;
        L[2] = l;
        U[0] = r;
        U[2] = m;
        U[8] = o;
        U[6] = t;
        U[1] = p;
        U[5] = n;
        U[7] = q;
        U[3] = s;
    }
    /**
     * One U' turn of the cube
     */
    public void moveUp()
    {
        int a = R[0];
        int b = R[1];
        int c = R[2];
        int d = L[0];
        int e = L[1];
        int f = L[2];
        int g = B[0];
        int h = B[1];
        int i = B[2];
        int j = F[0];
        int k = F[1];
        int l = F[2];
        int m = U[0];
        int n = U[1];
        int o = U[2];
        int p = U[3];
        int q = U[5];
        int r = U[6];
        int s = U[7];
        int t = U[8];
        
        F[0] = d;
        F[1] = e;
        F[2] = f;
        B[0] = a;
        B[1] = b;
        B[2] = c;
        R[0] = j;
        R[1] = k;
        R[2] = l;
        L[0] = g;
        L[1] = h;
        L[2] = i;
        U[0] = o;
        U[2] = t;
        U[8] = r;
        U[6] = m;
        U[1] = q;
        U[5] = s;
        U[7] = p;
        U[3] = n;
    }
    /**
     * One D turn of the cube
     */
    public void moveD()
    {
        int a = R[6];
        int b = R[7];
        int c = R[8];
        int d = L[6];
        int e = L[7];
        int f = L[8];
        int g = B[6];
        int h = B[7];
        int i = B[8];
        int j = F[6];
        int k = F[7];
        int l = F[8];
        int m = D[0];
        int n = D[1];
        int o = D[2];
        int p = D[3];
        int q = D[5];
        int r = D[6];
        int s = D[7];
        int t = D[8];
        
        F[6] = d;
        F[7] = e;
        F[8] = f;
        B[6] = a;
        B[7] = b;
        B[8] = c;
        R[6] = j;
        R[7] = k;
        R[8] = l;
        L[6] = g;
        L[7] = h;
        L[8] = i;
        D[0] = r;
        D[2] = m;
        D[8] = o;
        D[6] = t;
        D[1] = p;
        D[5] = n;
        D[7] = q;
        D[3] = s;
    }
    /**
     * One D' turn of the cube
     */
    public void moveDp()
    {
        int a = R[6];
        int b = R[7];
        int c = R[8];
        int d = L[6];
        int e = L[7];
        int f = L[8];
        int g = B[6];
        int h = B[7];
        int i = B[8];
        int j = F[6];
        int k = F[7];
        int l = F[8];
        int m = D[0];
        int n = D[1];
        int o = D[2];
        int p = D[3];
        int q = D[5];
        int r = D[6];
        int s = D[7];
        int t = D[8];
        
        F[6] = a;
        F[7] = b;
        F[8] = c;
        B[6] = d;
        B[7] = e;
        B[8] = f;
        R[6] = g;
        R[7] = h;
        R[8] = i;
        L[6] = j;
        L[7] = k;
        L[8] = l;
        D[0] = o;
        D[2] = t;
        D[8] = r;
        D[6] = m;
        D[1] = q;
        D[5] = s;
        D[7] = p;
        D[3] = n;
    }
    /**
     * One F turn of the cube
     */
    public void moveF()
    {
        int a = U[6];
        int b = U[7];
        int c = U[8];
        int d = L[8];
        int e = L[5];
        int f = L[2];
        int g = D[0];
        int h = D[1];
        int i = D[2];
        int j = R[6];
        int k = R[3];
        int l = R[0];
        int m = F[0];
        int n = F[1];
        int o = F[2];
        int p = F[3];
        int q = F[5];
        int r = F[6];
        int s = F[7];
        int t = F[8];
        
        R[0] = a;
        R[3] = b;
        R[6] = c;
        L[2] = g;
        L[5] = h;
        L[8] = i;
        U[6] = d;
        U[7] = e;
        U[8] = f;
        D[0] = j;
        D[1] = k;
        D[2] = l;
        F[0] = r;
        F[2] = m;
        F[8] = o;
        F[6] = t;
        F[1] = p;
        F[5] = n;
        F[7] = q;
        F[3] = s;
    }
    /**
     * One F' turn of the cube
     */
    public void moveFp()
    {
        int a = U[6];
        int b = U[7];
        int c = U[8];
        int d = L[8];
        int e = L[5];
        int f = L[2];
        int g = D[0];
        int h = D[1];
        int i = D[2];
        int j = R[6];
        int k = R[3];
        int l = R[0];
        int m = F[0];
        int n = F[1];
        int o = F[2];
        int p = F[3];
        int q = F[5];
        int r = F[6];
        int s = F[7];
        int t = F[8];
        
        R[0] = i;
        R[3] = h;
        R[6] = g;
        L[2] = c;
        L[5] = b;
        L[8] = a;
        U[6] = l;
        U[7] = k;
        U[8] = j;
        D[0] = f;
        D[1] = e;
        D[2] = d;
        F[0] = o;
        F[2] = t;
        F[8] = r;
        F[6] = m;
        F[1] = q;
        F[5] = s;
        F[7] = p;
        F[3] = n;
    }
    /**
     * One B turn of the cube
     */
    public void moveB()
    {
        int a = U[0];
        int b = U[1];
        int c = U[2];
        int d = L[0];
        int e = L[3];
        int f = L[6];
        int g = D[8];
        int h = D[7];
        int i = D[6];
        int j = R[2];
        int k = R[5];
        int l = R[8];
        int m = B[0];
        int n = B[1];
        int o = B[2];
        int p = B[3];
        int q = B[5];
        int r = B[6];
        int s = B[7];
        int t = B[8];
        
        R[2] = g;
        R[5] = h;
        R[8] = i;
        L[0] = c;
        L[3] = b;
        L[6] = a;
        U[0] = j;
        U[1] = k;
        U[2] = l;
        D[6] = d;
        D[7] = e;
        D[8] = f;
        B[0] = r;
        B[2] = m;
        B[8] = o;
        B[6] = t;
        B[1] = p;
        B[5] = n;
        B[7] = q;
        B[3] = s;
    }
    /**
     * One B' turn of the cube
     */
    public void moveBp()
    {
        int a = U[0];
        int b = U[1];
        int c = U[2];
        int d = L[0];
        int e = L[3];
        int f = L[6];
        int g = D[8];
        int h = D[7];
        int i = D[6];
        int j = R[2];
        int k = R[5];
        int l = R[8];
        int m = B[0];
        int n = B[1];
        int o = B[2];
        int p = B[3];
        int q = B[5];
        int r = B[6];
        int s = B[7];
        int t = B[8];
        
        R[2] = a;
        R[5] = b;
        R[8] = c;
        L[0] = i;
        L[3] = h;
        L[6] = g;
        U[0] = f;
        U[1] = e;
        U[2] = d;
        D[6] = l;
        D[7] = k;
        D[8] = j;
        B[0] = o;
        B[2] = t;
        B[8] = r;
        B[6] = m;
        B[1] = q;
        B[5] = s;
        B[7] = p;
        B[3] = n;
    }
    /**
     * Turn face arrays into strings
     */
    public void facesToString()
    {
        for (int i = 0; i < F.length; i++)
        {
            strF += F[i] + " ";
        }
        for (int i = 0; i < R.length; i++)
        {
            strR += R[i] + " ";
        }
        for (int i = 0; i < B.length; i++)
        {
            strB += B[i] + " ";
        }
        for (int i = 0; i < L.length; i++)
        {
            strL += L[i] + " ";
        }
        for (int i = 0; i < U.length; i++)
        {
            strU += U[i] + " ";
        }
        for (int i = 0; i < D.length; i++)
        {
            strD += D[i] + " ";
        }
    }
    /**
     * Testing another version of printScrambledCube()
     *  
     */
    public void printScrambledCube1()
    {
        List bebo = script.getScramble();
        String scramble = script.makeItEasier();
        this.readScramble(bebo);
        this.facesToString();
        String Fp = "F:";
        String top = strF.substring(0, 5);
        String mid = strF.substring(6, 11);
        String bot = strF.substring(12, 17);
        System.out.println(F);
        System.out.println(top);
        System.out.println(mid);
        System.out.println(bot);
        
    }
    /**
     * Get a face object as a string
     * 
     * @return String value
     */
    public String getFaceString()
    {
        return strF;
    }
}
