package AB_SCREEN;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class GenericOrderType implements Serializable {

  private static String DELIMITER = "|";
  private static List list = new ArrayList();

  private final int code;
  private final String name;

  private GenericOrderType(int code, String name) {
    this.code = code;
    this.name = name;
    if (name == null)
      throw new IllegalArgumentException("Name is required");
    list.add(this);
  }

  public static final GenericOrderType TYPE1 = new GenericOrderType(1, "Order Type 1");
  public static final GenericOrderType TYPE2 = new GenericOrderType(2, "Order Type 2");
  public static final GenericOrderType TYPE3 = new GenericOrderType(3, "Order Type 3");
  public static final GenericOrderType TYPE4 = new GenericOrderType(4, "Order Type 4");
  public static final GenericOrderType TYPE5 = new GenericOrderType(5, "Order Type 5");
  public static final GenericOrderType TYPE6 = new GenericOrderType(6, "Order Type 6");
  public static final GenericOrderType TYPE7 = new GenericOrderType(7, "Order Type 7");
  public static final GenericOrderType TYPE8 = new GenericOrderType(8, "Order Type 8");
  public static final GenericOrderType TYPE9 = new GenericOrderType(9, "Order Type 9");
  public static final GenericOrderType TYPE10 = new GenericOrderType(10, "Order Type 10");
  public static final GenericOrderType TYPE11 = new GenericOrderType(11, "Order Type 11");
  public static final GenericOrderType TYPE12 = new GenericOrderType(12, "Order Type 12");
  public static final GenericOrderType TYPE13 = new GenericOrderType(13, "Order Type 13");
  public static final GenericOrderType TYPE14 = new GenericOrderType(14, "Order Type 14");
  public static final GenericOrderType TYPE15 = new GenericOrderType(15, "Order Type 15");
  public static final GenericOrderType TYPE16 = new GenericOrderType(16, "Order Type 16");
  public static final GenericOrderType TYPE17 = new GenericOrderType(17, "Order Type 17");
  public static final GenericOrderType TYPE18 = new GenericOrderType(18, "Order Type 18");
  public static final GenericOrderType TYPE19 = new GenericOrderType(19, "Order Type 19");
  public static final GenericOrderType TYPE20 = new GenericOrderType(20, "Order Type 20");
  public static final GenericOrderType TYPE21 = new GenericOrderType(21, "Order Type 21");
  public static final GenericOrderType TYPE22 = new GenericOrderType(22, "Order Type 22");
  public static final GenericOrderType TYPE23 = new GenericOrderType(23, "Order Type 23");
  public static final GenericOrderType TYPE24 = new GenericOrderType(24, "Order Type 24");
  public static final GenericOrderType TYPE25 = new GenericOrderType(25, "Order Type 25");
  public static final GenericOrderType TYPE26 = new GenericOrderType(26, "Order Type 26");
  public static final GenericOrderType TYPE27 = new GenericOrderType(27, "Order Type 27");
  public static final GenericOrderType TYPE28 = new GenericOrderType(28, "Order Type 28");
  public static final GenericOrderType TYPE29 = new GenericOrderType(29, "Order Type 29");
  public static final GenericOrderType TYPE30 = new GenericOrderType(30, "Order Type 30");
  public static final GenericOrderType TYPE31 = new GenericOrderType(31, "Order Type 31");
  public static final GenericOrderType TYPE32 = new GenericOrderType(32, "Order Type 32");
  public static final GenericOrderType TYPE33 = new GenericOrderType(33, "Order Type 33");
  public static final GenericOrderType TYPE34 = new GenericOrderType(34, "Order Type 34");
  public static final GenericOrderType TYPE35 = new GenericOrderType(35, "Order Type 35");
  public static final GenericOrderType TYPE36 = new GenericOrderType(36, "Order Type 36");
  public static final GenericOrderType TYPE37 = new GenericOrderType(37, "Order Type 37");
  public static final GenericOrderType TYPE38 = new GenericOrderType(38, "Order Type 38");
  public static final GenericOrderType TYPE39 = new GenericOrderType(39, "Order Type 39");
  public static final GenericOrderType TYPE40 = new GenericOrderType(40, "Order Type 40");
  public static final GenericOrderType TYPE41 = new GenericOrderType(41, "Order Type 41");
  public static final GenericOrderType TYPE42 = new GenericOrderType(42, "Order Type 42");
  public static final GenericOrderType TYPE43 = new GenericOrderType(43, "Order Type 43");
  public static final GenericOrderType TYPE44 = new GenericOrderType(44, "Order Type 44");
  public static final GenericOrderType TYPE45 = new GenericOrderType(45, "Order Type 45");
  public static final GenericOrderType TYPE46 = new GenericOrderType(46, "Order Type 46");
  public static final GenericOrderType TYPE47 = new GenericOrderType(47, "Order Type 47");
  public static final GenericOrderType TYPE48 = new GenericOrderType(48, "Order Type 48");
  public static final GenericOrderType TYPE49 = new GenericOrderType(49, "Order Type 49");
  public static final GenericOrderType TYPE50 = new GenericOrderType(50, "Order Type 50");
  public static final GenericOrderType TYPE51 = new GenericOrderType(51, "Order Type 51");
  public static final GenericOrderType TYPE52 = new GenericOrderType(52, "Order Type 52");
  public static final GenericOrderType TYPE53 = new GenericOrderType(53, "Order Type 53");
  public static final GenericOrderType TYPE54 = new GenericOrderType(54, "Order Type 54");
  public static final GenericOrderType TYPE55 = new GenericOrderType(55, "Order Type 55");
  public static final GenericOrderType TYPE60 = new GenericOrderType(60, "Order Type 60");
  public static final GenericOrderType TYPE105 = new GenericOrderType(105, "Order Type 105");
  public static final GenericOrderType TYPE106 = new GenericOrderType(106, "Order Type 106");
  public static final GenericOrderType TYPE107 = new GenericOrderType(107, "Order Type 107");
  public static final GenericOrderType TYPE108 = new GenericOrderType(108, "Order Type 108");
  public static final GenericOrderType TYPE109 = new GenericOrderType(109, "Order Type 109");
  public static final GenericOrderType TYPE110 = new GenericOrderType(110, "Order Type 110");
  public static final GenericOrderType TYPE210 = new GenericOrderType(210, "Order Type 210");
  public static final GenericOrderType TYPE211 = new GenericOrderType(211, "Order Type 211");
  public static final GenericOrderType TYPE212 = new GenericOrderType(212, "Order Type 212");
  public static final GenericOrderType TYPE255 = new GenericOrderType(255, "Order Type 255");
  public static final GenericOrderType TYPE301 = new GenericOrderType(301, "Order Type 301");

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static GenericOrderType get(int code) {
    int size = list.size();
    for (int i = 0; i < size; i++) {
      GenericOrderType element = (GenericOrderType) list.get(i);
      if (element.getCode() == code) return element;
    }
    return null;
  }

  public static GenericOrderType parse(String name) {
    if (name == null) return null;

    int size = list.size();
    for (int i = 0; i < size; i++) {
      GenericOrderType element = (GenericOrderType) list.get(i);
      if (element.getName().equals(name))
        return element;
    }
    return null;
  }

  public static boolean contains(String name) {
    GenericOrderType element = parse(name);
    return element != null;
  }

  public static int size() {
    return list.size();
  }

  public String toString() {
    StringBuffer buf = new StringBuffer("<<GenericOrderType:");
    buf.append(" code=");
    buf.append(code);
    buf.append(" name=");
    buf.append(name);
    buf.append(">>");
    return buf.toString();
  }
}