package assignment1

class Group[T] {
  private var contents = List[T]()

  def add(x: T): Unit = {
    if (!has(x)) {
      contents = x :: contents 
    }
  }

  def delete(x: T): Unit = {
    contents = contents.filterNot(_ == x) 
  }

  def has(x: T): Boolean = {
    contents.contains(x) 
  }
}

object Group {
  def from[T](xs: Iterable[T]): Group[T] = {
    val result = new Group[T]
    for (x <- xs) {
      result.add(x) 
    }
    result
  }
}

@main def test() = {
  val group = Group.from(List(10, 20))
  println(group.has(10))
  // → true
  println(group.has(30))
  // → false
  group.add(10)
  group.delete(10)
  println(group.has(10))
  // → false
}
