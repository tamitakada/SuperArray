public class SuperArray {

  private String[] data;
  private int size;

  public SuperArray(int initialCapacity) {
    data = new String[initialCapacity];
    size = 0;
  }

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String element) {
    if (data.length == size) {
      resize();
    }

    data[size] = element;
    size++;

    return true;
  }

  public void add(int index, String element) {
    int newSize = data.length;
    if (data.length == size) newSize = (2 * size);
    String[] newData = new String[newSize];

    size++;

    for (int i = 0; i < size; i++) {
      if (i < index) newData[i] = data[i];
      else if (i == index) newData[i] = element;
      else newData[i] = data[i - 1];
    }

    data = newData;
  }

  public String get(int index) {
    return data[index];
  }

  public String set(int index, String element) {
    String toReplace = data[index];
    data[index] = element;
    return toReplace;
  }

  private void resize() {
    String[] newData = new String[size + 10];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void clear() {
    size = 0;
    data = new String[10];
  }

  public String toString() {
    String toReturn = "[";
    for (int i = 0; i < size; i++) {
      toReturn += data[i];
      if (i != (size - 1)) toReturn += ", ";
    }
    return (toReturn + "]");
  }

  public boolean contains(String s) {
    for (int i = 0; i < size; i++) {
      if (s.equals(data[i])) return true;
    }
    return false;
  }

}
