package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	AlienDictionary d = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String testo[] = txtWord.getText().toLowerCase().split(" ");
    	
    	if(testo.length==1) {
    		String alienWord = testo[0];
    		String traduzione = d.translateWord(alienWord);
    		if(traduzione == null)
    			txtResult.setText("Parola non presente\n");
    		else
    			txtResult.setText(traduzione+"\n");
    	}
    	else {
    	String alienWord = testo[0];
    	String translation = testo[1];
    	d.addWord(alienWord, translation);
    	txtResult.setText("Aggiunto al dizionario\n");
    	}
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}