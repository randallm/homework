#!/usr/bin/env python2.7

import random
from time import sleep
from collections import Counter

pennium_decayed = []
for i in xrange(0,100):
    if random.randint(0, 1):
        pennium_decayed.append('undecayed')
    else:
        pennium_decayed.append('decayed')

half_lives = 1
print '%i Half-Lives:' % (half_lives)
print Counter(pennium_decayed)

while 'undecayed' in pennium_decayed:
    for i, isotope in enumerate(pennium_decayed):
        if isotope == 'decayed':
            pass
        else:
            if random.randint(0, 1):
                pennium_decayed[i] = 'decayed'
    
    half_lives += 1
    sleep(1.5)  # simulate actual half-life time ;p
    print '%i Half-Lives:' % (half_lives)
    print Counter(pennium_decayed)
