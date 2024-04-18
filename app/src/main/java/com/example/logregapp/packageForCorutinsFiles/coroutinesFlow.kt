package com.example.logregapp.packageForCorutinsFiles

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(10){
        launch {
            produceCar()
        }
    }
}

suspend fun assembleCar() {
    println("Assembling car...")
    delay(2000)
    println("Car assembled!")
}

suspend fun paintCar() {
    println("Painting car...")
    delay(1000)
    println("Car painted!")
}

suspend fun addWheels() {
    println("Adding wheels to car...")
    delay(1000)
    println("Wheels added!")
}

suspend fun testDrive() {
    println("Test driving car...")
    delay(1000)
    println("Car tested!")
}


suspend fun produceCar() {
    assembleCar()
    paintCar()
    addWheels()
    testDrive()
}