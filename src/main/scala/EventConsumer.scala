
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer._
import java.util.Properties
import scala.collection.JavaConverters._
import java.util

case class KafkaConfig(kafkaConsumerConfig: KafkaConsumerConfigDetails)
case class KafkaConsumerConfigDetails(
                                       bootstrapServers: List[String],
                                       groupId: String,
                                       topic: String,
                                       keyDeserializer: String,
                                       valueDeserializer: String,
                                       pollTimeout: Long
                                     )

object EventConsumer extends LazyLogging{

  val KafkaConsumerConfig = pureconfig.loadConfigOrThrow[KafkaConfig].kafkaConsumerConfig

  private def properties(): Properties = {
    logger.info ("Read configuration for kafka-consumer")

    logger.info (s"kafka-consumer-config is ${KafkaConsumerConfig}")

    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConsumerConfig.bootstrapServers.mkString(","))
    props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConsumerConfig.groupId)
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaConsumerConfig.keyDeserializer)
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaConsumerConfig.valueDeserializer)
    logger.info ("kafka-consumer-properties: " + props)
    props
  }

  def start(): Unit = {

    val topic = KafkaConsumerConfig.topic

    val consumer = new KafkaConsumer[String,String](EventConsumer.properties())
    logger.info (s"subscribe consumer to topic $topic")

    consumer.subscribe(util.Collections.singletonList(topic))
    while(true){
      val records: ConsumerRecords[String, String] =consumer.poll(KafkaConsumerConfig.pollTimeout)
      for (record<-records.asScala){
        println(record)
      }
    }
  }
}