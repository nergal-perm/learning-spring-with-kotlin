package ru.terekhov

import org.springframework.beans.factory.stereotype.Component

@Component
class SampleFirstBean() {
    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }
}

@Component
class SampleSecondBean() {
    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }
}