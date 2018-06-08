package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToPageGroups();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //int before = app.getGroupHelper().getGroupCount();
        GroupData group = new GroupData("test2", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() + 1);

        /*int max = 0;
        for (GroupData g : after)
        {
            if (g.getId() > max){
                max = g.getId();
            }
        }*/

        /*int max = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId();
        group.setId(max);*/

        before.add(group);

        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);

        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); - сравнение множеств

    }

}
