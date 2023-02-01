import csv
import matplotlib.pyplot as plt

f = open('src/main/webapp/view/python/seoul.csv')
#f = open('seoul.csv')
data = csv.reader(f)
next(data)
next(data)

result = []
for row in data:
	if	row == []:
		continue
	if row[-1].strip() != '':
		result.append(row[-1])
		print(row[-1]) 
		
print('aaa' , len(result))
plt.plot(result, 'r')
plt.savefig('src/main/webapp/view/python/default.png')
#plt.show()
