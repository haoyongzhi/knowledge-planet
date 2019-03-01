#### 【python基础】-Task2-队列、元组
序列是Python中最基本的数据结构。

Python有6个序列的内置类型，但最常见的是列表和元组。

序列都可以进行的操作包括索引，切片,加，乘，检查成员。

此外，Python已经内置确定序列的长度以及确定最大和最小的元素的方法。

##### 1.列表
列表是最常用的Python数据类型，形式：方括号内的逗号分割值列表。

列表的数据项不需要具有相同的类型

列表的特点：

1. 是一个有序集合
2. 通过下标来索引，读取数据
3. 支持嵌套
4. 是一个可变的类型

创建一个列表，只要把逗号分隔的不同的数据项使用方括号括起来即可。如下所示：
```python
list1 = ['Google','Runoob',1007,2000];
list2 = [1,2,3,4,5];
list3 = ["a","b","c","d"];
```
与字符串索引一样，列表索引从0开始。列表可以进行截取、组合等。

* 索引
序列中的每个元素都分配一个数字-它的位置，或索引，第一个索引是0，第二个索引是1，依次类推。
* 基本操作(创建,`append()`,`pop()`,`del()`,拷贝)
```python
# 定义一个姓名列表
names = ["Zhangsan","Lisi","Wangwu"]
# 输出列表中每个项的值
print(names[0])
print(names[1])
print(names[2])
```
运行结果：
```
Zhangsan
Lisi
Wangwu
```
以上是利用下标输出列表的值。

###### 列表长度-len()函数
java中数组是有长度的，python中的列表也是有长度的，我们通过len(list)就可以获取列表的长度。【**由于python中的for循环的特殊性，不需要拿到长度照样可以遍历**】

* for循环遍历
```python
# 遍历输出姓名列表
names = ["Zhangsan","Lisi","Wangwu"]
print("列表的长度是：%d",len(names))
# 遍历输出
for name in names:
    print(name)
```
输出结果：
```
列表的长度是：3
Zhangsan
Lisi
Wangwu
```
* while循环
```python
# while 利用len()函数遍历列表
names = ["Zhangsan","Lisi","Wangwu"]
size = len(names)
i = 0
while i < size:
    print(names[i])
    i+=1
```
输出结果:
```
Zhangsan
Lisi
Wangwu
```
###### append函数
`list.append(obj)`在列表的末尾添加新的对象。

```python
# 在已有列表中添加Zhaoliu
names = ["Zhangsan","Lisi","Wangwu"]
print("append前的列表：%s"%names)
names.append("Zhaoliu")
print("append后的列表：%s"%names)
```
输出结果:
```
append前的列表：['Zhangsan', 'Lisi', 'Wangwu']
append后的列表：['Zhangsan', 'Lisi', 'Wangwu', 'Zhaoliu']
```
###### extend
`list.extend(seq):`将另一个列表一次性追加到列表的末尾。
```python
names1 = ["Zhangsan","Lisi","Wangwu"]
names2 = ["Zhaoliu","Haoqi"]
print("1班同学们:%s"%names1)
print("2班同学们:%s"%names2)
names1.extend(names2)
print("extend 之后合成一个班:%s"%names1)
```
输出结果：
```
1班同学们:['Zhangsan', 'Lisi', 'Wangwu']
2班同学们:['Zhaoliu', 'Haoqi']
extend 之后合成一个班:['Zhangsan', 'Lisi', 'Wangwu', 'Zhaoliu', 'Haoqi']
```

###### sort和reverse
`sort([func])`:func是可选参数，如果设置了就按该参数的方法进行排序，否则就按默认的顺序进行排序：**从小到大**
```python
# 把全班同学的成绩按照从小到大的顺序排列出来，并找出80以上的成绩
scores = [60,54,80,99,45,79,26,72,76,75,88,89,95]
# 定义一个空列表用于存放大于80分的成绩
youxiu = []
print("未排序之前的成绩:%s"%scores)
scores.sort()
print("从小到大排序之后的成绩:%s"%scores)
for score in scores:
    if(score >= 80):
        youxiu.append(score)
print("全班达到80分以上的成绩共有%d个%s"%(len(youxiu),youxiu))
```
输出结果：
```
未排序之前的成绩:[60, 54, 80, 99, 45, 79, 26, 72, 76, 75, 88, 89, 95]
从小大大排序之后的成绩:[26, 45, 54, 60, 72, 75, 76, 79, 80, 88, 89, 95, 99]
全班达到80分以上的成绩共有5个[80, 88, 89, 95, 99]
```
```python
# 全班成绩从大到小排序。
scores = [60,54,80,99,45,79,26,72,76,75,88,89,95]
print("未排序之前的成绩:%s"%scores)
scores.sort(reverse=True)
print("从大到小排序之后的成绩:%s"%scores)
```
输出结果：
```
未排序之前的成绩:[60, 54, 80, 99, 45, 79, 26, 72, 76, 75, 88, 89, 95]
从大到小排序之后的成绩:[99, 95, 89, 88, 80, 79, 76, 75, 72, 60, 54, 45, 26]
```

