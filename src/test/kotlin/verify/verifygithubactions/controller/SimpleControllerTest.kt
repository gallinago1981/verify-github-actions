package verify.verifygithubactions.controller

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleControllerTest {

    @LocalServerPort
    private val port: Int = 0

    @BeforeEach
    fun beforeEach() {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = port
    }

    @DisplayName("正常系")
    @Nested
    inner class SuccessTest {
        @Test
        fun 正常() {
            Given {
                contentType(ContentType.JSON)
                params("message", "junit")
            } When {
                get("hello-world")
            } Then {
                statusCode(200)
                body("message", Matchers.equalTo("hello world. junit"))
            }
        }
    }

    @DisplayName("異常系")
    @Nested
    inner class FailedTest {
        @Test
        fun 必須チェック() {
            Given {
                contentType(ContentType.JSON)
            } When {
                get("hello-world")
            } Then {
                statusCode(400)
            }
        }
    }
}