def solve(n, arr):
    # Count frequency of each number
    freq = {}
    for num in arr:
        freq[num] = freq.get(num, 0) + 1
    
    # Calculate maximum pairs for each number
    total_pairs = 0
    for count in freq.values():
        # Each pair needs 2 numbers, so we can make count//2 pairs
        total_pairs += count // 2
    
    return total_pairs
 
# Process multiple test cases
def process_test_cases():
    t = int(input())
    results = []
    
    for _ in range(t):
        n = int(input())
        arr = list(map(int, input().split()))
        results.append(solve(n, arr))
    
    return results
 
# Print results
if __name__ == "__main__":
    results = process_test_cases()
    for result in results:
        print(result)