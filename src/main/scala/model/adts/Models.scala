package model.adts

abstract class Item(val name: String, val price: BigDecimal)

case object Soup extends Item("Soup", 0.65)
case object Bread extends Item("Bread", 0.80)
case object Milk extends Item("Milk", 1.30)
case object Apples extends Item("Apples", 1.00)

object Items {
  val values = List(Soup, Bread, Milk, Apples)
}