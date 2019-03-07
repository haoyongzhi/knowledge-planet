### 【Day 5】(2day)
任务时间：请于3月7日22:00前完成。在评论处打卡，逾期未打卡的会被清退出群。

#### 1.file

* 打开文件方式（读写两种方式）

```python
open(file,[option])
#file 是要打开的文件
#option是可选择的参数，常见有 mode等
```
**文件的打开模式**

|参数|说明|
|---|---|
|`r`|只读模式，文件不存在时会报错。|
|`w`|写入模式，文件存在会清空之前的内容，文件不存在则会新建文件。|
|`x`|写入模式，文件存在会报错，文件不存在则会新建文件。|
|`a`|追加写入模式，不清空之前的文件，直接将写入的内容添加到后面。|
|`b`|以二进制模式读写文件，wb,rb,ab。|
|`+`|可读写模式，r+,w+,x+,a+,这几种模式还遵循了r,w,x,a的基本原则。|

**文件的读取**

```python
f.read(size)  #读取文件的内容，将文件的内容以字符串形式返回。
'''size是可选的数值，指定字符串长度，如果没有指定size或者指定为负数，就会读取并返回整个文件。当文件大小为当前机器内存两倍时就会产生问题，反之就尽可能大的size读取和返回数据，如果到了文件末尾，会返回空字符串。
'''

f.readline() #从文件中读取单独一行。
'''字符串结尾会自动加上一个换行符\n，只有当文件最后没有以换行符结尾时，这一操作才会被忽略，这样返回值就不会有混淆。如果返回空字符串，表示到达率文件末尾，如果是空行，就会描述为\n,一个只有换行符的字符串。
'''

f.readlines() #一次读取所有，返回一个列表，列表的元素为文件行的内容。
'''可以通过列表索引的方式将文件的每一行的内容输出。
可以通过for循环迭代输出每一行的信息。
'''
```

**文件的写入**

```
f.write()       #将要写入的内容以字符串的形式通过write方法写入文件中。
f.writelines()  #括号里必须是由字符串元素组成的序列。
```

**保存和关闭**

```
f.flush()
#在读写模式下，当写完的数据想要读取出来时，要先缓存区的内容保存到文件当中。

f.close() 
#关闭文件。对一个已经关闭的文件进行操作会报错。
```

**光标位置**

```
f.tell()            #返回光标在文件中的位置。
f.seek(offset,from) #常用 f.seek(0) 返回起始位置
#在文件中移动文件指针，从from(0代表起始位置，1代表当前位置，2代表文件末尾)偏移offset个字节。
# 常用 f.seek(0，0)  返回起始位置。 其他了解一下
```

**查看文件信息**

```
closed      #查看文件是否已经关闭，返回布尔值。
mode        #返回文件打开模式。
name        #返回文件名。
```

**with 形式打开文件，里面的语句执行完后会自动关闭文件**

```
with open('文件名') as f:
    f.read() 
```
 
* 文件对象的操作方法
file对象使用open函数来创建，下表列出了file对象常用的函数：

|序号|方法|描述|
|---|---|---|
|1	|`file.close()`|关闭文件。关闭后文件不能再进行读写操作。|
|2	|`file.flush()`|刷新文件内部缓冲，直接把内部缓冲区的数据立刻写入文件, 而不是被动的等待输出缓冲区写入。|
|3	|`file.fileno()`|返回一个整型的文件描述符(file descriptor FD 整型), 可以用在如os模块的read方法等一些底层操作上。|
|4	|`file.isatty()`|如果文件连接到一个终端设备返回 True，否则返回 False。|
|5	|`file.next()`|返回文件下一行。|
|6	|`file.read([size])`|从文件读取指定的字节数，如果未给定或为负则读取所有。|
|7	|`file.readline([size])`|读取整行，包括 "\n" 字符。|
|8	|`file.readlines([sizeint])`|读取所有行并返回列表，若给定sizeint>0，返回总和大约为sizeint字节的行, 实际读取值可能比 sizeint 较大, 因为需要填充缓冲区。|
|9	|`file.seek(offset[, whence])`|设置文件当前位置|
|10	|`file.tell()`|返回文件当前位置。|
|11	|`file.truncate([size])`|从文件的首行首字符开始截断，截断文件为 size 个字符，无 size 表示从当前位置截断；截断之后后面的所有字符被删除，其中 Widnows 系统下的换行代表2个字符大小。|
|12	|`file.write(str)`|将字符串写入文件，返回的是写入的字符长度。|
|13	|`file.writelines(sequence)`|向文件写入一个序列字符串列表，如果需要换行则要自己加入每行的换行符。|

