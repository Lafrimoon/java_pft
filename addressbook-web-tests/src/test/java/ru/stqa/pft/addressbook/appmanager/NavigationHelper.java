package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToPageGroups() {
        click(By.linkText("groups"));
    }

    public void goToPageHome() {
        click(By.linkText("home"));
    }
    public void goToPageNewContact() {
        click(By.linkText("add new"));
    }
}
