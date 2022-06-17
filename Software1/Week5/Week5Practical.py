############################ Exercise 1 ######################################
def display_dico(dico):
    for key in dico:
        print(key, '-->', dico[key])

def display_dico2(dico):
    for key, val in dico.items():
        print(key, '-->', val)


############################ Exercise 2 ######################################
def concat_dico(dico1, dico2):
    result = {}
    for key, val in dico1.items():
        result[key] = val

    for key, val in dico2.items():
        result[key] = val 

    return result

def concat_dico_advanced(dico1, dico2):
    result = {}
    for key, val in dico1.items():
        result[key] = val

    for key, val in dico2.items():
        if key in result:
            result[key] = [dico1[key],dico2[key]]

        else:
            result[key] = val

    return result

############################ Exercise 3 ######################################
def map_list(keys, values):
    mapped = {}
    for index in range(len(keys)):
        if keys[index] not in mapped:
            mapped[keys[index]] = values[index]
        else:
            print("Error: duplicate value", keys[index], "in the list of keys.")
            return None

    return mapped

############################ Exercise 4 ######################################
def reverse_dictionary(dico):
    reversed_dico = {}
    for key, val in dico.items():
        if val in reversed_dico:
            print("Duplicate values in initial dictionary are not allowed.")
            return None
        else:
            reversed_dico[val] = key

    return reversed_dico
