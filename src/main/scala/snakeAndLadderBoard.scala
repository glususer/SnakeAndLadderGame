
import  scala.util.Random

/**
 * @author shivangi
 */
object snakeAndLadderBoard{

	val noOfPlayers:Int = 4
			var playerList:List[Player] = Nil
			var snakeList:List[Snake] = Nil
			var ladderList:List[Ladder] = Nil

			def createPlayerList(noOfPlayers:Int):List[Player]={
		var playerList:List[Player] = Nil
				for (x <- 1 to noOfPlayers) playerList = playerList:::List( new Player(x.toString,0))   
				this.playerList = playerList
				playerList
}

def createSnakeList():List[Snake]={
		var snakeList:List[Snake] = Nil
				for (x <- 1 to 5){
					var a, b = Random.nextInt(99)
							snakeList = snakeList:::List( new Snake(new Position(math.max(a,b), math.min(a,b))))
				}
this.snakeList = snakeList
for (snake <- snakeList) print (snake.toString(),"\n")
snakeList
}

def createLadderList():List[Ladder]={
		var ladderList:List[Ladder] = Nil
				for (x <- 1 to 5){
					var a, b = Random.nextInt(99)
							var snakeinA = cellHasSnake(a)
							var snakeinB = cellHasSnake(b)
							var ladderinA=cellHasLadder(a)
							var ladderinB = cellHasLadder(b)

							while( snakeinA != null || snakeinB != null ||ladderinA != null|| ladderinB != null){
								a= Random.nextInt(99)
										b = Random.nextInt(99)
										snakeinA = cellHasSnake(a)
										snakeinB = cellHasSnake(b)
										ladderinA=cellHasLadder(a)
										ladderinB = cellHasLadder(b)
							}
					ladderList = ladderList:::List( new Ladder(new Position(math.min(a,b), math.max(a,b))))
				}
this.ladderList = ladderList
for (ladder <- ladderList) print (ladder.toString(),"\n")
ladderList
}

def generateBoard(noOfPlayers:Int):(List[Player],List[Snake], List[Ladder])= (createPlayerList(noOfPlayers), createSnakeList(), createLadderList())

def cellHasSnake(number:Int):Snake={
	for (snake <- this.snakeList if (snake.getPosition().getStart()== number)) return snake
			null
}


def cellHasLadder(number:Int):Ladder={
	for (ladder <- this.ladderList if (ladder.getPosition().getStart()== number))return ladder
			null
}
}
