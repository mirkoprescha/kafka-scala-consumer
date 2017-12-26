import org.scalatest.FunSuite

class EventConsumerTest() extends FunSuite{
     test("test") {
       new EventConsumer().start()
      assert (1==1)
    }

}