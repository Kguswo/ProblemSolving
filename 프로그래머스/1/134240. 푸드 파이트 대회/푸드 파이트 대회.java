class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            answer.append(String.valueOf(i).repeat(food[i] / 2));
        }       
        String left = answer.toString();
        answer.append("0").append(new StringBuilder(left).reverse());
        return answer.toString();
    }
}
