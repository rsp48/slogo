package backend_slogo_team04;

import java.util.Scanner;
import exceptions.UserInputException;
import interfaces_slogo_team04.ISlogoModelActions;

public class CmdSum extends CommandTreeNode {



    public CmdSum (Controller myController, CommandTreeNode myParent) {
        super(myController, myParent);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double executeCommand (ISlogoModelActions myController, ISlogoInterpreter myInterpreter) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public INonLinearCommand parseString (Scanner myScanner, ISlogoInterpreter myInterpreter) throws UserInputException {
        // TODO Auto-generated method stub
        return null;
    }

}