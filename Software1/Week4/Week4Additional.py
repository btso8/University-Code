######################### EXERCISE 3 #########################################
def get_words_starting_with(text, letter):
    list_words = text.split()
    output = []
    for word in list_words:
        if (word.lower().startswith(letter.lower())
            and word not in output):
            output.append(word)

    return output

############################ Exercise 4 ######################################
def caesar_encrypt(alphabet, shift, plaintext):
    cypher_text = ""
    for letter in plaintext:
        if letter in alphabet:
            index = alphabet.index(letter)
            substitution_index = (index + shift) % len(alphabet)
            cypher_text = cypher_text + alphabet[substitution_index]
        else:
            cypher_text = cypher_text + letter

    return cypher_text

def caesar_decrypt(alphabet, shift, cypher_text):
    plaintext = ""
    for letter in cypher_text:
        if letter in alphabet:
            index = alphabet.index(letter)
            substitution_index = (index - shift) % len(alphabet)
            plaintext = plaintext + alphabet[substitution_index]
        else:
            plaintext = plaintext + letter

    return plaintext

############################ Exercise 5 ######################################
def scalar_product(scalar, vector):
    prod = []    
    for number in vector:
        prod = prod + [number * scalar]

    return prod

def vector_addition(vector1, vector2):
    if(len(vector1) == len(vector2)):
        sum_vector = []
        index = 0
        while index < len(vector1):
            sum_vector = sum_vector + [vector1[index] + vector2[index]]
            index +=1

        return sum_vector
    else:
        print ("cannot add vectors with different dimensions.")
        return None
