class Tree
	attr_accessor :node_name, :children

	def initialize(hash)
		hash.each do |key,value|
			@node_name = key
			@children = []
			value.each { |name,child| @children << Tree.new(name => child) }
		end
	end

	def visit_all(&block)
    visit &block
    children.each {|child| child.visit_all(&block)}
  end

  def visit(&block)
    block.call self
  end
end

ruby_tree = Tree.new({'grandpa' => { 'dad' => {'child 1' => {}, 'child 2' => {} }, 'uncle' => {'child 3' => {}, 'child 4' => {} } } })

puts "Visiting a node"
ruby_tree.visit do |node| 
	puts node.node_name
end

puts "Visiting entire tree"
ruby_tree.visit_all do |node| 
	puts node.node_name
end
