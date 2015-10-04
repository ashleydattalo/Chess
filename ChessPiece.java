public class ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    private String name;
    private String nameOfPiece;
    
    private boolean isPawn = false;
    private boolean isCastle = false;
    private boolean isKnight = false;
    private boolean isBishop = false;
    private boolean isKing = false;
    private boolean isQueen = false;
    
    private Pawn p;
    private Castle ca;
    private Knight k;
    private Bishop b;
    private Queen q;
    private King ki;
    
    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(String c, String n)
    {
        // initialise instance variables
        color = c;
        nameOfPiece = n;
        name = color + nameOfPiece;
    }

    public String getName(){
        return name;
    }
    public int getLength(){
        return name.length();
    }
    public void setName(String n){
        name = n;
    }
    public String getColor(){
        return color;
    }
    public String getPiece(){
        return "";
    }
    public boolean [][] getLegalMoves( ChessPiece [][] pieces, int aYold, int aXold) {
        boolean [][] empty = new boolean[8][8];
        return empty;
    }
}

