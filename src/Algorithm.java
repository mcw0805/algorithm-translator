
package algtranslator;
import java.util.ArrayList;


/**
 *
 * @author Chaewon
 */
public class Algorithm {
    
    private String originalAlg;
    private String noSpaceAlg;
    private ArrayList<String> stringMoves;
    private ArrayList<Moves> algorithm;
    private final int algLength;
    
    public Algorithm(String userAlg) {
        
        if (userAlg.matches("^\\s*$"))
            throw new IllegalArgumentException ("NO MOVE IS ENTERED");
        
        stringMoves = new ArrayList<>();
        algorithm = new ArrayList<>();

        noSpaceAlg = spaceRemove(userAlg);
        stringMoves = storeIndividualMoves(noSpaceAlg);
        originalAlg = extractStringAlg(stringMoves);
        
        stringMoves.stream().forEach((move) -> {
            algorithm.add(new Moves(move));
        });
        
        algLength = stringMoves.size();
        
    }
    
    public static String spaceRemove(String alg) {
        return alg.trim().replaceAll(" +", "");
    }
       
    private ArrayList<String> storeIndividualMoves(String alg) {
        
        ArrayList<String> store = new ArrayList<>(); 
        
        for (int i = 0; i < alg.length(); i++) {
            if (i < alg.length() - 1 && (alg.charAt(i+1) == '\'' || alg.charAt(i+1) == '2')) {
                store.add(alg.substring(i, i+2));
                i++;
            }
            else
                store.add(alg.substring(i,i+1));
    
        }// end for
    
        return store;
    }
    
    public Moves getMoveInAlg(Algorithm alg, int index) {
        ArrayList<Moves> copyAlg = alg.algorithm;
        
        if (index >= copyAlg.size() || index < 0)
            throw new IllegalArgumentException("Invalid index position");
        
        for (int i = 0; i < copyAlg.size(); i++) {
            if (i == index)
                return copyAlg.get(i);
        }
        
        return null;
    }
    
    public String getAlgorithmString() {
        return originalAlg;
    }
    
    public String getNoSpaceAlg() {
        return noSpaceAlg;
    }
    
    public ArrayList<String> getAlgorithmStringMovesList() {
        return stringMoves;
    }
    
    public ArrayList<Moves> getAlgorithmMoves() {
        return algorithm;
    }
    
    public int getAlgorithmLength() {
        return algLength;
    }
    
    public void setAlgorithmStringMovesList(ArrayList<String> alg) {
        stringMoves = alg;
    }
    
    public void setAlgorithmString(String alg) {
        originalAlg = alg;
    }
    
    public void setNoSpceAlgString(String alg) {
        noSpaceAlg = alg;
    }
    
    public static ArrayList<String> storeIndividualMoves(ArrayList<Moves> alg) {
        ArrayList<String> store = new ArrayList<>(); 
        
        alg.stream().forEach((m) -> {
            store.add(m.getMove());
        });
        
        return store;
    }
    
    public static String extractStringAlg (ArrayList<String> alg) {
        String extractedAlg = "";
        
        for (int i = 0; i < alg.size(); i++) {
            extractedAlg += alg.get(i);
            
            if (i != alg.size() - 1) //put space except at the end
                extractedAlg += " ";
        }
        
        return extractedAlg; 
    }
    
    @Override
    public String toString() {
        return originalAlg;
    }
}
