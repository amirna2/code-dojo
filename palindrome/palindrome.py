#!/usr/lib/python

# iterating through the string length with a start and end indexes converging to
# the same character. Exit the loop if characters don't match
def is_palindrome1(string):
    start = 0
    end = len(string) - 1
    while end > start:
        start += 1
        end -= 1
        if string[start] != string[end]:
            return False
    return True


# Similar to above, but use a for range loop with a max_length = string length / 2
def is_palindrome2(string):
    max_length = int(len(string) / 2)
    for start in range(0, max_length):
        end = len(string) - start - 1
        if string[start] != string[end]:
            return False
    return True


# using a slice that starts at the end of the string, and moves backwards
def is_palindrome3(string):
    return string == string[::-1]


############
# checks if vowels in a string form a palindrome
# 1. create a string with all vowels in a given string
# 2. check if the vowel string is a palindrome
# 3. If the vowel string empty, print an error message
############

# checks if a character is a vowel
# This doesn't check for Y which can be either a vowel or a consonant
def is_vowel(c):
    v = list("aeiou")
    if c in v:
        return True
    return False


# returns a string of all vowels found in a string
def extract_vowels_from(string):
    v = []
    for c in string:
        if is_vowel(c):
            v.append(c)
    return v


def list_to_string(a_list):
    string = ""
    return string.join(a_list)


def is_vowel_palindrome(string):
    vowels = extract_vowels_from(string)
    if len(vowels) == 0:
        return "No vowels found."
    vstring = list_to_string(vowels)
    if is_palindrome3(vstring):
        return "True"

    return "False"


# main function
s1 = "raceecar"  # even length
s2 = "hello world"  # not a palindrome
s3 = "racecar"  # odd length
s4 = "zexacuvubanem" # a vowel palindrome
s5 = "qwertyuiop" # not a vowel palindrome

print("=== Using converging indexes. Full length loop")
print("Is [" + s1 + "] a palindrome? " + str(is_palindrome2(s1)))
print("Is [" + s2 + "] a palindrome? " + str(is_palindrome2(s2)))
print("Is [" + s3 + "] a palindrome? " + str(is_palindrome2(s3)))

print("=== Using converging indexes. Half length loop")
print("Is [" + s1 + "] a palindrome? " + str(is_palindrome2(s1)))
print("Is [" + s2 + "] a palindrome? " + str(is_palindrome2(s2)))
print("Is [" + s3 + "] a palindrome? " + str(is_palindrome2(s3)))

print("\n=== Using backward slice")
print("Is [" + s1 + "] a palindrome? " + str(is_palindrome3(s1)))
print("Is [" + s2 + "] a palindrome? " + str(is_palindrome3(s2)))
print("Is [" + s3 + "] a palindrome? " + str(is_palindrome3(s3)))

print("\n=== Is vowel palindrome")
print("Is [" + s4 + "] a vowel palindrome? " + str(is_vowel_palindrome(s4)))
print("Is [" + s5 + "] a vowel palindrome? " + str(is_vowel_palindrome(s5)))
