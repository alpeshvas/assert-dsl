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
# How to use?
## Gradle
Add the following repo url in repositories
```
    maven{
        url = uri("https://maven.pkg.github.com/alpeshvas/assert-dsl")
    }
```
Add relevant dependency

```
    testImplementation("com.alpesh.assertKt:assert-dsl:0.1-SNAPSHOT")
```
**Note**: Replace with the latest version

## Maven
```aidl
    <dependency>
        <groupId>com.alpesh.assertKt</groupId>
        <artifactId>assert-dsl</artifactId>
        <version>0.1-SNAPSHOT</version>
    </dependency>
```