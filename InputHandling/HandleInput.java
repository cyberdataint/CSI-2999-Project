package InputHandling;

import java.awt.Color;
import mechanics.GameBoard;
import mechanics.Space;
import mechanics.Piece;
import visuals.user_interface.Board;

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



public static boolean turn = false;

public static Piece activePiece = null;

public static GameBoard chess = new GameBoard();

public static Color[] original_color = null;


public static void handleButtonPress(int x, int y){

    if (turn == false) {

        //add logic for handling button press event
   
        System.out.println("Button handled");

        //get the space at the clicked coordinates
        Space clickedSpace = chess.gameBoard[x][y];

        //check if space is occupied
        if (clickedSpace.occupant != null){

            Piece clickedPiece = clickedSpace.occupant;
            activePiece = clickedPiece;

            //retrieve info about clicked piece
            boolean isWhite = clickedPiece.getColor();
            int[] position = clickedPiece.getPos();
            int id = clickedPiece.getId();

            Space[] validMoves = clickedPiece.validMoves(chess.gameBoard);

            //light up valid move spaces
            highlightValidMoves(validMoves);


            

            //highlight clicked piece
          


            turn = true;  //pt 1 of 2 click turn is complete

        }   
    }



    if (turn == true) {



        if (activePiece.moveTo( x, y, chess.gameBoard) == null) {

            //tell user its null
            System.out.println("Invalid Move Selected!");

            turn = false;  //complete turn
            activePiece = null;


            int count = 0;
            for (Space space: activePiece.validMoves(chess.gameBoard)){
                //need to get the button on this space to use setBackground
                if (space != null) {
                    Board.squares[space.xcoord][space.ycoord].setBackground(original_color[count]);
                    count++;
                }
                
            }
            original_color = null;

            return;

       

            }

        }

    }
    public static void highlightValidMoves(Space[] validMoves){



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


