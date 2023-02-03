import csv
import sys
import matplotlib as mpl
import matplotlib.pyplot as plt

# zone = sys.argv[1];

#f = open('src/main/webapp/view/python/subwayfee.csv')
f = open('subwayfee.csv')
data = csv.reader(f)
next(data)

mx = 0
rate = 0

for row in data:
	for i in range(4, 8):
		row[i] = int(row[i])
	#print(row)
	if row[6] != 0:
		rate = row[4] / (row[4]+row[6])
		if rate > mx :
			mx = rate
			print(row, round(rate,2))
print(mx)




	
