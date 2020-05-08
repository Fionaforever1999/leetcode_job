class Solution {
    public String[] map = {" ", "*", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    // public List<String> res = new List();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length()==0){
            return new ArrayList<>();
        }
        backTrack(digits, "", 0);
        return res;
    }
    public void backTrack(String digits, String letter, int index){
        if (index == digits.length()){
            res.add(letter);//list对象都是以add添加的
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0';//注意char单引号
        String str = map[pos];
        for (int i=0; i<str.length();i++){
            backTrack(digits, letter + str.charAt(i), index+1);
        }
        
    }
}