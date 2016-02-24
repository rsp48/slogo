package backend_slogo_team04;

import java.util.Scanner;
import exceptions.UserInputException;
import interfaces_slogo_team04.ISlogoModelActions;

public class CmdNotEqual extends CommandTreeNode {
    private INonLinearCommand expressionOne, expressionTwo;

    public CmdNotEqual (CommandTreeNode myParent) {
        super(myParent);
    }

    @Override
    public double executeCommand (ISlogoModelActions myController, ISlogoInterpreter myInterpreter) {
        double valOne, valTwo;
        valOne = expressionOne.executeCommand(myController, myInterpreter);
        valTwo = expressionTwo.executeCommand(myController, myInterpreter);
        return oneIfNotEqual(valOne, valTwo);
    }

    private double oneIfNotEqual(double valOne, double valTwo){
        int compareOutput = Double.compare(valOne, valTwo);
        if(compareOutput == 0){
            return CommandTreeNode.DOUBLE_ZERO;
        }
        return CommandTreeNode.DOUBLE_ONE;
    }

    @Override
    public INonLinearCommand parseString (Scanner myScanner, ISlogoInterpreter myInterpreter) throws UserInputException {
        expressionOne = CommandTreeNode.recursiveSlogoFactory(myScanner, this, myInterpreter);
        expressionTwo = CommandTreeNode.recursiveSlogoFactory(myScanner, this, myInterpreter);
        return this;
    }

}