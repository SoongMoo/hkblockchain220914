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
		if row[0].split('-')[1] == '01' and row[0].split('-')[2] == '15' :
			result.append(float(row[-1]))
			print(row[0] , row[-1]) 
f.close()		
print('aaa' , len(result))
plt.plot(result, 'r')
plt.savefig('src/main/webapp/view/python/default1.png')
#plt.show()

f = open('src/main/webapp/view/python/seoul.csv')
data = csv.reader(f)
next(data)
next(data)

result = [] 
for row in data:
	if	row == []:
		continue
	if row[-1].strip() != '':
		result.append(float(row[-1]))
f.close()

plt.hist(result, bins=100, color='r')
plt.savefig('src/main/webapp/view/python/histogrape1.png')
plt.show()