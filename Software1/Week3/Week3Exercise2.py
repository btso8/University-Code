# 1- Write a program that prompts the user to input a positive integer N and
#  print the sum of the first N natural numbert.
number = int(input('Enter a positive integer: '))

total = 0
for value in range(number):
    total += value

print('The sum of the first', number, 'natural number is:', total)

# 2- Write a program that prompts the user to input a positive integer. It 
# should then print the multiplication table of that number.
number = int(input('Enter a positive integer: '))
number_length = len(str(number))
table = ''
for i in range(1, 11):
    table += '{0:>2d} x {1} = '.format(i, number) 
    formatting =('{0:>' + str(number_length + 1) + 'd}\n')
    table += formatting.format(number * i)

print(table)

# 3- Write a program to print the factorial value of any number entered 
# through the keyboard. You must use a for loop, not any math function that
# already exists.
number = int(input('Enter a positive integer: '))
fact = 1
for i in range(1, number + 1):
    fact *= i

print(str(number) + '! =', fact)
