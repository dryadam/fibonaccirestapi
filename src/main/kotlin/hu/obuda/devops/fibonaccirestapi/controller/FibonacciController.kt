package hu.obuda.devops.fibonaccirestapi.controller

import hu.obuda.devops.fibonaccirestapi.service.FibonacciService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class FibonacciController(
    private val fibonacciService: FibonacciService
) {

    @GetMapping("fibonacci")
    fun fibonacci(@RequestParam n: Int): ResponseEntity<Int> {

        if (n > 46 || n < 1) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val result = fibonacciService.fibonacci(n)
        return ResponseEntity.ok(result)
    }
}