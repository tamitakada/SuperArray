import java.util.Arrays;
import java.util.Random;


public class SuperTester {

  public static void main(String[] args) {
    System.out.println(testArrayCreation());
    System.out.println(testAddAndGet());
    System.out.println(testSet());
    System.out.println(testResize());
    System.out.println(testIsEmptyAndClear());
  }

  public static boolean testArrayCreation() {
    SuperArray one = new SuperArray();
    if (one.size() != 0) return false;
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

}
