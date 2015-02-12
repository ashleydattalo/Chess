import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import java.applet.Applet;

public class ChessGame extends JApplet implements MouseListener, MouseMotionListener{
    int mouseX = 0;
    int mouseY = 0;
    
    //top Left Corner of ChessBoard
    int topLeftX = 100;
    int topLeftY = 100;
    
    //width and height of ChessBoard
    int widthBoard = 500;
    int heightBoard = 500;
    
    //width and height of rows and columns: creates the height and width of the indivual squares on the chessboard
    int widthSquare = (widthBoard - topLeftX)/8;
    int heightSquare = (heightBoard - topLeftY)/8;
    
    //holds board of chesspieces
    ChessPiece [][] arrPieces = new ChessPiece [8][8];
    
    boolean blackOnTop = false;
    int cTopAll;
    int cTopPawn;
    int cBottomPawn;
    int cBottomAll;
    
    int spacerX = widthSquare/3;
    int spacerY = heightSquare/2;
    
    boolean canMove = false;
    int aYold = 0;
    int aXold = 0;
    int aYnew = 0;
    int aXnew = 0;
    int click = 0;
    int whichCase=0;
    
    ChessPiece pieceMoved = new ChessPiece("b","");
    ChessPiece pieceToMove = new ChessPiece("", "");

    public ChessGame(){
        //Fills the array of chess pieces with an empty string representing an 'empty chess piece'
        for(int j = 0; j<=7; j++){
            for(int i = 0; i<=7; i++){
                arrPieces[j][i] = new ChessPiece("",""); 
            }
        }
        
        //declares location for white and black pawns if black is on top
        if(blackOnTop == true){
            cTopAll = 0;
            cTopPawn = 1;
            cBottomPawn = 6;
            cBottomAll = 7;
        }
        //declares location for white and black pawns if white is on top    
        if(blackOnTop == false){
            cTopAll = 7;
            cTopPawn = 6;
            cBottomPawn = 1;
            cBottomAll = 0;
        }
        
        final String pawnName = "p";
        final String castleName = "c";
        final String knightName = "k";
        final String bishopName = "b";
        final String queenName = "q";
        final String kingName = "ki";
        
        //fills black pieces:
        final String cBlack = "b";
        for(int i = 0; i<=7; i++){
            arrPieces[cTopPawn][i] = new Pawn(cBlack);
        }
        arrPieces[cTopAll][0] = new Castle(cBlack);
        arrPieces[cTopAll][7] = new Castle(cBlack);   
        arrPieces[cTopAll][1] = new Knight(cBlack);
        arrPieces[cTopAll][6] = new Knight(cBlack);   
        arrPieces[cTopAll][2] = new Bishop(cBlack);
        arrPieces[cTopAll][5] = new Bishop(cBlack);  
        arrPieces[cTopAll][3] = new Queen(cBlack);              
        arrPieces[cTopAll][4] = new King(cBlack);              

        //fills white Chess pieces
        final String cWhite = "w";
        for(int i = 0; i<=7; i++){
            arrPieces[cBottomPawn][i] = new Pawn(cWhite);
        }
        arrPieces[cBottomAll][0] = new Castle(cWhite);
        arrPieces[cBottomAll][7] = new Castle(cWhite);
        arrPieces[cBottomAll][1] = new Knight(cWhite);
        arrPieces[cBottomAll][6] = new Knight(cWhite);   
        arrPieces[cBottomAll][2] = new Bishop(cWhite);
        arrPieces[cBottomAll][5] = new Bishop(cWhite);  
        arrPieces[cBottomAll][3] = new King(cWhite);              
        arrPieces[cBottomAll][4] = new Queen(cWhite);         
    }
    
    public void init(){
      addMouseListener(this);
      addMouseMotionListener(this);
    }
    
    public void paint(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      setSize(widthBoard + topLeftX, heightBoard + topLeftY);
      g.clearRect(0, 0, 1000, 1000);
      
      //draws out the chessboard
      for(int j = 0; j<=7; j++){
          for(int i = 0 ; i<=7; i++){
              Rectangle oneTile = new Rectangle(topLeftX + widthSquare*i,topLeftY + heightSquare*j,widthSquare,heightSquare);
              g2.draw(oneTile);
          }
      }
      //draws out the name of the ChessPieces in the corrent location on the Board
      for(int k = 0; k<= 7; k++){
          for(int p = 0; p<=7; p++){
              String name = arrPieces[k][p].getName();
              g.drawString(name, topLeftX + widthSquare*p + spacerX,topLeftY + heightSquare*k +spacerY);
            }
      }
    }
    
    public void mouseClicked(MouseEvent e) {
      mouseX=e.getX();
      mouseY=e.getY();
      detClick(mouseX, mouseY);
      detTurn();
      repaint();
    }
    
