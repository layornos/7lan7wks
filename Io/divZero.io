div := Number getSlot("/")

Number / := method(i, if(i != 0, self div(i), 0))

1 / 0 println