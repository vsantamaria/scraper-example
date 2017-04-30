
import constants.Category;
import domain.Ad;
import helpers.FileHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ScraperService;

/**
 * @date Apr 30, 2017
 * @author vsantamaria
 */

public class App {

	static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String[] args) {

		ScraperService scraper = new ScraperService();

		List<Ad> ads = new ArrayList<>();

		//get ads for each category
		for (Category category : Category.values()) {
			ads.addAll(scraper.getAdsByCategory(category));
		}

		//save ads
		try {
			FileHelper.createCorpusDirs();
			String corpusPath = "src/main/resources/corpus";
			for (Ad ad : ads) {
				String fileName = new Date().getTime() + ".txt";
				String path = corpusPath + "/" + ad.getCategory().getName() + "/" + fileName;
				FileHelper.saveAd(ad, path);
				LOGGER.info("Ad saved to:" + path);
			}
		} catch (Exception ex) {
			LOGGER.log(Level.FINE, "", ex);
		}

	}

}
