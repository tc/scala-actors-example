package actor

import scala.actors.Actor
import scala.actors.Actor._

object NameResolver extends Actor { 
  import java.net.{InetAddress, UnknownHostException}
  def act() { 
    react {
    case (name: String, actor: Actor) => 
      actor ! getIp(name)
      act()
    case "EXIT" => 
      println("Name resolver exiting.") // quit
    case msg => 
      println("Unhandled message: "+ msg) 
      act()
    }
  }
  def getIp(name: String): Option[InetAddress] = {
    try{
      Some(InetAddress.getByName(name)) 
    }catch {
      case _:UnknownHostException => None
    }
  }
}

