class Vector(object):

    def __init__(self, *args):
        if len(args) == 0:
            self._vector = []
        elif len(args) == 1 and isinstance(args[0],list):
            self._vector = [float(x) for x in args[0]]
        else:
            self._vector = [float(x) for x in args]


    def __str__(self):
        return '<' + ', '.join([str(x) for x in self._vector]) + '>'

    def __eq__(self, other):
        if not isinstance(other, Vector):
            return NotImplemented
        else:
            return self._vector == other._vector

    def __add__(self, other):
        if not isinstance(other, Vector):
            return NotImplemented
        elif self.dim() != other.dim():
            raise ValueError('Vectors must be of same dimension!')
        else:
            return Vector([self._vector[i] + other._vector[i] 
                            for i in range(self.dim())])

    def __iadd__(self,  other):
        return self + other

    def __imul__(self, scalar):
        return scalar * self

    def __rmul__(self, scalar):

        if isinstance(scalar, float) or isinstance(scalar, int):
            return Vector([scalar * x for x in self._vector])
        else:
            return NotImplemented

    def __getitem__(self, index):
        return self._vector[index]

    def __setitem__(self, index, value):
        if isinstance(value, float) or isinstance(value, int):
            self._vector[index] = float(value)
        else:
            raise TypeError('value must be a number!')

    def dim(self):
        return len(self._vector)

    def get(self, index):
        return self[index]

    def set(self, index, value):
        self[index] = value

    def scalar_product(self, scalar):
        return scalar * self

    def add(self, other):
        return self + other
    
    def equals(self, other):
        return other == self
