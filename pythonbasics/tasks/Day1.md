## Datawhale-Python基础
### Day1
#### 1. 环境搭建
###### a) anaconda环境配置
* 开发工具：Pycharm2018.2
* 环境：Anaconda 是一个基于 Python 的数据处理和科学计算平台，它已经内置了许多非常有用的第三方库，装上Anaconda，就相当于把 Python 和一些如 Numpy、Pandas、Scrip、Matplotlib 等常用的库自动安装好了，使得安装比常规 Python 安装要容易。

参考：[Python入门：Anaconda和Pycharm的安装和配置](https://www.cnblogs.com/yuxuefeng/articles/9235431.html)

###### b) 解释器

当我们编写Python代码时，我们得到的是一个包含Python代码的以.py为扩展名的文本文件。要运行代码，就需要Python解释器去执行.py文件。CPython是官方自带的解释器，也是使用最广的。

参考：[Python解释器](  https://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/00143161198846783e33de56d4041058c3dfc7e44ee1203000)
#### 2. python初体验
###### a) print and input
``` python
print("hello word")
name = input()
print("input name is:" + name)
```
输出内容:
```
hello word
Tom
input name is:Tom
```
#### 3. python基础讲解
###### a) python变量特性+命名规则
* 变量特性

可以自由赋值的量，在计算机程序中，变量不仅可以为整数或浮点数，还可以是字符串。

* 命名规则

Python 需要使用标识符给变量命名，其实标识符就是用于给程序中变量、类、方法命名的符号（简单来说，标识符就是合法的名字）。

Python 语言的标识符必须以字母、下画线（_）开头，后面可以跟任意数目的字母、数字和下画线（_）。此处的字母并不局限于 26 个英文字母，可以包含中文字符、日文字符等。

由于 Python 3 支持 UTF-8 字符集，因此 Python 3 的标识符可以使用 UTF-8 所能表示的多种语言的字符。Python 语言是区分大小写的，因此 abc 和 Abc 是两个不同的标识符。

Python 2.x 对中文支持较差，如果要在 Python 2.x 程序中使用中文字符或中文变量，则需要在 Python 源程序的第一行增加“#coding:utf-8”，当然别忘了将源文件保存为 UTF-8 字符集。

在使用标识符时，需要注意如下规则：

1. 标识符可以由字母、数字、下画线（_）组成，其中数字不能打头。
2. 标识符不能是 Python 关键字，但可以包含关键字。
3. 标识符不能包含空格。

例如下面变量，有些是合法的，有些是不合法的：

* abc_xyz：合法。
* HelloWorld：合法。
* abc：合法。
* xyz#abc：不合法，标识符中不允许出现“#”号。
* abc1：合法。
* 1abc：不合法，标识符不允许数字开头。

参考: [Python变量命名规则（超级详细）](http://c.biancheng.net/view/2172.html)

###### b) 注释方法

Python中的注释有单行注释和多行注释。

Python中单行注释以 # 开头，例如：
``` python
# 这是一个注释
print("Hello, World!") 
```

多行注释用三个单引号 ''' 或者三个双引号 """ 将注释括起来，例如:

1、单引号（'''）

``` python
'''
这是多行注释，用三个单引号
这是多行注释，用三个单引号 
这是多行注释，用三个单引号
'''
```

2、双引号（"""）

``` python
"""
这是多行注释，用三个双引号
这是多行注释，用三个双引号 
这是多行注释，用三个双引号
"""
print("Hello, World!") 
```

参考:[Python3 注释](http://www.runoob.com/python3/python3-comment.html)

###### c) python中`:`作用

中括号[]用于定义列表或引用列表、数组、字符串及元组中元素位置。

实例:
``` python
list1 = ['physics', 'chemistry', 1997, 2000]
list2 = [1, 2, 3, 4, 5, 6, 7]
print("list1[0]:", list1[0])
print("list2[1:5]:", list2[1:5])
```
输出结果:
```
list1[0]:  physics
list2[1:5]:  [2, 3, 4, 5]
```

冒号```:```用于定义分片、步长。


```a[:n]```表示从第0个元素到第n个元素(不包括n)，a[1:]表示该列表中的第1个元素到最后一个元素。

```L[2]```读取列表中第三个元素，也即下标为2的元素

```L[-2]```读取列表中倒数第二个元素(正着数有0，倒着数没有0)

```L[1:]```从第二个元素开始截取列表

``` python
list3 = [1,2,3,4,5]
print(list3)
print(list3[-1])
print(list3[:-1])
```
输出结果
```
[1, 2, 3, 4, 5]
5
[1, 2, 3, 4]
```
Python序列切片地址可以写为[开始：结束：步长]，其中的开始和结束可以省略。

**首先注意，在python3中想输出后续结果需要注意：(python3中print不换行，需要设置``` end = ''```)**

``` python
idx = range(10)
print("type(idx):",end = '')
print(type(idx))
print("idx:",end = '')
print(idx)print("list(idx):",end = '')
print(list(idx))
for i in range(10):
    print(idx[i])
```
输出结果:
```
type(idx):<class 'range'>
idx:range(0, 10)
list(idx):[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
0
1
2
3
4
5
6
7
8
9
```
python3中range的类型还是range，直接range(n)生成[0,n)区间整数
```
range(10) 
[0,1,2,3,4,5,6,7,8,9]
```
开始start省略时，默认从第0项开始
```
range(10)[:10:2] 
[0,2,4,6,8]
```
结尾省略的时候，默认到数组最后。
```
range(10)[1::2] 
[1,3,5,7,9]
```
开始和结尾不省略的时候
```
range(10)[2:6:]#step省略默认为1 
[2,3,4,5]
range(10)[2:6:1] 
[2,3,4,5]
```
步长step=n;代表从start开始（start也算）每隔step间隔，取一个数，一直到结尾end
```
range(20)[::3] 
[0,3,6,9,12,15,18]
```
当step等于负数的时候，从右向左取数。
```
range(10)[::-1] 
[9,8,7,6,5,4,3,2,1,0]
range(10)[::-2] 
[9,7,5,3,1]
```

参考1:[python2和python3 print输出不换行]( https://blog.csdn.net/dcrmg/article/details/79091926)

参考2:[Python基础06 循环](http://www.cnblogs.com/vamei/archive/2012/05/30/2526357.html)

###### d) 学会使用dir()及help()

* dir()

dir() 函数不带参数时，返回当前范围内的变量、方法和定义的类型列表；带参数时，返回参数的属性、方法列表。如果参数包含方法__dir__()，该方法将被调用。如果参数不包含__dir__()，该方法将最大限度地收集参数信息。

* help():文档查看 
```
help() 
help(object) 
help('object')
```
**注意：object The most base type**

以上三种方式均可，object指需要帮助的内容，比如help(list)或help('list')。 

查看过后想要退出help函数，需输入字母q，猜想q是quit的缩写； 

如果使用help(object)或help('object')，退出时直接输入字母q即可； 

如果是help()，输入字母q后会出现help>提示符（prompt），此时再输入字母q并按下回车键即可退出。

参考1:[Python3: python3 内置函数, Python3 id() 详解, Python3 dir() 详解, Python3 str() 详解,Python3 type() 详解](http://justcode.ikeepstudying.com/2019/01/python3-python3-%E5%86%85%E7%BD%AE%E5%87%BD%E6%95%B0-python3-id-%E8%AF%A6%E8%A7%A3-python3-dir-%E8%AF%A6%E8%A7%A3-python3-str-%E8%AF%A6%E8%A7%A3python3-type-%E8%AF%A6%E8%A7%A3/)

参考2：[Python3 dir() 函数](  https://www.cnblogs.com/lxwphp/p/9074656.html)

###### e) import使用

Python3开始，import 默认只做absolute import。也就是说pack包内的```__init__.py```中如果有一句```import my_package```，Python3会去找一个叫```my_package```的包，而不会去找```pack.my_package```包。

参考1：[Python 2和3在包内import时的语法差异问题](https://segmentfault.com/q/1010000000400151)

插曲:
* 模块（module）：用来从逻辑（实现一个功能）上组织Python代码（变量、函数、类），本质就是*.py文件。文件是物理上组织方式"module_name.py"，模块是逻辑上组织方式"module_name"。
* 包（package）：定义了一个由模块和子包组成的Python应用程序执行环境，本质就是一个有层次的文件目录结构（必须带有一个__init__.py文件）。

参考2:[Python中import机制](https://www.cnblogs.com/yan-lei/p/7828871.html)

###### f) pep8介绍

PEP8 是 Python 的一套编码规范。详细请参考：[PEP8中文版 -- Python编码风格指南](https://python.freelycode.com/contribution/detail/47)

#### 4. python数值基本知识

###### a) python中数值类型:int,float,boolean记法等

Python 中的变量不需要声明。每个变量在使用前都必须赋值，变量赋值以后该变量才会被创建。在 Python 中，变量就是变量，它没有类型，我们所说的"类型"是变量所指的内存中对象的类型。

等号（=）用来给变量赋值。等号（=）运算符左边是一个变量名,等号（=）运算符右边是存储在变量中的值。例如：

``` python
counter = 100  # 整型变量
miles = 1000.0  # 浮点型变量
name = "runoob"  # 字符串
print(counter)
print(miles)
print(name)
```

###### b) 算术运算符

以下假设变量a为10，变量b为21：

|运算符|描述|实例|
|-----|-----|-----|
|+|加 - 两个对象相加|``` a + b```  输出结果 31|
|-|减 - 得到负数或是一个数减去另一个数|``` a - b```  输出结果 -11|
|\*|乘 - 两个数相乘或是返回一个被重复若干次的字符串|``` a * b```  输出结果 210|
|/|除 - x 除以 y|``` b / a```  输出结果 2.1|
|%|取模 - 返回除法的余数|``` b % a```  输出结果 1|
|\*\*|幂 - 返回x的y次幂|```a**b``` 为10的21次方|

###### c) 逻辑运算符

|运算符|逻辑表达式|描述|实例|
|---|---|---|---|
|and|x and y|布尔"与" - 如果 x 为 False，x and y 返回 False，否则它返回 y 的计算值。|```(a and b)``` 返回 20。|
|or|x or y|布尔"或" - 如果 x 是 True，它返回 x 的值，否则它返回 y 的计算值。|```(a or b)``` 返回 10。|
|not|not x|布尔"非" - 如果 x 为 True，返回 False 。如果 x 为 False，它返回 True。|```not(a and b)``` 返回 False|

###### d) 成员运算符
除了以上的一些运算符之外，Python还支持成员运算符，测试实例中包含了一系列的成员，包括字符串，列表或元组。

|运算符|描述|实例|
|---|---|---|
|in|如果在指定的序列中找到值返回 True，否则返回 False。|x 在 y 序列中 , 如果 x 在 y 序列中返回 True。|
|not in|如果在指定的序列中没有找到值返回 True，否则返回 False。|x 不在 y 序列中 , 如果 x 不在 y 序列中返回 True。|

``` python
a = 10
b = 20
list = [1, 2, 3, 4, 5 ];
if ( a in list ):
   print ("1 - 变量 a 在给定的列表中 list 中")
else:
   print ("1 - 变量 a 不在给定的列表中 list 中")
if ( b not in list ):
   print ("2 - 变量 b 不在给定的列表中 list 中")
else:
   print ("2 - 变量 b 在给定的列表中 list 中")
# 修改变量 a 的值
a = 2
if ( a in list ):
   print ("3 - 变量 a 在给定的列表中 list 中")
else:
   print ("3 - 变量 a 不在给定的列表中 list 中")
```
输出结果：
```
1 - 变量 a 不在给定的列表中 list 中
2 - 变量 b 不在给定的列表中 list 中
3 - 变量 a 在给定的列表中 list 中
```

###### e) 身份运算符

身份运算符用于比较两个对象的存储单元。

|运算符|描述|实例|
|---|---|---|
|is|is 是判断两个标识符是不是引用自一个对象|x is y, 类似 id(x) == id(y) , 如果引用的是同一个对象则返回 True，否则返回 False|
|is not|is not 是判断两个标识符是不是引用自不同对象	|x is not y ， 类似 id(a) != id(b)。如果引用的不是同一个对象则返回结果 True，否则返回 False。|
注： id() 函数用于获取对象内存地址。
以下实例演示了Python所有身份运算符的操作：

``` python
a = 20
b = 20
 
if ( a is b ):
   print ("1 - a 和 b 有相同的标识")
else:
   print ("1 - a 和 b 没有相同的标识")
 
if ( id(a) == id(b) ):
   print ("2 - a 和 b 有相同的标识")
else:
   print ("2 - a 和 b 没有相同的标识")
 
# 修改变量 b 的值
b = 30
if ( a is b ):
   print ("3 - a 和 b 有相同的标识")
else:
   print ("3 - a 和 b 没有相同的标识")
 
if ( a is not b ):
   print ("4 - a 和 b 没有相同的标识")
else:
   print ("4 - a 和 b 有相同的标识")
```
输出结果：
```
1 - a 和 b 有相同的标识
2 - a 和 b 有相同的标识
3 - a 和 b 没有相同的标识
4 - a 和 b 没有相同的标识
```

is 与 == 区别：is 用于判断两个变量引用对象是否为同一个， == 用于判断引用变量的值是否相等。
``` python
>>> a = [1, 2, 3]
>>> b = a
>>> b is a
True
>>> b == a
True
>>> id(b)
2251486671304
>>> id(a)
2251486671304
>>> b = a[:]
>>> id(b)
2251482217800
>>> b is a
False
>>> b == a
True
>>> id(a)
2251486671304
>>> print(b)
[1, 2, 3]
>>> print(a)
[1, 2, 3]
>>> print(a[:])
[1, 2, 3]
>>> a is a[:]
False
>>> a == a[:]
True
```

###### f) 运算符优先级

以下表格列出了从最高到最低优先级的所有运算符：

|运算符|描述|
|---|---|
|```**```|指数 (最高优先级)|
|```~ + -```|按位翻转, 一元加号和减号 (最后两个的方法名为 +@ 和 -@)|
|```* / % //```|乘，除，取模和取整除|
|```+ -```|加法减法|
|```>> <<```|右移，左移运算符|
|```&```|位 'AND'|
|```^ |```|位运算符|
|```<= < > >=```|比较运算符|
|```<> == !=```|等于运算符|
|```= %= /= //= -= += *= **=```|赋值运算符|
|```is is not```|身份运算符|
|```in not in```|成员运算符|
|```and or not```|逻辑运算符|
实例：
``` python
a = 20
b = 10
c = 15
d = 5
e = 0
 
e = (a + b) * c / d       #( 30 * 15 ) / 5
print ("(a + b) * c / d 运算结果为：",  e)
 
e = ((a + b) * c) / d     # (30 * 15 ) / 5
print ("((a + b) * c) / d 运算结果为：",  e)
 
e = (a + b) * (c / d);    # (30) * (15/5)
print ("(a + b) * (c / d) 运算结果为：",  e)
 
e = a + (b * c) / d;      #  20 + (150/5)
print ("a + (b * c) / d 运算结果为：",  e)
```
输出结果：
```
(a + b) * c / d 运算结果为： 90.0
((a + b) * c) / d 运算结果为： 90.0
(a + b) * (c / d) 运算结果为： 90.0
a + (b * c) / d 运算结果为： 50.0
```

参考：[Python3 运算符](http://www.runoob.com/python3/python3-basic-operators.html)