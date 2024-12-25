import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

@SetUp(skipped = false)
def setUp() {
    WebUI.openBrowser(GlobalVariable.url)
    WebUI.maximizeWindow()
}

@TearDown(skipped = true)
def tearDown() {

}

@SetupTestCase(skipped = true)
def setupTestCase() {
}

@TearDownTestCase(skipped = false)
def tearDownTestCase() {
	WebUI.click(findTestObject('Object Repository/Home/btn_Logo'))
	WebUI.refresh()
}
