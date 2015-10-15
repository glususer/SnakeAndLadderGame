
import scala.util.Random

/**
 * @author shivangi
 */
object snakeAndLadderBoard {
  var snakeList: List[Snake] = Nil
  var ladderList: List[Ladder] = Nil


  def createSnakeList(noOfSnakes: Int): List[Snake] = {
    for (x <- 1 to noOfSnakes) {
      val a, b = Random.nextInt(80) +1
      snakeList = snakeList ::: List(new Snake(new Location(math.max(a, b), math.min(a, b))))
    }
    for (snake <- snakeList) print(snake, "\n")
    snakeList
  }

  def createLadderList(noOfLadders: Int): List[Ladder] = {
    for (x <- 1 to noOfLadders) {
      var a, b = Random.nextInt(90)
      var snakeInA = Some(cellHasSnake(a))
      var snakeInB = Some(cellHasSnake(b))
      var ladderInA = Some(cellHasLadder(a))
      var ladderInB = Some(cellHasLadder(b))

      while (!(snakeInA.isDefined || snakeInB.isDefined || ladderInA.isDefined|| ladderInB.isDefined)) {
        a = Random.nextInt(90) +1
        b = Random.nextInt(90)+1
        snakeInA = Some(cellHasSnake(a))
        snakeInB = Some(cellHasSnake(b))
        ladderInA = Some(cellHasLadder(a))
        ladderInB = Some(cellHasLadder(b))
      }
      ladderList = ladderList ::: List(new Ladder(new Location(math.min(a, b), math.max(a, b))))
    }
    for (ladder <- ladderList) print(ladder, "\n")
    ladderList
  }

  def generateBoard(noOfSnakes: Int, noOfLadders: Int): (List[Snake], List[Ladder]) =
    (createSnakeList(noOfSnakes), createLadderList(noOfLadders))

  def cellHasSnake(number: Int): Option[Snake] = {
    snakeList.find(_.getLocation().getStart()==number)
  }


  def cellHasLadder(number: Int): Option[Ladder] = {
    ladderList.find(_.getLocation().getStart()==number)
  }
}
