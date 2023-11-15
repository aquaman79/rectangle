package worcCounter.implementation;

import worcCounter.strategie.WordCounterStrat;

public class WordCounterChar implements WordCounterStrat {

    char caracter ;
    public  WordCounterChar(char  caracter ){
        this.caracter = caracter ;
    }
    @Override
    public boolean wordIsExist(String word) {
       return word.charAt(0) == this.caracter;
    }
}