* 学习对excel及csv文件进行操作
1 需要用到的库：
1.1 操作xls格式的表格文件：
* 读取：xlrd
* 写入：xlwt
* 修改（追加写入）：xlutils

1.2 操作xlsx格式的表格文件：

* 读取/写入：openpyxl

**实现代码**

操作xls格式的表格文件：

```python
# coding=UTF-8
import xlrd
import xlwt
from xlutils.copy import copy
 
 
def write_excel_xls(path, sheet_name, value):
    index = len(value)  # 获取需要写入数据的行数
    workbook = xlwt.Workbook()  # 新建一个工作簿
    sheet = workbook.add_sheet(sheet_name)  # 在工作簿中新建一个表格
    for i in range(0, index):
        for j in range(0, len(value[i])):
            sheet.write(i, j, value[i][j])  # 像表格中写入数据（对应的行和列）
    workbook.save(path)  # 保存工作簿
    print("xls格式表格写入数据成功！")
 
 
def write_excel_xls_append(path, value):
    index = len(value)  # 获取需要写入数据的行数
    workbook = xlrd.open_workbook(path)  # 打开工作簿
    sheets = workbook.sheet_names()  # 获取工作簿中的所有表格
    worksheet = workbook.sheet_by_name(sheets[0])  # 获取工作簿中所有表格中的的第一个表格
    rows_old = worksheet.nrows  # 获取表格中已存在的数据的行数
    new_workbook = copy(workbook)  # 将xlrd对象拷贝转化为xlwt对象
    new_worksheet = new_workbook.get_sheet(0)  # 获取转化后工作簿中的第一个表格
    for i in range(0, index):
        for j in range(0, len(value[i])):
            new_worksheet.write(i+rows_old, j, value[i][j])  # 追加写入数据，注意是从i+rows_old行开始写入
    new_workbook.save(path)  # 保存工作簿
    print("xls格式表格【追加】写入数据成功！")
 
 
def read_excel_xls(path):
    workbook = xlrd.open_workbook(path)  # 打开工作簿
    sheets = workbook.sheet_names()  # 获取工作簿中的所有表格
    worksheet = workbook.sheet_by_name(sheets[0])  # 获取工作簿中所有表格中的的第一个表格
    for i in range(0, worksheet.nrows):
        for j in range(0, worksheet.ncols):
            print(worksheet.cell_value(i, j), "\t", end="")  # 逐行逐列读取数据
        print()
 
 
book_name_xls = 'xls格式测试工作簿.xls'
 
sheet_name_xls = 'xls格式测试表'
 
value_title = [["姓名", "性别", "年龄", "城市", "职业"],]
 
value1 = [["张三", "男", "19", "杭州", "研发工程师"],
          ["李四", "男", "22", "北京", "医生"],
          ["王五", "女", "33", "珠海", "出租车司机"],]
 
value2 = [["Tom", "男", "21", "西安", "测试工程师"],
          ["Jones", "女", "34", "上海", "产品经理"],
          ["Cat", "女", "56", "上海", "教师"],]
 
 
write_excel_xls(book_name_xls, sheet_name_xls, value_title)
write_excel_xls_append(book_name_xls, value1)
write_excel_xls_append(book_name_xls, value2)
read_excel_xls(book_name_xls)
```

操作xlsx格式的表格文件：

```python
# coding=UTF-8
import openpyxl
 
 
def write_excel_xlsx(path, sheet_name, value):
    index = len(value)
    workbook = openpyxl.Workbook()
    sheet = workbook.active
    sheet.title = sheet_name
    for i in range(0, index):
        for j in range(0, len(value[i])):
            sheet.cell(row=i+1, column=j+1, value=str(value[i][j]))
    workbook.save(path)
    print("xlsx格式表格写入数据成功！")
 
 
def read_excel_xlsx(path, sheet_name):
    workbook = openpyxl.load_workbook(path)
    # sheet = wb.get_sheet_by_name(sheet_name)这种方式已经弃用，不建议使用
    sheet = workbook[sheet_name]
    for row in sheet.rows:
        for cell in row:
            print(cell.value, "\t", end="")
        print()
 
 
book_name_xlsx = 'xlsx格式测试工作簿.xlsx'
 
sheet_name_xlsx = 'xlsx格式测试表'
 
value3 = [["姓名", "性别", "年龄", "城市", "职业"],
          ["111", "女", "66", "石家庄", "运维工程师"],
          ["222", "男", "55", "南京", "饭店老板"],
          ["333", "女", "27", "苏州", "保安"],]
 
 
write_excel_xlsx(book_name_xlsx, sheet_name_xlsx, value3)
read_excel_xlsx(book_name_xlsx, sheet_name_xlsx)
```

