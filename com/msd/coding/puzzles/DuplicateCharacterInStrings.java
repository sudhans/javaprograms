package com.msd.coding.puzzles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find if the given string has duplicate characters
 * Eg: apple has letter p occurring twice and considered to have duplicate characters
 */
public class DuplicateCharacterInStrings {
    public static void main(String[] args) {
        String str1 = "KingOfChennai";
        String str2 = "Kingdom";
        System.out.println("Has Duplicate Chars :: " + hasDuplicateChars(str1));
        System.out.println("Has Duplicate Chars :: " + hasDuplicateChars(str2));

        System.out.println("Has Duplicate Chars by distinct:: " + hasDuplicateCharsByDistinct(str1));
        System.out.println("Has Duplicate Chars by distinct :: " + hasDuplicateCharsByDistinct(str2));
    }

    private static boolean hasDuplicateChars(String input) {
        Map<Character, Long> characterMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return characterMap.values().stream()
                .filter(count -> count > 1)
                .count() > 1;
    }

    private static boolean hasDuplicateCharsByDistinct(String input) {
        return input.length() > input.chars().mapToObj(c -> (char) c).distinct().count();
    }
}
