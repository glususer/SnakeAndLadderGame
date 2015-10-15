

/**
 * @author shivangi
 */
object Rules {

  def canBeginGame(number: Int): Boolean = (number == 1)

  def hasAnotherChance(number: Int): Boolean = (number == 6)

  def hasWon(player: Player): Boolean = (player.getLocation == 100)

}