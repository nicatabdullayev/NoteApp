import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class Car(val model: String)

suspend fun receiveCar(channel: ReceiveChannel<Car>): Car? {
    return channel.receiveCatching().getOrNull()
}

fun main() = runBlocking<Unit> {
    val carChannel1 = Channel<Car>()
    val carChannel2 = Channel<Car>()
    val carChannel3 = Channel<Car>()

    fun produceCars(channel: SendChannel<Car>) = launch {
        repeat(10) {
            val car = Car("Model $it")
            channel.send(car)
            println("Produced $car")
            delay(1000)
        }
        channel.close()
    }

    launch { produceCars(carChannel1) }
    launch { produceCars(carChannel2) }
    launch { produceCars(carChannel3) }

    val assemblyJob = launch {
        repeat(30) {
            val car1 = receiveCar(carChannel1)
            if (car1 != null) {
                println("Assembled ${car1.model}")
            } else {
                println("All cars assembled")
                return@repeat
            }

            val car2 = receiveCar(carChannel2)
            if (car2 != null) {
                println("Assembled ${car2.model}")
            } else {
                println("All cars assembled")
                return@repeat
            }

            val car3 = receiveCar(carChannel3)
            if (car3 != null) {
                println("Assembled ${car3.model}")
            } else {
                println("All cars assembled")
                return@repeat
            }
        }
    }

    assemblyJob.join()
}