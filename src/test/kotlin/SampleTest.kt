import com.alpesh.assertKt.Sample
import com.alpesh.assertKt.assert
import org.junit.jupiter.api.Test

internal class SampleTest {
    private val sample = Sample()
    @Test
    fun sum() {
        assert {
            equals(sample.sum(1, 2), 3)
            notEquals(sample.sum(1, 2), 4)
        }
    }

    @Test
    fun sumWithMultiChecks() {
        assert {
            equals {
                check(sample.sum(1, 2), 3)
                check(sample.sum(1, 4), 5)
                check(sample.sum(2, 2), 4)
            }
            notEquals {
                check(sample.sum(1, 2), 4)
                check(sample.sum(1, 3), 5)
                check(sample.sum(1, 4), 6)
                check(sample.sum(2, 2), 5)
            }
        }
    }
}
