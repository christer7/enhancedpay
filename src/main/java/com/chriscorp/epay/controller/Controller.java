package com.chriscorp.epay.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private RadioButton creditCardRadioButton;

    @FXML
    private Label labelValidCard;

    @FXML
    public void finalizeCheckout(ActionEvent event) {
        System.out.println("Testing the finalizeCheckout event");
    }

    @FXML
    public void creditCardRadioB(ActionEvent event) {
        System.out.println("Testing the Credit Card");
    }

    @FXML
    public void boletoRadioB(ActionEvent event) {
        System.out.println("Testing the Boleto");
    }

    @FXML
    public void useBoleto(ActionEvent event) {
        System.out.println("Use the boleto");
    }

    @FXML
    public void validateCard(ActionEvent event) {
        System.out.println("Validate the card");


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

/*        paymentTypeRB.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (paymentTypeRB.getSelectedToggle() != null) {
                    if (paymentTypeRB.getSelectedToggle().getUserData() == creditCardRadioButton.getUserData()) {
                        System.out.println("Choosed: " + creditCardRadioButton.getText());
                    } else {
                        System.out.println("Choosed: " + boletoRadioButton.getText());
                    }
                } else {
                    System.out.println("Not geeting any selected");
                }


            }
        });*/


        }



    }



