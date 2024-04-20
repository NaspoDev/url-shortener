package dev.naspo.urlshortenerserver.utils;

import java.util.Stack;

// Handles conversion from base-10 to base-62;
public class Base62Converter {
    private final char[] BASE_62_CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'
    };

    @SuppressWarnings("ExtractMethodRecommender")
    public String convertToBase62(int base10Value) {
        // If the base-10 value is less than 62, return the
        // direct base-62 equivalent.
        if (base10Value < 62) {
            return String.valueOf(BASE_62_CHARS[base10Value]);
        }

        // Start the conversion process (building the base-62 number right-to-left).
        Stack<Character> stack = new Stack<>();
        int temp = base10Value;

        // Keep dividing the base-10 value by 62, until it becomes smaller than 62.
        // At each division step, push the remainder of the division to the stack.
        while (temp >= 62) {
            stack.push(BASE_62_CHARS[temp % 62]);
            temp = temp / 62;
        }
        // At the end, once the value is < 62, push the direct base-62 equivalent value of it to the stack.
        stack.push(BASE_62_CHARS[temp]);

        // Construct our string result from the stack and return it.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
