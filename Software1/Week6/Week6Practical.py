from string import punctuation

sample_text = (" As Python s creator, I'd like to say a few words about its "+
              "origins adding a bit of personal philosophy. "+
              "Over six years ago in December I was looking for a "+
              "hobby programming project that would keep me occupied "+
              "during the week around Christmas. My office, "+
              "a government run research lab in Amsterdam would be closed "+
              "but I had a home computer and not much else on my hands "+
              " I decided to write an interpreter for the new scripting "+
              "language  I had been thinking about lately a descendant of ABC "+
              "that would appeal to UnixC hackers I chose Python as a "+
              "working title for   the project being in a slightly irreverent "+
              "mood and a big fan of Monty Python s Flying Circus.  ")

######################### EXERCISE 1 ##########################################
def split_text(text, separator=' '):
    result = []
    wordUnderConstruction = ''

    for char in text:        
        if char in separator:
            if wordUnderConstruction != '': 
                result.append(wordUnderConstruction)
                wordUnderConstruction = ''              
        else: 
            wordUnderConstruction = wordUnderConstruction + char

    if wordUnderConstruction != '':
        result.append(wordUnderConstruction)

    return result

######################### EXERCISE 2 ##########################################
def get_words_frequencies(text):
    
    frequencies = {}
    
    list_words = split_text(text.lower(),punctuation + ' ')
    
    for word in list_words:
        if word in frequencies:
            frequencies[word] += 1
        else:
            frequencies[word] = 1

    return frequencies

######################### EXERCISE 3 ##########################################
def flatten(lst):
    output = []
    for elements in lst:
        output += elements
        
    return output

######################### EXERCISE 4 ##########################################
def rasterise(data, width):
    if width < 1 or len(data) % width: 
        return None
    else:
        output = []
        for i in range(0, len(data), width):
            output.append(data[i:i+width])
            
        return output
