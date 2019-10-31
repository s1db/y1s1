import matplotlib.pyplot as plt

ANALYTICAL_SOLUTION = 8.66666666667
INCRAMENTS = [4,2,1,0.5,0.25,0.125,0.0625]
DELTA_SOLUTIONS = []
START_POINT = 1
END_POINT = 5
 
def f(x):
    return INCRAMENT*(1/2*(x**3) - 4*(x**2)+8*(x))


def areaUnderCurve(INCRAMENT, START_POINT, END_POINT):
    remanSolution = 0
    while START_POINT <= END_POINT:
        remanSolution += f(START_POINT)
        START_POINT += INCRAMENT
    return remanSolution


for INCRAMENT in INCRAMENTS:
    print("Increment value:"+str(INCRAMENT))
    print("reman solution:"+str(areaUnderCurve(INCRAMENT, START_POINT, END_POINT)))
    print("Delta Solution:"+ str(ANALYTICAL_SOLUTION - areaUnderCurve(INCRAMENT, START_POINT, END_POINT)))
    DELTA_SOLUTIONS.append(ANALYTICAL_SOLUTION-areaUnderCurve(INCRAMENT, START_POINT, END_POINT))

plt.plot(INCRAMENTS, DELTA_SOLUTIONS)
plt.show()
