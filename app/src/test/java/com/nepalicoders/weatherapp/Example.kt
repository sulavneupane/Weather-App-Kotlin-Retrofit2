package com.nepalicoders.weatherapp

import org.junit.Assert
import org.junit.Test
import java.util.function.BiPredicate

/**
 * Created by Sulav on 9/10/17.
 */
class Example {

    @Test
    fun tester() {
        val people = mutableListOf(Person("Sally", 20))
        people.add(Person("Ryan", 40))
        people.add(Person("Ted", 82))
        people.add(Person("Lisa", 2))
        val averagePersonAge = people.average { person -> person.age }
        println("AveragePersonAge: $averagePersonAge")
    }

    fun <T> Iterable<T>.average(predicate: (T) -> Int): Int {
        val numOfItems = this.count()
        var sumOfItems = this.sumBy { predicate(it) }
        return sumOfItems / numOfItems
    }


}