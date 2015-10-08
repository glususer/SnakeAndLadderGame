 
/**
 * @author shivangi
 */
class Player(name:String, var pos:Int){
	var ready=false
			def getPosition:Int = this.pos
			def rollDice():Int= Dice.roll()
			def getName():String=this.name
			def isReady()= {
				this.ready=true     
			}
			def hasWon():Boolean=if (this.pos == 100) true else false
					def canMove(number:Int)=if (100-this.pos >= number ) true else false
					def canBeginGame(number:Int):Boolean=if(Rules.canBeginGame(number)) true else false
					def updatePosition(number:Int)=pos = getPosition+number
					def hasAnotherChance(number:Int):Boolean= if(number == 6) true else false
					def canPlay(number:Int):Boolean= (canBeginGame(number)|| ready)&&(this.getPosition <=100)
					override def toString():String="player: "+getName()+" on position "+getPosition
}