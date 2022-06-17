def is_power(a, b):
    if b == 0:
        if a == 0:
            return True
        else:
            return False
    if a == 1:
        return True
    elif b == 1:
        return False
    elif a % b == 0:
        return is_power(a/b, b)
    else:
        return False

def sum_digits(number):
    if number < 0:
        return sum_digits(-number)
    elif number == 0:
        return number
    else:
        quotient = number // 10
        digit = number % 10
        return digit + sum_digits(quotient)

def rec_sum(numbers):
    if numbers == []:
        return 0
    else:
        return numbers[0] + rec_sum(numbers[1:])

def flatten(numbers):
    if numbers == []:
        return []
    elif isinstance(numbers, list):
        return flatten(numbers[0]) + flatten(numbers[1:])
    elif isinstance(numbers, (float, int)):
        return [numbers]
    else:
        raise TypeError("invalid type in the list")

def merge(sorted1, sorted2):
    if sorted1 == []:
        return sorted2[:]
    elif sorted2 == []:
        return sorted1[:]
    elif sorted1[0] < sorted2[0]:
        return [sorted1[0]] + merge(sorted1[1:], sorted2)
    else:
        return [sorted2[0]] + merge(sorted1, sorted2[1:])

def iselfish(word):
    def elfish(word, pattern):
        if pattern == []:
            return True
        elif word == '':
            return False
        elif word[0] in pattern:
            pattern.remove(word[0])
            return elfish(word[1:], pattern)
        else:
            return elfish(word[1:], pattern)

    return elfish(word,['e', 'l', 'f'])

def something_ish(word, pattern):
    def _something_ish(word, pattern):
        if pattern == []:
                return True
        elif word == '':
            return False
        elif word[0] in pattern:
            pattern.remove(word[0])
            return _something_ish(word[1:], pattern)
        else:
            return _something_ish(word[1:], pattern)
    
    return _something_ish(word, list(pattern))
