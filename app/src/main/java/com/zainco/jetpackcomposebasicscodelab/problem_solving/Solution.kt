package com.zainco.jetpackcomposebasicscodelab.problem_solving

import java.util.LinkedList
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
    println("3Sum - sort then two pointers ${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) }")
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val sortedNums = nums.sortedArray()
    val outputList = LinkedList<List<Int>>()
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

