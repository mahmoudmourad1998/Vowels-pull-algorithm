import java.util.HashMap;

public class Mahmoud {

    public static Integer first_vowel_indx = null ;
    public static void main(String[] args) {
        String output1 = findSubstring("jeniferlopiz",6);
        System.out.println(output1);
    }
    public static String findSubstring(String s, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>( );
        char[] letters_array = s.toCharArray () ;
        for (int indx = 0 ; indx < letters_array.length ; indx++ ) {
            if (is_vowel (letters_array[indx])){
                if (first_vowel_indx == null) {
                    first_vowel_indx = indx;
                }
                int vowels_count = 1;
                hmap.put (indx, vowels_count);
                for (int indx1 = indx + 1 ; indx1 <= indx + k && indx1 < letters_array.length ; indx1++ ) {
                    if (is_vowel(letters_array[indx1])){
                        vowels_count++;
                        hmap.replace(indx, vowels_count);
                    }
                }
            }
        }
        System.out.println(hmap);
        int max_vowels_starting_indx = max_value_key(hmap);
        StringBuilder result = new StringBuilder();
        for (int indx3=max_vowels_starting_indx; indx3 < max_vowels_starting_indx + k && indx3 < letters_array.length ; indx3++) {
            result.append(letters_array[indx3]);
        }
        return "result is " + result.toString();
    }

    public static Boolean is_vowel (char letter){
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
            return true ;
        }
        else {
            return false ;
        }
    }
    public static int max_value_key (HashMap<Integer, Integer> hmap){
        Integer max_value = null ;
        int max_value_key = 0 ;
        for (int key : hmap.keySet()){
            if (max_value == null) {
                max_value = hmap.get(key);
                max_value_key = key ;
            }
            else {
                int value = hmap.get(key);
                if (value > max_value) {
                    max_value = value;
                    System.out.println("max value " + max_value);
                    max_value_key = key ;
                    System.out.println("max value key " + max_value_key);
                }
            }

        }
        return max_value_key ;
    }
}
