package com.avisow.exercise;

/**
 * Created by ryan on 8/16/16.

 #!/usr/bin/env python

 g_data = {"a": "b", "c": {"d": "e", "f": {"g": "h"}}, "i": "j"}

 def key_exists_anywhere(data, target_key):
      # returns true or false
        return False


 print "a", key_exists_anywhere(g_data, "a"), True
 print "b", key_exists_anywhere(g_data, "b"), False
 print "f", key_exists_anywhere(g_data, "f"), True
 print "g", key_exists_anywhere(g_data, "g"), True
 print "i", key_exists_anywhere(g_data, "i"), True
 print "j", key_exists_anywhere(g_data, "j"), False

 */

import java.util.Map;
import java.util.TreeMap;

class FindKeyAnyWhere {
    public static void main(String[] args) {
        // g_data = {"a": "b", "c": {"d": "e", "f": {"g": "h"}}, "i": "j"}
        Map<String, Object> data = new TreeMap<>();
        Map<String, Object> map2 = new TreeMap<>();
        Map<String, Object> map3 = new TreeMap<>();
        map3.put("g", "h");
        map2.put("d", "e");
        map2.put("f", map3);
        data.put("a", "b");
        data.put("c", map2);
        data.put("i", "j");

        System.out.println(data.toString());

        System.out.println("a " + findKeyAnyWhere(data, "a"));
        System.out.println("b " + findKeyAnyWhere(data, "b"));
        System.out.println("f " + findKeyAnyWhere(data, "f"));
        System.out.println("g " + findKeyAnyWhere(data, "g"));
        System.out.println("i " + findKeyAnyWhere(data, "i"));
        System.out.println("j " + findKeyAnyWhere(data, "j"));
    }

    private static Boolean findKeyAnyWhere(Map<String, Object> data, String key) {
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String itemKey = entry.getKey();
            Object value = entry.getValue();

            if (key.equals(itemKey)) {
                return true;
            }

            if (value instanceof Map) {
                Boolean result = findKeyAnyWhere((Map<String, Object>)value, key);
                if (result) {
                    return true;
                }
            }

        }

        return false;
    }
}
