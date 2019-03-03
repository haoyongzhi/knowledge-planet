### 【python基础】-Task3-字典、集合、判断语句、三目表达式、循环语句
#### 1.dictionary字典
##### 1).概述

通过前面的学习，我们知道`list`「列表」是一个可变类型的容器「支持增、删、改、查」，并且里面可以存放任意类型的对象，那么字典「`dictionary`」也是一样，是一个可变类型的容器，可以存放个任意类型的对象，不过字典存的是键值对。

字典这个东西，非常形象，我们如果遇到一个不会的字，通常会去查字典，那么拼音「或部首」查字法，都是一一对应的，一个拼音对应一个字

在`python`中字典类似于`java`中的`hashmap`，`js`中的`json`

字典是`Python`语言中唯一的映射类型，映射类型对象里哈希值（键，key）和指向的对象（值，value）是一对多的的关系，通常被认为是可变的哈希表。

##### 2).格式

```
dic = {key1:value1,key2:value2,key3:value3,...}
```

使用一个`{}`来把字典包起来，键值之间使用`:`来分隔，每个键值对之间使用`,`来分隔。字典中`key`是唯一的，但是值可以不必唯一。

```python
# demo1:按照拼音查找字
dic = {"zhangsan":"张三","lisi":"李四","piaoliang":"漂亮"}
print(dic['zhangsan'])
print(dic['lisi'])
print(dic['piaoliang'])
```
输出结果：
```
张三
李四
漂亮
```
```python
# 修改字典中的 age
xiaoli = {"name":"xiaoli","age":22,"address":"中国陕西"}
print("小李错误的年龄：%d"%xiaoli["age"])
# 修改年龄
xiaoli["age"] = 23
print("小李的年龄修改为：%d"%xiaoli["age"])
```
输出结果：
```
小李错误的年龄：22
小李的年龄修改为：23
```

##### 3).字典的遍历

* 遍历`key`

```
格式：
dic = {"key1":"value1":"key2":"value2",...}
for key in dic.keys():
    print key
```

```python
# 遍历输出字典中的key值
TigerChain = {"name":"TigerChain","age":18,"address":"中国陕西","love":["看书","游泳","爬山"]}
for key in TigerChain.keys():
    print("TigerChain 字典中的key:%s"%key)
```

以上例子说明了字典中的数据可以是任意类型的

输出结果：

```
TigerChain 字典中的key:name
TigerChain 字典中的key:age
TigerChain 字典中的key:address
TigerChain 字典中的key:love
```

* 遍历`values`

```
格式:
dic = {"key1":"value1":"key2":"value2",...}
for value in dic.values():
    print value
```

```python
# 遍历字典中的 所有的 values
dict = {"name":"zhangsan","age":18,"height":"165CM"}
print(dict)
for value in dict.values():
    print("dict 字典中的 value: %s"%value)
```

输出结果：
```
{'name': 'zhangsan', 'age': 18, 'height': '165CM'}
dict 字典中的 value: zhangsan
dict 字典中的 value: 18
dict 字典中的 value: 165CM
```

```python
# 修改字典中某个 key 所对应的值
dict = {"name":"zhangsan","age":18,"height":"165CM"}
print("修改之前的字典：%r"%dict)
dict["name"] = "junjun"
print("修改之后的字典：%r"%dict)
```

输出结果：

```
修改之前的字典：{'name': 'zhangsan', 'age': 18, 'height': '165CM'}
修改之后的字典：{'name': 'junjun', 'age': 18, 'height': '165CM'}
```

##### 4)字典内置方法

