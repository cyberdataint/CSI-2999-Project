package mechanics;

import visuals.border_panels.NorthPanel;

public class Score {

    private final static int pawnScore = 1;
    private final static int knightBishopScore = 3;
    private final static int rookScore = 5;
    private final static int queenScore = 9;

    public static void updateScore(String pieceName, Boolean isWhite) {

        switch (pieceName) {
            case "pawn":
                NorthPanel.updateScore(isWhite, pawnScore);
                break;
            case "knight":
            case "bishop":
                NorthPanel.updateScore(isWhite, knightBishopScore);
                break;
            case "rook":
                NorthPanel.updateScore(isWhite, rookScore);
                break;
            case "queen":
                NorthPanel.updateScore(isWhite, queenScore);
                break;
            default:
                break;

        }

    }
    
}
