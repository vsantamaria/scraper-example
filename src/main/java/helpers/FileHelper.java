package helpers;

import constants.Category;
import domain.Ad;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @date Apr 30, 2017
 * @author vsantamaria
 */


public class FileHelper {

	static final Logger LOGGER = Logger.getAnonymousLogger();

	
	public static void createCorpusDirs() {
		String corpusPath = "src/main/resources/corpus";
		for (Category category : Category.values()) {
			File dir = new File(corpusPath + "/" + category.getName());
			if (!dir.exists()) {
				System.out.println(dir.mkdirs());
			}
		}
	}
	
	public static void saveAd(Ad ad, String path) {
		String content = ad.getTitle() + "\n" + ad.getText();
		try {
			Files.write(Paths.get(path), content.getBytes());
		} catch (IOException ex) {
			LOGGER.log(Level.INFO, "", ex);
		}
	}

}
