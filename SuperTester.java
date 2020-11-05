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
    System.out.println(testRemove());
    System.out.println(testIndexOf());
    System.out.println(testToArray());
    System.out.println(testRemDuplicates());
    System.out.println(testOverlap());
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

  public static boolean testRemove() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray(100);

    if (one.remove(433) != null) return false;
    if (two.remove(4) != null) return false;

    String[] twoData = new String[] {
      "one", "2", " 3 ", "FOURRR", "", " s i x!"
    };

    for (int i = 0; i < 6; i++) {
      if (!two.add(twoData[i])) return false;
    }

    if (!two.remove(1).equals("2")) return false;
    if (two.size() != 5) return false;
    if (!two.toString().equals("[one,  3 , FOURRR, ,  s i x!]")) return false;

    for (int j = 0; j < 100; j++) {
      Random rng = new Random();
      String[] arrData = createRandomArr();
      SuperArray test = new SuperArray(arrData.length);

      for (int k = 0; k < arrData.length; k++) {
        if (!test.add(arrData[k])) return false;
      }

      int oldSize = test.size();
      int toRemove = rng.nextInt(oldSize);
      String strRemoved = test.get(toRemove);

      if (!test.remove(toRemove).equals(strRemoved)) return false;
      if (test.size() != (oldSize - 1)) return false;
    }

    return true;
  }

  public static boolean testIndexOf() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray(6);

    if (one.indexOf("jasdkasd") != -1) return false;
    if (two.indexOf("one") != -1) return false;

    String[] twoData = new String[] {
      "one", "2", " 3 ", "FOURRR", "", " s i x!"
    };

    for (int i = 0; i < 6; i++) {
      if (!two.add(twoData[i])) return false;
    }

    if (two.indexOf("FOURRR") != 3) return false;
    if (two.indexOf(" ashdkjsad ") != -1) return false;

    if (!two.remove(3).equals("FOURRR")) return false;
    if (two.indexOf("FOURRR") != -1) return false;
    if (two.indexOf("") != 3) return false;

    return true;
  }

  public static boolean testToArray() {
    SuperArray one = new SuperArray();
    SuperArray two = new SuperArray(6);

    if (one.toArray().length != 0) return false;
    if (two.toArray().length != 0) return false;

    String[] twoData = new String[] {
      "one", "2", " 3 ", "FOURRR", "", " s i x!"
    };

    for (int i = 0; i < 6; i++) {
      if (!two.add(twoData[i])) return false;
    }

    String[] arrayified = two.toArray();

    if (arrayified.length != 6) return false;

    for (int j = 0; j < arrayified.length; j++) {
      if (!arrayified[j].equals(twoData[j])) return false;
    }

    for (int k = 0; k < 100; k++) {
      Random rng = new Random();
      String[] arrData = createRandomArr();
      SuperArray test = new SuperArray(arrData.length);

      for (int l = 0; l < arrData.length; l++) {
        if (!test.add(arrData[l])) return false;
      }

      String[] arrayTest = test.toArray();
      if (arrayTest.length != arrData.length) return false;
      for (int m = 0; m < arrayTest.length; m++) {
        if (!arrayTest[m].equals(arrData[m])) return false;
      }
    }

    return true;
  }

  public static boolean testRemDuplicates() {
    SuperArray one = new SuperArray();
    String[] oneData = new String[] {
      "one", "two", "two", "aksjdasd ", " two", "two"
    };
    for (int i = 0; i < 6; i++) {
      if (!one.add(oneData[i])) return false;
    }

    removeDuplicates(one);
    if (!one.toString().equals("[one, two, aksjdasd ,  two]")) return false;

    return true;
  }

  public static boolean testOverlap() {
    SuperArray one = new SuperArray();
    String[] oneData = new String[] {
      "one", "two", " 3 ", "FOUR", "f i v e", "6.0000 0"
    };

    SuperArray two = new SuperArray();
    String[] twoData = new String[] {
      "one", "2", "THREEEE", "f i v e", " 3 "
    };

    for (int i = 0; i < 6; i++) {
      if (!one.add(oneData[i])) return false;
    }

    for (int i = 0; i < 5; i++) {
      if (!two.add(twoData[i])) return false;
    }

    SuperArray overlap = findOverlap(one, two);
    if (!overlap.toString().equals("[one, f i v e,  3 ]")) return false;

    return true;
  }

  public static void removeDuplicates(SuperArray s) {
    for (int i = s.size() - 1; i > 0; i--) {
      if (s.indexOf(s.get(i)) != i) s.remove(i);
    }
  }

  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray larger = a;
    SuperArray smaller = b;
    if (b.size() > a.size()) {
      larger = b;
      smaller = a;
    }

    SuperArray overlap = new SuperArray(smaller.size());

    for (int i = 0; i < smaller.size(); i++) {
      if (larger.contains(smaller.get(i))) {
        overlap.add(smaller.get(i));
      }
    }

    return overlap;
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
