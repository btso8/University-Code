# Depth-first search:
def dfs(graph, start, goal):
    visited = []
    fringe = [start]

    while fringe:
        node = fringe.pop()
        if node not in visited:
            visited.append(node)

            if node == goal:
                return(visited)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    fringe.append(neighbor)
    return(visited)

# Breadth-first search
def bfs(graph, start, goal):
    visited = []
    fringe = [start]

    while fringe:
        node = fringe.pop(0)
        if node not in visited:
            visited.append(node)

            if node == goal:
                return(visited)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    fringe.append(neighbor)
    return(visited)

# Tree search (with def'n of fringe class below)
def treesearch(graph, start, goal, fringe):
    visited = []
    fringe.append(start)

    while fringe.count() > 0:
        node = fringe.next()
        if node not in visited:
            visited.append(node)

            if node == goal:
                return(visited)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    fringe.append(neighbor)
    return(visited)
    

# Fringe class (for above)
class Fringe():
  def __init__(self, fifo):
    self.m_list = [] 
   
    if fifo:
      self.is_queue = True
    else:
      self.is_queue = False
  
  def next(self):
    if self.is_queue:
       return(self.m_list.pop(0))
    else:
       return(self.m_list.pop())

  def count(self):
    return(len(self.m_list))

  def append(self, val):
    self.m_list.append(val)      


### Test code for all the above:

# Test trees:
graph = {'A': ['B', 'C'], 'B':['D'], 'C':[], 'D':[]}
graph2 = {'A': ['B', 'C'], 'B':['D'], 'C':['E', 'F'], 'D':[], 'E':[], 'F':['G','H'], 'G':[], 'H':[]}

print(dfs(graph, 'A', 'D'))
print(dfs(graph2, 'A', ''))
print(bfs(graph, 'A', ''))
print(bfs(graph2, 'A', ''))

fringe_queue = Fringe(True)
fringe_stack = Fringe(False)

print(treesearch(graph2, 'A', '', fringe_queue))
print(treesearch(graph2, 'A', '', fringe_stack))

### End of test code

### State representation code:

# initial state
state = [5, 0]  

# actions
def DB(state):
    state_copy = state.copy()
    state_copy[0] = 0
    return(state_copy)

def DS(state):
    state_copy = state.copy()
    state_copy[1] = 0
    return(state_copy)

def PB(state):
    state_copy = state.copy()
    p = min(5 - state[0], state[1])

    state_copy[0] += p
    state_copy[1] -= p
    return(state_copy)

def PS(state):
    state_copy = state.copy()
    p = min(2 - state[1], state[0])
    state_copy[0] -= p
    state_copy[1] += p
    return(state_copy)



def successors(state, depth=1):
    acts = {}
    state_copy = state.copy()
    if state[0] > 0:
      acts["DB" + str(depth)] = DB(state_copy)
      if state[1] < 2:
        acts["PS" + str(depth)] = PS(state_copy)

    if state[1] > 0:
      acts["DS" + str(depth)] = DS(state_copy)
      if state[0] < 5:
        acts["PB" + str(depth)] = PB(state_copy)

    return(acts)

def goalReached(state):
    return(state[1] == 1)



# recursive (depth-limited) DFS:
lst = []
def waterjug(state, depth):
  global lst

  if goalReached(state):
    print("goal")
    return(True)

  if depth > 10: 
    return(False)

  succ = successors(state, depth)

  if len(succ) == 0:
    return(False)

  for key, value in succ.items():
    if waterjug(value, depth+1):
      lst.insert(0,key)
      return(True)

  return(False)

# initial state (5,0) and initial depth (1) :
waterjug([5,0], 1)
print(lst)


# basic timing:
import numpy as np
import time
graph2 = {'A': ['B', 'C'], 'B':['D'], 'C':['E', 'F'], 'D':[], 'E':[], 'F':['G','H'], 'G':[], 'H':[]}

fringe_queue = Fringe(True)
fringe_stack = Fringe(False)

print(treesearch(graph2, 'A', '', fringe_queue))
print(treesearch(graph2, 'A', '', fringe_stack))

tic = time.perf_counter()
treesearch(graph2, 'A', '', fringe_queue)
toc = time.perf_counter()

print("BFS:" + str(toc-tic))

tic = time.perf_counter()
treesearch(graph2, 'A', '', fringe_stack)
toc = time.perf_counter()

print("DFS:" + str(toc-tic))



# more consistent timing:
tic = []
toc = []
for i in range(1,10):
  tic.append(time.perf_counter())
  treesearch(graph2, 'A', '', fringe_stack)
  toc.append(time.perf_counter())

diff = np.subtract(toc, tic)
print("DFS:" + str(np.mean(diff)))

tic = []
toc = []
for i in range(1,10):
  tic.append(time.perf_counter())
  treesearch(graph2, 'A', '', fringe_queue)
  toc.append(time.perf_counter())

diff = np.subtract(toc, tic)
print("BFS:" + str(np.mean(diff)))
