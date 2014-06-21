public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || haystack == null)
            return haystack;

        if (needle.length() > haystack.length())
            return null;

        int[] f = new int[needle.length()];

        f[0] = 0;
        for (int i = 1; i < needle.length(); i ++) {
            if (needle.charAt(f[i - 1]) == needle.charAt(i))
                f[i] = f[i - 1] + 1;
            else
                f[i] = needle.charAt(0) == needle.charAt(i) ? 1 : 0;
        }

        int haystackIndex = 0;
        int needleIndex = 0;
        while (haystackIndex < haystack.length() && needleIndex < needle.length()) {
            if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
                haystackIndex ++;
                needleIndex ++;
                continue;
            }

            if (needleIndex > 0) {
                haystackIndex = haystackIndex - needleIndex + 1 + f[needleIndex - 1];
                needleIndex = f[needleIndex - 1];
            } else {
                haystackIndex ++;
                needleIndex = 0;
            }
        }

        if (needleIndex != needle.length())
            return null;
        return haystack.substring(haystackIndex - needleIndex);
    }
}