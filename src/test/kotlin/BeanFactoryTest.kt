import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.BeanFactory

const val BASE_PACKAGE = "ru.terekhov"
const val FIRST_BEAN_NAME = "sampleFirstBean"
const val SECOND_BEAN_NAME = "secondBeanName"

class BeanFactoryTest {

    @Test
    fun shouldFindAndInstantiateObjects() {
        val target = BeanFactory()

        target.instantiate(BASE_PACKAGE)
        assertEquals(2, target.singletons.size)
        assertNotNull(target.getBean(FIRST_BEAN_NAME))
        assertNotNull(target.getBean(SECOND_BEAN_NAME))
    }
}