myif := method(
    (call sender doMessage(call message argAt(0))) ifTrue( 
    call sender doMessage(call message argAt(1))) ifFalse( 
    call sender doMessage(call message argAt(2)))
)

myif(1 == 1, write("true\n"), write("false\n"))
