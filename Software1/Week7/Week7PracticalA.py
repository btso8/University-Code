class Vector(object):

    def __init__(self, data=None):
        if data is None:
            self._vector = []
        else:
            self._vector = [float(x) for x in data]

    def __str__(self):
        return '<' + ', '.join([str(x) for x in self._vector]) + '>'

    def dim(self):
        return len(self._vector)

    def get(self, index):
        return self._vector[index]

    def set(self, index, value):
        if isinstance(value, float) or isinstance(value, int):
            self._vector[index] = float(value)
        else:
            raise TypeError('value must be a number!')

    def scalar_product(self, scalar):
        if isinstance(scalar, float) or isinstance(scalar, int):
            return Vector([scalar * x for x in self._vector])
        else:
            raise TypeError('scalar must be a number!')

    def add(self, other):
        if not isinstance(other, Vector):
            raise TypeError('Vector object required!')
        elif self.dim() != other.dim():
            raise ValueError('Vectors must be of same dimension!')
        else:
            return Vector([self._vector[i] + other._vector[i] 
                            for i in range(self.dim())])
    
    def equals(self, other):
        if not isinstance(other, Vector):
            return False
        else:
            return self._vector == other._vector
