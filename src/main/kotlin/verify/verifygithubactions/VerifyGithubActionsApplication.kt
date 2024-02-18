package verify.verifygithubactions

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VerifyGithubActionsApplication

fun main(args: Array<String>) {
    runApplication<VerifyGithubActionsApplication>(*args)
}