|方法|描述|
|---|---|
|`dict.clear()`|删除字典里所有的元素|
|`dict.copy()`|返回一个字典的浅拷贝|
|`dict.fromkeys(seq[,val]))`|创建一个新字典，以序列seq中元素做字典的键，val为字典所有键对应的初始值|
|`dict.get(key,default=None)`|返回指定键的值，如果值不在字典中返回`default`值|
|`dict.has_key(key)`|如果键在字典dict里返回`true`，否则返回`false`|
|`dict.items()`|以列表返回可遍历的(键,值)元组数组|
|`dict.keys()`|以列表返回一个字典所有的键|
|`dict.update(dict2)`|把字典dict2的键/值对更新到dict里|
|`dict.values()`|以列表返回字典中的所有值|
|`pop(key[,default])`|删除字典给定键key所对应的值，返回值为被删除的值。key值必须给出。否则，返回default值。|
|`popitem()`|随机返回并删除字典中的一对键和值。|

##### 5).DEMO
**一个比较综合的例子，模拟一个注册，登录，和查询的例子，当输入`r`时就是注册，输入`l`时就是登录，注册成功以后，可以看到存起来的用户名和密码「用户名和密码拿字典来存」其中姓名是键，密码是值。**

```python
# 定义一个空字典
dic = {}
# 登录或注册的标志
flag = 'r'
# 查询的标志
search = 'r'
# 注册的标志
register = 'r'
# 登录的标志
login = 'r'
# 退出的标志
exit = 'r'

while flag == 'r' or 'l':
    flag = input("注册或登录?r/l: ")
    # 注册
    if flag == 'r':
        prompt = "添加用户名:"
        uname = input(prompt)
        upass = input("添加密码：")
        dic[str(uname)] = str(upass)
        print("注册成功")

        search = input("是否要查询已注册的用户?s/e:")
        if(search=='s'):
            print(dic)
        else:
            continue
        # 登录
    elif flag == 'l':
         loginUname = input("输入用户名:")
         loginPass = input("输入密码：")
         for key in dic.keys():
             if(str(loginUname) == key and dic[key] == str(loginPass)):
                 print("欢迎 %s 登录"%key)
                 exit = 'q'
                 break
             else:
                 exit = 'e'
         if exit =='e':
             print("用户名或密码错误")
        #  登录成功退出
         elif exit=='q':
             break
    else:
        print("输入错误")
        break
```

结果展示：

![结果示例](../../resources/task2Dict-20190301213749.gif)

#### 2.集合

set（集合）类型是Python3的一种数据类型，集合（set）中包含的元素是**无序的，无重复的序列**。集合数据类型的主要作用是测试是否是集合成员中的一个，和消除重复元素。

集合（set）是可变数据类型，支持插入和删除元素，但是不支持索引和分片元素。

##### Python3 定义集合
* 1）Python3的集合使用花括号{}定义，然后在花括号中把各个元素使用逗号,分开。Python3 集合中包含的元素可以是不同的数据类型（如包括字符串和整数），但通常情况下我们创建的集合的元素都是同一种数据类型。

```python
#定义集合中包含不同数据类型
s1 = {'Python3', 123, 321}
```

输出结果：

```
{'Python3', 123, 321}
```

```python
#集合的元素为相同数据类型，字符串
s2 = {'Python2', 'Python3'}
```

输出结果：

```
{'Python2', 'Python3'}
```

```python
#集合的元素为相同数据类型，整数
s3 = {123, 321, 234, 432}
```

输出结果：
```
{123, 321, 234, 432}
```

* 2）定义集合时，如果包含相同的数据元素，那么将去除重复的元素

```python
s = {123, 321, 123, 321}
```

输出结果：
```
{321, 123}
```

* 3）定义一个空集合，空集合使用set()函数定义，使用一对花括号{}定义的是一个字典（dictionary），

```python
st = set()
```

* 4）Python3 集合不支持嵌套定义。

##### Python3 测试元素是否存在

集合（set）的一个重要的功能就是测试集合中是否包含一个元素。

```python
basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
print(basket)                      # show that duplicates have been removed
{'orange', 'banana', 'pear', 'apple'}
'orange' in basket                 # fast membership testing
```

输出结果：
```
True
```

测试集合中不否包含特定的一个元素

```python
basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
print(basket)                      # show that duplicates have been removed
{'orange', 'banana', 'pear', 'apple'}
'crabgrass' not in basket            # fast membership testing
```

输出结果：

