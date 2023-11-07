package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;

public class LoginPageTest extends TestBase { // Extended because we had to call initialization method

	LoginPage loginPage; // defined here because need to be used throughout
	AccountPage accountPage;
	// LogoutPage logoutPage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();
	}

	@Test

	public void validateUserCanLoginWithValidCredentials() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not logged in");
	}

	@Test
	public void validateUserCanNotLoginWithInValidCredentials() {
		loginPage.submitLogin("andy123@mailinator.com", "Password@1234");
		Assert.assertEquals(loginPage.getAlertText(), " Warning", "User Loggedin");
	}

	@Test(dataProvider = "UserCredentials")
	public void validateLoginWithMultipleCredentials(String userName, String password) {
		loginPage.submitLogin(userName, password);
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Not Loggedin");

	}

	@DataProvider(name = "UserCredentials")
	public void getDataFromExcelSheet() throws Exception {
		String fileName = "\"C:\\Users\\HP_owner\\Desktop\\Book1.xlsx\"";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName, sheetName);
		System.out.println(rowCount);

		int cellCount = ExcelUtils.getCellCount(fileName, sheetName, rowCount);
		System.out.println(cellCount);

		String cellString = ExcelUtils.getCellData(fileName, sheetName, rowCount, cellCount);
		System.out.println(cellString);

		String[][] virtualSheet = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(fileName, sheetName, i, j); // why i and J= iteration
																							// over the cell

			}

		}
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
