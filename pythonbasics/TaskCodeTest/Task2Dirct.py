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