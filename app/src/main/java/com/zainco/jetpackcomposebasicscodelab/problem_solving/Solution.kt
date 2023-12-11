package com.zainco.jetpackcomposebasicscodelab.problem_solving
import kotlin.math.max
import kotlin.math.min


fun main() {
    //Jump GAme
    //https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
    println(
        "canJumpTillEndOfArrayUsingGreedy ${
            canJumpTillEndOfArrayUsingGreedy(
                intArrayOf(2, 3, 1, 1, 4)
            )
        }"
    )
    //Jump GAme 2
    //https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
    println("Jump Game II ${jumpStepsToReachLastElement(intArrayOf(2, 3, 1, 1, 4))}")
    //H-Index
    //https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
    println("H-Index ${hIndex(intArrayOf(600, 700, 800, 0))}")//6,5,3,1,0
    //Two Sum II - Input Array Is Sorted
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
    println("Two Sum II - Input Array Is Sorted ${twoSum(intArrayOf(2, 7, 11, 15), 9)}")
    //Container with most water - two pointers
    //https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
    println("Container with most water - two pointers ${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) }")
    //3Sum
    //https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
    //https://www.youtube.com/watch?v=qJSPYnS35SE
    println("3Sum - sort then two pointers ${threeSum(intArrayOf(-1,0,1,2,-1,-4))}")
    //SlidingWindow
    //https://www.youtube.com/watch?v=_rWnoxus0Qg&t=325s
    println("Sliding Window explanation ${slidingWindowMaxSum(intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20), 4)}")
    //sliding window Min size sub array sum
    //https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
    //https://www.youtube.com/watch?v=jKF9AcyBZ6E
    println("sliding window Min size sub array sum ${minSubArrayLen(7,intArrayOf(2,3,1,2,4,3))}")
    //sliding window Longest Substring Without Repeating Characters
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
    //https://www.youtube.com/watch?v=3IETreEybaA
    println("Longest Substring Without Repeating Characters ${lengthOfLongestSubstringWithoutRepeatingCharacters("abcabcbb")}")
//    sliding window - Minimum Window Substring
//    https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150
//    https://www.youtube.com/watch?v=eS6PZLjoaq8
    println("Longest Substring Without Repeating Characters ${minWindow("ADOBECODEBANC", "ABC")}")
}

fun minWindow(searchString: String, t: String): String {

    /*var minWindow = ""
    var leftPointer = 0
    var rightPointer = 0
    val targetedMapOfTs = HashMap<Char, Int>()
    val windowMapIncludingTs = HashMap<Char, Int>()
    t.forEach {character ->
        targetedMapOfTs[character] = targetedMapOfTs.getOrDefault(character,0) + 1
    }
    while (rightPointer < searchString.length){
        val currentSearchStringCharacter = searchString[rightPointer]
        minWindow += currentSearchStringCharacter
        //add all string elements to the windowMapIncludingTs
        windowMapIncludingTs[currentSearchStringCharacter] = windowMapIncludingTs.getOrDefault(currentSearchStringCharacter,0) + 1
        //currentSum >= target
        while (minWindow.length >=  t.length && leftPointer <= rightPointer ) {
            leftPointer++
        }
        rightPointer++
    }*/

    // Creating Map for storing the frequency
    val requiredCharactersMap = buildMappingOfCharactersToOccurrences(t)
    val windowCharacterMapping: MutableMap<Char, Int> = HashMap()
    var left = 0
    var right = 0
    val totalCharFrequenciesToMatch = requiredCharactersMap.size
    var charFrequenciesInWindowThatMatch = 0

    // This will store the minimum length of valid substring
    var minWindowLengthSeenSoFar = Int.MAX_VALUE

    // It will store the actual substring
    var minWindow = ""

    // Here we calculate the ans using 2 pointer's approach
    while (right < searchString.length) {//expanding my window as far as possible until I satisfy these requirements ex A=1 B=1 C=1
        val characterAtRightPointer = searchString[right]
        addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer)
        if (requiredCharactersMap.containsKey(characterAtRightPointer) && requiredCharactersMap[characterAtRightPointer] == windowCharacterMapping[characterAtRightPointer]) {
            //whenever found an existing element of window inside the required ones
            charFrequenciesInWindowThatMatch++
        }
        while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
            val characterAtLeftPointer = searchString[left]
            val windowSize = right - left + 1
            if (windowSize < minWindowLengthSeenSoFar) {
                minWindowLengthSeenSoFar = windowSize
                minWindow = searchString.substring(left, right + 1)
            }
            windowCharacterMapping[characterAtLeftPointer] =
                windowCharacterMapping[characterAtLeftPointer]!! - 1
            val leftCharIsARequirement = requiredCharactersMap.containsKey(characterAtLeftPointer)
            if (leftCharIsARequirement) {
                val characterFailsRequirement =
                    windowCharacterMapping[characterAtLeftPointer]!! < requiredCharactersMap[characterAtLeftPointer]!!
                if (characterFailsRequirement) {
                    charFrequenciesInWindowThatMatch--
                }
            }
            left++
        }
        right++
    }
    return minWindow
}

