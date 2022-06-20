from Logic import *

def ask_p(kb, f):
  print("Ask: ", f)
  print(kb.ask(f))

def tell_p(kb, f):
  print("Tell: ", f)
  print(kb.tell(f))

kb = createResolutionKB()

P13 = Atom('P13')
P11 = Atom('P11')
B11 = Atom('B11')
P12 = Atom('P12')
P21 = Atom('P21')
B21 = Atom('B21')
P22 = Atom('P22')
P31 = Atom('P31')
B12 = Atom('B12')

R1 = Not(P11)
R2 = Equiv(B11, Or(P12, P21))
R3 = Equiv(B21, Or(Or(P11, P22), P31))
R4 = Not(B11)
R5 = B21

R6 = Not(B12)
R7 = Equiv(B12, Or(Or(P11, P22), P13))

tell_p(kb, R1)
tell_p(kb, R2)
tell_p(kb, R3)
tell_p(kb, R4)
tell_p(kb, R5)
tell_p(kb, R6)
tell_p(kb, R7)

ask_p(kb, P13)
ask_p(kb, P31)
