package scalashop

import scalashop.HorizontalBoxBlurRunner.standardConfig

import java.util.concurrent.*
import scala.collection.*

class BlurSuite extends munit.FunSuite {


  test("3x3") {
    val radius = 1
    val width = 2
    val height = 2
    val src = Img(width, height)
    val dst = Img(width, height)

    HorizontalBoxBlur.blur(src, dst, 0, height, radius)
  }


  test("32x64 parallel") {
    val radius = 1
    val width = 32
    val height = 64
    val src = Img(width, height)
    val dst = Img(width, height)

    VerticalBoxBlur.parBlur(src, dst, 32, radius)
  }

  test("parVertical100x100") {
    val radius = 3
    val width = 100
    val height = 100
    val src = Img(width, height)
    val dst = Img(width, height)

    VerticalBoxBlur.parBlur(src, dst, 32, radius)
  }
}
