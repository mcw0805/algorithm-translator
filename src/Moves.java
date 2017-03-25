
package algtranslator;

/**
 *
 * @author Chaewon
 */

public class Moves {
    
    private String move;
    private String face;
    private String turningDir;
    private int moveNum;
    private int faceNum;
    private int turningDirNum;
    
    public Moves(String singleMove) {
        
        if (!Database.isValidMove(singleMove))
            throw new IllegalArgumentException("Illegal move");
        else {
            move = Algorithm.spaceRemove(singleMove);
            face = separateGetFace(singleMove);
            turningDir = separateGetDir(singleMove);
            
            moveNum = Database.getMoveNum(move);
            faceNum = Database.getFaceNum(face);
            turningDirNum = Database.getDirectionNum(turningDir);
        }
    
    }
    
    
    protected Moves(Moves m) {
        this.move = m.move;
        this.face = m.face;
        this.turningDir = m.turningDir;
        this.moveNum = m.moveNum;
        this.faceNum = m.faceNum;
        this.turningDirNum = m.turningDirNum;
    }
    
    public String getMove() {
        return move;
    }
    
    public int getMoveNum() {
        return moveNum;
    }
    
    public String getFace() {
        return face;
    }

    public int getFaceNum() {
        return faceNum;
    }

    public String getTurningDir() {
        return turningDir;
    }
    
    public int getTurningDirNum() {
        return turningDirNum;
    }
    
    private String separateGetFace(String singleMove) {
        return singleMove.substring(0, 1);
    }
    
    private String separateGetDir(String singleMove) {
        if (singleMove.length() == 2)
            return singleMove.substring(1);
        else 
            return "";
    }
    
     /**
     * Uses the string representation of the face and turning direction 
     * and concatenates them 
     * 
     * @return the string representation concatenated face and turning direction
     */
    private String getConcatenation() {
        return getFace() + getTurningDir();
    }
    
    @Override
    public String toString() {
        return move;
    }
    
    public void changeDir() {
        
        //String form of direction
        switch(getTurningDir()) {
            case "2":
                break;
            case "":
                turningDir = "'";
                break;
            case "'":
                turningDir = "";
                break;
        }
        
        //Number form of direction
        //Direction has changed from the first switch statement
        switch(getTurningDirNum()) {
            case 2:
                break;
            default: // 0 or 1
                turningDirNum = Database.getDirectionNum(turningDir);
                break;
        }
        
        move =  getConcatenation();
        moveNum = Database.getMoveNum(move);

    }
    
    public void changeFaceLR() {

        //String form of face
        switch(getFace()) {
            case "L":
                face = "R";
                break;
            case "R":
                face = "L";
                break;
            case "l":
                face = "r";
                break;
            case "r":
                face = "l";
                break; 
        }
        
        //Number form of face
        //Direction has changed from earlier
        switch(getFaceNum()) {
            case 1:
                faceNum = Database.getFaceNum(face);
                break;
            case 2: 
                faceNum = Database.getFaceNum(face);
                break;
            case 7:
                faceNum = Database.getFaceNum(face);
                break;
            case 8: 
                faceNum = Database.getFaceNum(face);
                break;
        }
        
        move = getConcatenation();
        moveNum = Database.getMoveNum(move);
        
    }
    
    public void changeFaceUD() {
        
        //String form of face
        switch(getFace( )) {
            case "U":
                face = "D";
                break;
            case "D":
                face = "U";
                break;
            case "u":
                face = "d";
                break;
            case "d":
                face = "u";
                break;   
        }
        
        //Number form of face
        //Direction has changed from earlier
        switch(getFaceNum( )) {
            case 3:
                faceNum = Database.getFaceNum(face);
                break;
            case 4: 
                faceNum = Database.getFaceNum(face);
                break;
            case 9:
                faceNum = Database.getFaceNum(face);
                break;
            case 10: 
                faceNum = Database.getFaceNum(face);
                break;
        }
        
        move = getConcatenation();
        moveNum = Database.getMoveNum(move);
        
        
    }
    
    public void changeFaceFB() {
        
        //String form of face
        switch(getFace()) {
            case "F":
                face = "B";
                break;
            case "B":
                face = "F";
                break;
            case "f":
                face = "b";
                break;
            case "b":
                face = "f";
                break;
        }
        
        //Number form of face
        //Direction has changed from earlier
        switch(getFaceNum()) {
            case 5:
                faceNum = Database.getFaceNum(face);
                break;
            case 6: 
                faceNum = Database.getFaceNum(face);
                break;
            case 11:
                faceNum = Database.getFaceNum(face);
                break;
            case 12: 
                faceNum = Database.getFaceNum(face);
                break;
        }
        
        move = getConcatenation();
        moveNum = Database.getMoveNum(move);
        
    }
  
    public void reflectLR() {
        changeDir();
        
        //String form of face
        switch(getFace()) {
            case "L":
                face = "R";
                break;
            case "R":
                face = "L";
                break;
            case "l":
                face = "r";
                break;
            case "r":
                face = "l";
                break; 
        }
        
        //Number form of face
        //Direction has changed from earlier
        switch(getFaceNum()) {
            case 1:
                faceNum = Database.getFaceNum(face);
                break;
            case 2: 
                faceNum = Database.getFaceNum(face);
                break;
            case 7:
                faceNum = Database.getFaceNum(face);
                break;
            case 8: 
                faceNum = Database.getFaceNum(face);
                break;
        }
        
        move = getConcatenation();
        moveNum = Database.getMoveNum(move);
        
    }
    
    public void reflectUD() {
        changeDir();
        
        //String form of face
        switch(getFace( )) {
            case "U":
                face = "D";
                break;
            case "D":
                face = "U";
                break;
            case "u":
                face = "d";
                break;
            case "d":
                face = "u";
                break;   
        }
        
        //Number form of face
        //Direction has changed from earlier
        switch(getFaceNum( )) {
            case 3:
                faceNum = Database.getFaceNum(face);
                break;
            case 4: 
                faceNum = Database.getFaceNum(face);
                break;
            case 9:
                faceNum = Database.getFaceNum(face);
                break;
            case 10: 
                faceNum = Database.getFaceNum(face);
                break;
        }
        
        move = getConcatenation();
        moveNum = Database.getMoveNum(move);
        
        
    }

    public void reflectFB() {
        changeDir();
        
        //String form of face
        switch(getFace()) {
            case "F":
                face = "B";
                break;
            case "B":
                face = "F";
                break;
            case "f":
                face = "b";
                break;
            case "b":
                face = "f";
                break;
        }
        
        //Number form of face
        //Direction has changed from earlier
        switch(getFaceNum()) {
            case 5:
                faceNum = Database.getFaceNum(face);
                break;
            case 6: 
                faceNum = Database.getFaceNum(face);
                break;
            case 11:
                faceNum = Database.getFaceNum(face);
                break;
            case 12: 
                faceNum = Database.getFaceNum(face);
                break;
        }
        
        move = getConcatenation();
        moveNum = Database.getMoveNum(move);
        
    }
    
    public void reflectSliceAndRotation() {
        
        switch (getFace()) {
            case "M":
                changeDir();
            case "S":
                changeDir();
            case "E":
                changeDir();
            case "x":
                 changeDir();    
            case "y":
                changeDir();    
            case "z":
                changeDir();            
        }
        
    }
    
    public void reflectAll() {
        reflectLR();
        reflectUD();
        reflectFB();
        reflectSliceAndRotation();
    }
    
    
}
