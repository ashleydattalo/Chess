/**
 * Bishop class. Creates a bishop piece. Contains methods controlling bishop's ability to move
 * 
 * @Ashley Dattalo
 * @Aug. 1st, 2015
 */
public class Bishop extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(String c)
    {
        super(c, "b");
        color = c;
    }
    public boolean isOnBoard(int num) {
        if(num>=0 && num<=7) {
            return true;
        }
        return false;
    }
    /*      LeftUp  LeftDn  RightUp  RightDn
        dy:  -1       1      -1       1
        dx:  -1      -1       1       1
     */
    /**
     * Method to determine where a bishop can move.
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
        int [] itsY = {-1,1,-1,1};
        int [] itsX = {-1,-1,1,1};
        /*  ∆   LeftUp  LeftDn  RightUp  RightDn
           dy:  -1       1      -1       1
           dx:  -1      -1       1       1
        */
        for(int i = 0; i < itsY.length; i++) {
            int checkY = aYold + itsY[i];
            int checkX = aXold + itsX[i];
            while(isOnBoard(checkY) && isOnBoard(checkX)) {
                if(pieces[checkY][checkX].getLength() == 0) {
                    legalMoves[checkY][checkX] = true;
                    checkY = checkY + itsY[i];
                    checkX = checkX + itsX[i];
                } 
                else { 
                    boolean sameColor = pieces[aYold][aXold].getColor().equals(pieces[checkY][checkX].getColor());
                    legalMoves[checkY][checkX] = !sameColor;
                    break;
                }
            }
        }
        return legalMoves;
    }
    public String getPiece(){
        return "Bishop";
    }
}
