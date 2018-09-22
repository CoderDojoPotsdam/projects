f = open("superstar4.txt")
l = f.readlines()
group = (l[0].split())
relations = {}
for n in group:
    relations[n] = []
print(relations)
l = l[1:]
for line in l:
    pair = line.split()
    relations[pair[0]].append(pair[1])
print(relations)
if group[1] in relations[group[0]]:
    
