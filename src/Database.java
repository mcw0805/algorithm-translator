
package algtranslator;

/**
 *
 * @author Chaewon
 */


public final class Database {
    
    //private static String[][] database = new String[54][3];
    
    private Database() {
        /*SingleMove[] allMoves = SingleMove.values();
        int index = 0;
        
        //storing the 2D string array with all the possible moves in the database
        for (String[] faceType : database) {
            for (int j = 0; j < database[0].length; j++) {
                faceType[j] = allMoves[index].getMove();
                index++;
            }
        }
        */
        
        //database = storeDatabase();
    }
    
    public enum Face {
        RIGHT("R", 1), LEFT("L", 2), UP("U", 3), DOWN("D", 4), FRONT("F", 5), BACK("B", 6),
        FAT_RIGHT("r", 7), FAT_LEFT("l", 8), FAT_UP("u", 9), FAT_DOWN("d", 10), FAT_FRONT("f", 11), FAT_BACK("b", 12),
        M_SLICE("M", 13), E_SLICE("E", 14), S_SLICE("S", 15),
        X_ROTATE("x", 16), Y_ROTATE("y", 17), Z_ROTATE("z", 18);
        
        private final String faceStringAssignment;
        private final int faceNumAssignment;
        
        private Face (String face, int num) {
            assert num >= 1 && num <= 18;
            
            faceStringAssignment = face;
            faceNumAssignment = num;
        } 
        
        public String getFaceStringAssignment() {
            return faceStringAssignment;
        }
        
        public int getFaceNumAssignment() {
            return faceNumAssignment;
        }
       
    }
    
    public enum TurningDirection {
        CW("", 0),CCW("'", 1),ONE_EIGHTY("2", 2);
        
        private final String turnStringAssignment;
        private final int turnNumAssignment; 
        
        private TurningDirection(String turn, int num) {
            assert num >= 0 && num <= 2;
            
            turnStringAssignment = turn;
            turnNumAssignment = num; 
        }
        
        public String getTurnStringAssignment() {
            return turnStringAssignment;
        }
        
        public int getTurnNumAssignment() {
            return turnNumAssignment;
        }
    }
    
    public enum SingleMove {
        R_CW("R", 0), R_CCW("R'", 1), R_180("R2", 2),
        L_CW ("L", 3), L_CCW("L'", 4), L_180("L2", 5),
        U_CW("U", 6), U_CCW("U'", 7), U_180("U2", 8),
        D_CW ("D", 9), D_CCW("D'", 10), D_180("D2", 11),
        F_CW("F", 12), F_CCW("F'", 13), F_180("F2", 14),
        B_CW ("B", 15), B_CCW("B'", 16), B_180("B2", 17),
        r_CW("r", 18), r_CCW("r'", 19), r_180("r2", 20),
        l_CW ("l", 21), l_CCW("l'", 22), l_180("l", 23),
        u_CW("u", 24), u_CCW("u'", 25), u_180("u2", 26),
        d_CW ("d", 27), d_CCW("d'", 28), d_180("d2", 29),
        f_CW("f", 30), f_CCW("f'", 31), f_180("f2", 32),
        b_CW ("b", 33), b_CCW("b'", 34), b_180("b2", 35),
        M_CW("M", 36), M_CCW("M'", 37), M_180("M2", 38),
        E_CW ("E", 39), E_CCW("E'", 40), E_180("E2", 41),
        S_CW("S", 42), S_CCW("S'", 43), S_180("S2", 44),
        x_CW("x", 45), x_CCW("x'", 46), x_180("x2", 47),
        y_CW ("y", 48), y_CCW("y'", 49), y_180("y2", 50),
        z_CW("z", 51), z_CCW("z'", 52), z_180("z2", 53);
        
        
        private final String move;
        private final int moveFormalNum;
        
        private SingleMove(String singleMove, int moveNum) {
            assert moveNum >= 0 && moveNum <= 53;
            
            move = singleMove;
            moveFormalNum = moveNum;
        }
        
        public String getMove() {
            return move;
        }
        
        public int getMoveNum() {
            return moveFormalNum;
        }
        
    }
    
    public static boolean isValidMove(String move) {
        
        for (SingleMove s : SingleMove.values()) 
            if (s.getMove().equals(Algorithm.spaceRemove(move))) 
                return true;
        
        return false;
    }
    
    public static String getFaceString(String face) {
        for (Face f : Face.values())
            if (f.getFaceStringAssignment().equals(face))
                return f.getFaceStringAssignment();
        
        return null;
    }
    
    public static String getDirectionString(String dir) {
        for (TurningDirection t : TurningDirection.values())
            if (t.getTurnStringAssignment().equals(dir))
                return t.getTurnStringAssignment();
        
        return null;
    }
    
    public static String getMoveString(String move) {
        for (SingleMove s : SingleMove.values())
            if (s.getMove().equals(move))
                return s.getMove();
        
        return null;
    }
    
    public static String getMoveString(Moves m) {
        for (SingleMove s : SingleMove.values())
            if (s.getMove().equals(m.getMove()))
                return s.getMove();
        
        return null;
    }
    
    public static int getFaceNum(String face) {
        for (Face f : Face.values())
            if (f.getFaceStringAssignment().equals(face))
                return f.getFaceNumAssignment();
        
        return -1;
    }
    
    public static int getDirectionNum(String dir) {
        for (TurningDirection t : TurningDirection.values())
            if (t.getTurnStringAssignment().equals(dir))
                return t.getTurnNumAssignment();
        
        return -1;
    }
    
    public static int getMoveNum(String move) {
        for (SingleMove moveEnum : SingleMove.values())
            if (move.equals(moveEnum.getMove()))
                return moveEnum.getMoveNum();
        
        return -1;
    }
    /*
    private static String[][] storeDatabase() {
        String [][] copy = new String [54][3];
        
        int i = 0;
        int j = 0;
        
        for (SingleMove s : SingleMove.values()) {
            copy[i][j] = s.getMove();
            j++;
            
            if (j >= copy[0].length) {
                i++;
                j=0;
            }
        }
        return copy;
    }
    
    public static void print() {
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[0].length; j++) {
                System.out.print(database[i][j] + " ");
            }
            System.out.println();
        }
    
    }
    */
}
