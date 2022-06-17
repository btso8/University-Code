def read_datafile(fileName):
    try:
        datafile = open(fileName)
    except IOError as err:
        print ('The following error occurred:',err)
        raise

    else:
        data = datafile.readlines()
        datarecords = {}
        datafile.close()
        row = 1
        while row < len(data):
            
            cells = data[row].split(',')
            if cells[0] in datarecords:
                raise ValueError()
            else:
                datarecords[int(cells[0])] = float(cells[1])

            row += 1
        return datarecords

def collate_precipitations(filenames,output_filename):
    list_datarecords = {}
    valid_list_of_files = []
    for name in filenames:
        try:
            datarecords = read_datafile(name)
        except IOError as err:
            print ('The following error occurred:',err)
        except ValueError as err:
            print ("duplicate year in file", name)
        else:
            valid_list_of_files.append(name)
            for item in datarecords.items():
                if item[0] in list_datarecords:
                    list_datarecords[item[0]].append(item[1])
                else:
                    list_datarecords[item[0]] = [item[1]]

    outputfile = None
    try:
        outputfile = open(output_filename,'w')
    except IOError as err:
        print(err)
        raise
    else:
        outputfile.write('Years,')
        outputfile.write(','.join(valid_list_of_files))
        outputfile.write('\n')
        outputfile.flush()

        for item in sorted(list_datarecords.items()):
            outputfile.write(str(item[0]))
            for value in item[1]:
                outputfile.write(',')
                outputfile.write(str(value))
            outputfile.write('\n')
            outputfile.flush()
    finally:
        if outputfile is not None:
             outputfile.close()

##########################################
##      TESTS
#########################################
 
list_of_files = ['Data/precipitations-europe.txt',
           'Data/precipitations-NAmerica.txt',
           'Data/precipitations-world.txt']

collate_precipitations(list_of_files, 'Data/collated.txt')
