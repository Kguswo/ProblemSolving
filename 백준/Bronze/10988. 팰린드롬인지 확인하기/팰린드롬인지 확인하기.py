def is_palindrome(word):
    length = len(word)

    for i in range(length//2):
        if word[i] != word[length-1-i]:
            return 0
        
    return 1

word = input()

print(is_palindrome(word))