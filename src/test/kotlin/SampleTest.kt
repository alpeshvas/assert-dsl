import com.alpesh.assertKt.Sample
import org.junit.jupiter.api.Test
import com.alpesh.assertKt.assert

internal class SampleTest {
    private val sample = Sample()
    @Test
    fun sum() {
        assert {
            equals(sample.sum(1, 2), 3)
            notEquals(sample.sum(1, 2), 4)
        }
    }
}
