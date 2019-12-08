package bomber.controllers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.bind.MissingServletRequestParameterException

@AutoConfigureMockMvc
@WebMvcTest
internal class JsonScriptControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @WithMockUser(username = "test", password = "test", roles = ["USER"])
    fun testGet() {
        val perform = mockMvc.perform(
            MockMvcRequestBuilders.get("/jsonScript")
        ).andReturn()

        assertEquals(MissingServletRequestParameterException::class, perform.resolvedException::class)
    }
}