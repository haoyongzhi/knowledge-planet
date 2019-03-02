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
* 特性
* 创建
* 方法

#### 3.判断语句

#### 4.三目表达式

#### 5.循环语句