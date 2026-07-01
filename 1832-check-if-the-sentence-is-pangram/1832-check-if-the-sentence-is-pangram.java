class Solution {
    public boolean checkIfPangram(String sentence) {
        String a="abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<a.length();i++)
        {
        if(!sentence.contains(a.charAt(i) + ""))
        {
            return false;
        }
        }
        return true;
    }
}