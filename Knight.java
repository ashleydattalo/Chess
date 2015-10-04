
/**
 * Knight class. Creates a knight piece. Contains methods controlling knight's ability to move
 * 
 * @Ashley Dattalo
 * @Aug 1, 2015
 */
public class Knight extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    /**
     * Constructor for objects of class Knight
     */
    public Knight(String c)
    {
        super(c, "k");
        color = c;
    }
    public boolean isOnBoard(int num) {
        if(num>=0 && num<=7) {
            return true;
        }
        return false;
    }
     /**
     * Method to determine where a knight can move.
     * 
     * @param pieces - the chess board populated with chess pieces
     * @param aYold - the Y coordinate of the clicked bishop
     * @param aXold - the X coordinate of the clicked bishop
     * 
     * @returns a boolean board - True: the bishop can move to that spot. 
     *                            False: the bishop cannot move to that spot.
     */
    public boolean [][] getLegalMoves(ChessPiece [][] pieces, int aYold, int aXold) {
        boolean [][] legalMoves = new boolean[8][8];
        int [] itsY = {-1,-2, 1, 2, 1, 2,-1,-2 };
        int [] itsX = { 2, 1, 2, 1,-2,-1, -2,-1 };
        
        for(int i = 0; i < itsY.length; i++) {
            int checkY = aYold + itsY[i];
            int checkX = aXold + itsX[i];
            if(isOnBoard(checkY) && isOnBoard(checkX)) {
                if(pieces[checkY][checkX].getLength() == 0){
                    legalMoves[checkY][checkX] = true;
                }
                else {
                    String knightColor = pieces[aYold][aXold].getColor();
                    String otherCol = pieces[checkY][checkX].getColor();
                    boolean equalCols = knightColor.equals(otherCol);
                    legalMoves[checkY][checkX] = !equalCols;
                }
            }
        }
        return legalMoves;
    }
    public String getPiece(){
        return "Knight";
    }
}
