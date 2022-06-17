######################### EXERCISE 1 #########################################

#########################   part 1   #########################################
sentence = input('Enter a sentence: ')
numbers = sentence.split()
count_even = 0
for a_number in numbers:
    a_number = int(a_number)
    if a_number % 2 == 0:
        count_even = count_even + 1

print('There are',count_even,'even numbers.')

#########################   part 2   #########################################
sentence = input('Enter a sentence: ')
numbers = sentence.split()
count_even = 0
even_numbers = []

for a_number in numbers:
    a_number = int(a_number)
    if a_number % 2 == 0:
        count_even = count_even + 1
        even_numbers.append(a_number)

print('There are',count_even,'even numbers:', even_numbers)

#########################   part 3   #########################################
sentence = input('Enter a sentence: ')
numbers = sentence.split()
count_even = 0
even_numbers = []

for a_number in numbers:
    a_number = int(a_number)
    if (a_number % 2 == 0
        and a_number not in even_numbers):
        count_even += 1 
        even_numbers.append(a_number)

print('There are',count_even,'distinct even numbers:', even_numbers)

######################### EXERCISE 2 #########################################

#########################   part 4   #########################################
table = []
sudoku_size = 4
for times in range(sudoku_size):
    data = input('Enter 4 digits (0..4) separated by a space: ')
    digits = data.split()
    for index in range(sudoku_size):
        digits[index] = int(digits[index])
    table.append(digits)

hline = '+-+-+-+-+\n'
output = hline
for row in table:
    for element in row:
        if element == 0:
            output += '| '
        else:
            output += '|'+str(element)
    output += '|\n'
    output += hline

print(output)

######################### EXERCISE 3 #########################################
number = int(input('Enter a positive natural number: '))
binary = ''
while number > 1:
    binary = str(number % 2) + binary
    number = number // 2

binary = str(number) + binary

print(binary)
