package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class KotlinIsFun {

    @Test
    fun kotlinIsLikeJava() {
        val subject = MyClass()
        assertThat(subject.cool).isTrue()
    }

    @Test
    fun kotlinConstructors() {
        val subject = MyClass(false)
        assertThat(subject.cool).isFalse()
    }

    @Test
    fun kotlinHasFunctions() {
        val subject = MyClass()
        assertThat(subject.double(2)).isEqualTo(4)
    }

    @Test
    fun `data classes`() {
        val one = MyClass()
        val two = MyClass()

        assertThat(one).isEqualTo(two)

        println(one)
    }

    @Test
    fun `collections`() {
        val things = listOf(MyClass(name = "Luis"), MyClass(name = "Daniel"), MyClass(name = "Derek"))

        val names = things.filter { it.name.startsWith("D") }
                .map { it.name.toLowerCase() }

        assertThat(names).containsExactlyInAnyOrder("derek", "daniel")
    }

    @Test
    fun `string templates`() {
        val daniel = MyClass(name = "Daniel")
        assertThat(daniel.greet()).isEqualToIgnoringCase("hello, daniel !")
    }
}

data class MyClass(val cool: Boolean = true, val name: String = "default") {

    fun double(input: Int) = input * 2
    fun greet() = "Hello, $name !"

}