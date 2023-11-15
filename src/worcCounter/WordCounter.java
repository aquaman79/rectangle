package worcCounter;

import worcCounter.strategie.WordCounterStrat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WordCounter {
	private String fileName;

	WordCounterStrat wordCounterStrat ;
	public WordCounter(String fileName,WordCounterStrat wordCounterStrat) {
		this.fileName = fileName;
		this.wordCounterStrat = wordCounterStrat;
	}

	public int countWords() throws IOException {
		try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
			String buffer = null;
			int wordCount = 0;
			buffer = inputFile.readLine();
			while (buffer != null) {
				StringTokenizer words = new StringTokenizer(buffer);
				while (words.hasMoreTokens()) {
					String word = words.nextToken();
					if (this.wordCounterStrat.wordIsExist(word))
						wordCount++;
				}
				buffer = inputFile.readLine();
			}
			return wordCount;
		}
	}
}
