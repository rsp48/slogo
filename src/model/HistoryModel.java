package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import backend_slogo_team04.Action;
import backend_slogo_team04.SlogoScanner;
import constants.DisplayConstants;
import frontend_slogo_team04.State;
import interfaces_slogo_team04.IHistoryModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import properties.ColorProperty;

public class HistoryModel extends State implements IHistoryModel{

	private ListProperty<String> commands;
	private StringProperty language;
	
	public HistoryModel(StringProperty language) {
		
		this.language = language;
		ObservableList<String> commandList = FXCollections.observableArrayList();
		commands = new SimpleListProperty<String>(commandList);
		addListeners();
		
	}
	
	private void addListeners() {
		language.addListener((a,b,c) -> updateText(b,c));
	}
	
	private void updateText(String old, String current) {
		for(int i=0; i<commands.size(); i++) {
			SlogoScanner scanner = new SlogoScanner(commands.get(i));
			ResourceBundle myBundle = ResourceBundle.getBundle(DisplayConstants.RESOURCES_PATH + old);
			String translated = scanner.getLanguageConvertedCode(myBundle);
			myBundle = ResourceBundle.getBundle(DisplayConstants.RESOURCES_PATH + current);
			translated = scanner.getCodeConvertToLanguage(myBundle);
			commands.set(i, translated);
		}
	}

	public ListProperty<String> getCommandList() {
		return commands;
	}
	
	public void add(String command) {
		SlogoScanner scanner = new SlogoScanner(command);
		ResourceBundle myBundle = ResourceBundle.getBundle(DisplayConstants.RESOURCES_PATH + language.get());
		String translated = scanner.getCodeConvertToLanguage(myBundle);
		commands.add(translated);
	}

	
	public StringProperty getLanguage() {
		return language;
	}

}
