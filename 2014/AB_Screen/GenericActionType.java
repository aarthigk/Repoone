package AB_SCREEN;

/**
 * @(#)GenericActionType.java	1.2 06/07/15 21:16:16
 *
 * Copyright (c) 2002-2020 All Rights Reserved
 *
 */

import java.io.*;
import java.util.*;

public class GenericActionType implements Serializable {

  private static String DELIMITER = "|";
  private static List list = new ArrayList();

  private final int code;
  private final String name;

  private GenericActionType(int code, String name) {
    this.code = code;
    this.name = name;
    if (name == null)
      throw new IllegalArgumentException("Name is required");
    list.add(this);
  }

  public static final GenericActionType TYPE0 = new GenericActionType(0, "Action Type 0");
  public static final GenericActionType TYPE1 = new GenericActionType(1, "Action Type 1");
  public static final GenericActionType TYPE2 = new GenericActionType(2, "Action Type 2");
  public static final GenericActionType TYPE3 = new GenericActionType(3, "Action Type 3");
  public static final GenericActionType TYPE4 = new GenericActionType(4, "Action Type 4");
  public static final GenericActionType TYPE5 = new GenericActionType(5, "Action Type 5");
  public static final GenericActionType TYPE6 = new GenericActionType(6, "Action Type 6");
  public static final GenericActionType TYPE7 = new GenericActionType(7, "Action Type 7");
  public static final GenericActionType TYPE8 = new GenericActionType(8, "Action Type 8");
  public static final GenericActionType TYPE9 = new GenericActionType(9, "Action Type 9");

  // Additional action types can be added here...

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static GenericActionType get(int code) {
    int size = list.size();
    for (int i = 0; i < size; i++) {
      GenericActionType element = (GenericActionType) list.get(i);
      if (element.getCode() == code) return element;
    }
    return null;
  }

  public static GenericActionType parse(String name) {
    if (name == null) return null;

    int size = list.size();
    for (int i = 0; i < size; i++) {
      GenericActionType element = (GenericActionType) list.get(i);
      if (element.getName().equals(name))
        return element;
    }
    return null;
  }

  public static boolean contains(String name) {
    GenericActionType element = parse(name);
    return element != null;
  }

  public static int size() {
    return list.size();
  }

  public String toString() {
    StringBuffer buf = new StringBuffer("<<GenericActionType:");
    buf.append(" code=");
    buf.append(code);
    buf.append(" name=");
    buf.append(name);
    buf.append(">>");
    return buf.toString();
  }
}