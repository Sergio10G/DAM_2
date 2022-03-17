import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CleanDict {
	public static void main(String[] args) {
		try {
			List<String> words = new ArrayList<>();
        	File f = new File("./dics/dict.txt");
			File fclean = new File("./dics/cleandict.txt");
			FileReader fr = new FileReader(f);
			FileWriter fw = new FileWriter(fclean);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);

			String w;
			while ((w = br.readLine()) != null)
			{
				if (w.contains("-") || w.contains(",") || w.matches("[a-zA-Z]*[0-9][a-zA-Z]*"))
					continue;
					bw.append(w + "\n");
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
