package com.zainco.jetpackcomposebasicscodelab.delegates

interface Person {
    fun work(title: String)
}

class Worker(val jobDesc: String): Person{
    override fun work(title: String) {
        println("I am a $title")
        println("I am working $jobDesc")
    }
}

class ProductionWorker(personData: Person): Person by personData
class Dustman(personData: Person): Person by personData{
    override fun work(title: String) {
        println("I am a $title")
    }
}

fun main() {
    val w = Worker("carry out some")
    ProductionWorker(w).work("ProductionWorker")
    Dustman(w).work("Dustman")
}