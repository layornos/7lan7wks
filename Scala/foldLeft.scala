val inputList: List[String] = List("one", "two", "three", "four")

println(inputList.foldLeft(0) { (acc, i) => acc + i.length })
