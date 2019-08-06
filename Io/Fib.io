fib := method(f,
    if(f<= 2, return 1)
    return fib(f-1)+fib(f-2)
    )
fib(25) println

