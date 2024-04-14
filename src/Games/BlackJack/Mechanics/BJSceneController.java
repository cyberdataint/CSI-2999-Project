package Games.BlackJack.Mechanics;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class BJSceneController {

    // UI component variables some need to be accessed others do not
    @FXML
    private Label balanceLabel;
    @FXML
    private Label balanceUpdateLabel;
    @FXML
    private Label betLabel;
    @FXML
    private Slider betSlider;
    @FXML
    private Label betUpdateLabel;
    @FXML
    private Button dealButton;
    @FXML
    private GridPane dealerGrid1;
    @FXML
    private GridPane dealerGrid2;
    @FXML
    private ImageView dealerImage;
    @FXML
    private Label dealerTotalLabel;
    @FXML
    private Label CPUTotalUpdateLabel;
    @FXML
    private Label Player2TotalUpdateLabel;
    @FXML
    private Label player2Label;
    @FXML
    private Label winLabel;
    @FXML
    private Label player1totalLabel;
    @FXML
    private Button doubleButton;
    @FXML
    private Button hitButton;
    @FXML
    private Button addPlayer2Button;
    @FXML
    private GridPane mainGridPane;
    @FXML
    private Button standButton;
    @FXML
    private GridPane player1Grid1;
    @FXML
    private GridPane player1Grid2;
    @FXML
    private GridPane cpuGrid1;
    @FXML
    private GridPane cpuGrid2;
    @FXML
    private GridPane player2Grid1;
    @FXML
    private GridPane player2Grid2;
  

   

    //declare the deck of cards so it can be accessed throughout rest of application
    
    public DeckOfCards deck = new DeckOfCards();

    // Declare globally to be accessible throughout
    DealerNPC dealer = new DealerNPC();
    PlayerNPC playerNPC = new PlayerNPC();
    PlayerUser player = new PlayerUser();

    Card dealerCardNotShown;    // the second card in the dealers hand that is not displayed until the end of the turn

    int handValue;

    Card dealerCard1;

    int balance = 0;

    @FXML
    public void initialize() {
        deck.shuffle();

        
    }

    @FXML
    void addPlayer2ButtonPressed(ActionEvent event) {
        Player2TotalUpdateLabel.setText("???");
        player2Label.setText("PLAYER 2");
        
    }
    

    @FXML
    void betSliderOn(MouseEvent event) {
        betSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                betUpdateLabel.setText("" +(int)betSlider.getValue());
                //what do we want to do when the slider changes?
                //if hand is won, balance += (2 * bet amount)
                //if hand is lost balance -= bet amount
            }

        });
    }

    @FXML
    void dealCardButtonPressed(ActionEvent event) throws Exception {

        winLabel.setText("");

        if (deck.getNumOfCards() < 10) {
            deck.resetDeck();
            deck.shuffle();
            winLabel.setText("--DECK REPLACED AND SHUFFLED--");
            winLabel.setText("");
        }

        // Clear all GridPanes before dealing new cards
        clearGridPane(dealerGrid1);
        clearGridPane(cpuGrid1);
        clearGridPane(player1Grid1);

        //clear player hands before dealing new cards
        playerNPC.clearHand();
        dealer.clearHand();
        player.clearHand();


        // pull cards from deck and give cards to playerNPC and dealer objects
        for (int i = 0; i < 2; i++) {
            pullCardDealer();
            pullCardPlayerNPC();
            pullCardPlayer();
        }
                
        // display initial cards
        setDealerCards(dealerGrid1,dealer.getHand());
        displayHand(cpuGrid1,playerNPC.getHand());
        displayHand(player1Grid1, player.getHand());

        displayInitialTotals();
        List<Card> dealerHand = dealer.getHand();
        
        displayInitialTotals();

        if (player.calculateHandValue() == 21) {
            gameWin(false);
        }

        }


    public void setDealerCards(GridPane dealergrid, List<Card> hand) {

            String filename;
            File file;

            Card dealerCard1 = hand.get(0);

            filename = "/Users/marktudor/Desktop/Card_pics/" +  dealerCard1.toString() + ".png";

            file = new File(filename);

            if (file.exists()) {
            //load and display card image
            Image cardImage = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(58);
            imageView.setOpacity(0);
            dealerGrid1.add(imageView,0,0);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setDelay(Duration.seconds(0.5)); // Delay based on card index
            fadeTransition.play();
            }
            else {
            System.out.println("NOT FOUND");
            }
            //have to keep this card but not display it, this is the "face down card"
            Card dealerCardNotShown = hand.get(1);

            filename = "/Users/marktudor/Desktop/Card_pics/" +  "BACK" + ".png";

            file = new File(filename);

            if (file.exists()) {
            //load and display card image
            Image cardImage = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(58);
            imageView.setOpacity(0);
            dealerGrid1.add(imageView,1,0);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setDelay(Duration.seconds(0.5)); // Delay based on card index
            fadeTransition.play();
        }

    }


    @FXML
    void hitButtonPressed(ActionEvent event) {
        pullCardPlayer();
        displayHand(player1Grid1, player.getHand());
        displayInitialTotals();

        if (player.calculateHandValue() > 21 || player.calculateHandValue() == 21) {
            
            playerNPC.play(deck, dealer.getHand().get(0));
            displayHand(cpuGrid1,playerNPC.getHand());
            dealer.play(deck);
            displayHand(dealerGrid1, dealer.getHand());
            displayFullTotals();
            gameWin(false);
        }
    }

    @FXML
    void standButtonPressed(ActionEvent event) {
        // turn is ended
        playerNPC.play(deck,dealer.getHand().get(0));

        displayHand(cpuGrid1, playerNPC.getHand());

        showDealerSecondCard(dealer.getHand());
        dealer.play(deck);
        displayHand(dealerGrid1, dealer.getHand());
        displayTotals();
        gameWin(false);
        
    }
    @FXML
    void doubleButtonPressed(ActionEvent event) {
        winLabel.setText("DOUBLE DOWN! INITIAL BET VALUE DOUBLED.");
        pullCardPlayer();
        displayHand(player1Grid1, player.getHand());
        displayInitialTotals();
        playerNPC.play(deck, dealer.getVisibleCard());
        displayHand(cpuGrid1, playerNPC.getHand());
        displayInitialTotals();
        dealer.play(deck);
        displayHand(dealerGrid1, dealer.getHand());
        displayFullTotals();
        
        gameWin(true);

     

    }


    public void displayHand(GridPane gridToDisplayCards, List<Card> hand) {
        // variables
        String filename;
        File file;

        for (int i = 0; i < hand.size(); i++){

            Card cardInHand = hand.get(i);
    
            filename = "/Users/marktudor/Desktop/Card_pics/" +  cardInHand.toString() + ".png";
    
            file = new File(filename);
    
            if (file.exists()) {
            //load and display card image
            Image cardImage = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(58);
            imageView.setOpacity(0);
            gridToDisplayCards.add(imageView,i,0);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            //not going to use fade transition with delay  
            fadeTransition.setDelay(Duration.seconds(0.5)); // Delay based on card index
            fadeTransition.play();
    
        }

        }

}
// these functions pull cards from the deck and add to the hand of the respective object
public void pullCardPlayerNPC() {
    Card dealtCard = deck.dealCard();
    playerNPC.receiveCard(dealtCard);
}

