package ic.doc;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {

  List<Object> list;

  public RecentlyUsedList() {
    list = new ArrayList<Object>();
  }

  public int size() {
    return list.size();
  }

  public void add(Object i) {
    if (list.contains(i)) {
      list.remove(list.indexOf(i));
    }
    list.add(0, i);
  }

  public Object retrieve(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("Argument must be a positive integer");
    }
    // Note that the 'get' function throws IndexOutOfBoundsException if index is out of range
    return list.get(i);
  }

  @Override
  public String toString() {
    return String.valueOf(list);
  }
}
