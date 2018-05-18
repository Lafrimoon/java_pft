package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase{
    @Test
    public void testGroupDelete() {
        goToPage("groups");
        selectGroup();
        deleteSelectedGroups();
        goToPage("groups");
    }

}
