# 定义一个姓名列表
names = ["Zhangsan","Lisi","Wangwu"]
# 输出列表中每个项的值
print(names[0])
print(names[1])
print(names[2])

print("列表的长度是：%d"%len(names))
# for遍历输出
for name in names:
    print(name)
# while遍历
size = len(names)
i = 0
while i < size:
    print(names[i])
    i+=1

# 在已有列表中添加Zhaoliu
names = ["Zhangsan","Lisi","Wangwu"]
print("append前的列表：%s"%names)
names.append("Zhaoliu")
print("append后的列表：%s"%names)
print("=======")
names1 = ["Zhangsan","Lisi","Wangwu"]
names2 = ["Zhaoliu","Haoqi"]
print("1班同学们:%s"%names1)
print("2班同学们:%s"%names2)
names1.extend(names2)
print("extend 之后合成一个班:%s"%names1)
print("=================")
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
scores = [60,54,80,99,45,79,26,72,76,75,88,89,95]
print("未排序之前的成绩:%s"%scores)
scores.sort(reverse=True)
print("从大到小排序之后的成绩:%s"%scores)
print("=================")
names = ["Zhangsan","Lisi","Wangwu"]
print("原名字顺序:%s"%names)
names.sort()
print("从小到大排序后:%s"%names)
print("=================")
scores = [60,90,87,56,43,88]
print("反向排序之前的成绩：%s"%scores)
scores.reverse()
print("反向排序之后的成绩：%s"%scores)
print("=================")
# 移除姓名列表中最后一个名字
names = ["Zhangsan","Lisi","Wangwu"]
print("移除最后一个名字前的列表：%s"%names)
names.pop()
print("移除最后一个名字后的列表：%s"%names)
print("=================")
names = ["Zhangsan","Lisi","Wangwu"]
print("移除最后一个名字前的列表：%s"%names)
names.pop(1)
print("移除索引=1的名字后的列表：%s"%names)
print("=================")
names = ["Zhangsan","Lisi","Wangwu","Lisi","Zhangsan"]
print("列出所有名字：%s"%names)
input_name = input("输入你要删除的名字:")
for name in names:
    if(name==input_name):
        names.remove(name)
print("删除指定名字后的列表：%s"%names)
names.remove("Zhangsan")
print("删除Zhangsan后的列表：%s"%names)
print("=================")
# 创建并初始化一个元组
names = ("Zhangsan","Lisi","Wangwu")
print(names)
for name in names:
    print("我是:%s"%name)
print("=================")
# 统计姓名"Zhangsan"在元组中的个数
names = ["Zhangsan","Lisi","Wangwu","Lisi","Zhangsan","zhangsan"]
# 把一个列表转化成元组
new_names = tuple(names)
print(new_names)
print("Zhangsan出现的次数:%d"%new_names.count("Zhangsan"))
print("=================")
# 修改元组中的项:Lisi，改为Zhaoliu
names = ['Zhangsan', 'Lisi', 'Wangwu', 'Lisi', 'Zhangsan', 'zhangsan']
new_names = tuple(names)
# 尝试修改
#new_names[1] = "Zhaoliu"
print(new_names)
print("=================")
print("C:\\nowhere")
print(r"C:\\nowhere")
print("=================")
from string import Template
s = Template("I am ${name}, and I love ${thing}.")
print(s.substitute(name="huoty", thing="python"))
print("=================")
TigerChain = {"name":"TigerChain","age":18,"address":"中国陕西","love":["看书","游泳","爬山"]}
for key in TigerChain.keys():
    print("TigerChain 字典中的key:%s"%key)

print("=================")
dict = {"name":"zhangsan","age":18,"height":"165CM"}
print(dict)
for value in dict.values():
    print("dict 字典中的 value: %s"%value)
print("=================")
dict = {"name":"zhangsan","age":18,"height":"165CM"}
print("修改之前的字典：%r"%dict)
dict["name"] = "junjun"
print("修改之后的字典：%r"%dict)