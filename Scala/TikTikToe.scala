var board = Array.ofDim[Int](3,3)

def checkRowCol(c1: Int, c2: Int, c3: Int) : Boolean = {
    return ((c1 != 0) && (c1 == c2) && (c2 == c3))
}

def checkRows(board : Array[Array[Int]]) : Boolean = {
    for (i <- 0 until 3){
        if (checkRowCol(board(i)(0), board(i)(1), board(i)(2)) == true) {
                return true
        }
    }
    return false
}

def checkCols(board : Array[Array[Int]]) : Boolean = {
    for (i <- 0 until 3) {
        if (checkRowCol(board(0)(i), board(1)(i), board(2)(i)) == true) {
            return true
        }
    }
    return false
}

def checkDiags(board : Array[Array[Int]]) : Boolean = {
    return ((checkRowCol(board(0)(0), board(1)(1), board(2)(2)) == true) || (checkRowCol(board(0)(2), board(1)(1), board(2)(0)) == true))
}

def checkBoard(board : Array[Array[Int]]) : Boolean = {
    return checkRows(board) || checkCols(board) || checkDiags(board)
}

board = Array(Array(1,1,1), Array(0,0,0), Array(0,0,0))
checkBoard(board)

board = Array(Array(2,1,1), Array(2,0,0), Array(2,0,0))
checkBoard(board)

board = Array(Array(2,1,1), Array(0,2,0), Array(0,0,2))
checkBoard(board)

board = Array(Array(1,1,2), Array(0,2,0), Array(2,0,0))
checkBoard(board)