```
True
```

##### Python3 集合的添加删除操作

* Python3 向集合中添加元素

Python3向集合中添加元素的语法如下

```
set.add(elem)
```

实例如下：

```python
i = {1, 2, 3, 4, 5}
i.add(8)
```

输出结果：

```
{1, 2, 3, 4, 5, 8}
```

* Python3 删除集合中的一个元素

1）使用`remove(elem)`方法删除一个元素，如果元素不存在，则会抛出一个错误

```
set.remove(elem)
```

实例如下：

```
i = {1, 2, 3, 4, 5}
i.remove(5)
i
{1, 2, 3, 4}
i.remove(9)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
KeyError: 9
```

2）使用`discard(elem)`方法删除一个元素，如果元素不存在，则不会抛出错误

```
set.discard(elem)
```

实例如下：

```python
i = {1, 2, 3, 4, 5}
i.discard(5)
i
{1, 2, 3, 4}
i.discard(9)
i
{1, 2, 3, 4}
```

3）使用`set.pop()`删除集合中的第一个元素，并返回元素的值

```
set.pop()
```

实例如下：

```python
i = {1, 2, 3, 4, 5}
i.pop()
1
```

##### Python3 集合的交并差运算

假设三个集合i = {1, 2, 3, 4, 5}，j = {4, 5, 6, 7, 8}，k={4, 5}

![集合交叉运算](../../resources/t1.png)

#####  Python3 集合的赋值运算

假设三个集合i = {1, 2, 3, 4, 5}，j = {4, 5, 6, 7, 8}，k={4, 5}

![集合交叉运算](../../resources/t2.png)

#### 3.判断语句

Python3 条件控制语句是根据条件的真假来决定要执行什么样的语句，来执行相应的程序功能。

##### Python3 条件语句详解

Python3 中的条件语句具有三种语法形式：

* 单`if`条件语句
* `if else`条件语句
* `if elif else`条件语句

条件语句中条件可以是值 True 或 False，也可以是表达式的布尔类型上下文环境。

**Python3单`if`条件语句形式**

这种形式是最简单的条件语句形式，当条件为真时，此处的条件是一个布尔值，执行相应的语句：

```
if 条件 :
    语句
```
实例：

```python
num = 20
if num > 0:
    print("num 是正数")
```

此实例的运行结果为：

```
num 是正数
```

**Python3 if else 条件语句形式**

1)此种形式是当 if 的条件为真时，执行 if 条件内的语句，如果 if 条件为假，则执行 else 内的语句。

```
if 条件 :
    语句
else :
    语句
if else 条件语句实例：
```

```python
num = -20
if num > 0:
    print("num 是正数")
else:
    print("num 是负数")
```

 此实例的运行结果为：

```
num 是负数
```

**Python3 `if elif else`条件语句形式**

1）此种形式是复杂的条件语句形式，当 if 的条件为真时，执行 if 条件内的语句，否则则测试 elif 条件的真值，如果为真，则执行 elif 内的语句，否则执行 else 内的语句。

```
if 条件 :
    语句
elif 条件 :
    语句
else :
    语句
if elif else 条件语句实例：
```

```python
num = 0
if num > 0:
    print("num 是正数")
elif num < 0:
    print("num 是负数")
else:
    print("num 是零")
```

此实例的运行结果为：

```
num 是零
```

2）此种形式可以包含多个 elif 条件语句，形式如下：

```
if 条件 :
    语句
elif 条件 :
    语句
elif 条件 :
    语句
else :
    语句
```
多个`elif`条件语句实例：

```python
student = "大学生"
if student == "小学生":
    print("Student 是小学生")
elif student == "初中生":
    print("Student 是初中生")
elif student == "高中生":
    print("Student 是高中生")
else:
    print("Student 是大学生")
```

此实例的运行结果为：

```
Student 是大学生
```

**Python3 `if`条件语句常用操作符**

`if`条件语句中，对条件的判断一般是比较（当然可以是任意布尔类型上下文环境），所以常用的操作符有一下的比较操作符：

