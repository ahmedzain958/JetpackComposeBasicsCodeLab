package com.zainco.jetpackcomposebasicscodelab.problem_solving

fun main() {
    println(" ${canJumpTillEndOfArrayUsingGreedy(intArrayOf(2,3,1,1,4))}")

    //Jump GAme 2
    println("Jump Game II ${jumpStepsToReachLastElement(intArrayOf(2, 3, 1, 1, 4))}")
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
 */
fun canJumpTillEndOfArrayUsingGreedy(nums: IntArray): Boolean {
    var finalPosition = nums.size - 1
    for (i in nums.size - 2 downTo  0) {
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

