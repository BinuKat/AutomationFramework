package com.naveenautomation.pages;

public enum SideNavBar {
	EDIT_ACCOUNT("Edit Account"),

	RETURNS("Returns"),
	NEWSLETTER("Newsletter"),
	LOGOUT("Logout");

	String sideNavBarMenu;

	SideNavBar(String menu) {
		sideNavBarMenu = menu;
	}

	public String getSideNavBarMenu() {
		return sideNavBarMenu;
	}

}
