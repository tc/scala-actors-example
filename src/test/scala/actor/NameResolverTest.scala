package actor

import org.junit.{Test, Assert}
import scala.actors.Actor

@Test
class NameResolverTest{

  @Test
  def testNameResolver{
    NameResolver.start()
    NameResolver ! (("http://twitter.com", Actor.self))
    Actor.self.receiveWithin(100){case x => x}
  }

}

