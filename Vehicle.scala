class Vehicle extends VehicleDetails {
  println(model("Challenger"))
  println(year(2022))
  println(price(10000.0))


  def vType(): Unit = {
    var a = 1
    while(true) {
      println(a)
      a = a + 1
    }
  }

  def samp(): Boolean = {
    return false
  }
  def oddOrEve(input: Int): Boolean = {
    if (input % 2 == 0)
      return true
    else
      return false
  }
}
