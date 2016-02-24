package backend_slogo_team04;

import java.util.ResourceBundle;
import java.util.Scanner;

public class SlogoScanner {
    private static final String ALL_WHITESPACE_REGEX = "[ \\t\\x0B\\f\\r]+";
    private static final String WHITESPACE = " ";
    private Scanner myScanner;
    
    public SlogoScanner(String myString){
        this.myScanner = new Scanner(myString);
        this.myScanner.useDelimiter(ALL_WHITESPACE_REGEX);
    }
    
    public Scanner getSlogoFormattedScanner(){
        return this.myScanner;
    }
    
    /**
     * NEED TO REFACTOR THESE 4 METHODS INTO 2
     */
   public String getLanguageConvertedCode(ResourceBundle myResourceBundle) {
       StringBuilder myStringBuilder = new StringBuilder();
       while(myScanner.hasNext()){
           String nextSlogoCommand = convert(myScanner.next(), myResourceBundle);
           myStringBuilder.append(nextSlogoCommand + WHITESPACE);
       }

       return myStringBuilder.toString();
   }
   
   public String getCodeConvertToLanguage(ResourceBundle myResourceBundle) {
       StringBuilder myStringBuilder = new StringBuilder();
       while(myScanner.hasNext()){
           String nextSlogoCommand = convertReverse(myScanner.next(), myResourceBundle);
           myStringBuilder.append(nextSlogoCommand + WHITESPACE);
       }

       return myStringBuilder.toString();
   }
    
    
    private String convert(String text, ResourceBundle myBundle ) {
        for(String key: myBundle.keySet()) {
                if(text.matches(myBundle.getString(key))) {
                        text = key;
                        break;
                }
        }
        return text;
    }  
    
    private String convertReverse(String text, ResourceBundle myBundle ) {
        if(myBundle.containsKey(text)) {
              String str = myBundle.getString(text);
              return str.substring(0, str.indexOf("|"));
        }
        return text;
    } 

}
