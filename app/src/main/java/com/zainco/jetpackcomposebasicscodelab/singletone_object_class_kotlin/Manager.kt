package com.zainco.jetpackcomposebasicscodelab.singletone_object_class_kotlin

class Manager private constructor() {
    companion object {
        private var instance: Manager? = null
        fun getInstance() = synchronized(this) {
            if (instance == null)
                instance = Manager()
            instance

        }

        //instead of getInstance() we can use
        operator fun invoke() = synchronized(this) {
            if (instance == null)
                instance = Manager()
            instance

        }
    }
}

fun main() {
    println(Manager())
    println(Manager.invoke())
    //both are equal, but in kotlin instead of writing all this boilerplate code to create a singleton class, we can create an object
    println(ManagerObject)
    println(ManagerObject)
    //both have a single instance

    /**
     * output of all previous code
     *
     * com.zainco.jetpackcomposebasicscodelab.singletone_kotlin.Manager@681a9515   of Manager() instance
     * com.zainco.jetpackcomposebasicscodelab.singletone_kotlin.Manager@681a9515   of Manager() instance
     * com.zainco.jetpackcomposebasicscodelab.singletone_kotlin.ManagerObject@19469ea2   of ManagerObject() instance
     * com.zainco.jetpackcomposebasicscodelab.singletone_kotlin.ManagerObject@19469ea2   of ManagerObject() instance
     */
}

/**
 * object classes are thread safe
 */
object ManagerObject{
    init {

    }
}