package worcCounter.implementation;

import worcCounter.strategie.WordCounterStrat;

public class WordCounterInteger implements WordCounterStrat {

    int len ;
    public  WordCounterInteger(int len ){
        this.len = len ;
    }

    @Override
    public boolean wordIsExist(String word) {
        return word.length()==len;
    }
}
