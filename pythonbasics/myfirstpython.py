print("hello word")
# name = input()
# print("input name is:" + name)
list1 = ['physics', 'chemistry', 1997, 2000]
list2 = [1, 2, 3, 4, 5, 6, 7]
print("list1[0]:", list1[0])
print("list2[1:5]:", list2[1:5])
print("========================")
list3 = [1,2,3,4,5]
print(list3)
print(list3[-1])
print(list3[:-1])
print("=========================")
idx = range(10)
print("type(idx):",end = '')
print(type(idx))
print("idx:",end = '')
print(idx)
print("list(idx):",end = '')
print(list(idx))
for i in range(10):
    print(idx[i])
print("=========================")
x = 'runoob'
for i in range(len(x)):
	print(x[i])
print("===============Python3 基本数据类型=================")
counter = 100  # 整型变量
miles = 1000.0  # 浮点型变量
name = "runoob"  # 字符串
print(counter)
print(miles)
print(name)
print("===============身份运算符==============")
a = 20
b = 20
if (a is b):
    print("1 - a 和 b 有相同的标识")
else:
    print("1 - a 和 b 没有相同的标识")

if (id(a) == id(b)):
    print("2 - a 和 b 有相同的标识")
else:
    print("2 - a 和 b 没有相同的标识")

# 修改变量 b 的值
b = 30
if (a is b):
    print("3 - a 和 b 有相同的标识")
else:
    print("3 - a 和 b 没有相同的标识")

if (a is not b):
    print("4 - a 和 b 没有相同的标识")
else:
    print("4 - a 和 b 有相同的标识")
print("===============Python运算符优先级==============")
a = 20
b = 10
c = 15
d = 5
e = 0

e = (a + b) * c / d  # ( 30 * 15 ) / 5
print("(a + b) * c / d 运算结果为：", e)

e = ((a + b) * c) / d  # (30 * 15 ) / 5
print("((a + b) * c) / d 运算结果为：", e)

e = (a + b) * (c / d);  # (30) * (15/5)
print("(a + b) * (c / d) 运算结果为：", e)

e = a + (b * c) / d;  # 20 + (150/5)
print("a + (b * c) / d 运算结果为：", e)