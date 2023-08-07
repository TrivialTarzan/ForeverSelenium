<h1 align="center">ForeverSelenium</h1>
<h2 align="center">Selenium/Gherkin/Cucumber/JUnit/Maven</h2>


## Directory Tree

  - src
    - Cucumber
      - Features
    - test
      - java
        - MyStore
          - Scenarios 
          - Screenshots
          - WebDriverHooks
          ... and the objects representing website pages
        - RunTest.java

##

| File | Description |
| ------ | ------ |
| scr/Cucumber/Features/ | Contains all the test scenarios |
| src/test/MyStore/Scenarios| ... |
| src/test/MyStore/Screenshots| ... |
| src/test/MyStore/WebDriverHooks| ... |

## Tests execution

Each sceanrio has its own fixture.

Tu run singular scenario, use the following fixtures:
```java
@add-and-delete-address

or

@successful-purchase
```

To run all the scenarios:
```java
@my-store
```

To run a specific scenario, you need to change the value of the 'tags' component in the @CucumberOptions annotation, in the ```src/test/java/RunTest.java```:

```java
@CucumberOptions(
        features = "src/Cucumber/Features/",
        plugin = {"pretty","html:out"},
        tags = "@add-and-delete-address"
)
```
