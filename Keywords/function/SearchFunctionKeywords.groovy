package function
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import org.openqa.selenium.Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class SearchFunctionKeywords {
	@Keyword
	private void sendKeysAndPressEnter(String searchValue) {
		WebUI.sendKeys(findTestObject('Object Repository/Home/txt_SearchBox'), searchValue + Keys.ENTER)
	}

	@Keyword
	private void checkMessageSuccess(String searchValue) {
		String actualMessage = WebUI.getText(findTestObject('Object Repository/Home/message_SearchResult'))
		String expectMessage = "Kết quả tìm kiếm cho:  "+searchValue.trim()
		WebUI.verifyEqual(actualMessage, expectMessage)
	}

	@Keyword
	private void checkNoResultMessage(String expectMessage) {
		String actualMessage = WebUI.getText(findTestObject('Object Repository/Home/message_SearchResult'))
		WebUI.verifyEqual(actualMessage, expectMessage)
	}

	/** Chuẩn luồng case này phải verify DB nhưng không có thông tin DB nên e chỉ dừng lại ở visible **/
	@Keyword
	private void verifySearchResultSuccess() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/Home/lbl_SearchResult'))
	}

	@Keyword
	private void verifyNoSearchResult() {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Home/lbl_SearchResult'), 30)
	}
}
