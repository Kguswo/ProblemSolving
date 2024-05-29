class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        return calculate(numbers, target, 0, 0);
    }
    public int calculate(int[] numbers, int target, int cnt, int sum){
        if (cnt == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int add = calculate(numbers, target, cnt + 1, sum + numbers[cnt]);
        int subtract = calculate(numbers, target, cnt + 1, sum - numbers[cnt]);
        return add + subtract;
    }
}