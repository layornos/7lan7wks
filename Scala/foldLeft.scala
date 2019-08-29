def countCharsInListOfStrings(inputList : List[String]): Int = {
    inputList.foldLeft(0) { (acc, i) => acc + i.length }
}

def main() = {
    val strings: List[String] = List("one", "two", "three", "four")    
    println(countCharsInListOfStrings(strings))
}

main()