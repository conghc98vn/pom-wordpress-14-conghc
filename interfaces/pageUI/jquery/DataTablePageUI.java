package pageUI.jquery;

public class DataTablePageUI {
	public static final String DYNAMIC_HEADER_COLUMN_TEXT = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String DYNAMIC_ONLY_ONE_ROW_WITH_TEXT = "//tr[not(@style='display: none;')]/td[text()='%s']";
}
