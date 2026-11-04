object Exercises {
  val pi = 3.14159
  var counter = 0
  counter += 1

  // 1. Double Elements
  def doubleElements(lst: List[Int]): List[Int] = {
    lst.map(_ * 2)
  }

  // 2. Filter Odd Numbers
  def filterOddNumbers(lst: List[Int]): List[Int] = {
    lst.filter(_ % 2 == 0)
  }

  // 3. Higher-Order Function
  def applyFunction[A, B](f: A => B, lst: List[A]): List[B] = {
    lst.map(f)
  }
}
