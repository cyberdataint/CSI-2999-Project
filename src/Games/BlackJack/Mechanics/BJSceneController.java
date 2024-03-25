package visualsfx;
import visualsfx.DeckOfCards;
import visualsfx.Card;

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
  
    //variables I want to be able to access throughout code below,  declaring dealer, player totals
    int dealerTotal;
    int player1Total;
    int player2Total;
    int cpuTotal;

    //declare the deck of cards so it can be accessed throughout rest of application
    
    public DeckOfCards deck = new DeckOfCards();
    // Component event handling methods and methods I created to supplement event handling below such as setDealerCards and setPlayer1Cards

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
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        setDealerCards(dealerGrid1, deck);
        setPlayer1Cards(player1Grid1, deck);
        setCPUcards(cpuGrid1, deck);

        }


    public void setDealerCards(GridPane dealergrid, DeckOfCards deck) {
            dealerTotal = 0;
            int dealerAcetotal = 0;
            boolean dealerAceCard = false;
            int cardValue = 0;

            String filename;
            File file;

            Card dealtCard = deck.dealCard();

            filename = "/Users/marktudor/Desktop/Card_pics/" +  dealtCard.toString() + ".png";

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
            cardValue = dealtCard.getFaceValue();
            if (cardValue == 1) {
                dealerTotal += cardValue;
                dealerAcetotal += 11;
                dealerAceCard = true;
            }
            else {
                dealerTotal += cardValue;
            }
            if (dealerTotal == 1) {
                int secondtotal = dealerTotal + 11;
                dealerTotalLabel.setText("" + dealerTotal + "/" + secondtotal);
            }
            else {
                dealerTotalLabel.setText("" + dealerTotal);
            }
            
            
            }
            else {
            System.out.println("NOT FOUND");
            }
            //have to keep this card but not display it, this is the "face down card"
            Card notShownCard = deck.dealCard();

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
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            //fadeTransition.setDelay(Duration.seconds(2)); // Delay based on card index
            fadeTransition.play();
            
            cardValue = dealtCard.getFaceValue();
            if (cardValue == 1) {
                dealerTotal += cardValue;
                if (dealerAcetotal == 11) {
                    dealerAcetotal += 1;
                }
                else {
                    dealerAcetotal += cardValue;
                }
            }
            /* 
            if (dealerAceCard) {
                dealerTotalLabel.setText("" + dealerTotal + "/" + dealerAcetotal);
            }
            else {
                dealerTotalLabel.setText("" + dealerTotal);
            }
            }
            else {
            System.out.println("NOT FOUND");
            }
            dealerTotalLabel.setText("" + dealerTotal);
            */
        }

    }
    public void setPlayer1Cards(GridPane player1Grid1, DeckOfCards deck) {
        player1Total = 0;
        int player1Acetotal = 0;
        boolean playerAceCard = false;
        int cardValue = 0;

        String filename;
        File file;
        
        for (int i = 0; i < 2; i++){
            Card dealtCard = deck.dealCard();

            filename = "/Users/marktudor/Desktop/Card_pics/" +  dealtCard.toString() + ".png";

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

            filename = "/Users/marktudor/Desktop/Card_pics/" +  dealtCard.toString() + ".png";

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
    


    

    @FXML
    void hitButtonPressed(ActionEvent event) {
        
    }

    @FXML
    void standButtonPressed(ActionEvent event) {

    }
    
    
     
    }


