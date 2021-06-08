/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Connessione;
import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="distanzaMinima"
    private TextField distanzaMinima; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaAeroporti(ActionEvent event) {
    	String dist = distanzaMinima.getText();
    	int distanza = 0;
    	try {
    		distanza = Integer.parseInt(dist);
    	} catch(NumberFormatException e) {
    		txtResult.setText("Devi inserire un numero!");
    		return;
    	} catch(NullPointerException ne) {
    		txtResult.setText("Devi inserire un numero!");
    		return;
    	}
    	this.model.creaGrafo(distanza);
    	//List<Connessione> result = new LinkedList<Connessione>(this.model.creaGrafo(distanza));
    	txtResult.setText("# VERTICI: " + this.model.getNumeroVertici()+"\n");
    	txtResult.appendText("# ARCHI: " + this.model.getNumeroArchi(distanza)+"\n");
    	
    	for(Connessione c: this.model.getArchi(distanza)) {
    		txtResult.appendText(c.getA1().getAirportName()+" "+c.getA2().getAirportName()+" "+c.getPeso()+"\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert distanzaMinima != null : "fx:id=\"distanzaMinima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
