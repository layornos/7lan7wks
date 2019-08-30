def countCharsInListOfStrings(inputList : List[String]): Int = {
    inputList.foldRight(0) { (i, acc) =>  acc + i.length }
}

def main() = {
    val strings: List[String] = List("one", "two", "three", "four")    
    println(countCharsInListOfStrings(strings))
}

main()