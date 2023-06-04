package com.example.sampleproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameWindowController {

    @FXML
    private Button addCardButton;

    @FXML
    private GridPane deskAttackCardPane;

    @FXML
    private GridPane deskAnswerCardPane;

    @FXML
    private ScrollPane firstPlayerScroll;

    @FXML
    private ScrollPane secondPlayerScroll;

    @FXML
    private FlowPane firstPlayerPane;

    @FXML
    private FlowPane secondPlayerPane;

    String[] Cost0 = {"6", "7", "8", "9", "10", "Vallet", "Dama", "Korol'", "Tuz"};

    String[] Name0 = {"Bubi", "Kresti", "Chervi", "Piki"};
    ArrayList<String> Cost = new ArrayList<>(Arrays.asList(Cost0));
    ArrayList<String> Name = new ArrayList<>(Arrays.asList(Name0));

    @FXML
    void addCard(ActionEvent event) throws IOException, InterruptedException {
        int size = firstPlayerPane.getChildren().size() + secondPlayerPane.getChildren().size();
        if (size < 12 && size % 2 == 0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            int n = (int) Math.floor(Math.random() * Cost.size());
            int n1 = (int) Math.floor(Math.random() * Name.size());

            CardController cardController = loader.getController();
            cardController.setCardParameters(Cost.get(n), Name.get(n1), this, newPane);


            firstPlayerPane.getChildren().add(newPane);

            firstPlayerScroll = new ScrollPane();
            firstPlayerScroll.setContent(firstPlayerPane);
        }
        else if (size < 12 && size % 2 == 1){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            int n = (int) Math.floor(Math.random() * Cost.size());
            int n1 = (int) Math.floor(Math.random() * Name.size());

            CardController cardController = loader.getController();
            cardController.setCardParameters(Cost.get(n), Name.get(n1), this, newPane);


            secondPlayerPane.getChildren().add(newPane);

            secondPlayerScroll = new ScrollPane();
            secondPlayerScroll.setContent(secondPlayerPane);
        }
    }

    public void addCardOnTable(CardController card) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Card.fxml"));

        Pane newPane = (Pane) loader.load();

        CardController cardController = loader.getController();
        cardController.setCardParameters(card.getNominal(), card.getMask(), this, newPane);

        deskAttackCardPane.add(newPane, deskAttackCardPane.getChildren().size(), 0);
    }
}
