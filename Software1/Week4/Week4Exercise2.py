import turtle
import math
my_turtle = turtle.Turtle()
my_turtle.showturtle()

# 1- design a function draw_triangle to draw a triangle. Using this function and 
# a for loop, draw the following image.    
def draw_triangle(x, y, length=10):
    radius = length/math.sqrt(3)
    my_turtle.penup()
    my_turtle.goto(x, y+radius)
    my_turtle.pendown()
    my_turtle.right(60)
    for i in range(3):
        my_turtle.forward(length)
        my_turtle.right(120)

    my_turtle.left(60)
    my_turtle.penup()

size = 10

# 2- design a function draw_polygon to draw a regular polygon. Using this 
# function, you should be able to draw triangles, squares, pentagon, exagon
# and so on.
def draw_polygon(x=0, y=0, length=10, sides=4):
    my_turtle.penup()
    my_turtle.goto(x,y)
    my_turtle.pendown()
    my_turtle.setheading(0)
    for i in range(sides):
        my_turtle.forward(length)
        my_turtle.right(360/sides)

    my_turtle.penup()

def draw_star(x=0,y=0,radius=10):
    cx = x
    cy = y+radius
    bx = cx * math.cos(2*math.pi/3) - ( cy * math.sin(2*math.pi/3) )
    by = cx * math.sin(2*math.pi/3) + ( cy * math.cos(2*math.pi/3) )
    ax = cx * math.cos(4*math.pi/3) - ( cy * math.sin(4*math.pi/3) )
    ay = cx * math.sin(4*math.pi/3) + ( cy * math.cos(4*math.pi/3) )
    my_turtle.penup()
    my_turtle.goto(cx, cy)
    my_turtle.pendown()
    my_turtle.goto(bx, by)
    my_turtle.goto(ax, ay)
    my_turtle.goto(cx, cy)
    my_turtle.penup()
    cy = y-radius
    bx = cx * math.cos(2*math.pi/3) - ( cy * math.sin(2*math.pi/3) )
    by = cx * math.sin(2*math.pi/3) + ( cy * math.cos(2*math.pi/3) )
    ax = cx * math.cos(4*math.pi/3) - ( cy * math.sin(4*math.pi/3) )
    ay = cx * math.sin(4*math.pi/3) + ( cy * math.cos(4*math.pi/3) )
    my_turtle.penup()
    my_turtle.goto(cx, cy)
    my_turtle.pendown()
    my_turtle.goto(bx, by)
    my_turtle.goto(ax, ay)
    my_turtle.goto(cx, cy)
    my_turtle.penup()

size = 10
for i in range(5):
    draw_star(radius = size)
    size *= 2.2

my_turtle.screen.exitonclick()
