

/**
 * @author shivangi
 */
class Snake(pos:Position){
	def getPosition():Position= this.pos
			def slideDownOnSnake(player:Player)={
		player.pos = getPosition().getEnd()
	}
	override def toString():String="position of snake : "+getPosition()
}