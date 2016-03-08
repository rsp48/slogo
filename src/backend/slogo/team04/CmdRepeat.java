package backend.slogo.team04;

import exceptions.LogicException;
import exceptions.UserInputException;
import interfaces.slogo.team04.ISlogoModelActions;


public class CmdRepeat extends CommandTreeNode {
   //TODO change this to a resource bundle reference
    private static final String REP_COUNT_VAR_NAME = ":repcount"; //TODO resource bundle perhaps so langauge change
    private CmdVariable myRepCount;
    private INonLinearCommand myExpression, myCommands;
    



    public CmdRepeat (CommandTreeNode myParent) {
        super(myParent);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double executeCommand (ISlogoModelActions myController, ISlogoInterpreter myInterpreter) throws LogicException {
        double limit = myExpression.executeCommand(myController, myInterpreter);
        double lastValueSeen = 0d;
        for(double i = 1d; i <= limit; i+=1d){
            myRepCount.setVariableValue(i, myInterpreter);
            lastValueSeen = myCommands.executeCommand(myController, myInterpreter);
        }
        return lastValueSeen;
    }

    @Override
    public INonLinearCommand parseString (SlogoScanner myScanner, ISlogoInterpreter myInterpreter) throws UserInputException {
        myExpression = CommandFactory.recursiveSlogoFactoryNoListsAllowed(myScanner, this, myInterpreter);     
        myRepCount = new CmdVariable(this, REP_COUNT_VAR_NAME);
        myCommands = new CmdListOfCommands(this).parseString(myScanner, myInterpreter);
        return this;
    }

}
