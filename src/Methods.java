package algtranslator;
import java.util.ArrayList;
/**
 *
 * @author Chaewon
 */

public final class Methods {
    
    
    private Methods() {}
    
    public static Algorithm invert(Algorithm alg) {
        Algorithm newAlg = new Algorithm(alg.getAlgorithmString());
        ArrayList<Moves> copy = newAlg.getAlgorithmMoves();
        
        copy.stream().forEach((m) -> {
            m.changeDir();
        });
        
        //reverses the moves
        for (int i = 0; i < copy.size()/2; i++) {
            Moves temp = copy.get(i);
            copy.set(i, copy.get(copy.size()-1-i));
            copy.set(copy.size()-1-i, temp);   
        }
        
        //sets original string array to new ArrayList<String> from ArrayList<Moves>
        newAlg.setAlgorithmStringMovesList(Algorithm.storeIndividualMoves(copy));
        
        //sets original alg to new string alg from ArrayList<String>
        newAlg.setAlgorithmString(Algorithm.extractStringAlg(
                                  newAlg.getAlgorithmStringMovesList()));
        
        //sets original no space alg to new one
        newAlg.setNoSpceAlgString(Algorithm.spaceRemove(newAlg.getAlgorithmString()));
        
        return newAlg;
    }
    
    public static Algorithm complement(Algorithm alg) {
        Algorithm newAlg = new Algorithm(alg.getAlgorithmString());
        ArrayList<Moves> copy = newAlg.getAlgorithmMoves();
        
        for (Moves m : copy) {
            if (m.getMove().equals(Database.SingleMove.S_CW.getMove()) || 
                m.getMove().equals(Database.SingleMove.S_CCW.getMove()) ||
                m.getMove().equals(Database.SingleMove.z_CW.getMove()) ||
                m.getMove().equals(Database.SingleMove.z_CCW.getMove()) )
                continue;
            m.changeFaceFB();
            m.changeDir();    
        }
        
        //sets original string array to new ArrayList<String> from ArrayList<Moves>
        newAlg.setAlgorithmStringMovesList(Algorithm.storeIndividualMoves(copy));
        
        //sets original alg to new string alg from ArrayList<String>
        newAlg.setAlgorithmString(Algorithm.extractStringAlg(
                                  newAlg.getAlgorithmStringMovesList()));
        
        //sets original no space alg to new one
        newAlg.setNoSpceAlgString(Algorithm.spaceRemove(newAlg.getAlgorithmString()));
        
        return newAlg;
    }
    
    public static Algorithm mirrorVertical(Algorithm alg) {
        Algorithm newAlg = new Algorithm(alg.getAlgorithmString());
        ArrayList<Moves> copy = newAlg.getAlgorithmMoves();
        
        for (Moves m : copy) {
            if (m.getMove().equals(Database.SingleMove.M_CW.getMove()) || 
                m.getMove().equals(Database.SingleMove.M_CCW.getMove()) ||
                m.getMove().equals(Database.SingleMove.x_CW.getMove()) ||
                m.getMove().equals(Database.SingleMove.x_CCW.getMove()) )
                continue;
            
            m.changeFaceLR();
            m.changeDir();
        }
        
        //sets original string array to new ArrayList<String> from ArrayList<Moves>
        newAlg.setAlgorithmStringMovesList(Algorithm.storeIndividualMoves(copy));
        
        //sets original alg to new string alg from ArrayList<String>
        newAlg.setAlgorithmString(Algorithm.extractStringAlg(
                                  newAlg.getAlgorithmStringMovesList()));
        
        //sets original no space alg to new one
        newAlg.setNoSpceAlgString(Algorithm.spaceRemove(newAlg.getAlgorithmString()));
        
        return newAlg;
    }
    
    public static Algorithm mirrorHorizontal(Algorithm alg) {
        Algorithm newAlg = new Algorithm(alg.getAlgorithmString());
        ArrayList<Moves> copy = newAlg.getAlgorithmMoves();
        
        for (Moves m : copy) {
            if (m.getMove().equals(Database.SingleMove.E_CW.getMove()) || 
                m.getMove().equals(Database.SingleMove.E_CCW.getMove()) ||
                m.getMove().equals(Database.SingleMove.y_CW.getMove()) ||
                m.getMove().equals(Database.SingleMove.y_CCW.getMove()) )
                continue;
            
            m.changeFaceUD();
            m.changeDir();
        }
        
        //sets original string array to new ArrayList<String> from ArrayList<Moves>
        newAlg.setAlgorithmStringMovesList(Algorithm.storeIndividualMoves(copy));
        
        //sets original alg to new string alg from ArrayList<String>
        newAlg.setAlgorithmString(Algorithm.extractStringAlg(
                                  newAlg.getAlgorithmStringMovesList()));
        
        //sets original no space alg to new one
        newAlg.setNoSpceAlgString(Algorithm.spaceRemove(newAlg.getAlgorithmString()));
        
        return newAlg;
    }
    
    
    
}
