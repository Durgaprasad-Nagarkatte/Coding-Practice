package com.coding.topics.strings.easy;

import java.util.HashSet;
import java.util.Set;

/*
    Given a string that contains duplicate occurrences of characters,
    remove the duplicate occurrences such that every character
    in the string appears only once.

    I/P : abbabcddbabcdeedebc
    O/P : abcde

    Time complexity - O(n)
    Space complexity - O(n)

    Space can be optimized by adding the elements to the same array and returning a copy of it later.
 */
public class RemoveDuplicates {

  public static String removeDuplicates(char[] charArray) {
    Set<Character> uniqueCharSet = new HashSet<>();
    StringBuilder builder = new StringBuilder();

    for (char c : charArray) {
      if (!uniqueCharSet.contains(c)) {
        uniqueCharSet.add(c);
        builder.append(c);
      }
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("abbabcddbabcdeedebc".toCharArray()));
  }

}
