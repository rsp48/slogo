package model;


import backend_slogo_team04.Action;
import backend_slogo_team04.Actor;

import java.util.List;
import java.util.Observable;
import interfaces_slogo_team04.ISlogoModelActions;
import interfaces_slogo_team04.IView;
import properties.ColorProperty;

public class ViewModel extends Observable implements IView, ISlogoModelActions {
	
	private Actor turtle;
	private boolean penDown = true;
	private boolean isShowing = true;
	private ColorProperty backgroundColor;
	
	public ViewModel() {
		backgroundColor = new ColorProperty();
	}
	
	public double forward(double pixels) {

		turtle.setYLocation(pixels);
		setChanged();
		notifyObservers();
		return turtle.getYLocation();
	}

	@Override
	public double back(double pixels) {
		turtle.setYLocation(pixels);
		setChanged();
		notifyObservers();
		return turtle.getYLocation();
	}

	@Override
	public double left(double pixels) {
		turtle.setXLocation(pixels);
		setChanged();
		notifyObservers();
		return turtle.getXLocation();
	}

	@Override
	public double right(double pixels) {
		turtle.setXLocation(pixels);
		setChanged();
		notifyObservers();
		return turtle.getXLocation();
	}

	@Override
	public double setHeading(double degrees) {
		turtle.setHeading(degrees);
		setChanged();
		notifyObservers();
		return turtle.getHeading();
	}

	@Override
	public double towards(double x, double y) {
		setChanged();
		notifyObservers();
		return 0;
	}

	@Override
	public double[] setxy(double x, double y) {
		double [] location = new double [2];
		turtle.setXLocation(x);
		turtle.setYLocation(y);
		setChanged();
		notifyObservers();
		location[0] = turtle.getXLocation();
		location[1] = turtle.getYLocation();
		return location;
	}

	public double penDown() {
		setChanged();
		notifyObservers();
		return 1;
	}

	public double penUp() {
		setChanged();
		notifyObservers();
		return 0;
	}

	@Override
	public double showTurtle() {
		setChanged();
		isShowing = true;
		notifyObservers();
		return 0;
	}

	@Override
	public double hideTurtle() {
		isShowing = false;
		setChanged();
		notifyObservers();
		return 0;
	}

	@Override
	public double home() {
		// TODO Auto-generated method stub
		setChanged();
		
		notifyObservers();
		return 0;
	}

	@Override
	public double xCor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double yCor() {
		return turtle.getYLocation();
	}

	@Override
	public double heading() {
		return turtle.getHeading();
	}

	@Override
	public double isPenDown() {
		return (penDown)? 1:0;
	}

	@Override
	public double isShowing() {
		return (isShowing)? 1:0;
	}

	public double getRotation(){
		return turtle.getRotation();
	}

	@Override
	public ColorProperty getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public double clearScreen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Action> getHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
