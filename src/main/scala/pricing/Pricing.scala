package pricing

import model.adts.Item
import offers.{ApplesDiscount, Offer, SoupBreadDiscount}

import scala.collection.immutable

object BasketPricing {
  def calculateSubtotal(basket: List[Item]): BigDecimal = basket.map(_.price).sum

  def calculateOffers(basket: List[Item]): Seq[(Offer, BigDecimal)] = {
    val availableOffers = List(ApplesDiscount, SoupBreadDiscount)
    val offersWithDiscount: immutable.Seq[(Offer, BigDecimal)] =availableOffers.flatMap(offer => {
      val disc = offer.discount(basket)
      if (disc != 0) Some((offer, disc)) else None
    })
    offersWithDiscount
  }

  def calculateTotal(subtotal: BigDecimal, offers: List[(Offer, BigDecimal)]): BigDecimal = {
    subtotal + offers.map(_._2).sum
  }
}