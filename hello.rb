puts "Hello, world!"
puts "Hello"
puts "Hello, world!"
puts "Hello"
puts "Hello, world!"
puts "Hello"
puts "Hello, world!"
puts "Hello"

def odd_or_even(number)
  if number % 2 == 0
    puts "#{number} is even."
  else
    puts "#{number} is odd."
  end
end

# Test the function with some numbers
odd_or_even(5)
odd_or_even(10)
odd_or_even(23)
odd_or_even(100)

