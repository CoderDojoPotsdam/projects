f = open("superstar4.txt")
l = f.readlines()
group = (l[0].split())
relations = {}
for person in group:
    relations[person] = []
print(relations)
l = l[1:]
for line in l:
    pair = line.split()
    relations[pair[0]].append(pair[1])
print(relations)

superstar = group
if group[1] is in relations[group[0]]:
    superstar = superstar - group[0]
else
    superstar = superstar - group[1]



#for i in range(0,len(group))
#    if group[i] in relations[group[i-1]]:
        
    
