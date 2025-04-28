package org.tst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetGenerator {
    private final static int TOKEN_LENGTH = 3;
    Set<String> results = new HashSet<>();

    void subsetGenerateHelper(String token, int start, List<Character> path) {
        if (path.size() == TOKEN_LENGTH) {
            results.add(path.stream().map(String::valueOf).collect(Collectors.joining("")));
        }

        for (int i = start; i < token.length(); i++) {
            var newPath = new ArrayList<>(path);
            newPath.add(token.charAt(i));
            subsetGenerateHelper(token, i + 1, newPath);
        }
    }

    Set<String> subsetGenerate(List<String> source) {
        subsetGenerateHelper(String.join("", source), 0, new ArrayList<>());
        return results;
    }

    public static void main(String[] args) {
        Set<String> result = new SubsetGenerator().subsetGenerate(List.of("on", "job", "lake"));
        result.forEach(System.out::println);
    }
}
