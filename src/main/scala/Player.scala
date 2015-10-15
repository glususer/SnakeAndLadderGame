
/**
 * @author shivangi
 */
class Player(name: String, var loc: Int) {
  var isReady = false

  def getLocation: Int = this.loc

  def rollDice(): Int = Dice.roll()

  def getName(): String = this.name

  def getReady() = {
    this.isReady = true
  }

  def hasWon(): Boolean = if (this.loc == 100) true else false

  def canMove(number: Int) = if (100 - this.loc >= number) true else false

  def canBeginGame(number: Int): Boolean = if (Rules.canBeginGame(number)) true else false

  def updatePosition(number: Int) = loc = getLocation + number

  def hasAnotherChance(number: Int): Boolean = if (number == 6) true else false

  def canPlay(number: Int): Boolean = (canBeginGame(number) || isReady) && (this.getLocation <= 100)

  override def toString(): String = "player: " + getName() + " on position " + getLocation
}