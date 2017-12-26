
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer._

import scala.util.Properties

class EventConsumer extends LazyLogging{

  val topic = "test"
  val props = Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

  props.put("group.id", "kakfa-scala-consumer")

  val consumer = new EventConsumer()
  props.put ()
}