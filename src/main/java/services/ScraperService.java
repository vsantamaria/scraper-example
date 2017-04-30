package services;

import constants.Category;
import constants.SiteConstants;
import domain.Ad;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @date Apr 30, 2017
 * @author vsantamaria
 */
public class ScraperService {

	static final Logger LOGGER = Logger.getAnonymousLogger();

	public List<Ad> getAdsByCategory(Category category) {

		List<Ad> ads = new ArrayList<>();
		LOGGER.info("Gettting ads for : " + category);
		try {
			Document categoryPage = Jsoup.connect(SiteConstants.BASE_URL + "/" + category)
					.timeout(300000)
					.get();
			Elements adsInPage = categoryPage.select(SiteConstants.AD_ENDPOINT_SELECTOR);
			for (Element adElement : adsInPage) {
				String adUrl = SiteConstants.BASE_URL + "" + adElement.attr("href");
				LOGGER.info("Connecting to : " + adUrl);
				Document adPage = Jsoup.connect(adUrl).timeout(300000).get();
				String adTitle = adPage.select(SiteConstants.AD_TITLE_SELECTOR).text();
				String adText = adPage.select(SiteConstants.AD_TEXT_SELECTOR).text();
				Ad ad = new Ad(adUrl, category, adText, adTitle);
				ads.add(ad);
			}
		} catch (Exception ex) {
			LOGGER.log(Level.FINE, "", ex);
		}
		return ads;

	}

}
