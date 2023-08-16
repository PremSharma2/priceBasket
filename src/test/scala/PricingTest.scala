
import model.adts.{Apples, Bread, Milk, Soup}
import org.scalatest.{FlatSpec, Matchers}
import pricing.BasketPricing.{calculateOffers, calculateSubtotal, calculateTotal}

class PricingTest extends FlatSpec with Matchers{

  it should "calculate subtotal correctly" in {
    val basket = List(Apples, Milk, Bread)
    calculateSubtotal(basket) shouldEqual 3.10
  }

  it should "calculate offers correctly" in {
    val basket1 = List(Apples, Apples, Soup, Soup, Bread)
    val offers1 = calculateOffers(basket1).map(_._2)
    offers1 should contain (-0.10)
    offers1 should contain (-0.40)

    val basket2 = List(Milk)
    val offers2 = calculateOffers(basket2)
    offers2 shouldBe empty
  }

  it should "calculate total correctly" in {
    val basket = List(Apples, Milk, Bread)
    val subtotal = calculateSubtotal(basket)
    val offers = calculateOffers(basket)
    calculateTotal(subtotal, offers) shouldEqual 3.00
  }

}
