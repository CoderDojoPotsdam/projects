import datetime

primes = []

max = 10000
isPrime = True

startTime = datetime.datetime.now()

for i in range(2,max):
    isPrime = True
    for prime in primes:
        if i % prime == 0:
            isPrime = False

    if isPrime:
        primes.append(i)

duration = datetime.datetime.now() - startTime
print("Time passed:",duration.total_seconds()*1000)
