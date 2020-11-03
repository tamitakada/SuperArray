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
      if (data[i].equals(s)) return true;
    }
    return false;
  }

}
