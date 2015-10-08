

/**
 * @author shivangi
 */

object Main extends App {
	val g = new Game(4).startGame()
}

class Game(noOfPlayers:Int){
	def gameIsOver(playerList: List[Player]):Boolean={
			for (player <- playerList if (player.hasWon() )) return true
					false
	}

	def startGame()={
		var (playerList,snakeList,ladderList)=snakeAndLadderBoard.generateBoard(noOfPlayers)       
				while(!gameIsOver(playerList)){
					for (player <-playerList if !gameIsOver(playerList)){
						var currentNumber = player.rollDice()
								println(player +" rolled "+currentNumber)
								play(player,currentNumber)
								while (!gameIsOver(playerList) && player.hasAnotherChance(currentNumber)&& player.canPlay(currentNumber)){
									currentNumber = player.rollDice()
											println(player +" has another chance and has rolled "+currentNumber)
											play(player,currentNumber)
								}
					}       
				}
		for (player <- playerList if (player.hasWon() )) println("Game Over and winner is "+player)
	}

	private def play(player:Player, currentNumber:Int)={
		if(player.canPlay(currentNumber)){       
			player.isReady()
			if(player.canMove(currentNumber))  player.updatePosition(currentNumber)
			println (player +" has rolled "+ currentNumber+" and the current position is "+player.getPosition)

			var snake = snakeAndLadderBoard.cellHasSnake(player.getPosition)
			if(snake!= null) snake.slideDownOnSnake(player)

			var ladder= snakeAndLadderBoard.cellHasLadder(player.getPosition) 
			if (ladder != null) ladder.moveUpLadder(player)
		}
	}
}