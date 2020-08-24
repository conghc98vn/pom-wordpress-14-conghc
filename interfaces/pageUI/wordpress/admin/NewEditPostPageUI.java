package pageUI.wordpress.admin;

public class NewEditPostPageUI {
	public static final String ADD_TITLE_TEXTBOX = "//input[@id='title']";
	public static final String TINY_MCE_IFRAME = "//iframe[@id='content_ifr']";
	public static final String TINY_MCE_TEXTBOX = "//body[@id='tinymce']/p";
	public static final String CATEGORY_CHECKBOX = "//label[contains(text(),'%s')]/input";
	public static final String TAG_TEXTBOX = "//input[@id='new-tag-post_tag']";
	public static final String ADD_TAG_BUTTON = "//input[@class='button tagadd']";
	public static final String SET_FUTURE_IMAGE_LINK = "//a[@id='set-post-thumbnail']";
	public static final String UPLOAD_FILE_TAB_BUTTON = "//button[@id='menu-item-upload']";
	public static final String SET_FUTURE_IMAGE_BUTTON = "//button[text()='Set featured image']";
	public static final String FEATURE_IMAGE_THUMBNAIL = "//a[@id='set-post-thumbnail']/img[contains(@src, '%s')]";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "//input[@id='publish']";
	public static final String DELETE_TAG_NAME_ICON = "//span[@class='screen-reader-text' and contains(., '%s')]/preceding-sibling::span[@class='remove-tag-icon']";
	public static final String MOVE_TO_TRASH_LINK = "//div[@id='delete-action']/a";
}