// Helper function for computing the character's frequency of a string
private fun buildMappingOfCharactersToOccurrences(s: String): Map<Char, Int> {
    val map: MutableMap<Char, Int> = HashMap()
    for (i in s.indices) {
        val occurrencesOfCharacter = map.getOrDefault(s[i], 0)
        map[s[i]] = occurrencesOfCharacter + 1
    }
    return map
}

// Helper function to insert a character in the map
private fun addCharacterToHashtableMapping(map: MutableMap<Char, Int>, c: Char) {
    val occurrences = map.getOrDefault(c, 0)
    map[c] = occurrences + 1
}
fun lengthOfLongestSubstringWithoutRepeatingCharacters(s: String): Int {
    var leftPointer = 0
    var rightPointer = 0
    var lengthOfLongestSubstring = 0
    val hashSet = LinkedHashSet<Char>()//holds up unique characters
    //the one that is expanding the window is gonna get to the end before the one that sits in the beginning
    while (rightPointer < s.length) {
       if (hashSet.contains(s[rightPointer])){
           hashSet.remove(s[leftPointer])
           leftPointer++
       }else{
           hashSet.add(s[rightPointer])//add the current pointer
           rightPointer++//expand the window
           //we just want to keep the maximum length throughout the whole thing
           lengthOfLongestSubstring = max(lengthOfLongestSubstring, hashSet.size/*incrementing lengthOfLongestSubstring++ isn't right because we already add new item to the hashset*/)
       }
    }
    return lengthOfLongestSubstring
}
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var right = 0
    var currentSum = 0
    var minLength = Int.MAX_VALUE

    while (right < nums.size) {
        currentSum += nums[right]

        while (currentSum >= target) {
            minLength = minOf(minLength, right - left + 1)
            currentSum -= nums[left]
            left++
        }

        right++
    }
/*
if the next line is return minLength;
it will fail in case of
 Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
    return if (minLength == Int.MAX_VALUE) 0 else minLength
}
/**
 * personal demonstration: He fixed a window of k items and while looping he adds an item from the right and removes one from the left
 */
fun slidingWindowMaxSum(nums: IntArray, k:Int): Int {
    var windowSum = 0
    var maxSum = 0
    if (k > nums.size){
        return 0
    }
    for (i in 0 until k){
        windowSum += nums[i]
    }
    maxSum = windowSum
     for (i in k until nums.size){
        windowSum += nums[i]
        windowSum -= nums[i-k]
         if (windowSum > maxSum){
             maxSum = windowSum
         }
    }
    /**
     * previous loop could be conciser to be
     * for (i in k until nums.size){
     *         windowSum =windowSum +  nums[i]- nums[i-k]
     *          maxSum = max(maxSum, windowSum)
     *     }
     */

    return maxSum
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val sortedNums = nums.sorted()
    val outputList = mutableListOf<List<Int>>()

    for (i in 0 until sortedNums.size) {
        if (i == 0 || (i > 0 && sortedNums[i] != sortedNums[i - 1])) {
            val sum = 0 - sortedNums[i]
            var low = i + 1
            var high = sortedNums.size - 1

            while (low < high) {
                when {
                    sortedNums[low] + sortedNums[high] == sum -> {
                        outputList.add(listOf(sortedNums[i], sortedNums[low], sortedNums[high]))

                        while (low < high && sortedNums[low] == sortedNums[low + 1]) low++
                        while (low < high && sortedNums[high] == sortedNums[high - 1]) high--

                        low++
                        high--
                    }
                    sortedNums[low] + sortedNums[high] > sum -> high--
                    else -> low++
                }
            }
        }
    }
    return outputList
}


