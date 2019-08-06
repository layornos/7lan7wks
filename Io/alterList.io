List avg := method(
	sum := 0 
	self foreach(i,v, if(v type == "Number", sum = sum + v, Exception raise("#{v} is not a Number" interpolate))) 
	(sum / self size)
)

list(5) avg println
list(1,2,3) avg println
list(15, 50, 105, 1000, 5000) avg println
list(1, "2", 3) avg println
