Guess := Object clone do(
	rnd := Random value(100) floor
	input := 0
	try := 1
	result := false

	random := method(
		rnd println
	)

	number := method(
		"Guess a Number between 0 and 100" println
		"You have 10 tries!" println
		while(((result == false) and try <= 10),
			input := File standardInput readLine
			if(rnd == input asNumber) then(
				result = true
				"Congratulations!!!" println
				if(try == 1) then("After #{try} try" interpolate println) else( 
					"After #{try} tries" interpolate println
				)
			) else(
				try = try + 1
				if(rnd > input asNumber) then("Higher" println) else("Lower" println)
			)
		)
	)
)

g := Guess clone
g number
