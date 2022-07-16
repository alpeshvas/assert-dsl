# assert-dsl
Simple dsl implementation for Junit 5 assertions.
TODO: To add more complex examples before v1.0 release
```
    @Test
    fun sum() {
        assert {
            equals(sample.sum(1, 2), 3)
            notEquals(sample.sum(1, 2), 4)
        }
    }
```
