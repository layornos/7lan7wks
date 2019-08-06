if RUBY_VERSION =~ /2.3/ # assuming you're running Ruby ~1.9
  Encoding.default_external = Encoding::UTF_8
  Encoding.default_internal = Encoding::UTF_8
end

filename = "example.txt"
text = File.open(filename).read
linenumber = 1

text.each_line do |line|
	if line =~ /ü(.*)ö(.*)(ä.*)/
		puts linenumber.to_s + ": " + line
	end
	linenumber += 1
end