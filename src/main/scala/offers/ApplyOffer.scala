package offers
//strategy design pattern
import model.adts.{Apples, Bread, Item, Soup}

trait Offer {
  def description: String

  def discount(basket: List[Item]): BigDecimal
}

object ApplesDiscount extends Offer {
  override val description = "Apples 10% off"

  override def discount(basket: List[Item]): BigDecimal = {
    val appleCount = basket.count(_ == Apples)
    appleCount * Apples.price * 0.10 * -1
  }
}

object SoupBreadDiscount extends Offer {
  override val description = "Bread half price (with 2 tins of Soup)"

  override def discount(basket: List[Item]): BigDecimal = {
    if (basket.count(_ == Soup) >= 2 && basket.contains(Bread))
      Bread.price * 0.50 * -1
    else
      0
  }

}





