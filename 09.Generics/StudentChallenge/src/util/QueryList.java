package util;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> extends ArrayList<T> {

  public QueryList() {

  }

  public QueryList(List<T> items) {
    super(items);
  }

  public QueryList<T> getMatches(String field, String value) {
    QueryList<T> matches = new QueryList<>();
    for (T item : this) {
      if (item.matchFieldValue(field, value)) matches.add(item);
    }

    return matches;
  }
}