|操作符|描述|
|---|---|
|<||小于|
|<=|小于或等于|
|>|大于|
|>=|大于或等于|
|==|等于，比较对象是否相等|
|!=|不等于|

**Python3 if 条件语句的嵌套**

在`if`条件语句中的`if`语句，`elif`语句，`else`语句中都可以嵌套入`if`语句三种语法形式中任何一种形式，如：

```
​if 条件 :
    if 条件 :
        语句
    else :
        语句
elif 条件 :
    if 条件 :
        语句
    else :
        语句
else :
    if 条件 :
        语句
    else :
        语句
```

#### 4.三目表达式

#### 5.循环语句

Python3 循环语句根据特定的条件的多次执行特定的语句，在 Python 3 中用来实现循环功能的语句有 for 语句和 while 语句。

##### 为什么需要循环语句？

假如要计算 1 + 2 + 3 的结果，可以直接写算术表达式：

```python
1 + 2 + 3
6
```

但是如果要计算`1 + 2 + 3 + ... + 10000`的结果，使用算术表达式就非常的麻烦，这时我们可以借助循环语句来完成计算，非常简单。

假如要计算`1 + 2 + 3 + ... + x`的结果，`x`是用户输入的任意一个值，那么使用算术表达式就不能完成计算，这时也需要借助循环语句。

##### Python3 for 循环语句

Python3 中 for 语句中不像其他语言那样，其他语言在 for 语句中包含初始值，条件判断语句，递增（其他语言的 for 循环形式 `for(i=0, i<=10, i++){}`），Python3 的 for 语句的一般形式如下：

```
for variable in sequence:
    statements
[else
    else_statements]
```

解释：

for 循环每次从sequence中获取上次获取元素的下一个元素，如果元素存在，则把取出的元素的值赋予variable，然后执行循环体statements语句。
else 为可选语句，功能的是在sequence中没有下一个元素时（即sequence中的元素全部被遍历）执行else_statements语句。
如上可以看出：Python3 for 循环需要借助 Sequence(序列) 数据类型限定循环次数，Sequence(序列) 中元素的个数就是 for 语句循环的次数，Python 3 中 Sequence(序列) 数据类型包括的子数据类型有：list(列表)，tuple(元组)，range，str(字符串)，bytes(字节)，bytesarray(字节数组)。

**Python 3 for 循环实例**

1）简单的 for 循环实例：

```python
py = ["Python2", "Python3"] 
for x in py:
    print (x)
```
输出结果：
```
Python2
Python3
```

2）具有 else 的 for 循环语句实例：

```python
py = ["Python2", "Python3"]
for x in py:
    print(x)
else:
    print("循环结束!")
```

如上脚本的运行结果如下：

```
Python2
Python3
循环结束!
```

3）Python3 实现其他语言`for(i=2, i<10, i++){}`形式的相同功能的循环语句，实现这种功能需要借助 Range 对象，实例如下：

```python
r = range(2, 10)
for i in r:
    print(i)
```

如上脚本运行结果如下：

```
2
3
4
5
6
7
8
9
```

##### Python3 while 循环语句

Python3 中 while 语句和其他语言中的形式相似，在条件为真是执行循环体内的语句，Python3 的 while 语句的一般形式如下：

```
while expression:
    statements
[else
    else_statements]
```

解释：

while 语句重复测试 expression 的值，如果值为 True，执行循环体statements语句，否则退出循环。
else 为可选语句，功能是在 expression 的值第一次为 False 时，执行 else_statements 语句。
expression 可以是任意形式的值，只要可以转换为 bool 值。

**Python 3 while 循环实例**

1）简单的 while 循环实例：

```python
x = 1
while x <= 5:
    print (x)
    x += 1
```

```
1
2
3
4
5
```

2）具有 else 的 while 循环语句实例：

```python
x = 5
while x <= 10:
    print (x)
    x += 1
else:
    print("循环完成！")
```

如上脚本的运行结果如下：

```
5
6
7
8
9
10
循环完成！
```