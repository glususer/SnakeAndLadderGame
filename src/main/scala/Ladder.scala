

/**
 * @author shivangi
 */
class Ladder(pos:Position){
	def getPosition():Position=this.pos
			def moveUpLadder(player:Player)={
		player.pos = getPosition().getEnd()
	}
	override def toString():String="position of ladder : "+getPosition()
}