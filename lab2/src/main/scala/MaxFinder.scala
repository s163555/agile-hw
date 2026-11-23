
import chisel3._
import chisel3.util._
import chisel3.stage._

/**
  * Find the maximum value in a Vec using treeReduce
  * @param n number of elements
  */
class MaxFinder(val n: Int, val width: Int) extends Module {
  val io = IO(new Bundle {
    val in = Input(Vec(n, UInt(width.W)))
    val out = Output(UInt(width.W))
  })

  io.out := io.in.reduceTree((a, b) => Mux(a > b, a, b))
}

object MaxFinderMain extends App {
  println(ChiselStage.emitVerilog(new MaxFinder(4,8)))
}