
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer._

import scala.util.Properties
import scala.collection.JavaConverters._

import java.util

class EventConsumer extends LazyLogging{

  def start(): Unit = {
    import java.util.Properties
    val topic = "test"
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")

    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    props.put("group.id", "kakfa-scala-consumer")

    val consumer = new KafkaConsumer[String,String](props)

    consumer.subscribe(util.Collections.singletonList(topic))
    while(true){
      val records: ConsumerRecords[String, String] =consumer.poll(100)
      for (record<-records.asScala){
        println(record)
      }
    }
  }
}