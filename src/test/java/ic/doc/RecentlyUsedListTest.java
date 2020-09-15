package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class RecentlyUsedListTest {

  @Test
  public void emptyListWhenInitialised() {
    assertThat(new RecentlyUsedList().size(), is(0));
  }

  @Test
  public void canAddIntToList() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    assertThat(list.size(), is(1));
  }

  @Test
  public void canAddStringToList() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add("Hello");
    assertThat(list.size(), is(1));
  }

  @Test
  public void canAddStringAndIntToList() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add("Hello");
    list.add(1);
    assertThat(list.size(), is(2));
  }

  @Test
  public void canRetrieveFirstFromList() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    assertThat(list.retrieve(0), is(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void retrieveNegativeArgumentThrowsError() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    try {
      list.retrieve(-1);
    } catch (IllegalArgumentException iae) {
      assertThat(iae.getMessage(), is("Argument must be a positive integer"));
      throw iae;
    }
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void retrieveTooLargeArgumentThrowsError() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    try {
      list.retrieve(1);
    } catch (IndexOutOfBoundsException exception) {
      throw exception;
    }
  }

  @Test
  public void canRetrieveSecondFromListWithArgument() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    list.add(2);
    assertThat(list.retrieve(1), is(1));
  }

  @Test
  public void mostRecentItemFirst() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    list.add(2);
    assertThat(list.retrieve(0), is(2));
  }

  @Test
  public void addOnlyDuplicateValue() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    list.add(1);
    list.add(1);
    assertThat(list.size(), is(1));
  }

  @Test
  public void addDuplicateValue() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    list.add(2);
    list.add(1);
    assertThat(list.retrieve(0), is(1));
  }

  @Test
  public void toStringOverridenInt() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    list.add(2);
    assertThat(list.toString(), is("[2, 1]"));
  }

  @Test
  public void toStringOverridenIntAndString() {
    RecentlyUsedList list = new RecentlyUsedList();
    list.add(1);
    list.add(2);
    list.add("Hello");
    assertThat(list.toString(), is("[Hello, 2, 1]"));
  }
}
