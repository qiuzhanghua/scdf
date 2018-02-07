# Learn Spring Cloud Data Flow

## cloud-task-learning
use @EnableTask

### Use jdbc to watch task_execution

1. Lunch h2database

```bash
java -jar h2-1.4.196.jar
```

2. Run this spring boot app

3. Use browser to watch http://localhost:8082/

- &nbsp;&nbsp;&nbsp;Dirver Class:  org.h2.Driver
- &nbsp;&nbsp;&nbsp;JDBC URL:  &nbsp;&nbsp;jdbc:h2:~/app
- &nbsp;&nbsp;&nbsp;User Name: &nbsp;app
- &nbsp;&nbsp;&nbsp;Password:  &nbsp;app

4. Run SQL
```sql
SELECT * FROM TASK_EXECUTION
```
5. Fields of Table TASK_EXECUTION
- TASK_EXECUTION_ID
- START_TIME
- END_TIME
- TASK_NAME
- EXIT_CODE
- EXIT_MESSAGE
- ERROR_MESSAGE
- LAST_UPDATED
- EXTERNAL_EXECUTION_ID
- PARENT_EXECUTION_ID




## cloud-stream-learning

Generate String and send them to kafka

1. Start kafka

2. run 
```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic test
```
to listen to messages

3. run this spring boot app

### application.properties
```properties
spring.cloud.stream.bindings.output.destination=test
```
