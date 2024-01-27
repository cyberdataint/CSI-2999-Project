package mechanics;

import visuals.border_panels.NorthPanel;
import visuals.user_interface.GameLog;

public class HandleInput {

    private static int[][] coords = {
        { 8, 8 },     // { x, y },
        { 8, 8 }      // { x, y }
    };

    private static int count = 0;

    private static int[] firstInput = new int[2];
    private static int[] secondInput = new int[2];

    public static boolean isValid = true;

    public static void getCoordinates(int x, int y) {

        if ( count == 0) {

            coords[0][0] = x;
            coords[0][1] = y;

            count++;

        }
        else {

            coords[1][0] = x;
            coords[1][1] = y;

            count = 0;

        }

    }

    public static void compareCoordinates() {

        if (coords[1][1] != 8) {
            // CHECK TO MAKE SURE COORDINATES ARE NOT EQUAL IN CASE OF DESELECTION
            if ((coords[0][0] == coords[1][0]) && (coords[0][1] == coords[1][1])) {

                for (int j = 0; j < 2; j++) {
                    for (int i = 0; i < 2; i++) {

                        coords[i][j] = 8;

                    }
                }

            }
            else {
                if (isValid) {

                    firstInput[0] = coords[0][0];
                    firstInput[1] = coords[0][1];

                    secondInput[0] = coords[1][0];
                    secondInput[1] = coords[1][1];

                    sendMessage(isValid);
                    Game.changeTurn();

                    firstInput[0] = 8;
                    firstInput[1] = 8;

                    secondInput[0] = 8;
                    secondInput[1] = 8;

                    for (int j = 0; j < 2; j++) {
                        for (int i = 0; i < 2; i++) {

                            coords[i][j] = 8;

                        }
                    }

                }
                else {

                    sendMessage(!isValid);

                    for (int j = 0; j < 2; j++) {
                        for (int i = 0; i < 2; i++) {

                            coords[i][j] = 8;

                        }
                    }

                }
            }

        }
        else {

            // waiting for second input

        }

    }

    public static boolean getIsAttacking() {

        // checks to see if its a valid move and opposing square is an opposing color

        // implement

        return false;

    }

    public static boolean getIsTransforming() {

        // checks to see if its a valid move and its the opposing row of selected color

        // implement

        return false;

    }

    public static void sendMessage(boolean isValid) {

        if (isValid) {

            // implement a getIsAttacking and a getIsTransforming
            String message = GameLog.formatMessage(getIsAttacking(), getIsTransforming(), Game.isWhiteTurn, GameLog.formatCoordinates(firstInput), GameLog.formatCoordinates(secondInput));
        
            GameLog.textArea.append(message);
            GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());

        }
        else {

            String message = "[" + NorthPanel.gameClock.getText() + "] Sorry! Your move was invalid! Try Again!\n";

            GameLog.textArea.append(message);
            GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());

        }

    }

}
