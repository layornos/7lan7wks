module ToFile
	def filename
		"object_#{self.object_id}.txt"
	end

	def to_f
		File.open(filename, 'w') { |file|  file.write(to_s)}
	end
end

module ToText
	def print_name
		"#{self.name}"
	end

	def to_s
		print_name
	end
end

class NamedElement
	include ToFile
	include ToText
	attr_accessor :name

	def initialize(name)
		@name = name
	end

end	

NamedElement.new('matz').to_f