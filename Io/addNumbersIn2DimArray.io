l := list(list(1,1,1), list (2,2,2), list(3,3,3), list(1), list(2), list(3)) 
sum := 0
l foreach(i,v, v foreach(j,w, sum = sum + w))

sum println

l := list(list(1,1,1), list (2,2,2), list(3,3,3), 1, 2, 3) 
l flatten sum println
