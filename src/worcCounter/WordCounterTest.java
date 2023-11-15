package worcCounter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import worcCounter.implementation.WordCounterChar;
import worcCounter.implementation.WordCounterInteger;

class WordCounterTest {

	@Test
	void test1() {
		WordCounterChar wordCounterChar = new WordCounterChar('A');
		WordCounter fwc = new WordCounter("sample.txt",wordCounterChar);
		try {
			int count = fwc.countWords();
			assertTrue(count == 4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		WordCounterInteger wordCounterInteger = new WordCounterInteger(4);

		WordCounter fwc = new WordCounter("sample.txt",wordCounterInteger);
		try {
			int count = fwc.countWords();
			assertTrue(count == 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
