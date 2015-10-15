
import scala.util.Random

/**
 * @author shivangi
 */
object snakeAndLadderBoard {
  var snakeList: List[Snake] = Nil
  var ladderList: List[Ladder] = Nil


  def createSnakeList(noOfSnakes: Int): List[Snake] = {
    for (x <- 1 to noOfSnakes) {
      val a, b = Random.nextInt(80)
      snakeList = snakeList ::: List(new Snake(new Location(math.max(a, b), math.min(a, b))))
    }
    for (snake <- snakeList) print(snake, "\n")
    snakeList
  }

  def createLadderList(noOfLadders: Int): List[Ladder] = {
    for (x <- 1 to noOfLadders) {
      var a, b = Random.nextInt(90)
      var snakeInA = cellHasSnake(a)
      var snakeInB = cellHasSnake(b)
      var ladderInA = cellHasLadder(a)
      var ladderInB = cellHasLadder(b)

      while (snakeInA != null || snakeInB != null || ladderInA != null || ladderInB != null) {
        a = Random.nextInt(99)
        b = Random.nextInt(99)
        snakeInA = cellHasSnake(a)
        snakeInB = cellHasSnake(b)
        ladderInA = cellHasLadder(a)
        ladderInB = cellHasLadder(b)
      }
      ladderList = ladderList ::: List(new Ladder(new Location(math.min(a, b), math.max(a, b))))
    }
    for (ladder <- ladderList) print(ladder, "\n")
    ladderList
  }

  def generateBoard(noOfSnakes: Int, noOfLadders: Int): (List[Snake], List[Ladder]) =
    (createSnakeList(noOfSnakes), createLadderList(noOfLadders))

  def cellHasSnake(number: Int): Snake = {
    for (snake <- this.snakeList if (snake.getPosition().getStart() == number))  snake
    null
  }


  def cellHasLadder(number: Int): Ladder = {
    for (ladder <- this.ladderList if (ladder.getLocation().getStart() == number))  ladder
    null
  }
}
