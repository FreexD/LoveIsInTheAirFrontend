package pl.mwolny.love.frontend

/**
  * Created by mw on 05/04/17.
  */

import scala.scalajs.js.{JSApp}
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.jquery.jQuery
import fr.hmil.roshttp.HttpRequest
import monix.execution.Scheduler.Implicits.global
import fr.hmil.roshttp.Method.POST
import fr.hmil.roshttp.Method.DELETE
import fr.hmil.roshttp.Protocol.HTTP

object FrontendApp extends JSApp {
  def main(): Unit = {
    jQuery(() => setupUI())
  }

  def setupUI(): Unit = {
    jQuery("#addCreatureButton").click(() => addCreature())
    jQuery("#killAllCreaturesButton").click(() => killAllCreatures())
  }

  @JSExportTopLevel("addCreature")
  def addCreature(): Unit = {
    HttpRequest()
        .withProtocol(HTTP)
        .withHost("localhost")
        .withPort(9000)
        .withPath("/creature")
        .withMethod(POST)
        .send()
  }

  @JSExportTopLevel("killAllCreatures")
  def killAllCreatures(): Unit = {
    HttpRequest()
      .withProtocol(HTTP)
      .withHost("localhost")
      .withPort(9000)
      .withPath("/creature")
      .withMethod(DELETE)
      .send()
  }
}
