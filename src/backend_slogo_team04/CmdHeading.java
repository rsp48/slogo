package backend_slogo_team04;

import java.util.Scanner;

public class CmdHeading extends CommandTreeNode {

    public CmdHeading (Controller myController) {
        super(myController);
        // TODO Auto-generated constructor stub
    }

    public CmdHeading (Controller myController, CommandTreeNode myParent) {
        super(myController, myParent);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double executeCommand (Controller myController, Interpreter myInterpreter) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public INonLinearCommand parseString (Scanner myScanner) {
        // TODO Auto-generated method stub
        return null;
    }

}
