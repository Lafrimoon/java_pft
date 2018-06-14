package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() {
        app.goTo().pageGroups();
        List<GroupData> before = app.group().list();
        //int before = app.group().getGroupCount();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        List<GroupData> after = app.group().list();
        //int after = app.group().getGroupCount();
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
