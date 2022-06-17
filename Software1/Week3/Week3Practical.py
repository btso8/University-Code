######################### EXERCISE 1 #########################################
sentence = input('Enter a sentence: ')
sentence = sentence.lower()
front_index = 0
rear_index = len(sentence) - 1 

is_palindrome = True

while is_palindrome and front_index < rear_index: 
    if sentence[front_index] != sentence[rear_index]:
        is_palindrome = False
    front_index += 1
    rear_index -= 1

if is_palindrome:
    print('It is a palindrome.')
else:
    print('it is NOT a palindrome')

######################### EXERCISE 2 #########################################

#######################    part 1    #########################################
sentence = input('Enter a sentence: ')
output = ''
for letter in sentence:
    if letter != ' ':
        output += letter

print(output)

#######################    part 2    #########################################
sentence = input('Enter a sentence: ')
output = ''

first_letter = True

for letter in sentence:
    if letter != ' ':
        if first_letter:
            output += letter.upper()
            first_letter = False
        else:
            output += letter.lower()
    else:
        first_letter = True

print(output)

#######################    part 3    #########################################
sentence = input('Enter a sentence: ')
output = ''

first_letter = True

current_word = ''

output = []

for letter in sentence:
    if letter.isupper():
        if current_word != '':
            output.append(current_word)
        current_word = letter
    else: 
        current_word += letter

output.append(current_word)
print(output)

######################### EXERCISE 3 #########################################

#########################   part 1   #########################################
plaintext = input("Enter message to encrypt: ")
alphabet = "abcdefghijklmnopqrstuvwxyz"
shift = 3
cypher_text = ""
for letter in plaintext:
    if letter in alphabet:
        index = alphabet.index(letter)
        substitution_index = (index + shift) % len(alphabet)
        cypher_text = cypher_text + alphabet[substitution_index]
    else:
        cypher_text = cypher_text + letter

print(cypher_text)

#########################   part 2   #########################################
plaintext = ""
for letter in cypher_text:
    if letter in alphabet:
        index = alphabet.index(letter)
        substitution_index = (index - shift) % len(alphabet)
        plaintext = plaintext + alphabet[substitution_index]
    else:
        plaintext = plaintext + letter

print(plaintext)
