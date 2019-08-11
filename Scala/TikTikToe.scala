var board = Array.ofDim[Char](3,3)

def checkRowCol(c1: Char, c2: Char, c3: Char) : Boolean = {
    return ((c1 != 0) && (c1 == c2) && (c2 == c3))
}

def checkRows(board : Array[Array[Char]]) : Boolean = {
    for (i <- 0 until 3){
        if (checkRowCol(board(i)(0), board(i)(1), board(i)(2)) == true) {
                return true
        }
    }
    return false
}

def checkCols(board : Array[Array[Char]]) : Boolean = {
    for (i <- 0 until 3) {
        if (checkRowCol(board(0)(i), board(1)(i), board(2)(i)) == true) {
            return true
        }
    }
    return false
}

def checkDiags(board : Array[Array[Char]]) : Boolean = {
    return ((checkRowCol(board(0)(0), board(1)(1), board(2)(2)) == true) || (checkRowCol(board(0)(2), board(1)(1), board(2)(0)) == true))
}

def checkBoard(board : Array[Array[Char]]) : Boolean = {
    return checkRows(board) || checkCols(board) || checkDiags(board)
}

// Row Test
board = Array(Array('X','X','X'), Array(' ',' ',' '), Array(' ',' ',' '))
println(checkBoard(board))

// Column Test
board = Array(Array('O','X','X'), Array('O',' ',' '), Array('O',' ',' '))
println(checkBoard(board))

// Diagonal Test left to right
board = Array(Array('O','X','X'), Array(' ','O',' '), Array(' ',' ','O'))
println(checkBoard(board))

// Diagonal Test right to left
board = Array(Array('O','O','X'), Array(' ','X',' '), Array('X',' ',' '))
println(checkBoard(board))
