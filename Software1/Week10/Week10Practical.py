class Polynomial:

    def __init__(self, coefs):
        if coefs is None or not isinstance(coefs, list):
            raise ValueError('Invalid argument, must be a list of floats.')
        
        self._coef = []
        for coef in coefs:
            self._coef.append(float(coef))

    def degree(self):
        return len(self._coef) - 1

    def eval(self, x):
        result = 0
        for i in range(self.degree()+1):
            result += self._coef[i]*pow(x, i)
        return result

    def __add__(self, other):
        if not isinstance(other, Polynomial):
            raise TypeError('Can only add polynomial to polynomial.')
        if other == -self:
            return Polynomial([0])
        highest_degree = max(self.degree(), other.degree())

        coef1 = list(self._coef) + [0] * (highest_degree - self.degree())
        coef2 = list(other._coef) + [0] * (highest_degree - other.degree())

        for i in range(len(coef1)):
            coef1[i] += coef2[i]
        trim_zeros = True

        while trim_zeros:
            if coef1[-1] == 0:
                coef1.pop()
            else:
                trim_zeros = False

        return Polynomial(coef1)

    def __neg__(self):
        coefs = []
        for c in self._coef:
            coefs.append(-c)

        return Polynomial(coefs)


    def __sub__(self, other):
        if not isinstance(other, Polynomial):
            raise TypeError('Can only substract polynomial to polynomial.')

        return self + (-other)

    def __eq__(self, other):
        if not isinstance(other, Polynomial):
            return False
        else:
            return self._coef == other._coef

    def __mul__(self, other):
        if not isinstance(other, Polynomial):
            raise TypeError('Can only multiply polynomial with polynomial.')

        coefs = [0] * (self.degree() + other.degree() + 1)
        for i in range(len(self._coef)):
            for j in range(len(other._coef)):
                coefs[i+j] += self._coef[i] * other._coef[j]

        return Polynomial(coefs)
    
    def to_latex(self):
        output = ''
        if self.degree() == 0:
            return str(self._coef[0])
        elif self._coef[0] < 0:
            output += str(self._coef[0])
        elif self._coef[0] > 0:
            output += '+' + str(self._coef[0])
        if self.degree() == 1:
            return str(self._coef[1]) + 'x' + output
        elif self._coef[1] > 0:
            output = '+' + str(self._coef[1]) + 'x' + output
        elif self._coef[1] < 0:
            output = str(self._coef[1]) + 'x' + output
        for d in range(2, self.degree()):
            if self._coef[d] > 0: 
                output = '+' + str(self._coef[d]) + 'x^' + str(d) + output
            elif self._coef[d] < 0:
                output = str(self._coef[d]) + 'x^' + str(d) + output
        output = str(self._coef[self.degree()]) + 'x^' + str(self.degree()) + output
        return output

p = Polynomial([0,2])
p2 = Polynomial([1,-2,3])
p1 = p2-p
print(p1._coef, '|', p1.to_latex())
p3 = p*p2
print(p3._coef, '|', p.to_latex(), '|', p2.to_latex())
