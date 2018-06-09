package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillFormContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());


        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void acceptDialogContactDelete() {
        wd.switchTo().alert().accept();
    }

  //действия на странице контакта
    //TODO: на нижней кнопке delete на странице контакта, name=update, это имя стиля или бага?
    public void initUpdateContact() {
        click(By.name("update"));
    }
    //страница контакта в режиме "просмотр"
    public void initDeleteFromContactPage() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }
    public void goToEditContactFromContactPage() {
        click(By.name("modifiy"));
    }

  //действия на главной странице
    public void initDeleteContactFromMainTable() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }
    public void goToViewContact() { //клик по иконке "человечек" - переход на просмотр контакта
        click(By.xpath("//table[@id='maintable']/tbody//a/img[@title='Details']"));
    }
    public void goToEditContactFromMainTable() { //клик по иконке "карандаш" - переход на редактирование контакта
        click(By.xpath("//table[@id='maintable']/tbody//a/img[@title='Edit']"));
    }

    public void createContact(ContactData contactData, boolean creation) {
        fillFormContact(contactData, creation);
        submitContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element: elements)
        {
            String name = element.findElement(By.xpath("td[3]")).getText();
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData(id, name, lastname);
            contacts.add(contact);

        }

        return contacts;
    }
}
