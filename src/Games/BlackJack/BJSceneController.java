<<<<<<< HEAD:src/Games/BlackJack/Mechanics/BJSceneController.java
package Games.BlackJack.Mechanics;
=======
package Games.BlackJack;
>>>>>>> main:src/Games/BlackJack/BJSceneController.java
import Games.BlackJack.Mechanics.DeckOfCards;
import Games.BlackJack.Mechanics.Card;

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

    Card dealerCardNotShown;    // the second card in the dealers hand that is not displayed until the end of the turn

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

        // Clear all GridPanes before dealing new cards
        clearGridPane(dealerGrid1);
        clearGridPane(cpuGrid1);

        //clear player hands before dealing new cards
        playerNPC.clearHand();
        dealer.clearHand();

        // pull cards from deck and give cards to playerNPC and dealer objects
        for (int i = 0; i < 2; i++) {
            pullCardDealer();
            pullCardPlayerNPC();
        }
                
        // display initial cards
        setDealerCards(dealerGrid1,dealer.getHand());
        displayHand(cpuGrid1,playerNPC.getHand());

        }


    public void setDealerCards(GridPane dealergrid, List<Card> hand) {

            String filename;
            File file;

            Card card1inHand = hand.get(0);

<<<<<<< HEAD:src/Games/BlackJack/Mechanics/BJSceneController.java
            filename = "/Users/marktudor/Desktop/Card_pics/" +  card1inHand.toString() + ".png";
=======
            filename = "./Card_pics/" +  dealtCard.toString() + ".png";
>>>>>>> main:src/Games/BlackJack/BJSceneController.java

            file = new File(filename);

            if (file.exists()) {
            //load and display card image
            Image cardImage = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(58);
            imageView.setOpacity(0);
            dealerGrid1.add(imageView,0,0);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            //fadeTransition.setDelay(Duration.seconds(2)); // Delay based on card index
            fadeTransition.play();
            }
            else {
            System.out.println("NOT FOUND");
            }
            //have to keep this card but not display it, this is the "face down card"
            Card dealerCardNotShown = hand.get(1);

            filename = "./Card_pics/" +  "BACK" + ".png";

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
            //fadeTransition.setDelay(Duration.seconds(2)); // Delay based on card index
            fadeTransition.play();
        }

    }

<<<<<<< HEAD:src/Games/BlackJack/Mechanics/BJSceneController.java
=======
        String filename;
        File file;
        
        for (int i = 0; i < 2; i++){
            Card dealtCard = deck.dealCard();

            filename = "./Card_pics/" +  dealtCard.toString() + ".png";

            file = new File(filename);

            if (file.exists()) {
            //load and display card image
            Image cardImage = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(58);
            imageView.setOpacity(0);
            player1Grid1.add(imageView,i,0);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            //not going to use fade transisiton with delay  
            //fadeTransition.setDelay(Duration.seconds(i)); // Delay based on card index
            fadeTransition.play();
            cardValue = dealtCard.getFaceValue();
            //Keeps track if card dealt is an ace, if yes; must hold both values added to player total
            if (cardValue == 1) {
                player1Total += cardValue;
                player1Acetotal += 11;
                playerAceCard = true;
            }
            else {
                player1Total += cardValue;
                player1Acetotal += cardValue;
            }
            
            }
            else {
            System.out.println("NOT FOUND");
            }

        }
        //if 1 of the players cards is an ace, display both values (card + 1, card + 11)
        if (player1Acetotal == 21) {
            player1totalLabel.setText("" + player1Acetotal);
            winLabel.setText("BLACKJACK!!");
        }
        else if (playerAceCard) {
            player1totalLabel.setText(""+ player1Total + "/" + player1Acetotal);
        }
        else {
            player1totalLabel.setText("" + player1Total);
        }

    }
    public void setCPUcards(GridPane cpuGrid1, DeckOfCards deck) {
        cpuTotal = 0;
        int cpuAcetotal = 0;
        boolean cpuAceCard = false;
        int cardValue = 0;

        String filename;
        File file;
        
        for (int i = 0; i < 2; i++){
            Card dealtCard = deck.dealCard();

            filename = "./Card_pics/" +  dealtCard.toString() + ".png";

            file = new File(filename);

            if (file.exists()) {
            //load and display card image
            Image cardImage = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(58);
            imageView.setOpacity(0);
            cpuGrid1.add(imageView,i,0);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            //not going to use fade transisiton with delay  
            //fadeTransition.setDelay(Duration.seconds(i)); // Delay based on card index
            fadeTransition.play();
            cardValue = dealtCard.getFaceValue();
            //Keeps track if card dealt is an ace, if yes; must hold both values added to player total
            if (cardValue == 1) {
                cpuTotal += cardValue;
                cpuAcetotal += 11;
                cpuAceCard = true;
            }
            else {
                cpuTotal += cardValue;
                cpuAcetotal += cardValue;
            }
            
            }
            else {
            System.out.println("NOT FOUND");
            }

        }
        //if 1 of the players cards is an ace, display both values (card + 1, card + 11)
        if (cpuAcetotal == 21) {
            CPUTotalUpdateLabel.setText("" + cpuAcetotal);
            winLabel.setText("BLACKJACK!!");
        }
        else if (cpuAceCard) {
            CPUTotalUpdateLabel.setText(""+ cpuTotal + "/" + cpuAcetotal);
        }
        else {
            CPUTotalUpdateLabel.setText("" + cpuTotal);
        }
    }
    


    
>>>>>>> main:src/Games/BlackJack/BJSceneController.java

    @FXML
    void hitButtonPressed(ActionEvent event) {
        // Have to know which object selected to hit

        // pull card method will be called
        // displayHand method will be called
    }

    @FXML
    void standButtonPressed(ActionEvent event) {
        // turn is ended
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
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            //not going to use fade transition with delay  
            //fadeTransition.setDelay(Duration.seconds(i)); // Delay based on card index
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

// method to clear GridPane of cards
public void clearGridPane(GridPane gridPane) {
    gridPane.getChildren().clear();
}









}


