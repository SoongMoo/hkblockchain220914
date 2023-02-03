import csv
import sys
import matplotlib as mpl
import matplotlib.pyplot as plt

zone = sys.argv[1];

f1 = open('src/main/webapp/view/python/gender.csv')
#f1 = open('gender.csv')
data = csv.reader(f1)

m = []
f = []

for row in data:
	if zone in row[0] :
		for i in row[3:104]:
			#m.append(int(i))
			m.append(-int(i))
		for i in row[106:]:
			f.append(int(i))
			
 
font_name = mpl.font_manager.FontProperties(fname='C:\Windows\Fonts\malgun.ttf').get_name()
mpl.rc('font',family=font_name)
mpl.rcParams['axes.unicode_minus'] = False
plt.title(zone + ' 지역의 인구 구조')

plt.barh(range(101), m , label='남성')
plt.barh(range(101), f , label='여성')
plt.legend()
plt.savefig('src/main/webapp/view/python/gender.png')
plt.show()