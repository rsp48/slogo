package backend.slogo.team04;

import exceptions.LogicException;
import exceptions.UserInputException;
import interfaces.slogo.team04.ISlogoModelActionsExtended;


public class CmdSetPalette extends CommandTreeNode {
    private INonLinearCommand myIndex, myR, myG, myB;
    private double proposedIndex, proposedR, proposedG, proposedB;



    public CmdSetPalette (CommandTreeNode myParent) {
        super(myParent);

    }

    @Override
    public double executeCommand (ISlogoModelActionsExtended myController, ISlogoInterpreter myInterpreter) throws LogicException {
        proposedIndex = myIndex.executeCommand(myController, myInterpreter);
        proposedR = myR.executeCommand(myController, myInterpreter);
        proposedG = myG.executeCommand(myController, myInterpreter);
        proposedB = myB.executeCommand(myController, myInterpreter);
        if(SlogoRegexChecker.isIndexValue(proposedIndex)
                && SlogoRegexChecker.isRGBValue(proposedR)
                && SlogoRegexChecker.isRGBValue(proposedG)
                && SlogoRegexChecker.isRGBValue(proposedB)){
            return myController.setPalette((int) proposedIndex, (int) proposedR, (int) proposedG, (int) proposedB);
        }else{
            throw new LogicException("Improper input values into set palette command");
        }
    }
    
    


    @Override
    public INonLinearCommand parseString (SlogoScanner myScanner, ISlogoInterpreter myInterpreter) throws UserInputException {
        myIndex = CommandFactory.recursiveSlogoFactoryNoListsAllowed(myScanner, this, myInterpreter);
        myR = CommandFactory.recursiveSlogoFactoryNoListsAllowed(myScanner, this, myInterpreter);
        myG = CommandFactory.recursiveSlogoFactoryNoListsAllowed(myScanner, this, myInterpreter);
        myB = CommandFactory.recursiveSlogoFactoryNoListsAllowed(myScanner, this, myInterpreter);
        
        return this;
    }

}