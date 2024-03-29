import scala.io.StdIn.readLine

var board = Array.ofDim[Char](3,3)

def checkRowCol(c1: Char, c2: Char, c3: Char) : Boolean = {
    return ((c1 != 0) && (c1 == c2) && (c2 == c3))
}

def checkRows(board : Array[Array[Char]]) : Char = {
    for (i <- 0 until 3){
        if (checkRowCol(board(i)(0), board(i)(1), board(i)(2)) == true) {
                return board(i)(0)
        }
    }
    return ' '
}

def checkCols(board : Array[Array[Char]]) : Char = {
    for (i <- 0 until 3) {
        if (checkRowCol(board(0)(i), board(1)(i), board(2)(i)) == true) {
            return board(0)(i)
        }
    }
    return ' '
}

def checkDiagsRtoL(board : Array[Array[Char]]) : Char = {
    if (checkRowCol(board(0)(0), board(1)(1), board(2)(2)) == true) {
        return board(0)(0)
    }
    return ' '
}

def checkDiagsLtoR(board : Array[Array[Char]]) : Char = {
    if (checkRowCol(board(0)(2), board(1)(1), board(2)(0)) == true) {
        return board(0)(2)
    }
    return ' '
}

def isWinner(board : Array[Array[Char]]) : (Boolean, Char) = {
    var winState = false
    var winner = ' '
    var resultRows = checkRows(board)
    var resultCols = checkCols(board)
    var resultRtoL = checkDiagsRtoL(board)
    var resultLtoR = checkDiagsLtoR(board)
    if (resultCols != ' ' || resultRows != ' ' || resultRtoL != ' ' || resultLtoR != ' '){
        winState = true
    } else {
        winState = false
    }

    if (resultRows != ' ') winner = resultRows
    if (resultCols != ' ') winner = resultCols
    if (resultRtoL != ' ') winner = resultRtoL
    if (resultLtoR != ' ') winner = resultLtoR

    return (winState, winner)
}

def checkBoard(board : Array[Array[Char]]) : Boolean = {
    var result = isWinner(board)
    if(result._1){
        //println("We have a winner: " + result._2)
        return true
    } else {
        //println("No winner.")
        return false
    }
}

def boardTests() = {
    println("Running some test before you can play.")
    // Winner Tests
    // Row Test
    board = Array(Array('X','X','X'), Array(' ',' ',' '), Array(' ',' ',' '))
    assert(checkBoard(board) == true)

    // Column Test
    board = Array(Array('O','X','X'), Array('O',' ',' '), Array('O',' ',' '))
    assert(checkBoard(board) == true)

    // Diagonal Test left to right
    board = Array(Array('O','X','X'), Array(' ','O',' '), Array(' ',' ','O'))
    assert(checkBoard(board) == true)

    // Diagonal Test right to left
    board = Array(Array('O','O','X'), Array(' ','X',' '), Array('X',' ',' '))
    assert(checkBoard(board) == true)


    // No Winner Tests
    // Row Test
    board = Array(Array('O','X','X'), Array(' ',' ',' '), Array(' ',' ',' '))
    assert(checkBoard(board) == false)

    // Column Test
    board = Array(Array('O','X','X'), Array('X',' ',' '), Array('O',' ',' '))
    assert(checkBoard(board) == false)

    // Diagonal Test left to right
    board = Array(Array('X',' ','X'), Array(' ','O',' '), Array(' ',' ','O'))
    assert(checkBoard(board) == false)

    // Diagonal Test right to left
    board = Array(Array('O',' ','O'), Array(' ','X',' '), Array('X',' ',' '))
    assert(checkBoard(board) == false)
}


def coreGameLoop() = {
    var input = readLine()
//    while(true){
//        input = readInt("Whats do you want to do? ")
//    }
}

boardTests()
coreGameLoop()









