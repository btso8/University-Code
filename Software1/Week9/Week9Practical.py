class LinkedNode:

    def __init__(self, data=None, next= None):
        self._data = data
        if next is None or isinstance(next, LinkedNode):
            self._next = next
        else:
            raise TypeError('Node type object expected!')
        

    def __str__(self):
        if self._data is None:
            return ''
        elif self._next is None:
            return str(self._data)
        else:
            return str(self._data) + ', ' + str(self._next)

    @property
    def data(self):
        return self._data

    @data.setter
    def data(self, value):
        self._data = value

    @property
    def tail(self):
        return self._next

    @tail.setter
    def tail(self, node):
        if node is None or isinstance(node, LinkedNode):
            self._next = node
        else:
            raise TypeError('Node type object expected!')

class LinkedStack:

    def __init__(self):
        self._top = None
        self._size = 0

    def __str__(self):
        return 'LinkedStack([' + str(self._top) +')]'

    def push(self, value):  
        newnode = LinkedNode(value)
        if self._top is None:
            self._top = newnode
        else:
            newnode.tail = self._top
            self._top = newnode
        self._size += 1

    def peek(self):
        if self._top is None:
            return None
        else:
            return self._top.data

    def pop(self):
        if self._top is None:
            raise ValueError('Cannot pop an empty stack!')
        else:
            popped = self._top 
            self._top = self._top.tail
            popped.tail = None
            self._size -= 1
            return popped.data

    def isempty(self):
        return self._size == 0

    def __len__(self):    
        return self._size

class LinkedQueue:

    def __init__(self):
        self._front = None
        self._back = None
        self._size = 0

    def __str__(self):
        return 'LinkedQueue([' + str(self._front) +')]'

    def enqueue(self, value):
        newnode = LinkedNode(value)
        if self._front is None:
            self._front = newnode
            self._back = newnode
        else:
            self._back.tail = newnode 
            self._back = newnode
        self._size += 1

    def peek(self):
        if self._front is None:
            return None
        else:
            return self._front.data

    def pop(self):
        if self._front is None:
            raise ValueError('Cannot pop an empty queue!')
        else:
            popped = self._front 
            self._front = self._front.tail
            if self._front is None:
                self._back = self._front
            popped.tail = None
            self._size -= 1
            return popped.data

    def isempty(self):
        return self._size == 0
        
    def __len__(self):
        return self._size

class LinkedList:

    def __init__(self):
        self._front = None
        self._tail = None
        self._size = 0

    def __str__(self):
        if self._front is None:
            return 'LinkedList([])'
        else:
            return 'LinkedList([' + str(self._front) +'])'

    def __len__(self):
        return self._size
    
    def isempty(self):
        return self._size == 0

    def append(self, value):
        newnode = LinkedNode(value)
        if self._front is None:
            self._front = newnode
            self._tail = newnode
        else:
            self._tail.tail = newnode
            self._tail = newnode

        self._size += 1

    def pop(self):
        if self.isempty():
            raise IndexError('The list is empty.')
        
        front_node = self._front
        self._front = self._front.tail
        front_node.tail = None
        self._size -= 1
        return front_node.data

    def __getitem__(self, index):
        if index >= self._size :
            raise IndexError('list index out of range')
        
        currentnode = self._front
        for i in range(index):
            currentnode = currentnode.tail
        return currentnode.data

    def __setitem__(self, index, value):
        if index >= self._size :
            raise IndexError('list assignment index out of range')
        
        currentnode = self._front
        for i in range(index):
            currentnode = currentnode.tail
        currentnode.data = value

    def __contains__(self, key):
        if self._size == 0:
            return False

        currentnode = self._front
        while currentnode is not None:
            if currentnode.data == key:
                return True
            currentnode = currentnode.tail
        return False

    def index(self, value, start=0, stop=2147483647):
        if self._size == 0:
            raise ValueError(str(value) + ' is not in list')
        
        index = 0
        currentnode = self._front
        while currentnode is not None:
            if currentnode.data == value:
                return index
            currentnode = currentnode.tail
            index += 1
        raise ValueError(str(value) + ' is not in list')

    def insert(self, index, object):
        newnode = LinkedNode(object)
        if self._size == 0:
            self._front = newnode
            self._tail = newnode
            self._size = 1
            return
                    
        if index == 0:
            newnode.tail = self._front
            self._front = newnode
            self._size += 1
            return
                    
        if index >= self._size:
            self._tail.tail = newnode
            self._tail = newnode
            self._size += 1
            return

        currentnode = self._front
        for i in range(index-1):
            currentnode = currentnode.tail
        newnode.tail = currentnode.tail
        currentnode.tail = newnode
        self._size += 1

    def remove(self, value):
        if self._size == 0:
            raise ValueError(str(value) + ' is not in list')
        
        index = 0
        currentnode = self._front
        if currentnode.data == value:
            self._front = self._front.tail
            currentnode.tail = None
            self._size -= 1
            if self._size == 0:
                self._tail = self._front
            return

        previousnode = currentnode
        currentnode = currentnode.tail
        while currentnode is not None:
            if currentnode.data == value:
                if currentnode is self._tail:
                    self._tail = previousnode
                previousnode.tail = currentnode.tail
                currentnode.tail = None
                self._size -= 1
                return
            previousnode = currentnode
            currentnode = currentnode.tail

        raise ValueError(str(value) + ' is not in list')
