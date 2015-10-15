

/**
 * @author shivangi
 */
class Snake(loc: Location) {

  def getPosition(): Location = loc

  override def toString(): String = "location of snake : " + getPosition()
}