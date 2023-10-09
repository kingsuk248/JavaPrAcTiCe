package sites.coding.codesignal;

public class CommonCharacterCount {
    public static void main(String[] args) {
        CommonCharacterCount ccc = new CommonCharacterCount();
        String s1 = "aabcc";
        String s2 = "adcaa";
        int count = ccc.solution(s1, s2);
        System.out.println(count);
        System.out.println(Integer.valueOf('1') - 48);
    }

    int solution(String s1, String s2) {
        int count = 0;
        int[] charIdxArray = new int[26];
        for (char ch : s1.toCharArray()) {
            int idx = ch - 97;
            charIdxArray[idx] = charIdxArray[idx] + 1;
        }

        for (char ch : s2.toCharArray()) {
            int idx = ch - 97;
            if (charIdxArray[idx] > 0) {
                charIdxArray[idx] = charIdxArray[idx] - 1;
                count++;
            }
        }
        System.out.println();
        return count;
    }

}
