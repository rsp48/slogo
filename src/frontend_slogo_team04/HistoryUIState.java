package frontend_slogo_team04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import constants.DisplayConstants;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanBooleanProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import properties.*;


public class HistoryUIState extends State {

	ColorProperty color;
	StringProperty language;
	
	public HistoryUIState() {
		color = new ColorProperty();
		language = new SimpleStringProperty("English");
	}
	
	public StringProperty getLanguageProperty() {
		return language;
	}
	
	public ColorProperty getColorProperty() {
		return color;
	}

}