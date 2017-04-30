package domain;

import constants.Category;

/**
 * @date Apr 30, 2017
 * @author vsantamaria
 */
public class Ad {

	private String url;
	private Category category;
	private String title;
	private String text;

	public Ad() {}
	
	public Ad(String url, Category category, String title, String text) {
		this.url = url;
		this.category = category;
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "AdItem{" + "url=" + url + ", category=" + category + ", title=" + title + ", text=" + text + '}';
	}

}
