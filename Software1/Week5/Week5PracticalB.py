########### EXERCISE 2 ###################
def save_list2file(sentences, filename):
    output_file = None
    try:
        output_file = open(filename, 'w')
    except IOError as err:
        print(err)
    else:
        for aSentence in sentences:
            output_file.write(aSentence + '\n')
    finally:
        if output_file is not None:
            output_file.close()

def save_list2file_with(sentences, filename):
    with open(filename, 'w') as output_file:
        for aSentence in sentences:
            output_file.write(aSentence + '\n')
            
########### EXERCISE 3 ###################
def save_to_log(entry, logfile):
    logs = None
    try:
        logs = open(logfile, 'a')
    except IOError as err:
        print(err)
    else:
        logs.write(entry)
        logs.write('\n')
    finally:
        if logs is not None:
            logs.close()

########### EXERCISE 5 ###################
def to_upper_case(input_file, output_file):
    data_in = []    
    with open(input_file, 'r') as in_file:
        data_in = in_file.readlines()
        
    with open(output_file, 'w') as out_file:
        for data in data_in:
            out_file.write(data.upper())

########### EXERCISE 6 ###################
def sum_numbers(entry):
    total = 0
    numbers = entry.split()
    for number in numbers:
        total += int(number)
        
    return total

def sum_from_file(filename):
    total = 0
    with open(filename, 'r') as input_file:
        for line in input_file:
            total += sum_numbers(line)
            
    return total    
