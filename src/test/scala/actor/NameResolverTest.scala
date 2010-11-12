package actor

import org.junit.{Test, Assert}

@Test
class NameResolverTest{

  @Test
  def testNameResolver{
    NameResolver.start()
    NameResolver ! ("http://twitter.com", self)
    self.receiveWithin(100){case x => x}
  }

}

