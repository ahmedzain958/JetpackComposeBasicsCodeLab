package com.zainco.jetpackcomposebasicscodelab.problem_solving

fun main() {
    println(" ${canJump(intArrayOf(2,3,1,1,4))}")
    //Jump GAme 2
    println("Jump Game II ${jump(intArrayOf(2,3,1,1,4))}")
}
fun jump(nums: IntArray): Int {
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

