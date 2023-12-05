package com.zainco.jetpackcomposebasicscodelab

import java.util.Collections


//The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.)
// This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time.

/**
 * | Feature             | HashMap                 | HashTable               |
 * |---------------------|-------------------------|-------------------------|
 * | **Synchronization** | Not synchronized        | Synchronized            |
 * | **Performance**     | Better in single-threaded | Overhead in multi-threaded |
 * | **Null values**     | Allows null key, multiple null values | Does not allow null keys or values |
 * | **Inheritance**     | Extends AbstractMap      | Extends Dictionary       |
 * | **Iterator behavior**| Fail-fast               | Not fail-fast            |
 * | **Performance tuning**| Adjustable initial capacity and load factor | Fixed capacity and load factor |
 *
 */
object HashMapExample {
    @JvmStatic
    fun main(args: Array<String>) {
        // Creating a HashMap (not synchronized)
        val hashMap: MutableMap<String?, Int?> = HashMap()

        // Adding elements
        hashMap["One"] = 1
        hashMap["Two"] = 2
        hashMap["Three"] = 3
        hashMap[null] = null
        hashMap[null] = null
        hashMap[null] = null

        // Accessing elements
        println("HashMap: $hashMap")

        // Modifying the map in a single thread
        hashMap["Four"] = 4
        println("Updated HashMap: $hashMap")

        // Trying to access HashMap in multiple threads (no explicit synchronization)
        // This is safe in a single-threaded environment but can lead to issues in a multi-threaded one.
        // For concurrent access, consider ConcurrentHashMap.
    }
}


object SynchronizedHashMapExample {
    @JvmStatic
    fun main(args: Array<String>) {
        // Creating a synchronized HashMap
        val synchronizedHashMap = Collections.synchronizedMap(HashMap<String, Int>())

        // Adding elements
        synchronizedHashMap["One"] = 1
        synchronizedHashMap["Two"] = 2
        synchronizedHashMap["Three"] = 3

        // Accessing elements
        println("Synchronized HashMap: $synchronizedHashMap")

        // Modifying the synchronized map in multiple threads is safer due to explicit synchronization.
        // For better performance in multi-threaded environments, consider ConcurrentHashMap.
    }
}


object HashMapGetOrDefaultExample {
    @JvmStatic
    fun main(args: Array<String>) {
        // Creating a HashMap
        val hashMap: MutableMap<String, Int> = java.util.HashMap()

        // Adding key-value pairs
        hashMap["One"] = 1
        hashMap["Two"] = 2
        hashMap["Three"] = 3

        // Using getOrDefault to retrieve a value
        val valueOne = hashMap.getOrDefault("One", 0) // Existing key, returns 1
        val valueFour = hashMap.getOrDefault(
            "Four",
            0
        ) // Non-existing key, returns default value 0 placed in method getOrDefault(,0)
        println("Value for key 'One': $valueOne")
        println("Value for key 'Four': $valueFour")
    }
}

fun main() {
    println(buildMappingOfCharactersToOccurrences("Ahmed"))
    val targetedMapOfTs = HashMap<Char, Int>()
    "Ahmed".forEach { character ->
        targetedMapOfTs[character] = targetedMapOfTs.getOrDefault(character, 0) + 1
    }
    println(targetedMapOfTs)
}

private fun buildMappingOfCharactersToOccurrences(s: String): Map<Char, Int> {
    val map: MutableMap<Char, Int> = HashMap()
    for (i in s.indices) {
        val occurrencesOfCharacter = map.getOrDefault(s[i], 0)
        map[s[i]] = occurrencesOfCharacter + 1
    }
    return map
}

object HashMapElementsExistingInAnother {
    @JvmStatic
    fun main(args: Array<String>) {
        // Creating two HashMaps
        val map1 = hashMapOf("A" to 1, "B" to 2, "C" to 3)
        val map2 = hashMapOf("B" to 2, "C" to 3, "D" to 4)

        // Compare elements of map1 with map2
        val elementsNotInMap2 = hashMapOf<String, Int>()
        val elementsInBothMaps = hashMapOf<String, Int>()

        for ((key, value) in map1) {
            // Check if the key is present in map2 and if the corresponding values match
            if (!map2.containsKey(key) || map2[key] != value) {
                elementsNotInMap2[key] = value
            }
            if (map2.containsKey(key) || map2[key] == value) {
                elementsInBothMaps[key] = value
            }
        }

        // Display elements not present in map2
        println("Elements in map1 but not in map2: $elementsNotInMap2")
        println("Elements in both map1 map2: $elementsInBothMaps")
    }

}


