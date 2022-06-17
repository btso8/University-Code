try:
    datafile = open('Data/precipitations-europe.txt')
except IOError as err:
    print ('The following error occurred:',err)
else:
    data = datafile.readlines()
    datafile.close()
    min_precipitation = []
    max_precipitation = []
    average_precipitation = 0.0
    row = 1

    while row < len(data):
        
        cells = data[row].split(',')
        cells[0] = int(cells[0])
        cells[1] = float(cells[1])
        if (len(min_precipitation) == 0 or
            cells[1] < min_precipitation[1]):
            min_precipitation = [cells[0], cells[1]]

        if (len(max_precipitation) == 0  or
            cells[1] > max_precipitation[1]):
            max_precipitation = [cells[0], cells[1]]
            
        average_precipitation += cells[1]

        row += 1
        
    print ("min precipitation was", min_precipitation[1], end='')
    print (" and it occurred in",min_precipitation[0],)
    
    print ("max precipitation was", max_precipitation[1], end='')
    print (" and it occurred in",max_precipitation[0])
        
    print ("the average precipitation in last century was",
           average_precipitation/(len(data)-1))
