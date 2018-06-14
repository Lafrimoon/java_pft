package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() {
        app.goTo().pageGroups();
        Set<GroupData> before = app.group().all();
        //List<GroupData> before = app.group().list();
        //int before = app.group().getGroupCount();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Set<GroupData> after = app.group().all();

        Assert.assertEquals(after.size(), before.size() + 1);

        /*int max = 0;
        for (GroupData g : after)
        {
            if (g.getId() > max){
                max = g.getId();
            }
        }*/

        /*int max = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId(); - поиск группы с максимальным id
        group.setId(max);*/

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());

        before.add(group);

        /*Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId); - сравнение списков
        before.sort(byId);
        after.sort(byId);*/

        Assert.assertEquals(before, after);

        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); - сравнение множеств

    }

}
