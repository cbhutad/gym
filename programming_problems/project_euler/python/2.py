def fibonacci_sum_even(limit):
    fib1, fib2 = 1, 2
    sum_even = 0

    while fib1 < limit:
        if fib1 % 2 == 0:
            sum_even += fib1
        
        next_fib = fib1 + fib2
        fib1, fib2 = fib2, next_fib
    
    return sum_even


result = fibonacci_sum_even(4_000_000)
print("The sum of even-valued terms in the Fibonacci sequence up to 4 million is:", result)