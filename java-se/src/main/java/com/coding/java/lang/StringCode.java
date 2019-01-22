package com.coding.java.lang;

import java.nio.charset.Charset;
import java.util.Locale;

public class StringCode {

    private static class Constructor {
        private static byte[] bytes = new byte[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
        private static String str = "abcdefgh";

        public static String string() {
            return new String("abcdefgh");
        }

        public static String byteArray() {
            return new String(bytes);
        }

        public static String byteArrayChatset() {
            return new String(bytes, Charset.defaultCharset());
        }

        public static char[] covertToCharArray() {
            return str.toCharArray();
        }

        public static String toUppercase() {
            return str.toUpperCase(Locale.SIMPLIFIED_CHINESE);
        }


    }

    public static void main(String[] args) {
//        System.out.println(Constructor.string());
//        System.out.println(Constructor.byteArray());
//        System.out.println(Constructor.byteArrayChatset());
//        System.out.println(Constructor.covertToCharArray());
        System.out.println(Constructor.toUppercase());
    }
}
