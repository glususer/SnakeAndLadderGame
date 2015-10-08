

/**
 * @author shivangi
 */
object Rules {
	def canBeginGame(number:Int):Boolean=if(number == 1) true else false
			def hasAnotherChance(number:Int):Boolean= if(number == 6) true else false
			def hasWon(player:Player):Boolean= if(player.getPosition== 100) true else false

}