fun main() {
    // Начало занятия

    // try-catch конструкция
    println(divide(4, 2))
    println(divide(5, 0))

    // Функции области видимости
    // let - когда нужно вернуть результат операции над объектом в переменную
    val name = "Name"
    val nameLength = name.let {
        // Внутри блока можно писать любой исполняемый код
        println(it.length)
        // Записываем в nameLength длину строки name
        it.length
    }

    // run - то же самое что let,
    // но более предпочтительна в работе с null объектами
    val name2 = "Name 2"
    val nameLength2 = name2.run {
        this.length
    }

    // with
    val string = StringBuilder()
    string.append("Hello, ")
    string.append("World!")
    // Аналог
    with(string) {
        append(" Hew")
        append(" Hello, ")
        append("World!")
    }

    // Создание объектов класса Box с разными типами данных item
    val box1 = Box(5)
    val box2 = Box("Some string")
    val box3 = Box(false)

    box1.item
    box2.item
    box3.item

    // Создание объектов класса Box с разными типами данных item
    // НО, тип данных item будет определяться автоматически
    val box4 = Box2(5)
    val box5 = Box2("Some string")
    val box6 = Box2(false)

    // Пример применения функции-расширения
    val helloWorld = "Hello, World!"
    println(helloWorld.firstLetter())
}

// Создание обычного класса
class Box(val item: Any)

// Создание класса дженерика
class Box2<T>(val item: T)

// Создание функции дженерика
fun <T> example(a: T): T {
    return a
}

// Функция-расширение/Extension-функция
fun String.firstLetter(): Char {
    println("Текущая строка $this")
    return this[0]
}

fun divide(a: Int, b: Int): Int {
    return try {
        // Внутри блока try находится исполняемый код
        a / b
    } catch (e: ArithmeticException) {
        // Внутри блока catch будет происходить обработка ошибок
        println("Возникла ошибка $e")
        0
    } finally {
        // Блок finally выполняется в любом случае
        println("Блок finally выполнился")
    }
}