    public void detClick(int x, int y){
        //cases
        int lenPieceClicked = arrPieces[getArrY(y)][getArrX(x)].getLength();
        if(click == 0 && lenPieceClicked != 0){
            //first click on non empty space
            aYold = getArrY(y);
            aXold = getArrX(x);
            click = 1;
            whichCase = 1;
            pieceToMove = arrPieces[aYold][aXold];
        }
        else if(click == 0 && lenPieceClicked == 0){
            //firstClick empty piece
            click = 0;
            whichCase = 2;
        }
        else if(click == 1 && lenPieceClicked == 0){
            //second click on empty space
            aYnew = getArrY(y);
            aXnew = getArrX(x);
            whichCase = 3;
            click = 0;
        }
        else if(click == 1 && lenPieceClicked != 0){
            //second click on a diff piece
            aYnew = getArrY(y);
            aXnew = getArrX(x);
            click = 0;
            whichCase = 4;
        }
    }
    
    public void detTurn(){
        String colorPieceMoved = pieceMoved.getColor();
        String colorPieceToMove = pieceToMove.getColor();
        if(colorPieceMoved.equals("b")){
            if(colorPieceToMove.equals("w")){
                movePieces();
            }
        }
        if(colorPieceMoved.equals("w")){
            if(colorPieceToMove.equals("b")){
                movePieces();
            }
        }
    }
    
    public void movePieces(){
        if(whichCase == 3){
            boolean isLegalMove = legal(arrPieces, aYold, aXold, aYnew, aXnew);
            ChessPiece pieceToReplace = arrPieces[aYnew][aXnew];
            if(isLegalMove == true){
               pieceMoved = arrPieces[aYold][aXold];
               arrPieces[aYnew][aXnew] = arrPieces[aYold][aXold];
               arrPieces[aYold][aXold] = pieceToReplace;
            } 
        }
        if(whichCase == 4){
            boolean isLegalToTake = takePiece(arrPieces, aYold, aXold, aYnew, aXnew);
            if(isLegalToTake == true){
               pieceMoved = arrPieces[aYold][aXold];
               arrPieces[aYnew][aXnew] = arrPieces[aYold][aXold];
               arrPieces[aYold][aXold] = new ChessPiece("","");
            } 
        }
    }
   
    public boolean legal(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew){
        if(arrPieces[aYold][aXold].getClass() == Pawn.class){
            String colorP = ((Pawn)(arrPieces[aYold][aXold])).getColor();
            boolean legal = ((Pawn)(arrPieces[aYold][aXold])).detLegal(pieces,aYold, aXold, aYnew, aXnew, blackOnTop);
            if(aYnew == 0 || aYnew == 7){
                if(legal == true){
                    arrPieces[aYold][aXold] = new Queen(colorP);
                }
            }
            return legal;
        }
        if(arrPieces[aYold][aXold].getClass() == Bishop.class){
            return ((Bishop)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
        }
        if(arrPieces[aYold][aXold].getClass() == Knight.class){
            return ((Knight)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
        }
        if(arrPieces[aYold][aXold].getClass() == Castle.class){
            return ((Castle)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
        }
        if(arrPieces[aYold][aXold].getClass() == King.class){
            return ((King)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
        }
        if(arrPieces[aYold][aXold].getClass() == Queen.class){
            return ((Queen)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
        }
        return false;
    }
    public boolean takePiece(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew){
        if(arrPieces[aYold][aXold].getClass() == Pawn.class){
            String colorP = ((Pawn)(arrPieces[aYold][aXold])).getColor();
            boolean legal = ((Pawn)(arrPieces[aYold][aXold])).detToTake(pieces, aYold, aXold, aYnew, aXnew, blackOnTop);
            if(aYnew == 0 || aYnew == 7){
                if(legal == true){
                    arrPieces[aYold][aXold] = new Queen(colorP);
                }
            }
            return legal;
        }
        if(arrPieces[aYold][aXold].getClass() == Bishop.class){
            return ((Bishop)(arrPieces[aYold][aXold])).detToTake(pieces, aYold, aXold, aYnew, aXnew);
        }
        if(arrPieces[aYold][aXold].getClass() == Knight.class){
            boolean legal = ((Knight)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
            boolean colorLegal =  ((Knight)(arrPieces[aYold][aXold])).detToTake(pieces, aYold, aXold, aYnew, aXnew);
            if(legal == true && colorLegal == true){
                return true;
            }
            return false;
        }
        if(arrPieces[aYold][aXold].getClass() == Castle.class){
            return ((Castle)(arrPieces[aYold][aXold])).detToTake(pieces,aYold, aXold, aYnew, aXnew);
        }
        if(arrPieces[aYold][aXold].getClass() == King.class){
            boolean legal = ((King)(arrPieces[aYold][aXold])).detLegal(pieces, aYold, aXold, aYnew, aXnew);
            boolean colorLegal =  ((King)(arrPieces[aYold][aXold])).detToTake(pieces,aYold, aXold, aYnew, aXnew);
            if(legal == true && colorLegal == true){
                return true;
            }
            return false;
        }
        if(arrPieces[aYold][aXold].getClass() == Queen.class){
            return ((Queen)(arrPieces[aYold][aXold])).detToTake(pieces,aYold, aXold, aYnew, aXnew);
        }
        return false;
    }
    public int getArrX(int x){
        return (x - topLeftX)/widthSquare;
    }
    public int getArrY(int y){
        return (y - topLeftY)/heightSquare;
    }
    
    public void mouseMoved(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    
}