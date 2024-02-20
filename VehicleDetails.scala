class VehicleDetails {

  def model(model: String): String = {
    model
  }

  def year(year: Int): Int = {
    year
  }

  def price(price: Double) : Long = {
    val i = price.round
    i
  }

}
