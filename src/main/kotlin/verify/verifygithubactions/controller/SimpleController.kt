package verify.verifygithubactions.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SimpleController {

    @RequestMapping(
        value = ["/hello-world"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun helloWorld(@RequestParam(value="message") message: String): ResponseEntity<Response> {
        return ResponseEntity.ok(Response("hello world. $message"))
    }

    data class Response(val message: String)
}