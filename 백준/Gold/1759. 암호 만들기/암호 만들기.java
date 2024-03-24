import java.util.*;

public class Main {
    static int L, C;
    static char[] characters;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        C = scanner.nextInt();
        characters = new char[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            characters[i] = scanner.next().charAt(0);
        }

        Arrays.sort(characters); // 입력된 문자들을 정렬

        generatePasswords(0, 0, 0, "");

        scanner.close();
    }

    private static void generatePasswords(int index, int consonants, int vowels, String password) {
        if (password.length() == L) {
            if (consonants >= 2 && vowels >= 1) {
                System.out.println(password);
            }
            return;
        }

        if (index == C) {
            return;
        }

        char currentCharacter = characters[index];
        int newConsonants = consonants;
        int newVowels = vowels;

        if (isVowel(currentCharacter)) {
            newVowels++;
        } else {
            newConsonants++;
        }

        // 현재 문자를 선택하는 경우
        generatePasswords(index + 1, newConsonants, newVowels, password + currentCharacter);
        
        // 현재 문자를 선택하지 않는 경우
        generatePasswords(index + 1, consonants, vowels, password);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
