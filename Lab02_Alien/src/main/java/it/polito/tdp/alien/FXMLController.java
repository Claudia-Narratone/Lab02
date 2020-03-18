package it.polito.tdp.alien;

import java.net.URL;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dictionary=new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	txtInsert.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	//controllo input
    	String testo=txtInsert.getText().toLowerCase();
    	try {
    		testoValido(testo);
    	}catch(IllegalArgumentException e) {
    		txtResult.appendText("Devi inserire solo caratteri alfabetici");
    		return;
    	}
    	
    	
    	if(testo.contains(" ")) {
    		String[] parole=testo.split(" ");
    		String alienWord=parole[0];
    		String translation=parole[1];
    		dictionary.addWord(alienWord, translation);
    		txtResult.appendText("parola aggiunta al dizionario: "+alienWord+"\n");
    	}else {
    		for(String s:dictionary.translateWord(testo)) {
    			txtResult.appendText("Traduzione "+testo+": "+s+"\n");
    		}
    		
    	}
    }
    
    public boolean testoValido(String testo) {
    	for(int i=0;i<testo.length()-1;i++){
    		char ch=testo.charAt(i);
    		if(!(Character.isAlphabetic(ch) || ch==' ')) {
    			throw new IllegalArgumentException("Inserire solo caratteri alfabetici");
    		}
    	}
    	return true;
    }
    

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
