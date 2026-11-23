import chisel3._
import chiseltest._
import chisel3.util._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.util.Random

class MaxFinderTest extends AnyFlatSpec with ChiselScalatestTester with Matchers {
  "MaxFinder" should "find the maximum value in a Vec" in {
    test(new MaxFinder(4, 8)) { dut =>
      // All zeros
      dut.io.in.poke(Vec.Lit(Seq(0.U, 0.U, 0.U, 0.U)))
      dut.io.out.expect(0.U)

      // All equal values
      dut.io.in.poke(Vec.Lit(Seq(10.U, 10.U, 10.U, 10.U)))
      dut.io.out.expect(10.U)

      // Maximum at boundaries
      dut.io.in.poke(Vec.Lit(Seq(100.U, 10.U, 20.U, 30.U)))
      dut.io.out.expect(100.U)

      dut.io.in.poke(Vec.Lit(Seq(10.U, 20.U, 30.U, 255.U)))
      dut.io.out.expect(255.U)
    }
  }

  "MaxFinder" should "correctly find maximum across random input vectors" in {
    test(new MaxFinder(4, 8)) { dut =>
      val r = new Random(1337)
      for(_ <- 0 until 100) {
        val values = Seq.fill(4)(r.nextInt(256))
        val expectedMax = values.max

        dut.io.in.poke(V(values.map(_.U)))
        dut.io.out.expect(expectedMax.U)
      }
    }
  }
}
