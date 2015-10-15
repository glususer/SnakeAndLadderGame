import java.lang.reflect.Array

/**
 * @author shivangi
 */

object Main extends App() {
  if (args.length != 3)
    throw new IllegalArgumentException("please pass required number of arguments in the form no of players, no of snakes, no of ladders");
  val g = new Game(args(0).toInt, args(1).toInt, args(2).toInt).startGame()
}

class Game(noOfPlayers: Int, noOfSnakes: Int, noOfLadders: Int) {
  def startGame() = {
    snakeAndLadderBoard.generateBoard(noOfSnakes, noOfPlayers)
    val playerList = createPlayerList(noOfPlayers)
    while (!gameIsOver(playerList)) {
      for (player <- playerList if !gameIsOver(playerList)) {
        var currentNumber = player.rollDice()
        println(player + " rolled " + currentNumber)
        play(player, currentNumber)
        while (!gameIsOver(playerList) && player.hasAnotherChance(currentNumber) && player.canPlay(currentNumber)) {
          currentNumber = player.rollDice()
          println(player + " has another chance and has rolled " + currentNumber)
          play(player, currentNumber)
        }
      }
    }
    for (player <- playerList if (player.hasWon())) println("Game Over and winner is " + player)
  }

  def createPlayerList(noOfPlayers: Int): List[Player] = {
    var playerList: List[Player] = Nil
    for (x <- 1 to noOfPlayers) playerList = playerList ::: List(new Player(x.toString))
    playerList
  }

  def moveUpLadder(ladder: Ladder, player: Player) = {
    player.loc = ladder.getLocation().getEnd()
  }

  def slideDownOnSnake(snake: Snake, player: Player) = {
    player.loc = snake.getLocation().getEnd()
  }

  def gameIsOver(playerList: List[Player]): Boolean = {
    playerList.exists(_.hasWon())
  }

  private def play(player: Player, currentNumber: Int) = {
    if (player.canPlay(currentNumber)) {
      player.getReady()
      if (player.canMove(currentNumber)) player.updatePosition(currentNumber)
      println(player + " has rolled " + currentNumber + " and the current position is " + player.getLocation)

      val snake = snakeAndLadderBoard.cellHasSnake(player.getLocation)
      snake match {
        case Some(snake)=>slideDownOnSnake (snake, player)
        case None=>
      }

      val ladder = snakeAndLadderBoard.cellHasLadder(player.getLocation)
      ladder match{
        case Some(ladder)=>moveUpLadder(ladder, player)
        case None=>
      }
    }

  }
}

