import chisel3._

class BCD(width: Int, digits: Int) extends Module {
    val io = IO(new Bundle {
        val din = Input(UInt(width.W))
        val dout = Output(UInt((digits * 4).W))
    })

    var bcd = 0.U(((digits * 4)).W)

    for (i <- 0 until width) {
        for (j <- (digits - 1) to 0 by -1) {
            val digit = bcd(j * 4 + 3, j * 4)
            bcd = Mux(digit > 4.U, bcd + (3.U << (j * 4)), bcd)
        }
        bcd = (bcd << 1) | io.din(width - 1 - i)
    }
    io.dout := bcd
}