
package algtranslator;
import java.io.*;
import java.util.ArrayList;

public class AlgTranslator {


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        System.out.println(Database.getMoveString("R'"));
        System.out.println(Database.isValidMove("R'  "));
        System.out.println(Database.isValidMove("R'fsd"));
        
        System.out.println("\nEnter an algorithm: ");
    
        Algorithm test = new Algorithm (br.readLine());
        //Algorithm test = new Algorithm("R U R' U R U2 R'");
        System.out.println("\nTesting algorithm toString: ");
        System.out.println(test);
        
        /*
        Moves f = new Moves ("f");
        Moves z = new Moves ("z2");
        Moves L = new Moves ("R2");
        Moves E = new Moves ("E'");
        Moves U = new Moves ("U");
        //Moves invalid = new Moves ("fjdksl");
        
        System.out.println("\nTesting move toString: ");
        System.out.println(f);
        System.out.println(z);
        System.out.println(L);
        System.out.println(E);
        System.out.println(U);
        //System.out.println(invalid);
        //R2 u R' U R' U' R u' R2 y' R' U R
        
        System.out.println("\nTesting getFaceNum method in the database: ");
        System.out.println(Database.getFaceNum("x"));
        System.out.println(Database.getFaceNum("z"));
        System.out.println(Database.getFaceNum("L"));
        
        ArrayList<Moves> testVals = new ArrayList<>();
        testVals.add(f);
        testVals.add(z);
        testVals.add(L);
        testVals.add(E);
        testVals.add(U);
        System.out.println("\nPrinting array list: " + testVals);
        
        System.out.println("\nTesting getters: ");
        for (Moves m : testVals) {
            System.out.println(m.toString() + ":");
            System.out.println("Move: " + m.getMove());
            System.out.println("Move num: " + m.getMoveNum());
            System.out.println("Face: " + m.getFace());
            System.out.println("Face num: " + m.getFaceNum());
            System.out.println("Dir: " + m.getTurningDir());
            System.out.println("Dir num: " + m.getTurningDirNum());
            System.out.println();
        }
        
        for (Moves m : testVals) {
            System.out.println("Before dir change: " + m.toString());
            m.changeDir();
            System.out.println("After dir change: " + m.toString());
            System.out.println("Before reflect: " + m.toString());
            m.reflectAll();
            System.out.println("After reflect: " + m.toString());
            System.out.println();
            
        }
        */
        
        // R U R' U R U2 R'
        // x'RU'RD2R'UR                    D2 R2
        
        int[] moveNums = new int[test.getAlgorithmLength()];
        int[] faceNums = new int[test.getAlgorithmLength()];
        int[] directionNums = new int[test.getAlgorithmLength()];
        
        System.out.println("\nOriginal: " + test);
        System.out.println("Test alg ArrayList: " + test.getAlgorithmMoves());
        System.out.println("Test alg String ArrayList: " + test.getAlgorithmStringMovesList());
        for (int i = 0; i < moveNums.length; i++)
            directionNums[i] = test.getAlgorithmMoves().get(i).getTurningDirNum();
        for (int i = 0; i < moveNums.length; i++)
            System.out.print(directionNums[i] + " ");
        
        Algorithm newInvert = Methods.invert(test);
        System.out.println("\n\nInverted: " + newInvert);
        System.out.println("Inverted ArrayList: " + newInvert.getAlgorithmMoves());
        for (int i = 0; i < moveNums.length; i++)
            directionNums[i] = newInvert.getAlgorithmMoves().get(i).getTurningDirNum();
        for (int i = 0; i < moveNums.length; i++)
            System.out.print(directionNums[i] + " ");
        
        Algorithm newMirror = Methods.mirrorVertical(test);
        System.out.println("\n\nMirrored: " + newMirror);
        System.out.println("Mirrored ArrayList: " + newMirror.getAlgorithmMoves());
        for (int i = 0; i < moveNums.length; i++)
            directionNums[i] = newMirror.getAlgorithmMoves().get(i).getTurningDirNum();
        for (int i = 0; i < moveNums.length; i++)
            System.out.print(directionNums[i] + " ");
        
        Algorithm newComplement = Methods.complement(test);
        System.out.println("\n\nComplemented: " + newComplement);
        System.out.println("Complemented ArrayList: " + newComplement.getAlgorithmMoves());
        for (int i = 0; i < moveNums.length; i++)
            directionNums[i] = newComplement.getAlgorithmMoves().get(i).getTurningDirNum();
        for (int i = 0; i < moveNums.length; i++)
            System.out.print(directionNums[i] + " ");
        
        Algorithm mirrorHoriz = Methods.mirrorHorizontal(test);
        System.out.println("\n\nMirror U/D: " + mirrorHoriz);
        System.out.println("Mirror U/D ArrayList: " + mirrorHoriz.getAlgorithmMoves());
        for (int i = 0; i < moveNums.length; i++)
            directionNums[i] = mirrorHoriz.getAlgorithmMoves().get(i).getTurningDirNum();
        for (int i = 0; i < moveNums.length; i++)
            System.out.print(directionNums[i] + " ");
        

        
    }
    
}
