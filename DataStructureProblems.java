// Hashtables, ArrayLists, Stringbuilder

/*
    1.1 Is Unique: Implent an algorithm to determine if a string has all unique charactesr. 
    What if you cannot use additional data structures?
 */
public boolean isUnique(String word) {
    ArrayList<String> list =  new ArrayList<String>();
    for (int i  = 0; i < word.length() - 1; i++) {
        String l = word[i];
        if (list.contains(i)) { 
            return false;
        } else {
            list.set(i);
        }
    }
    return true;
}

// 2. No additional data structures
public boolean isUnique(String word) {
    String w2 = null;

    for (int i = 0; i < word.length() - 1; i++) {
        if (w2.contains(word[i])) {
            return false;
        }
        w2 += word[i];
    }
    return true;
}

/*
    1.2 Check Permutation: Given two strings, 
    write a method to decide if one is a permutation of the other.

    Things to consider:
        - Sort the strings before comparison and simply check if each string equals the other.
        - Consider if things like white space and case sensitive is significant

    The method we did checks identical character counts.

    Instead of creating an additional data structure, can simply store a count
    using the character's index in ASCII and storing the count at that index. 
*/
public boolean permutation(String w1, String w2) {
    HashMap<String, Int> list = new HashMap<String, Int>();
    HashMap<String, Int> list2 = new HashMap<String, Int>();

    for (int i = 0; i < w1.length() - 1; i++) {
        if (list.contains(w1[i])) {
            int count = list.get(w1[i]);
            count++;
            list.put(w1[i], count);
        } else {
            list.put(w1[i], 1);
        }
    }

    for (int i = 0; i < w2.length() - 1; i++) {
        if (list2.contains(w2[i])) {
            int count = list.get(w2[i]);
            count++;
            list2.put(w2[i], count);
        } else {
            list2.put(w2[i], 1);
        }
    }

    if (list.size() != list2.size()) {
        return false;
    }

    for (String k: list) {
        if (!list2.containsKey(key) && (list.get(k) != list2.get(k))) {
            return false;
        }
    }
    return true;
}

/*
    1.3 URLify: Write a method to replace all spaces in a string with '%'20'. You may assume that
    the string has sufficient space at the end to hold the additional characters, and that you are given the 'true'
    length of the string. 
*/
public void urlify(String w) {
    for (int i = 0; i < length - 1; i++) {
        if (w[length - 1 - i] == " ") {
            for (int j = 0; j < i - 1; j++) {
                String s = w[length - 1- j];
                w[length - 1 - j] = s;
            }
            w[length - 1 - i] = "%";
            w[length - i] = "2";
            w[length - i + 1] = "0";
        }
    }
}

/*
    1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation
    of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is
    a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    Ignore casing and spaces.
*/
public boolean palperm(String s) {
    boolean odd = false;
    int count = 0;
    
    if (s.length == 1) {
        return true;
    }

    char tempArray[] = s.toCharArray();
    Arrays.sort(tempArray);

    for (int i = 0; i < tempArray.length - 1; i++) {
        if (tempArray[i + 1] != tempArray[i]) {
            if (count % 2 == 1 && odd) {
                return false;
            } else if (count % 2 == 1) {
                odd = true;
            }
            count = 0;
        }
        count++;
    }

    return true;
}

// LinkedLists

/*
    2.2 Kth to Last: Find the kth to last element and return that element.
 */
public Node returnKth(Node n, int k) {
    int count = 0;
    Node p1 = n;

    while (p1!= null) {
        count++;
        p1=p1.next;
    }
    int rep = count - k;
    Node p2 = n;
    for (int i = 0; i < rep; i++) {
        p2 = p2.next;
    }
    return p2;
}

/*
    2.3 Delete node: Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
    This is assuming there is a first and last node and you aren't given the first and last node to remove. 

    Notes: Cannot turn a node of type int into null. In this example. was trying to basically copy the
    node that is next and then once we know we're at the end, turn the current value into null, but
    you cannot turn the current reference into a null. So instead, must either stop at the value before the last node
    and set the value equal to the last node and then remove the reference to the last node.

    The other method is to just change the .next of the current or given node to .next.next (access the next value of the next value),
    that way we don't have to worry about looping. Do you need to loop to do the problem????

    Take away is avoid dealing with accessing a null value. 
*/
public void deleteNode(ListNode node) {
    while (node.next.next != null) {
        node.val = node.next.val;
        node = node.next;
    }

    node.val = node.next.val;
    node.next = null;
}

// Bit Manipulation

/*
    5.1 Insertion
*/

public int insertion(int N, int M, int i, int j) {
    int mask = ( -1 << (j + 1)) | (~(-1 << i));
    return (N & mask ) | ( M << i );
}

