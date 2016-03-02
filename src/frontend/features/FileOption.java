package frontend.features;

import java.util.ResourceBundle;
import java.util.Set;

import constants.DisplayConstants;
import constants.ResourceConstants;
import frontend.slogo.team04.Workspace;
import frontend.slogo.team04.WorkspaceManager;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

public class FileOption extends Menu {

	private WorkspaceManager manager;
	private ResourceBundle myBundle;
	private Menu open;
	
	public FileOption(WorkspaceManager manager) {
		myBundle = ResourceBundle.getBundle(DisplayConstants.RESOURCES_PATH + ResourceConstants.ENGLISH);
		this.manager= manager;
		this.setText(myBundle.getString("File"));
		setUp();
		addListeners();
	}
	
	private void addListeners() {
		manager.getWorkspaceNames().addListener((a,b,c) -> makeOpenMenuItems(c));
	}

	private void makeOpenMenuItems(ObservableList<String> c) {
		open.getItems().clear();
		for(String name: c) {
			addToOpen(name);
		}
	}

	private void addToOpen(String name) {
		MenuItem item = new MenuItem(name);
		open.getItems().add(item);
		item.setOnAction(e -> manager.show(name));
		
	}

	private void setUp() {
		MenuItem newWorkspace = new MenuItem(myBundle.getString("New"));
		open = new Menu("Open");
		newWorkspace.setOnAction( e-> getDialog());
		this.getItems().add(newWorkspace);
		this.getItems().add(open);
		makeOpenMenuItems(manager.getWorkspaceNames());
	}
	
	private void getDialog() {
		TextInputDialog nameInput = new TextInputDialog();
		nameInput.show();
		nameInput.setOnCloseRequest(e-> newWorkspace(nameInput));
	}
	
	private void newWorkspace(TextInputDialog nameInput) {
		if(nameInput.getResult()!=null) {
			manager.addNewAndGo(nameInput.getResult());
		}	
	}
}
