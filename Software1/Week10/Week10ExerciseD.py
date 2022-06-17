##########  READING THE DATA FROM FILE ###########
datafile = open('Data/aberporth_meteorological_data.txt')
data = datafile.readlines()
datafile.close()

row = 2
year_record = {}

while row < len(data):
    
    cells = data[row].split(',')
    if cells[0] in year_record:
        record = year_record.get(cells[0])
        for index in range(4, len(cells)):
            record[index - 4] += float(cells[index])
    else:
        record = []
        for index in range(4, len(cells)):
            record.append(float(cells[index]))

        year_record[cells[0]] = record

    row += 1

###### WRITING THE SUMMARY FILE ########
summary_datafile = open('Data/aberporth_meteorological_data_summary.txt','w')

summary_datafile.write(data[0])
cells = data[1].split(',')
cells = [cells[0]] + cells[4:]
summary_datafile.write(','.join(cells))
summary_datafile.flush()

for item in sorted(year_record.items()):
    line = item[0]
    for value in item[1]:
        line += ',' +str(value)
            
    summary_datafile.write(line)
    summary_datafile.write('\n')
    summary_datafile.flush()

summary_datafile.close()