fun maxArea(height: IntArray): Int {
    var leftIndex = 0
    var rightIndex = height.size - 1
    var area = 0
    while (leftIndex < rightIndex) {
        area = max(area, (rightIndex - leftIndex) * min(height[leftIndex], height[rightIndex]))
        if (height[leftIndex] < height[rightIndex])
            leftIndex++//incrementing && decrementing must be done till reaching the max area recorded
        else
            rightIndex--
    }
    return area
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var i = 1
    var j = numbers.size
    while (true) {
        val sum = numbers[i - 1] + numbers[j - 1]
        if (sum == target) break
        else if (sum > target) j--
        else i++
    }
    return intArrayOf(i, j)
}

/**
 * Citations[N-h] > h (sorted asc) 0,1,3,5,6
 * citations[4-0]>0 yes citations[4]>0 yes 6 > 0
 * citations[4-1]>1 yes citations[3]>1 yes 5 > 1
 * citations[4-2]>2 yes citations[2]>2 yes 3 > 2 return h = 3
 * citations[4-3]>3 mo citations[1]>3 no 1 > 3
 */
fun hIndex(citations: IntArray): Int {
    val sorted = citations.sortedArrayDescending()
    var hIndex = 0
    for (i in sorted.indices) {
        if (sorted[i] >= i + 1) {
            hIndex++
        } else break
    }
    return hIndex
}

//https://www.youtube.com/watch?v=lDY3AnVOYmA
fun hIndexUsingNMinusH(citations: IntArray): Int {
    val sorted = citations.sortedArray()
    val sortedSize = citations.size - 1
    var hIndex = 0
    for (i in sorted.indices) {
        if (sorted[sortedSize - i] >= i) {
            hIndex++
        } else break
    }
    return hIndex
}

fun jumpStepsToReachLastElement(nums: IntArray): Int {
    val n = nums.size
    var maxReach = 0
    var steps = 0
    var lastJump = 0

    for (i in 0 until n - 1) {
        maxReach = maxOf(maxReach, i + nums[i])

        if (i == lastJump) {
            lastJump = maxReach
            steps++
        }
    }

    return steps
}

fun canJumpTillEndOfArray(nums: IntArray): Boolean {
    var i = 0
    // not index but element ex: maxReach = 4 for 3,2,1,0,4 is element with value 0
    var maxReach = 0
    while (i < nums.size && i <= maxReach) {
        val currentValue = nums[i]
        maxReach = maxOf(maxReach, i + currentValue)
        i++
    }
    if (i == nums.size)
        return true
    return false
}

/**
 * 3,2,1,0,4
 * https://www.youtube.com/watch?v=Gtugy3mRV-A
 */
fun canJumpTillEndOfArrayUsingGreedy(nums: IntArray): Boolean {
    var finalPosition = nums.size - 1
    for (i in nums.size - 2 downTo 0) {
        //can you reach the final position(flag) from position you are standing
        if (i + nums[i] >= finalPosition) {
            finalPosition = i
        }
    }
    return finalPosition == 0
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            profit += (prices[i] - prices[i - 1])
        }
    }
    return profit
}

fun main2() {
    val hashSet = LinkedHashSet<Char>()
    hashSet.add('a')
    hashSet.add('b')
    hashSet.add('c')
    hashSet.remove(hashSet.first())
    hashSet.remove("abc"[2])
    hashSet.forEach {
        println(it)
    }
}
