package visuals.user_interface;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.NorthPanel;

public class GameLog extends JPanel {

    // Format: [HH:mm:ss] "text"

    // implement
    /*
     *  create a game log (essentially a chat log) that
     *  tracks each move as the end turn button is pressed
     *  each log will include a time stamp using the above format
     *  and sample messages would include messages regarding:
     *      moves done:
     *          (White Knight [E4] -> [B7]) 
     *      pieces taken:
     *          (White Knight [E4] took  Black Bishop [B7])
     *      converting pawn to Queen, etc:
     *          (White Pawn [E4] became White Queen [E4]), 
     *      game start and game end:
     *          (Game Start!)
     *          (Game Finished! White wins!)
     *  this will also include a scrolling pane so users can
     *  scroll up to see previous messages
     */

    public static JTextArea textArea;
    
    public GameLog() {

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        setTextAreaFont(textArea, "Roboto", Font.BOLD, 12);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textArea.setEditable(false);
        textArea.setFocusable(false);

        textArea.append("[00:00:00] Welcome to Offline Chess Simulator!\n\n");

        scrollPane.setPreferredSize(new Dimension(200, 650));

        add(scrollPane);

    }

    public static String formatMessage(boolean isAttacking, boolean isTransforming, boolean isFirstWhite, String firstInput, String secondInput) {

        String gameClock = NorthPanel.gameClock.getText();

        if (isAttacking && isTransforming) {

            return "[" + gameClock + "] " + isWhiteToString(isFirstWhite) + " " + firstInput + " took " 
                    + isWhiteToString(!isFirstWhite) + " " + secondInput + " and became " 
                    + isWhiteToString(isFirstWhite) + secondInput + "\n";

        }
        else if (isTransforming) {

            return "[" + gameClock + "] " + isWhiteToString(isFirstWhite) + " " + firstInput + " became " 
                    + isWhiteToString(isFirstWhite) + " " + secondInput + "\n";

        }
        else if (isAttacking) {

            return "[" + gameClock + "] " + isWhiteToString(isFirstWhite) + " " + firstInput + " took " 
                    + isWhiteToString(!isFirstWhite) + " " + secondInput + "\n";

        }
        else {

            return "[" + gameClock + "] " + isWhiteToString(isFirstWhite) + " " + firstInput + " -> " 
                    + secondInput + "\n";

        }

    }

    private static String isWhiteToString(boolean isWhite) {

        if (isWhite) {
            return "White";
        }
        else {
            return "Black";
        }

    }

    public static String formatCoordinates(int[] input) {

        String formattedCoords;
        String formattedXCoord = "";
        int formattedYCoord = 0;

        switch (input[0]) { // x
            case 0:
                formattedXCoord = "A";
                break;
            case 1:
                formattedXCoord = "B";
                break;
            case 2:
                formattedXCoord = "C";
                break;
            case 3:
                formattedXCoord = "D";
                break;
            case 4:
                formattedXCoord = "E";
                break;
            case 5:
                formattedXCoord = "F";
                break;
            case 6:
                formattedXCoord = "G";
                break;
            case 7:
                formattedXCoord = "H";
                break;
            default:
                break;
        }

        switch (input[1]) { // y
            case 0:
                formattedYCoord = 8;
                break;
            case 1:
                formattedYCoord = 7;
                break;
            case 2:
                formattedYCoord = 6;
                break;
            case 3:
                formattedYCoord = 5;
                break;
            case 4:
                formattedYCoord = 4;
                break;
            case 5:
                formattedYCoord = 3;
                break;
            case 6:
                formattedYCoord = 2;
                break;
            case 7:
                formattedYCoord = 1;
                break;
            default:
                break;
        }

        formattedCoords = "[" + formattedXCoord + formattedYCoord + "]";
        return formattedCoords;

    }

    private static void setTextAreaFont(JTextArea textArea, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        textArea.setFont(newFont);

    }
    
}
