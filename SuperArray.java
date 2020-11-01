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

  public void resize() {
    String[] newData = new String[size + 10];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
  }

}
