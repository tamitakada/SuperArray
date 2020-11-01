public class SuperArray {

  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String element) {
    String[] newData = new String[size + 1];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }

    newData[size] = element;

    size++;
    data = newData;

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

}
