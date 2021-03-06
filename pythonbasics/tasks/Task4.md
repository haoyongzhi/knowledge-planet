## 【Task4】-函数

Python3 函数是一个预先组织好的，可重复使用的代码段，使用它可以完成特定的功能。函数能够使你的程序模块化，并提高代码的重用性。

Python3 提供了很多内置函数，如 print()，你可以在任何需要输出内容的地方调用函数，不需要自定定义输出函数，提高了代码的重新率。在编写函数可以把功能相同的函数写在一个文件中，这样使程序高度模块化。

Python3 中用户可以自定义函数，它们称为用户自定义函数。

### Python3 如何定义函数

Python3 定义一个函数，需要遵循如下规则：

* 最开始为函数名行以 def 关键词开头，后面为函数标识符名称和 ()，最后是冒号 :，def 和标识符之间有一个空格，标识符和 () 之间无空格，右括号 ) 和 冒号 : 之间无空格。
* 所有需要传递的参数都需要放在圆括号 () 之内，圆括号与其相邻的参数之间不能有空格。
* 函数体内的第一条语句可以是一个可选的文档字符串。
* 函数体从冒号 : 开始（而不是以 {} 开始），下一行相对于当前行，必须缩进，当某行的缩进与函数名行的缩进相同时，表示函数定义结束。
* 最后可以是可选的 return [表达式] 语句，当 return 语句中无表达式时，相当于返回 None。

**Python3 定义函数的语法**

```
def 函数名(参数列表):
   """可选文档字符串"""
   函数体
   return [表达式]
```

Python3 函数定义实例

```python
def printme(str):
   """简单输出任何输入的字符串"""
   print(str)
   return
```

### Python3 调用函数

Python3 调用函数时需要指定函数名，并提供函数定义中所需要提供的参数（在函数定义时不需为参数指定数据类型，Python3 自动识别数据类型，但是调用函数时传递的参数必须和定义中实际需要的参数类型相同）：

我们再次以如上定义的 printme() 函数为例：

```python
# 函数定义
def printme(str):
   """简单输出任何输入的字符串"""
   print(str)
   return
# 函数调用
printme("第一次调用函数!")
printme("再一次调用函数!")
```

### Python3 值传递与引用传递

Python3 在传递参数时，都是把变量所指向的存储单元内的起始地址，传递进函数，函数接收参数时，在函数内部为参数申请一个地址空间，把传递过来的值存储在这个地址内。

那么值传递与引用传递什么区别哪？详细查看 Python3 可变数据类型和不可变数据类型。

**Python3 值传递**

Python3 值传递是针对不可变数据类型，如整数，在传递参数时，只传递进函数一个值，对参数值的修改，不会影响原来变量的值：

```python
def change_value(a):
    a = 10

b = 2
change_value(b)
print( b )
# 结果是 2
```

**Python3 引用传递**

Python3 引用传递是针对可变数据类型，如列表（List），字典（Dictionary），在传递参数时，相当于传递给函数一个变量的引用，函数内修改参数的值，相当于直接对原数据的值进行修改：

```python
# 函数定义
def changeme(mylist):
   """改变传递进函数的列表的值"""
   print ("改变前的列表值: ", mylist)
   mylist[2]=50
   print ("改变后的列表值: ", mylist)
   return

# 调用函数
mylist = [10,20,30]
changeme( mylist )
print ("调用函数后的列表值: ", mylist)
```

脚本的输出结果：

```
改变前的列表值:  [10, 20, 30]
改变后的列表值:  [10, 20, 50]
调用函数后的列表值:  [10, 20, 50]
```

复合类型中不可变数据类型作为参数传递时，传递的也是引用，只不过它们不能被修改，在编程过程中不会产生错误。

### Python3 函数参数

Python3 在函数中使用如下几种类型的参数：

* 必须参数（位置参数）
* 关键字参数（非位置参数）
* 默认参数
* 可变长度参数（任意参数列表）

**Python3 必须参数（位置参数）**

Python3 的必须参数是在调用函数时，必须传递的函数定义中明确定义的参数，而且传递的参数的个数和顺序必须和函数定义中参数的个数和顺序一致（这就是位置参数由来，即：参数传递的位置必须与函数定义中参数的位置相同）。

如上面实例中的 printme() 函数定义了一个参数 str，如果在调用时就必须传递一个参数，否则 Python3 会报告语法错误：

```python
# 函数定义
def printme(str):
   """简单输出任何输入的字符串"""
   print(str)
   return

# 函数调用
printme()
```

上面的函数调用将会提示如下错误：

```
Traceback (most recent call last):
   File "test.py", line 11, in <module>
      printme();
TypeError: printme() takes exactly 1 argument (0 given)
```

**注：上一个实例中是正确的调用形式，此函数定义中定义了一个参数，在函数体内没有具体数据类型的操作，所以在调用时可以传递任何数据类型。如果在函数体内有具体的数据类型的操作，在传递参数时就必须传递具体的数据类型，虽然在函数定义时没有定义参数的数据类型。**

