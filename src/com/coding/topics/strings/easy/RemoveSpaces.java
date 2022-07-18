package com.coding.topics.strings.easy;

/*
 This can be used to return the subset of the array
 String ansStr = String.valueOf(Arrays.copyOfRange(s, 0, writePtr));
 */
public class RemoveSpaces {
  static String removeWhiteSpaces(char[] s) {
    StringBuilder builder = new StringBuilder();

    for (char a : s) {
      if (!Character.isSpaceChar(a)) {
        builder.append(a);
      }
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(removeWhiteSpaces("All greek to me.".toCharArray()));
  }

}
