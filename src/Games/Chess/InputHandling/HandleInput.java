package Games.Chess.InputHandling;

import java.awt.Color;
import Games.Chess.Mechanics.GameBoard;
import Games.Chess.Mechanics.Space;
import Games.Chess.Mechanics.Piece;
import Games.Chess.Visuals.user_interface.Board;

public class HandleInput {
    
    //New Function to add ActionListener to buttons that are currently set up

//New Function to handle button press events

    /*  1.  Retrieve piece/ know which piece has been clicked
     * 
     *  2.  Detect danger?
     * 
     *  3.  View Valid moves
     * 
     * 
     *  4. Move Piece to desired valid location
     * 
     */


public static boolean whiteTurn = true;
public static boolean activeTurn = false;

public static Piece activePiece = null;

public static Color[] original_color = null;
public static Space[] highlightedSpaces;
public static Space clickedSpace;


public static void handleButtonPress(int x, int y){

    if (activeTurn == false) {

        //add logic for handling button press event
   
        System.out.println("Button handled");

        //get the space at the clicked coordinates
        clickedSpace = GameBoard.gameBoard[x][y];

        //check if space is occupied
        if (clickedSpace.occupant != null){

            Piece clickedPiece = clickedSpace.occupant;
            activePiece = clickedPiece;

            //retrieve info about clicked piece
            boolean isWhite = clickedPiece.getColor();
            // int[] position = clickedPiece.getPos();
            // int id = clickedPiece.getId();
            if (isWhite != whiteTurn) { //not your turn!!!
                activePiece = null;
                if (whiteTurn) {
                    System.out.println("It's White's turn!");
                }
                else {
                    System.out.println("It's Black's turn!");
                }
                return;
            }
            if (whiteTurn) {
                if (GameBoard.whiteChecked() && activePiece.getName() != "King") {
                    System.out.println("White King is checked! Save the King!");
                    activePiece = null;
                    return;
                }
            }
            else {
                if (GameBoard.blackChecked() && activePiece.getName() != "King") {
                    System.out.println("Black King is checked! Save the King!");
                    activePiece = null;
                    return;
                }
            }

            Space[] validMoves = clickedPiece.validMoves(GameBoard.gameBoard);

            //light up valid move spaces
            highlightValidMoves(validMoves);


            

            //highlight clicked piece
          


            activeTurn = true;  //pt 1 of 2 click turn is complete

        }   
    }



    if (activeTurn == true) {

        
        if (activePiece.moveTo( x, y, GameBoard.gameBoard) == null) {

            //tell user its null
            System.out.println("Invalid Move Selected!");

            return;
        }

        activeTurn = false;  //complete turn
        activePiece = null;
        int count = 0;
        for (Space space: highlightedSpaces){
            //need to get the button on this space to use setBackground
            if (space != null) {
                Board.squares[space.xcoord][space.ycoord].setBackground(original_color[count]);
                count++;
            }
            
        }
        original_color = null;
        highlightedSpaces = null;
        GameBoard.updateBoard();
        whiteTurn = !whiteTurn;
        return;

    

        }

    }

    
    public static void highlightValidMoves(Space[] validMoves){


        highlightedSpaces = validMoves;
        original_color = new Color[validMoves.length];

        int count = 0;

        for (Space space: validMoves){
            //need to get the button on this space to use setBackground
            if (space != null) {

                original_color[count] = Board.squares[space.xcoord][space.ycoord].getBackground();

                Board.squares[space.xcoord][space.ycoord].setBackground(Color.YELLOW);

                count++;
            }
            
        }
    }


}