**运行结果**

![结果1](https://img-blog.csdn.net/2018082118452784?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTMyNTAwNzE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![结果2](https://img-blog.csdn.net/20180821184956460?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTMyNTAwNzE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![结果3](https://img-blog.csdn.net/20180821184837493?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTMyNTAwNzE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 2.os模块

os.path 模块主要用于获取文件的属性。

以下是 os.path 模块的几种常用方法：

|方法|说明|
|---|---|
|os.path.abspath(path)|返回绝对路径|
|os.path.basename(path)|返回文件名|
|os.path.commonprefix(list)|返回list(多个路径)中，所有path共有的最长的路径|
|os.path.dirname(path)|返回文件路径|
|os.path.exists(path)|路径存在则返回True,路径损坏返回False|
|os.path.lexists|路径存在则返回True,路径损坏也返回True|
|os.path.expanduser(path)|把path中包含的"~"和"~user"转换成用户目录|
|os.path.expandvars(path)|根据环境变量的值替换path中包含的"$name"和"${name}"|
|os.path.getatime(path)|返回最近访问时间（浮点型秒数）|
|os.path.getmtime(path)|返回最近文件修改时间|
|os.path.getctime(path)|返回文件 path 创建时间|
|os.path.getsize(path)|返回文件大小，如果文件不存在就返回错误|
|os.path.isabs(path)|判断是否为绝对路径|
|os.path.isfile(path)|判断路径是否为文件|
|os.path.isdir(path)|判断路径是否为目录|
|os.path.islink(path)|判断路径是否为链接|
|os.path.ismount(path)|判断路径是否为挂载点|
|os.path.join(path1[, path2[, ...]])|把目录和文件名合成一个路径|
|os.path.normcase(path)|转换path的大小写和斜杠|
|os.path.normpath(path)|规范path字符串形式|
|os.path.realpath(path)|返回path的真实路径|
|os.path.relpath(path[, start])|从start开始计算相对路径|
|os.path.samefile(path1, path2)|判断目录或文件是否相同|
|os.path.sameopenfile(fp1, fp2)|判断fp1和fp2是否指向同一文件|
|os.path.samestat(stat1, stat2)|判断stat tuple stat1和stat2是否指向同一个文件|
|os.path.split(path)|把路径分割成 dirname 和 basename，返回一个元组|
|os.path.splitdrive(path)|一般用在 windows 下，返回驱动器名和路径组成的元组|
|os.path.splitext(path)|分割路径，返回路径名和文件扩展名的元组|
|os.path.splitunc(path)|把路径分割为加载点与文件|
|os.path.walk(path, visit, arg)|遍历path，进入每个目录都调用visit函数，visit函数必须有3个参数(arg, dirname, names)，dirname表示当前目录的目录名，names代表当前目录下的所有文件名，args则为walk的第三个参数|
|os.path.supports_unicode_filenames|设置是否支持unicode路径名|

**实例**

以下实例演示了 os.path 相关方法的使用：

```python
import os
print( os.path.basename('/root/runoob.txt') )   # 返回文件名
print( os.path.dirname('/root/runoob.txt') )    # 返回目录路径
print( os.path.split('/root/runoob.txt') )      # 分割文件名与路径
print( os.path.join('root','test','runoob.txt') )  # 将目录和文件名合成一个路径
```

**输出结果**

```
runoob.txt
/root
('/root', 'runoob.txt')
root/test/runoob.txt
```

以下实例输出文件的相关信息。

```python
import os
import time
 
file='/root/runoob.txt' # 文件路径
 
print( os.path.getatime(file) )   # 输出最近访问时间
print( os.path.getctime(file) )   # 输出文件创建时间
print( os.path.getmtime(file) )   # 输出最近修改时间
print( time.gmtime(os.path.getmtime(file)) )  # 以struct_time形式输出最近修改时间
print( os.path.getsize(file) )   # 输出文件大小（字节为单位）
print( os.path.abspath(file) )   # 输出绝对路径
print( os.path.normpath(file) )  # 规范path字符串形式
```

**输出结果**

```
1539052805.5735736
1539052805.5775735
1539052805.5735736
time.struct_time(tm_year=2018, tm_mon=10, tm_mday=9, tm_hour=2, tm_min=40, tm_sec=5, tm_wday=1, tm_yday=282, tm_isdst=0)
7
/root/runoob.txt
/root/runoob.txt
```

#### 3.datetime模块

datetime是Python处理日期和时间的标准库。

获取当前日期和时间

我们先看如何获取当前日期和时间：

```python
from datetime import datetime
now = datetime.now() # 获取当前datetime
print(now)
#2015-05-18 16:28:07.198690
print(type(now))
#<class 'datetime.datetime'>
```

注意到datetime是模块，datetime模块还包含一个datetime类，通过from datetime import datetime导入的才是datetime这个类。

如果仅导入import datetime，则必须引用全名datetime.datetime。

datetime.now()返回当前日期和时间，其类型是datetime。

**获取指定日期和时间**

要指定某个日期和时间，我们直接用参数构造一个datetime：

```python
from datetime import datetime
dt = datetime(2015, 4, 19, 12, 20) # 用指定日期时间创建datetime
print(dt)
#2015-04-19 12:20:00
#datetime转换为timestamp
```

在计算机中，时间实际上是用数字表示的。我们把1970年1月1日 00:00:00 UTC+00:00时区的时刻称为epoch time，记为0（1970年以前的时间timestamp为负数），当前时间就是相对于epoch time的秒数，称为timestamp。

你可以认为：

`timestamp = 0 = 1970-1-1 00:00:00 UTC+0:00`

对应的北京时间是：

`timestamp = 0 = 1970-1-1 08:00:00 UTC+8:00`

可见timestamp的值与时区毫无关系，因为timestamp一旦确定，其UTC时间就确定了，转换到任意时区的时间也是完全确定的，这就是为什么计算机存储的当前时间是以timestamp表示的，因为全球各地的计算机在任意时刻的timestamp都是完全相同的（假定时间已校准）。

把一个datetime类型转换为timestamp只需要简单调用timestamp()方法：

```python
from datetime import datetime
dt = datetime(2015, 4, 19, 12, 20) # 用指定日期时间创建datetime
dt.timestamp() # 把datetime转换为timestamp
#1429417200.0
```

注意Python的timestamp是一个浮点数。如果有小数位，小数位表示毫秒数。

某些编程语言（如Java和JavaScript）的timestamp使用整数表示毫秒数，这种情况下只需要把timestamp除以1000就得到Python的浮点表示方法。

**`timestamp`转换为`datetime`**

要把timestamp转换为datetime，使用datetime提供的fromtimestamp()方法：

```python
from datetime import datetime
t = 1429417200.0
print(datetime.fromtimestamp(t))
#2015-04-19 12:20:00
```

注意到timestamp是一个浮点数，它没有时区的概念，而datetime是有时区的。上述转换是在timestamp和本地时间做转换。

本地时间是指当前操作系统设定的时区。例如北京时区是东8区，则本地时间：

`2015-04-19 12:20:00`

实际上就是UTC+8:00时区的时间：

`2015-04-19 12:20:00 UTC+8:00`

而此刻的格林威治标准时间与北京时间差了8小时，也就是UTC+0:00时区的时间应该是：

`2015-04-19 04:20:00 UTC+0:00`

**timestamp也可以直接被转换到UTC标准时区的时间：**

```python
from datetime import datetime
t = 1429417200.0
print(datetime.fromtimestamp(t)) # 本地时间
#2015-04-19 12:20:00
print(datetime.utcfromtimestamp(t)) # UTC时间
#2015-04-19 04:20:00
#str转换为datetime
```

很多时候，用户输入的日期和时间是字符串，要处理日期和时间，首先必须把str转换为datetime。转换方法是通过datetime.strptime()实现，需要一个日期和时间的格式化字符串：

```python
from datetime import datetime
cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')
print(cday)
#2015-06-01 18:19:59
```

字符串`'%Y-%m-%d %H:%M:%S'`规定了日期和时间部分的格式。详细的说明请参考Python文档。

注意转换后的datetime是没有时区信息的。

**datetime转换为str**

如果已经有了datetime对象，要把它格式化为字符串显示给用户，就需要转换为str，转换方法是通过strftime()实现的，同样需要一个日期和时间的格式化字符串：

```python
from datetime import datetime
now = datetime.now()
print(now.strftime('%a, %b %d %H:%M'))
#Mon, May 05 16:28
```
datetime加减

对日期和时间进行加减实际上就是把datetime往后或往前计算，得到新的datetime。加减可以直接用+和-运算符，不过需要导入timedelta这个类：

```python
from datetime import datetime, timedelta
now = datetime.now()
now
#datetime.datetime(2015, 5, 18, 16, 57, 3, 540997)
now + timedelta(hours=10)
#datetime.datetime(2015, 5, 19, 2, 57, 3, 540997)
now - timedelta(days=1)
#datetime.datetime(2015, 5, 17, 16, 57, 3, 540997)
now + timedelta(days=2, hours=12)
#datetime.datetime(2015, 5, 21, 4, 57, 3, 540997)
```

可见，使用timedelta你可以很容易地算出前几天和后几天的时刻。

**本地时间转换为UTC时间**

本地时间是指系统设定时区的时间，例如北京时间是UTC+8:00时区的时间，而UTC时间指UTC+0:00时区的时间。

一个datetime类型有一个时区属性tzinfo，但是默认为None，所以无法区分这个datetime到底是哪个时区，除非强行给datetime设置一个时区：

```python
from datetime import datetime, timedelta, timezone
tz_utc_8 = timezone(timedelta(hours=8)) # 创建时区UTC+8:00
now = datetime.now()
now
#datetime.datetime(2015, 5, 18, 17, 2, 10, 871012)
dt = now.replace(tzinfo=tz_utc_8) # 强制设置为UTC+8:00
dt
#datetime.datetime(2015, 5, 18, 17, 2, 10, 871012, tzinfo=datetime.timezone(datetime.timedelta(0, 28800)))
```

如果系统时区恰好是UTC+8:00，那么上述代码就是正确的，否则，不能强制设置为UTC+8:00时区。

**时区转换**

我们可以先通过`utcnow()`拿到当前的UTC时间，再转换为任意时区的时间：

```python
# 拿到UTC时间，并强制设置时区为UTC+0:00:
utc_dt = datetime.utcnow().replace(tzinfo=timezone.utc)
print(utc_dt)
#2015-05-18 09:05:12.377316+00:00
# astimezone()将转换时区为北京时间:
bj_dt = utc_dt.astimezone(timezone(timedelta(hours=8)))
print(bj_dt)
#2015-05-18 17:05:12.377316+08:00
# astimezone()将转换时区为东京时间:
tokyo_dt = utc_dt.astimezone(timezone(timedelta(hours=9)))
#print(tokyo_dt)
2015-05-18 18:05:12.377316+09:00
# astimezone()将bj_dt转换时区为东京时间:
tokyo_dt2 = bj_dt.astimezone(timezone(timedelta(hours=9)))
print(tokyo_dt2)
#2015-05-18 18:05:12.377316+09:00
```

时区转换的关键在于，拿到一个datetime时，要获知其正确的时区，然后强制设置时区，作为基准时间。

利用带时区的datetime，通过astimezone()方法，可以转换到任意时区。

注：不是必须从UTC+0:00时区转换到其他时区，任何带时区的datetime都可以正确转换，例如上述bj_dt到tokyo_dt的转换。

**小结**

datetime表示的时间需要时区信息才能确定一个特定的时间，否则只能视为本地时间。

如果要存储datetime，最佳方法是将其转换为timestamp再存储，因为timestamp的值与时区完全无关。

#### 4.类和对象

面向对象最重要的概念就是类（Class）和实例（Instance），必须牢记类是抽象的模板，比如Student类，而实例是根据类创建出来的一个个具体的“对象”，每个对象都拥有相同的方法，但各自的数据可能不同。

仍以Student类为例，在Python中，定义类是通过class关键字：

```
class Student(object):
    pass
```

class后面紧接着是类名，即Student，类名通常是大写开头的单词，紧接着是(object)，表示该类是从哪个类继承下来的，继承的概念我们后面再讲，通常，如果没有合适的继承类，就使用object类，这是所有类最终都会继承的类。

定义好了Student类，就可以根据Student类创建出Student的实例，创建实例是通过类名+()实现的：

```python
bart = Student()
bart
#<__main__.Student object at 0x10a67a590>
Student
#<class '__main__.Student'>
```

可以看到，变量bart指向的就是一个Student的实例，后面的0x10a67a590是内存地址，每个object的地址都不一样，而Student本身则是一个类。

可以自由地给一个实例变量绑定属性，比如，给实例bart绑定一个name属性：

```python
bart.name = 'Bart Simpson'
bart.name
#'Bart Simpson'
```

由于类可以起到模板的作用，因此，可以在创建实例的时候，把一些我们认为必须绑定的属性强制填写进去。通过定义一个特殊的__init__方法，在创建实例的时候，就把name，score等属性绑上去：

```python
class Student(object):

    def __init__(self, name, score):
        self.name = name
        self.score = score
```

 注意：特殊方法“__init__”前后分别有两个下划线！！！

注意到__init__方法的第一个参数永远是self，表示创建的实例本身，因此，在__init__方法内部，就可以把各种属性绑定到self，因为self就指向创建的实例本身。

有了__init__方法，在创建实例的时候，就不能传入空的参数了，必须传入与__init__方法匹配的参数，但self不需要传，Python解释器自己会把实例变量传进去：

```python
bart = Student('Bart Simpson', 59)
bart.name
#'Bart Simpson'
bart.score
#59
```

和普通的函数相比，在类中定义的函数只有一点不同，就是第一个参数永远是实例变量self，并且，调用时，不用传递该参数。除此之外，类的方法和普通函数没有什么区别，所以，你仍然可以用默认参数、可变参数、关键字参数和命名关键字参数。

**数据封装**

面向对象编程的一个重要特点就是数据封装。在上面的Student类中，每个实例就拥有各自的name和score这些数据。我们可以通过函数来访问这些数据，比如打印一个学生的成绩：

```python
def print_score(std):
     print('%s: %s' % (std.name, std.score))

print_score(bart)
#Bart Simpson: 59
```

但是，既然Student实例本身就拥有这些数据，要访问这些数据，就没有必要从外面的函数去访问，可以直接在Student类的内部定义访问数据的函数，这样，就把“数据”给封装起来了。这些封装数据的函数是和Student类本身是关联起来的，我们称之为类的方法：

```python
class Student(object):

    def __init__(self, name, score):
        self.name = name
        self.score = score

    def print_score(self):
        print('%s: %s' % (self.name, self.score))
```

要定义一个方法，除了第一个参数是self外，其他和普通函数一样。要调用一个方法，只需要在实例变量上直接调用，除了self不用传递，其他参数正常传入：

```python
bart.print_score()
#Bart Simpson: 59
```

这样一来，我们从外部看Student类，就只需要知道，创建实例需要给出name和score，而如何打印，都是在Student类的内部定义的，这些数据和逻辑被“封装”起来了，调用很容易，但却不用知道内部实现的细节。

封装的另一个好处是可以给Student类增加新的方法，比如get_grade：

```python
class Student(object):

    def get_grade(self):
        if self.score >= 90:
            return 'A'
        elif self.score >= 60:
            return 'B'
        else:
            return 'C'
```

同样的，get_grade方法可以直接在实例变量上调用，不需要知道内部实现细节：

```python
class Student(object):
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def get_grade(self):
        if self.score >= 90:
            return 'A'
        elif self.score >= 60:
            return 'B'
        else:
            return 'C'

lisa = Student('Lisa', 99)
bart = Student('Bart', 59)
print(lisa.name, lisa.get_grade())
print(bart.name, bart.get_grade())
```

**小结**

类是创建实例的模板，而实例则是一个一个具体的对象，各个实例拥有的数据都互相独立，互不影响；

方法就是与实例绑定的函数，和普通函数不同，方法可以直接访问实例的数据；

通过在实例上调用方法，我们就直接操作了对象内部的数据，但无需知道方法内部的实现细节。

和静态语言不同，Python允许对实例变量绑定任何数据，也就是说，对于两个实例变量，虽然它们都是同一个类的不同实例，但拥有的变量名称都可能不同：

```python
bart = Student('Bart Simpson', 59)
lisa = Student('Lisa Simpson', 87)
bart.age = 8
bart.age
#8
lisa.age
#Traceback (most recent call last):
# File "<stdin>", line 1, in <module>
#AttributeError: 'Student' object has no attribute 'age'
```

#### 5.正则表达式

#### 6.re模块

#### 7.http请求