/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxLingua"
    private ComboBox<String> boxLingua; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpell"
    private Button btnSpell; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrori"
    private TextArea txtErrori; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumErr"
    private Label txtNumErr; // Value injected by FXMLLoader

    @FXML // fx:id="txtParole"
    private TextArea txtParole; // Value injected by FXMLLoader

    @FXML // fx:id="txtTemp"
    private Label txtTemp; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtErrori.clear();
    	this.txtParole.clear();
    	

    }
 
    @FXML
    void handleCorrezione(ActionEvent event) {
      	String s= this.txtParole.getText();
    	s=s.toLowerCase();
    	s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String array[];
    	ArrayList<String> list= new ArrayList<String>();
    	String lingua= (String)this.boxLingua.getValue();
    	
    	model.loadDictionary(lingua);
    	array=s.split(" ");
    	for(String si: array) {
    		list.add(si);
    	}
    	List<RichWord> listChecked =model.spellCheckText(list);
    	int contatore=0;

    	if(s.length()>0) {
    	for(RichWord ri: listChecked) {
    		if(ri.isCorrect()==false) {
    			contatore++;
    		this.txtErrori.appendText(ri.getParola()+"\n");
    		}
    		this.txtNumErr.setText(Integer.toString(contatore));
    	}
    }
    	else {
    		this.txtErrori.setText("Scrivere una parola nell'apposito campo");
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumErr != null : "fx:id=\"txtNumErr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTemp != null : "fx:id=\"txtTemp\" was not injected: check your FXML file 'Scene.fxml'.";
        
        boxLingua.getItems().add("English");
        boxLingua.getItems().add("Italian");

    }

	public void setModel(Dictionary model) {
		this.model=model;
		
	}

}




