package test;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
class Pair{
    String key;
    String value;
}


public class Test {
    public static void main(String[] args) {
        List<String> list = List.of("TAP", "ABC", "PAT", "BAC", "PQR", "APT");
        List<Pair> pairList = list.stream().map(s -> new Pair(sorted(s), s)).toList();
        Map<String, List<Pair>> listMap = pairList.stream().collect(Collectors.groupingBy(pair -> pair.key));

        Collection<List<Pair>> values = listMap.values();
        List<List<String>> listList = values.stream().map(pairs -> pairs.stream().map(pair -> pair.value).toList()).toList();
        System.out.println(listList);
    }

    private static String sorted(String s) {
        List<Integer> freq = new ArrayList<>();
        for(int i=0;i<26;i++)
            freq.add(0);
        int length = s.length();
        for(int i=0;i<length;i++) {
            char c = s.charAt(i);
            int pos = c - 'A';
            freq.set(pos, freq.get(pos)+1);
        }
        StringBuilder sortedS = new StringBuilder();
        for(int i=0;i<26;i++){
            sortedS.append(String.valueOf('A' + i).repeat(Math.max(0, freq.get(i))));
        }
        return sortedS.toString();
    }
}
