import java.util.Arrays;
import java.util.Random;


public class SuperTester {

  public static void main(String[] args) {
    System.out.println(testArrayCreation());
    System.out.println(testAddAndGet());
    System.out.println(testSet());
    System.out.println(testResize());
    System.out.println(testIsEmptyAndClear());
    System.out.println(testToString());
    System.out.println(testContains());
    System.out.println(testAddIndex());
  }

  public static boolean testArrayCreation() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray(30);

    if (one.size() != 0) return false;
    if (two.size() != 0) return false;

    return true;
  }

  public static boolean testAddAndGet() {
    SuperArray one = new SuperArray();
    if (one.size() != 0) return false;

    String[] sample = new String[] {
      "hello",
      "abcdef",
      "54321",
      "Good Bye."
    };

    for (int i = 0; i < 4; i++) {
      one.add(sample[i]);
    }

    if (one.size() != 4) return false;

    for (int i = 0; i < 4; i++) {
      if (one.get(i) != sample[i]) return false;
    }

    for (int i = 0; i < 100; i++) {
      String toAdd = createRandomStr();
      SuperArray test = new SuperArray();
      if (!test.add(toAdd)) return false;
      if (test.size() != 1) return false;
      if (test.get(0) != toAdd) return false;
    }

    return true;
  }

  public static boolean testSet() {
    SuperArray one = new SuperArray();
    if (!one.add("hello")) return false;
    if (one.set(0, "goodbye") != "hello") return false;
    if (one.get(0) != "goodbye") return false;

    SuperArray two = new SuperArray();
    String[] sample = new String[] {
      "hello",
      "abcdef",
      "54321",
      "Good Bye."
    };

    for (int i = 0; i < 4; i++) {
      two.add(sample[i]);
    }

    if (two.set(2, "99ABC") != "54321") return false;
    if (two.get(2) != "99ABC") return false;

    for (int i = 0; i < 100; i++) {
      String toAdd = createRandomStr();
      String toSet = createRandomStr();
      SuperArray test = new SuperArray();
      if (!test.add(toAdd)) return false;
      if (test.set(0, toSet) != toAdd) return false;
      if (test.get(0) != toSet) return false;
    }

    return true;
  }

  public static boolean testResize() {
    SuperArray one = new SuperArray();

    String[] sample = new String[] {
      "hello", "abcdef",
      "54321", "Good Bye",
      "hjsad", "23123sd",
      "ahhh", "the cats",
      "0 + 9 * 2", "  "
    };

    for (int i = 0; i < 10; i++) {
      if (!one.add(sample[i])) return false;
    }

    if (!one.add("eleven")) return false;
    if (one.size() != 11) return false;
    if (one.get(10) != "eleven") return false;

    for (int i = 0; i < 10; i++) {
      if (one.get(i) != sample[i]) return false;
    }

    return true;
  }

  public static boolean testIsEmptyAndClear() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray();
    if (!(two.add("hello") && two.add("hello 2"))) return false;

    if (!one.isEmpty()) return false;
    if (two.isEmpty()) return false;

    two.clear();
    if (!two.isEmpty()) return false;
    if (two.size() != 0) return false;

    return true;
  }

  public static boolean testToString() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray();

    String[] sample = new String[] {
      "hello", "22",
      "  ", "E nD"
    };

    for (int i = 0; i < 4; i++) {
      if (!two.add(sample[i])) return false;
    }

    if (!one.toString().equals("[]")) return false;
    if (!two.toString().equals("[hello, 22,   , E nD]")) return false;

    return true;
  }

  public static boolean testContains() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray(100);

    if (one.contains("hello")) return false;
    if (two.contains("2 hello")) return false;

    two.add(0, "2 hello");
    if (!two.contains("2 hello")) return false;

    return true;
  }

  public static boolean testAddIndex() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray();

    one.add(0, "zero");
    if ((!one.get(0).equals("zero")) || (one.size() != 1)) return false;

    String[] sample = new String[] {
      "hello", "22",
      "  ", "E nD"
    };

    for (int i = 0; i < 4; i++) {
      if (!two.add(sample[i])) return false;
    }

    two.add(2, "insert");

    String[] expected = new String[] {
      "hello", "22", "insert",
      "  ", "E nD"
    };

    for (int i = 0; i < 4; i++) {
      if (!two.get(i).equals(expected[i])) return false;
    }

    for (int j = 0; j < 100; j++) {
      Random rng = new Random();
      String[] arrData = createRandomArr();
      SuperArray test = new SuperArray(arrData.length);

      for (int k = 0; k < arrData.length; k++) {
        if (!test.add(arrData[k])) return false;
      }

      String toAdd = createRandomStr();
      int insertionIndex = rng.nextInt(test.size());
      test.add(insertionIndex, toAdd);

      if (test.get(insertionIndex) != toAdd) return false;
    }

    return true;
  }

  public static String createRandomStr() {
    Random rng = new Random();
    char[] allChars = new char[] {
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
      'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
      'W', 'X', 'Y', 'Z'
    };

    String str = "";

    for (int i = 0; i < rng.nextInt(101); i++) {
      int rand = rng.nextInt(26);
      str += allChars[rand];
    }

    return str;
  }

  public static String[] createRandomArr() {
    Random rng = new Random();
    int len = rng.nextInt(201) + 1;

    String[] toReturn = new String[len];

    for (int i = 0; i < len; i++) {
      toReturn[i] = createRandomStr();
    }

    return toReturn;
  }

}
