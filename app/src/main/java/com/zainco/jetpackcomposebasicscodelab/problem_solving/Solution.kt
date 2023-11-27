package com.zainco.jetpackcomposebasicscodelab.problem_solving

fun main() {
    val canJumb = canJump(intArrayOf(2,3,1,1,4))
}

fun canJump(nums: IntArray): Boolean {
    var i = 0
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
