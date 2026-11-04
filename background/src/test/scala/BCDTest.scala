import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class BCDTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior.of("BCD")

  it should "convert 4-bit binary to 1-digit BCD" in {
    test(new BCD(width = 4, digits = 1)) { c =>
      c.io.din.poke(0.U); c.io.dout.expect(0.U)
      c.io.din.poke(5.U); c.io.dout.expect(5.U)
      c.io.din.poke(9.U); c.io.dout.expect(9.U)
    }
  }

  it should "convert 8-bit binary to 2-digit BCD" in {
    test(new BCD(width = 8, digits = 2)) { c =>
      c.io.din.poke(0.U); c.io.dout.expect(0.U)
      c.io.din.poke(9.U); c.io.dout.expect(9.U)
      c.io.din.poke(10.U); c.io.dout.expect(16.U) // BCD 10 (0x10)
      c.io.din.poke(15.U); c.io.dout.expect(21.U) // BCD 15 (0x15)
    }
  }
}