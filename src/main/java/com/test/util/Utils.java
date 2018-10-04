package com.test.util;
    
public class Utils {
    static String payload ="{'one': 'one', 'two':'two'}";
    
    public static void main(String[] args) {
        String value = getValue(payload, "two");
        System.out.println(value);
    }
    
    public static String getValue(String s, String attribute) {
        String value ="";
        if(s == null || s.isEmpty()) {
            return value;
        }
        
        int indexOf = s.indexOf(attribute);
        if(indexOf != -1) {
            int indexOf2 = s.indexOf(":", indexOf);
            if(indexOf2 != -1) {
                int indexOf3 = s.indexOf(",", indexOf2);
                if(indexOf3 != -1) {
                    value = s.substring(indexOf2, indexOf3);
                }else {
                    value = s.substring(indexOf2);
                }
                
            }
        }
        value = value.replaceAll(":", "").replaceAll("'", "").replaceAll("}", "");
        return value;
    }
}
