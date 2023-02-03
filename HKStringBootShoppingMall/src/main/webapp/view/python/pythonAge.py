import matplotlib as mpl
import matplotlib.pyplot as plt

import csv
import sys

f = open('src/main/webapp/view/python/age.csv')
#f= open('age.csv')
zone = sys.argv[1];

data = csv.reader(f)

result = []

for row in data:
	if zone in row[0] :
		for i in row[3:]:
			print(i)
			result.append(int(i))
print(result)

print(plt.style.available)

plt.style.use('ggplot')
font_name = mpl.font_manager.FontProperties(fname='C:\Windows\Fonts\malgun.ttf').get_name()
mpl.rc('font',family=font_name)
plt.title(zone + ' 지역의 인구 구조')
#plt.bar(range(101), result)
plt.plot(result)
plt.savefig('src/main/webapp/view/python/age.png')
plt.show()

