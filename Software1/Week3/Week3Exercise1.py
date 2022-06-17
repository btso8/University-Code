# 1- Write a program to keep asking for a number until you enter a negative 
# number. At the end, print the sum of all entered numbers.
number = 0

total = 0
while number >= 0:
    number = float(input('Enter a number (<0 to quit): '))
    if number >= 0:
        total += number

print('The sum is:', total)

# 2- Write a program to keep asking for a number until you enter a negative 
# number. At the end, print the average of all entered numbers.
number = 0
total = 0
count = 0
while number >= 0:
    number = float(input('Enter a number (<0 to quit): '))
    if number >= 0:
        total += number
        count += 1

if count > 0:
    print('The average is:', total/count)
else:
    print('The average is 0.')

# 3- Write a program to keep asking for a number until you enter a negative 
# number. At the end, print the number of even number entered.
number = 0
even = 0
while number >= 0:
    number = int(input('Enter a whole number (<0 to quit): '))
    if number % 2 == 0:
        even += 1

print('The number of even number entered is:', even)
