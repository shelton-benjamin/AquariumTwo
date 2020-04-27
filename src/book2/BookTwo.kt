package book2

import java.util.*

class Book(val title: String, val author: String, val year: Int, var pages: Int = 0) {

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < MAX_NUMBER_BOOKS)
    }


    object Constants {
        const val BASE_URL = "http://www.turtlecare.net/"
    }

    fun printUrl() {
        println(Constants.BASE_URL + title + ".html")
    }


    companion object {
        val BASE_URL = "http://www.turtlecare.net/"
    }


}

const val MAX_NUMBER_BOOKS = 20

fun Book.weight(): Double {
    return (pages * 1.5)
}

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))


    }
}


    fun main(args: Array<String>) {

        val book = Book("Romeo and Juliet", "William Shakespeare", 1597)
        val bookTitleAuthor = book.getTitleAuthor()
        val bookTitleAuthorYear = book.getTitleAuthorYear()

        println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

        println(
            "Here is your book ${bookTitleAuthorYear.first} " +
                    "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}"
        )

        val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
        val library = mapOf("Shakespeare" to allBooks)
        println(library.any { it.value.contains("Hamlet") })

        val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
        moreBooks.getOrPut("Jungle Book") { "Kipling" }
        moreBooks.getOrPut("Hamlet") { "Shakespeare" }
        println(moreBooks)


        val puppy = Puppy()
        val book2 = Book("Oliver Twist", "Charles Dickens", 1837, 540)

        puppy.playWithBook(book2)
        while (book2.pages > 0) {
            puppy.playWithBook(book2)
            println("${book2.pages} left in ${book2.title}")
        }
        println("Sad puppy, no more pages in ${book2.title}. ")
    }