public void pullCardDealer() {
    Card dealtCard = deck.dealCard();
    dealer.receiveCard(dealtCard);
}

public void pullCardPlayer() {
    Card dealtCard = deck.dealCard();
    player.receiveCard(dealtCard);
}

// method to clear GridPane of cards
public void clearGridPane(GridPane gridPane) {
    gridPane.getChildren().clear();
}

public String numToString(int num) {
    String numStr = String.valueOf(num);
    return numStr;
}

public void displayTotals() {
    //calculate hand values and display
    handValue = player.calculateHandValue();
    player1totalLabel.setText(numToString(handValue));
    handValue = dealer.calculateHandValue(dealer.getHand());
    dealerTotalLabel.setText(numToString(handValue));
    handValue = playerNPC.calculateHandValue(playerNPC.getHand());
    CPUTotalUpdateLabel.setText(numToString(handValue));
}

public void showDealerSecondCard(List<Card> hand) {
        String filename;
        File file;
        Card cardInHand = hand.get(1);
    
        filename = "/Users/marktudor/Desktop/Card_pics/" +  cardInHand.toString() + ".png";
    
        file = new File(filename);
    
        if (file.exists()) {
        //load and display card image
        Image cardImage = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(cardImage);
        imageView.setFitWidth(50);
        imageView.setFitHeight(58);
        imageView.setOpacity(0);
        dealerGrid1.add(imageView,1,0);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        //not going to use fade transition with delay  
        //fadeTransition.setDelay(Duration.seconds(i)); // Delay based on card index
        fadeTransition.play();
    
        }

        }
        public void displayInitialTotals() {
            handValue = dealer.calculateDealerInitialCardValue(dealer.getHand());
            dealerTotalLabel.setText(numToString(handValue));
            handValue = player.calculateHandValue();
            player1totalLabel.setText(numToString(handValue));
            handValue = playerNPC.calculateHandValue(playerNPC.getHand());
            CPUTotalUpdateLabel.setText(numToString(handValue));
        }

        public void displayFullTotals() {
            //calculate hand values and display
            handValue = player.calculateHandValue();
            player1totalLabel.setText(numToString(handValue));
            handValue = dealer.calculateHandValue(dealer.getHand());
            dealerTotalLabel.setText(numToString(handValue));
            handValue = playerNPC.calculateHandValue(playerNPC.getHand());
            CPUTotalUpdateLabel.setText(numToString(handValue));
        }

        public void gameWin(boolean doubleDownSelected) {
            //separate logic in this code
            if (doubleDownSelected == false) {
                if ((player.calculateHandValue() > dealer.calculateHandValue(dealer.getHand())) && player.calculateHandValue() <= 21){
                    winLabel.setText("WIN!");
                    balance =  (int)balance + (int)betSlider.getValue() * 2;
                    balanceUpdateLabel.setText("" + (int)balance);
                }
                else if ((dealer.calculateHandValue(dealer.getHand()) > 21) && player.calculateHandValue() <= 21) {
                    winLabel.setText("WIN!");
                    balance =  (int)balance + (int)betSlider.getValue() * 2;
                    balanceUpdateLabel.setText("" + (int)balance);
                }
                
                else if (player.calculateHandValue() < dealer.calculateHandValue(dealer.getHand()) && dealer.calculateHandValue(dealer.getHand()) <= 21 ) {
                    winLabel.setText("LOSS...");
                    balance = (int)balance - (int)betSlider.getValue();
                    balanceUpdateLabel.setText("" + (int)balance);
    
                }
                else if ((player.calculateHandValue() > 21)) {
                    winLabel.setText("LOSS...");
                    balance = (int)balance - (int)betSlider.getValue();
                    balanceUpdateLabel.setText("" + (int)balance);
                }
    
                else if (player.calculateHandValue() == dealer.calculateHandValue(dealer.getHand())) {
                    winLabel.setText("PUSH");
                    
                }

            }
            else {
                if ((player.calculateHandValue() > dealer.calculateHandValue(dealer.getHand())) && player.calculateHandValue() <= 21){
                    winLabel.setText("WIN!");
                    balance =  (int)balance + ((int)betSlider.getValue() * 4);
                    balanceUpdateLabel.setText("" + (int)balance);
                }
                else if ((dealer.calculateHandValue(dealer.getHand()) > 21) && player.calculateHandValue() <= 21) {
                    winLabel.setText("WIN!");
                    balance =  (int)balance + ((int)betSlider.getValue() * 4);
                    balanceUpdateLabel.setText("" + (int)balance);
                }
                
                else if (player.calculateHandValue() < dealer.calculateHandValue(dealer.getHand()) && dealer.calculateHandValue(dealer.getHand()) <= 21 ) {
                    winLabel.setText("LOSS...");
                    balance = (int)balance - ((int)betSlider.getValue() * 2);
                    balanceUpdateLabel.setText("" + (int)balance);
    
                }
                else if ((player.calculateHandValue() > 21)) {
                    winLabel.setText("LOSS...");
                    balance = (int)balance - ((int)betSlider.getValue() * 2);
                    balanceUpdateLabel.setText("" + (int)balance);
                }
    
                else if (player.calculateHandValue() == dealer.calculateHandValue(dealer.getHand())) {
                    winLabel.setText("PUSH");
                    
                }
            }
            
        }



}



