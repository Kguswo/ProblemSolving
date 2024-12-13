class Solution {
public:
    int maxArea(vector<int>& height) {
        int n, left, right, width, res;
        n = height.size();
        left = 0;
        right = n-1;
        width = right-left;
        res =0;
        while(left<right){
            int leftH = height[left];
            int rightH = height[right];
            int minH = min(leftH, rightH);
            int S = width * minH;
            res = max(res, S);

            if(leftH < rightH) left++; 
            else right--;
            width--;
        }
        return res;
    }
};