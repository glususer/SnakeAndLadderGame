

/**
 * @author shivangi
 */
class Snake(loc: Location) {

  def getLocation(): Location = loc

  override def toString(): String = "location of snake : " + getLocation()
}