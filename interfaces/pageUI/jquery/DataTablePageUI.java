package pageUI.jquery;

public class DataTablePageUI {
	public static final String DYNAMIC_HEADER_COLUMN_TEXT = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String DYNAMIC_ONLY_ONE_ROW_WITH_TEXT = "//tr[not(@style='display: none;')]/td[text()='%s']";
	public static final String DYNAMIC_EDIT_OR_DELETE_ICON_BY_CONNTRY  = "//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[contains(@class, '%s')]";
	public static final String DYNAMIC_PAGE_BY_INDEX = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String DYNAMIC_PAGE_ACTIVED_BY_INDEX = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_COLUMN_POSITION_INDEX = "//tr/th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_COMLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s ]/input";
}
