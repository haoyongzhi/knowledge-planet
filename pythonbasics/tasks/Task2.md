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
print("从小大大排序之后的成绩:%s"%scores)
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
##### 2.元组
* 标志
* 基本操作(创建及不可变性)
##### 3.string字符串
* 定义及基本操作(`+`,`*`,读取方式)
* 字符串格式化问题