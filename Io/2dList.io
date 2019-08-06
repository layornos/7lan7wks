Matix := Object clone do(
	xLength := nil
	yLength := nil
	lists := list()
	dim := method(x, y,
		xLength = (x-1)
		yLength = (y-1)
		for(i, 0, yLength,
			self lists append(list())
			for(j, 0, xLength,
					self lists at(i) append(0)
				)
			)
	)

	set := method(x, y, value,
		self lists at(y) atPut(x, value)		
	)

	get := method(x, y,
		self lists at(y) at(x)
	)

	transpose := method(
		tmpL := list()
		for(i, 0, yLength,
			tmpL append(list())
			for(j, 0, xLength,
					tmpL at(i) append(0)
				)
			)
		self lists foreach(i, v,
				v foreach(j, w,
					tmpL at(i) atPut(j, w)
				)
			)
		self lists reverseForeach(i, v,
				v reverseForeach(j, w,
					tmpL at(xLength - i) atPut(yLength - j, w)
				)
			)
		lists = tmpL
	)

	write := method(
			f := File with("matrix.txt")
			f remove
			f openForUpdating
			self lists foreach(i,v,
					v foreach(j,w,
							f write(w asString, " ")
						)
					f write("\n")
				)
			f close
		)

	read := method(name,
		self lists = list()
		f := File with(name)
		f openForReading
		f foreachLine(i,v,
			yLength = i
			lists append(list())
			v foreach(j, w,
				if((w asCharacter asNumber) >= 0, lists at(i) append(w asCharacter asNumber))
			)
		)
		f close
		yLength = ((lists size) - 1)
		xLength = ((lists at(lists size - 1) size) - 1)
	)
)

l := Matix clone
l read("matrix.txt")
l transpose()
l write