**Python3 关键字参数（非位置参数）**

Python3 关键字参数是在调用函数时，把需要传递的指定给函数定义中相应的参数名，这样的好处是：不用像必须参数那样必须按照一定的顺序提供参数。使用关键字参数时，参数的顺序可以任意（这就是非位置参数的由来，即：关键字参数传递时没有固定的位置）。

如下实例中在参数传递时指定参数名，使用的就是关键词参数：

```python
# 函数定义
def printinfo(name, age):
   """输出传递进函数的参数信息"""
   print ("姓名: ", name)
   print ("年龄 ", age)
   return

# 函数调用
printinfo(age=50, name="王飞")
printinfo(name="王飞", age=50)
```

两次函数调用输出的结果相同：

```
姓名:  王飞
年龄  50

姓名:  王飞
年龄  50
```

**Python3 必须参数和关键字参数混合使用解释**

必须参数和关键字参数混合使用时，必须参数必须全部在任意一个关键字参数的前面，否则会出现语法错误。

例如函数定义：

```python
# 函数定义
def printinfo(name, age=20, sex="男", is_student="是"):
   """输出传递进函数的参数信息"""
   print (name, "今年", age, "岁", is_student,"学生")
   return
```

正确的调用形式：

```
printinfo("王飞")                        # 1 个位置参数
printinfo(name="王飞")                   # 1 个关键字参数
printinfo(name="王飞", sex="男")         # 2 个关键字参数
printinfo(sex="男", name="王飞")         # 2 个关键字参数
printinfo("王飞", 25, "男")              # 3 个位置参数
printinfo("腾飞", is_student="不是")     # 1 个位置参数, 1 个关键字参数
```

错误的调用形式：

```
printinfo()                    # 没有提供必须的参数
parrot(name="王飞", "是")      # 关键字参数后有一个必须参数
parrot("王飞", name="王飞")    # 一个参数赋了两次值
parrot(actor="演员")           # 函数定义中不存在的关键字参数
```

**Python3 默认参数**

Python3 默认参数是在函数定义时为参数赋一个值，在调用函数时如果为此参数传递参数，函数将使用传递的参数，如果不为此参数传递值，那么函数将使用参数定义时赋予的值。

推荐：在参数赋值时，= 的两侧不使用空格（当然也可以两侧各添加一个空格）。

```python
# 函数定义
def printinfo(name, age=20):
   """输出传递进函数的参数信息"""
   print ("姓名: ", name)
   print ("年龄 ", age)
   return

# 函数调用
printinfo(age=50, name="王飞")
printinfo(name = "王飞")
```

如上函数调用的输出结果是：

```
姓名:  王飞
年龄  50

姓名:  王飞
年龄  20
```

**Python3 可变长度参数（任意参数列表）**

Python3 可变长度参数是在调用函数时可以提供任意个数的参数，这些参数会组成一个元组（tuple），并赋值给可变长度参数。函数定义时定义可变长度参数是在参数名前添加一个星号 *。在可变长度参数前可以包含必须参数，和关键字参数。

```
def write_multiple_items(file, separator, *args):
    file.write(separator.join(args))
```

可变长度参数后面不能包含必须参数，因为在函数调用时：从可变长度参数开始的位置到关键字参数前都会封装赋值给可变长度参数，所以后面的必须参数是不可能在调用时被赋值的。但是后面可以包含关键字参数。

```python
def concat(*args, sep="/"):
     return sep.join(args)

concat("earth", "mars", "venus")
'earth/mars/venus'
concat("earth", "mars", "venus", sep=".")
'earth.mars.venus'
```

**Python3 开箱参数列表**

Python3 中有些函数需要多个参数，但是我们已经把这多个参数封装进了一个列表或元组，这时我们可以使用 Python3 提供的开箱参数列表功能，在函数调用时从列表或元组中自动提取需要的多个参数，我们只需在函数调用时在参数前添加一个星号 * 实例如下：

```python
list(range(3, 6))            # 常规调用 list() 函数构建一个列表
[3, 4, 5]
args = [3, 6]
list(range(*args))            # 开箱一个参数列表，构建一个列表
[3, 4, 5]
```

同样，可以在参数前添加两个星号 ** 来开箱一个字典（dictionary），开箱字典相当于使用关键字参数，实例如下：

```python
def printinfo(name, age=20, sex="男", is_student="是"):
    """输出传递进函数的参数信息"""
    print (name, "今年", age, "岁", is_student,"学生")
    return
 
d = {"name": "王飞", "age": 30, "sex": "男", "is_student": "不是"}
printinfo(**d)
#输出结果：王飞 今年 30 岁 不是 学生
```

### 参考

[Python3 函数定义和调用 | Python 3 教程](https://www.yuzhi100.com/tutorial/python3/python3-dingyi-hanshu)