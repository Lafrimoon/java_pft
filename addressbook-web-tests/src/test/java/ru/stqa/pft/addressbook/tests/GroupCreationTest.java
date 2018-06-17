package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() {
        app.goTo().pageGroups();
        Groups before = app.group().all();
        //Set<GroupData> before = app.group().all();
        //List<GroupData> before = app.group().list();
        //int before = app.group().getGroupCount();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size() + 1));

        /*int max = 0;
        for (GroupData g : after)
        {
            if (g.getId() > max){
                max = g.getId();
            }
        }*/

        /*int max = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId(); - поиск группы с максимальным id
        group.setId(max);*/

        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());

        //before.add(group);

        /*Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId); - сравнение списков
        before.sort(byId);
        after.sort(byId);*/

        //Assert.assertEquals(before, after);

        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); - сравнение множеств

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
