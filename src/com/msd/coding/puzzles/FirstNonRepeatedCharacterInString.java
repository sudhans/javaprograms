package com.msd.coding.puzzles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This program finds the first non repeated character in the given string
 * Eg. "apple" = has three non repeated characters - a, l and e
 * Of which, "a" is the first non repeated character
 */
public class FirstNonRepeatedCharacterInString {
    public static void main(String[] args) {
        String input1 = "apple";
        String input2 = "aarrgh";

        System.out.println("1. First Non Repeated character :: " + firstNonRepeatedCharacter(input1));
        System.out.println("2. First Non Repeated character :: " + firstNonRepeatedCharacterWithStreams(input2));
    }

    private static char firstNonRepeatedCharacter(String input){
        Map<Character, Integer> characterCountMap = new LinkedHashMap<>();
        for (char ch: input.toCharArray()) {
            characterCountMap.compute(ch, (k, v) -> (v==null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry: characterCountMap.entrySet()){
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    private static char firstNonRepeatedCharacterWithStreams(String input){
        Map<Character, Long> characterCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        return characterCountMap.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Character.MIN_VALUE);

    }
}