/*
    5.2 Binary to String

    NOTES:

    Process for converting decimal to binary is a bit different than
    integer numbers.

    For decimal, multiply decimal by 2. If the result is >= 1, then that bit is 1. 
    After that subtract 1.
    If the result is < 1, then the bit is 0 and we do not subtract.

    If you were to iterate through the entire decimals, this would continue until you arrive at a 
    decimal of 1.0, from where you would then stop. last bit would basically always be 1 because of this.

    This is also essentially shifting the fraction up through each iteration of above. 
*/

public static String printBinary(double num) {
    // Check Number is Between 0 to 1 or Not
   if (num >= 1 || num <= 0)
       return "ERROR";

   StringBuilder binary = new StringBuilder();
   binary.append(".");

   while (num > 0)
   {
       /* Setting a limit on length: 32 characters,
          If the number cannot be represented
          accurately in binary with at most 32
          character  */
       if (binary.length() >= 32)
           return "ERROR";

       // Multiply by 2 in num to check it 1 or 0
       double r = num * 2;
       if (r >= 1)
       {
           System.out.println(binary);
           binary.append(1);
           num = r - 1;
       }
       else
       {
           binary.append(0);
           num = r;
       }
   }
   return binary.toString();
}

/*
    5.3: Flip Bit to Win

    NOTES: 
    First thought was to build a string to reiterate through,
    but in the first loop we're already iterating through it as 
    binary number so no need to do a second loop
        1. When doing this method, store the numbers in an ArrayList as opposed 
        to a String
    - When resetting the count, reset it to 0. Only want to increment
    if it's continuing off of a 1, not if it's necessarily connected to a 1. 
    - IMPORTANT: Issue appeared when 0's would occur with 1's on both sides.
        In this case, this was solved by having an additional variable
        to keep track of the previous count to add to the current count and then adding +1 to
        subsitute the 0 connecting both counts. 
    
        Key to this problem is knowing we can somehow keep track of the next bit. If we used
        an arraylist, we could also keep track of the previous bit. 
*/

/*
    5.4: Next Numm

    Current method is brute force.

*/
public static int flipBit(int num) {
    if (num == 0) {
        return 1;
    }
     
    String s = "";
    int n1 = num;
     
    int maxCount = 0;
    int currentCount = 0;
    int previousCount = 0;

     
     while (n1 > 0) {
         if (n1 % 2 == 1) {
            currentCount++;
            s += "1";
         } else {
             s += "0";
            
             
            // Check next bit
            int nextNum = (n1 / 2) % 2;
            
            System.out.println("Next num: " + nextNum);
            
            if (nextNum == 1) {
                previousCount = currentCount;
            } else {
                previousCount = 0;
            }
            currentCount = 0;
         }
         
         n1 /= 2;
         
         if (currentCount + previousCount + 1 > maxCount) {
             maxCount = currentCount + previousCount + 1;
         }
         
     }
     

    System.out.println("integer: " + num);
     System.out.println("binary: " + s);
     System.out.println("max: " + maxCount);
     System.out.println();
     
     return maxCount;
     
 }

 public static void nextNum(int num) {
    int c1 = count(num);
    int big = num + 1;
    int small = num - 1;

    System.out.println("OG: " + c1);
    
    boolean fBig = false;
    boolean fSmall = false;
    
    while (!fBig) {
        int c2 = count(big);
        if (c1 == c2) {
            fBig = true;
            System.out.println("Big Count: " + c2);
        } else {
            big += 1;
        }
    }
    
    while (!fSmall && small > 0) {
        int c3 = count(small);
        if (c1 == c3) {
            fSmall = true;
            System.out.println("Small Count: " + c3);
        } else {
            small -= 1;
        }
    }
    
    // Did not find next smaller number; 
    if (small == 0) {
        small = num;
    }
    
    System.out.println("Num: " + big + " Binary: " + bin(big));
    System.out.println("Num: " + small + " Binary: " + bin(small));
}

private static int count(int num) {
    int count = 0;
    while (num != 0) {
        if ((num & 1) == 1) {
            count++;
        }
        num >>>= 1;
    }
    return count;
}


// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s == null) {
        return 0;
    }    
    
    int max = 1;
    
    // Pointers
    int right = 0;
    int left = 0;
    
    // Keep track of characters          
    HashSet<Character> chars = new HashSet<Character>();
    
    // Move right pointer         
    while (right < s.length()) {
        char c = s.charAt(right);
        
        // Move left pointer if HashSet contains the character at our head 
        // Will remove all letters up to the point where the first occurrence
        // of our duplicate occurs (inclusive so that it removes the first occurrence).
        // Left will end up 1 ahead of our duplicate by the time it exists this
        // while loop
        while (chars.contains(c)) {;
            chars.remove(s.charAt(left));
            left++;
        }
        chars.add(c);
        
        // Compare current length with our max           
        max = Math.max(right - left + 1, max);
        right++;
    }
    
    return max; 
}