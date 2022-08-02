package hm.binkley.labs.graphql

import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rest/books")
@RestController
class BookController(
    private val books: BookRepository,
) {
    @GetMapping("")
    fun all(): Iterable<Book> = books.findAll()

    @GetMapping("{id}")
    fun byId(@PathVariable id: String) = books.findById(id)
        .orElseThrow { ResourceNotFoundException() }
}
