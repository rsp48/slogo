package backend_slogo_team04;

public class Parser {
    
    Controller myController;
    Interpreter myInterpreter;
    
    public Parser(Controller myController){
        this.myController = myController;
        myInterpreter = new Interpreter();
    }
    
    
    public Action parseString(String stringToParse){
        //TODO something that breaks input string into space delineated words
        
        NonLinearCommand myHeadNode = null; // now make the tree here
        
        //TODO 
        myInterpreter.interpretCommandTree(myHeadNode);
        return null;
    }
    
    private void makeCommandTree(){
        
    }
    
    public NonLinearCommand getNonLinearCommandForString(String input){
        return null;
    }
    
    

}
