arr = Array(1..16)
count = 0

#arr.each{ |a| if a % 4 == 3 puts "#{arr[(a%4) - 3]} #{arr[(a%4) - 2]} #{arr[(a%4) - 1]} #{arr[(a%4)]}"}

puts"arr.each"
arr.each do |a|
	if count % 4 == 3
		puts "#{arr[count - 3]} #{arr[count - 2]} #{arr[count - 1]} #{arr[count]}"
	end
	count += 1
end
puts "\narr.each_slice"
arr.each_slice(4) {|a| puts a.join(" ")}