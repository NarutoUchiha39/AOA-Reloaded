"""
In this question we are trying to reduce the complexity it takes to search for a pattern in a given string. If we follow the naive algorithm , we
compare two characters and if they match just move both the pointers in the forward direction (One pointer for pattern and one for text). This causes
unnecessary comparisons of overlapping characters.

(i pointer for string, j pointer for pattern)
eg string is O N I O N I O N S
and pattern is O N I O N S

naive algorithm will try to match O with O and N with N and so on till we each the first point of discontinuity (i.e.
S and I) Now naive matching algorithm will restart the search with the j pointer set to 0 and i pointer set to 1. Do
we need all the comparisons again ? The answer is no we don't need to.

Consider the pattern. Suppose we have to find the longest suffix(beginning of word ) that is also the longest prefix(
ending of word). Suppose we have O N I O N S. O is a suffix, ON is a suffix ONIO is a suffix. The whole string can
also be suffix but we dont consider that. Now consider prefixes S, SN, ONS ..... again full string can be suffix but
we don't consider that here. Now what suffix is also equal to prefix ? consider string till S ON is present on the
front as well as back so longest prefix that is a suffix is ON so we will first make a table :

O N I O N S
0 0 0 1 2 0

here the numbers represent the length of the longest ame prefix and suffix till that point. (till the N before S ON is
at beginning and at the end) So this is our Longest prefix that is a Suffix(in short LPS).

Now comes the question why are we doing this ? We are doing this in order to reduce the number of searches required
to find a substring in a string. Suppose in the above example, instead of starting comparison from beginning again, What
if we start comparison from the LPS before the point of discontinuity ? In this way we won't need to take i pointer to the
beginning again. Why does this work ? this is because we know that all the characters before the point of discontinuity
match. So if we find the sequence of characters in the beginning that match with the sequence of characters from the end,
we can move the j pointer to the character after the index where overlap occurs and then resume the checking of main string without disturbing the
i pointer .

Example ; O N I O N I O N S
LPS:
O N I O N S
0 0 0 1 2 0

start from i = 0 and j  = 0. Everything matches till i =5 and j = 5. Now since we know that all the characters before
j  = 5 match, we simply find the text that is same from beginning and end before we encountered I. That will be ON so we move
our J pointer after ON in the pattern. Now j will become 2

          i
          |
          -
O N I O N I O N S
      O N I O N S
          |
          _
          j

In order to calculate the LPS array we use two pointers(len and j. len will be set to 0 and j will be set to 1).
First we go on comparing the character pointed by len with character pointed by j. If they match then the LPS value for
j becomes previous LPS value + 1. Now the case if they dont match.

We simply decrement the len pointer to the previous character and set it to the value of LPS till the previous character
This is done because we have to check again if the character pointed by j is equal to the prefix so that the LPS value of
jth character can be set as the LPS value of character pointed by len and increment it by 1 (if they match) if they dont match then len is decremented
till it reaches 0. On reaching zero it is obvious that the jth character doesnt match with any prefix hence its LPS value is set to zero.

 eg  A A B A A A
 initial j = 0, len = 1
 1) Compare A nd A they are equal set LPS of j as 0 and LPS of len as 1
 2) Increment j and len
 3) B and A donot match set j = LPS[j-1] i.e j = 0. Now compare B and A they don't match and j = 0.set LPS[len] = 0 since
 B doesn't match any prefix. Increment len by 1
 4) Compare A and A they match increment len and j.
 5) Compare A and A they repeat step 4
 6) Compare A and B they dont match. Set j = LPS[j-1] or j = 1
 7) Compare LPS[j](i.e A) and LPS[len] they are equal set LPS[len] = LPS[j] + 1 (i.e. LPS[len] = 2)

 Thus final array is 0 1 0 1 2 which is the correct answer (2 aa from back match 2 aa from start and that is the longest)

Time complexity : O(N+M)
Space Complexity: O(M) M: Pattern length and N is string length
"""
class Solution:
    def search(self, pat, txt):
        LPS = [0]*len(pat) # Longest prefix that is also a suffix
        def KMP():
            i = 1
            len1 = 0

            while(i<len(pat)):
                if(pat[i] == pat[len1]):

                    LPS[i] = len1+1
                    i+=1
                    len1+=1

                else:
                    if(len1!=0):
                        len1 = LPS[len1-1]
                    else:
                        LPS[i] = 0
                        i+=1

        def search():
            res = []
            i = 0
            j = 0
            while(i<len(txt)):
                if(pat[j] == txt[i]):
                    i+=1
                    j+=1

                else:
                    if(j!=0):
                        j = LPS[j-1]
                    else:
                        i+=1
                if(j==len(pat)):
                    res.append(i-j+1)
                    j = LPS[j-1]


            return res


        KMP()
        return search()


        KMP()
        return search()