除了数字排序，字符串也可以排序，按首字母ASCII码来排序(**,首字母一样，按次字母，以此类推**)

```python
# 把名字按从小到大排序
names = ["Zhangsan","Lisi","Wangwu"]
print("原名字顺序:%s"%names)
names.sort()
print("从小到大排序后:%s"%names)
```
输出结果：
```
原名字顺序:['Zhangsan', 'Lisi', 'Wangwu']
从小到大排序后:['Lisi', 'Wangwu', 'Zhangsan']
```
###### `reverse`:反向列表中的数据
```python
scores = [60,90,87,56,43,88]
print("反向排序之前的成绩：%s"%scores)
scores.reverse()
print("反向排序之后的成绩：%s"%scores)
```
输出结果：
```
反向排序之前的成绩：[60, 90, 87, 56, 43, 88]
反向排序之后的成绩：[88, 43, 56, 87, 90, 60]
```

###### `pop`和`remove`
`list.pop(obj=list[-1])`:默认移除列表最后一个元素。

```python
# 移除姓名列表中最后一个名字
names = ["Zhangsan","Lisi","Wangwu"]
print("移除最后一个名字前的列表：%s"%names)
names.pop()
print("移除最后一个名字后的列表：%s"%names)
```
输出结果：
```
移除最后一个名字前的列表：['Zhangsan', 'Lisi', 'Wangwu']
移除最后一个名字后的列表：['Zhangsan', 'Lisi']
```

```python
# 删除指定位置的姓名
names = ["Zhangsan","Lisi","Wangwu"]
print("移除最后一个名字前的列表：%s"%names)
names.pop(1)
print("移除索引=1的名字后的列表：%s"%names)
```
输出结果：
```
移除最后一个名字前的列表：['Zhangsan', 'Lisi', 'Wangwu']
移除索引=1的名字后的列表：['Zhangsan', 'Wangwu']
```

`remove`:用于删除与列表中某个值的**第一个匹配项**
```python
names = ["Zhangsan","Lisi","Wangwu","Lisi","Zhangsan"]
print("列出所有名字：%s"%names)
input_name = input("输入你要删除的名字:")
for name in names:
    if(name==input_name):
        names.remove(name)
print("删除指定名字后的列表：%s"%names)
names.remove("Zhangsan")
print("删除Zhangsan后的列表：%s"%names)
```
输出结果：
```
列出所有名字：['Zhangsan', 'Lisi', 'Wangwu', 'Lisi', 'Zhangsan']
输入你要删除的名字:Lisi
删除指定名字后的列表：['Zhangsan', 'Wangwu', 'Zhangsan']
删除Zhangsan后的列表：['Wangwu', 'Zhangsan']
```

**remove只能移除第一个匹配到的项**

通过上面我们知道我们可以对列表进行增、删、改、查。

##### 2.tuple-元组
元组和列表在结构上没有什么区别，唯一的区别就是元组是只读的，不能修改（增、删、改），是不可变类型，元组使用"()"表示。
```python
# 创建并初始化一个元组
names = ("Zhangsan","Lisi","Wangwu")
print(names)
for name in names:
    print("我是:%s"%name)
```
输出结果：
```
('Zhangsan', 'Lisi', 'Wangwu')
我是:Zhangsan
我是:Lisi
我是:Wangwu
```

```python
# 统计姓名"Zhangsan"在元组中的个数
names = ["Zhangsan","Lisi","Wangwu","Lisi","Zhangsan","zhangsan"]
# 把一个列表转化成元组
new_names = tuple(names)
print(new_names)
print("Zhangsan出现的次数:%d"%new_names.count("Zhangsan"))
```
输出结果：
```
('Zhangsan', 'Lisi', 'Wangwu', 'Lisi', 'Zhangsan', 'zhangsan')
Zhangsan出现的次数:2
```
**注意:count区分大小写**

```python
# 修改元组中的项:Lisi，改为Zhaoliu
names = ['Zhangsan', 'Lisi', 'Wangwu', 'Lisi', 'Zhangsan', 'zhangsan']
new_names = tuple(names)
# 尝试修改
new_names[1] = "Zhaoliu"
print(new_names)
```
输出结果：
```
删除指定名字后的列表：['Zhangsan', 'Lisi', 'Wangwu', 'Lisi', 'Zhangsan']
  File "xxx/knowledge-planet/pythonbasics/TaskCodeTest/Task2.py", line 96, in <module>
删除Zhangsan后的列表：['Lisi', 'Wangwu', 'Lisi', 'Zhangsan']
    new_names[1] = "Zhaoliu"
('Zhangsan', 'Lisi', 'Wangwu')
TypeError: 'tuple' object does not support item assignment
```
* 基本操作(创建及不可变性)
##### 3.string字符串
* 定义及基本操作(`+`,`*`,读取方式)
* 字符串格式化问题