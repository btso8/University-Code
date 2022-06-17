datarecords = {}

list_of_files = ['Data/precipitations-europe.txt',
               'Data/precipitations-NAmerica.txt',
               'Data/precipitations-world.txt']
valid_list_of_files = []

for filename in list_of_files:
    try:
        datafile = open(filename)
        data = datafile.readlines()
        datafile.close()
    except IOError as err:
        print ('The following error occurred:',err)
    else:
        valid_list_of_files.append(filename)
        row = 1
        while row < len(data):
            
            cells = data[row].split(',')

            cells[0] = int(cells[0])
            cells[1] = float(cells[1])
            if cells[0] in datarecords:
                datarecords[cells[0]].append(cells[1])
            else:
                datarecords[cells[0]] = [cells[1]]

            row += 1

output_file = None
try:
    output_file = open('Data/collatedFiles.txt','w')
except IOError as err:
    print ('The following error occurred:',err)
else:
    output_file.write('Years,')
    output_file.write(','.join(valid_list_of_files))
    output_file.write('\n')
    output_file.flush()

    for item in sorted(datarecords.items()):
        output_file.write(str(item[0]))
        for value in item[1]:
            output_file.write(',')
            output_file.write(str(value))
        output_file.write('\n')
        output_file.flush()
finally:
    if output_file is not None:
        output_file.close()
