package interfaces_slogo_team04;


import java.util.Observer;

public interface IView{

	public void addObserver(Observer o);
	public double xCor();
	public double yCor();
	public double isPenDown();
	public double getRotation();
}
