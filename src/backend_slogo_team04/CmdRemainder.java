package backend_slogo_team04;

import java.util.Scanner;

public class CmdRemainder extends CommandTreeNode {

    public CmdRemainder (Controller myController) {
        super(myController);
        // TODO Auto-generated constructor stub
    }

    public CmdRemainder (Controller myController, CommandTreeNode myParent) {
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
