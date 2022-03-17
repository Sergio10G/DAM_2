import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
		Map<Integer, String> evaluatedWords = new HashMap<Integer, String>();
        File f = new File("./dics/cleandict.txt");
		File fwords = new File("./words.txt");
		FileReader fr = new FileReader(f);
		FileWriter fw = new FileWriter(fwords);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);

		String w;
		while ((w = br.readLine()) != null)
		{
			if (w.length() != 5)
				continue;
			if (countVowels(w) < 2)
				continue;
			if (!allCharsDiffer(w))
				continue;
			int score = evaluateWord(w);
			evaluatedWords.put(score, w);
		}
		List<Integer> sortedKeys = new ArrayList<>(evaluatedWords.keySet());
		Collections.sort(sortedKeys);

		for (Integer key : sortedKeys) {
			String word = evaluatedWords.get(key);
			bw.write(word + "\n");
		}

		bw.close();
		br.close();
		fr.close();
		fw.close();
    }

	public static int countVowels(String word) {
		int count = 0;
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || 
			word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
				count++;
		}
		return count;
	}

	public static boolean allCharsDiffer(String word) {
		for (int i = 0; i < word.length() - 1; i++) {
			for (int j = i + 1; j < word.length(); j++) {
				if (word.charAt(i) == word.charAt(j))
					return false;
			}
		}
		return true;
	}

	public static int evaluateWord (String word)
	{
		int score = 0;
		String mostCommonLetters = "EAOSRNIDLCTUMPBGVYQHFZJÑXKW";
		char[] mostCommonChars = mostCommonLetters.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < mostCommonChars.length; j++) {
				if (word.charAt(i) == mostCommonChars[j])
				{
					score += mostCommonChars.length - j;
					break;
				}
			}
		}
		return score;
	}
}
