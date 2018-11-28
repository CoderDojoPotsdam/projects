f = open("superstar4.txt")
l = f.readlines()                        #wer folgt wem
group = (l[0].split())                   #wer ist in gruppe
relations = {}
for person in group:
    relations[person] = []               #wer folgt dieser person
#print(group)
l = l[1:]
for line in l:
    pair = line.split()
    relations[pair[0]].append(pair[1])   #der folgt dieser person
#print(relations)

superstar = group[:]
#print (superstar)
#print(group)

zaeler = 0
for i in range (len(superstar)-1):
    if superstar[1] in relations[superstar[0]]:
        del superstar[0:1]
        zaeler = zaeler + 1
    else:
        del superstar[1:2]
        zaeler = zaeler + 1
#print(zaeler)
#print(superstar)


for k in range (len(group)):
    if group[k] == superstar[0]:
        del group[k]
	break
#print(group)

for j in range (len(group)):
    if superstar[0] in relations[group[j]]:
    	zaeler = zaeler + 1
    else:
	del superstar[0:1]
	print('kein superstar')
	break
#print(superstar)

for m in range (len(group)):
    if group[m] in relations[superstar[0]]:
	del superstar[0:1]
	print('kein superstar')
	break
    else:
    	zaeler = zaeler + 1

print(zaeler,"Abfragungen")
print(superstar)






