package frontend_features;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import constants.DisplayConstants;
import frontend_slogo_team04.State;
import frontend_slogo_team04.VisualTurtle;
import interfaces_slogo_team04.IView;
import javafx.scene.Node;
import javafx.scene.image.Image;
import visual_states.GuiUserOption;
import visual_states.ViewUIState;

public class View extends StaticPane implements Observer{

	private VisualTurtle turtle;
	private double scaleFactor = 1;
	private ViewUIState visuals;
	private IView model;
	
	public View(IView model) {
		turtle = new VisualTurtle(getFirstImage());
		this.model = model;
		addCSS("visual_resources/DefaultView.css");
		visuals = new ViewUIState();
		addSilentListeners();
		model.addObserver(this);
		setUp();
	}
	
	private Image getFirstImage() {
		return new Image(getClass().getClassLoader().getResourceAsStream("visual_resources/turtle.jpg"));
	}

	private void addSilentListeners() {
		visuals.getImageProperty().addListener((a,b,c) -> setTurtleImage(c));
		
	}
	public void draw() {

	}

	public void setUp() {
		add(turtle, getCenterXCor(),  getCenterYCor());
	}


	private void setTurtleImage(Image i) {
		turtle.setImage(i);
		
	}

	public double getMaxWidth() {
		return DisplayConstants.VIEW_WIDTH;
	}

	public double getMaxHeight() {
		return DisplayConstants.VIEW_HEIGHT;
	}


	public double getScaleFactor() {
		return scaleFactor;
	}
	

	public State getState() {
		return null;
	}
	
	public double getCenterXCor(){
		return DisplayConstants.VIEW_WIDTH/2;
	}
	
	public double getCenterYCor(){
		return DisplayConstants.VIEW_HEIGHT/2;
	}

	protected List<Node> getReleventProperties(GuiUserOption factory) {
		List<Node> list = new ArrayList<Node>();
		list.add(factory.get(visuals.getImageProperty(), "Choose Actor Image"));
		return list;
	}
	
	public void update(Observable o, Object arg) {
		
	}

}

