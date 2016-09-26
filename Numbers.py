from fractions import Fraction
import itertools
from math import factorial

def P(event,space):
    return Fraction(len(event & space),len(space))

def cross(A, B):
    return {a+b for a in A for b in B}

def combos(items, n):
    return {' '.join(combo) for combo in itertools.combinations(items,n)}

def choose(n,c):
    "returns the NcR"
    return factorial(n)//(factorial(n-c) * factorial(c))

def even(n): return n%2==0


is_predicate = callable
def Pnew(event, space):
    if is_predicate(event):
        event = such_that(event,space)
    return Fraction(len(event&space),len(space))

def such_that(predicate,collection):
    return {s for s in collection if predicate(s)}
    
def prime_sum(outcome):
    return is_prime(sum(outcome))
def is_prime(n):
    return n>1 and not any(n%i==0 for i in range(2,n))
    
def flush(hand):
    return any(hand.count(suit)==5 for suit in suits)



#Probablity of four of a kind

def four_kind(hand):  
    return any(hand.count(rank)==4 for rank in ranks)



def win_unfinished_games(Hwins, Twins):
    def HwinS(outcome): return outcome.count('h')>=Hwins
    return Pnew(HwinS,continuations(Hwins, Twins))


def continuations(Hwins,Twins):
    rounds = ['ht' for _ in range(Hwins+Twins-1)]
    return set(itertools.product(*rounds))

print(win_unfinished_games(2,3))



#Card problems
#suits = 'SHDC'
#ranks = 'A23456789TJQK'

#deck = cross(ranks,suits)
#print(len(deck))


#hands = combos(deck,5)

#print(len(hands))
#print(Pnew(flush,hands))
#assert len(hands) == choose(len(deck),5)
#probablity of flush(5 hands same suit)
#print(Pnew(four_kind,hands))
    


##################################################

# Sum of three dice roles is a prime
#D ={1,2,3,4,5,6}
#D3 = {(d,d1,d2)  for d in D for d1 in D for d2 in D}

#print(Pnew(prime_sum,D3))

#print(Pnew(even,D))


##urn = cross('W','12345678')|cross('B','123456')|cross('R','123456789')
##
##print(len(urn))
##print(len(combos(urn,6)))
##
##a = {'1','2','3','4','5','6'}
##perm = {' '.join(combo) for combo in itertools.permutations(a,3)}
##comb = {' '.join(combo) for combo in itertools.combinations(a,3)}
##print(len(perm & comb))
##print(len(perm | comb))
##
##
##print(choose(23,6))
##
##print("Probablity of choosing 6 Red balls")
##
##u6 = combos(urn,6)
##
##red6 = {s for s in u6 if s.count('R')==6}
##
##print(len(red6))
##print(len(u6))
##print(P(red6,u6))
##print(Fraction(choose(9,6),choose(23,6)))
