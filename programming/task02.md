## 【任务2 - 栈、队列、递归】

首先回顾一下数组，数组更多的是用来进行数据的存储，纯粹用来存储数据的数据结构，我们期望数组的插入、删除和查找性能都比较好。对于无序数组，插入快，但是删除和查找都很慢。

栈和队列更多是作为程序员构思算法的辅助工具，而非完全的数据存储工具。这些数据结构的生命周期比数据库类型的结构要短得多，在程序执行期间它们才被创建，通常用它们去执行某项特殊的业务，执行完成之后，它们就被销毁。

### 栈

**栈的基本概念**

栈（英语：stack）又称为堆栈或堆叠，栈作为一种数据结构，是一种只能在一端(称为栈顶(top))进行插入和删除操作的特殊线性表。它按照先进后出的原则存储数据，先进入的数据被压入栈底，最后的数据在栈顶，需要读数据的时候从栈顶开始弹出数据（最后一个数据被第一个读出来）。栈具有记忆作用，对栈的插入与删除操作中，不需要改变栈底指针。

栈是允许在同一端进行插入和删除操作的特殊线性表。允许进行插入和删除操作的一端称为栈顶(top)，另一端为栈底(bottom)；栈底固定，而栈顶浮动；栈中元素个数为零时称为空栈。插入一般称为进栈（PUSH），删除则称为退栈（POP）。

由于堆叠数据结构只允许在一端进行操作，因而按照后进先出（LIFO, Last In First Out）的原理运作。栈也称为后进先出表。

这里以羽毛球筒为例，羽毛球筒就是一个栈，刚开始羽毛球筒是空的，也就是空栈，然后我们一个一个放入羽毛球，也就是一个一个push进栈，当我们需要使用羽毛球的时候，从筒里面拿，也就是pop出栈，但是第一个拿到的羽毛球是我们最后放进去的。

#### 用数组实现一个顺序栈

```
package com.ys.datastructure;

public class MyStack {
	private int[] array;
	private int maxSize;
	private int top;

	public MyStack(int size) {
		this.maxSize = size;
		array = new int[size];
		top = -1;
	}

	// 压入数据
	public void push(int value) {
		if (top < maxSize - 1) {
			array[++top] = value;
		}
	}

	// 弹出栈顶数据
	public int pop() {
		return array[top--];
	}

	// 访问栈顶数据
	public int peek() {
		return array[top];
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return (top == -1);
	}

	// 判断栈是否满了
	public boolean isFull() {
		return (top == maxSize - 1);
	}

}
```

测试：

```
package com.ys.test;

import com.ys.datastructure.MyStack;

public class MyStackTest {
	public static void main(String[] args) {
		MyStack stack = new MyStack(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
```

结果：

```
3
3
2
1
```

这个栈是用数组实现的，内部定义了一个数组，一个表示最大容量的值以及一个指向栈顶元素的top变量。构造方法根据参数规定的容量创建一个新栈，push()方法是向栈中压入元素，指向栈顶的变量top加一，使它指向原顶端数据项上面的一个位置，并在这个位置上存储一个数据。pop()方法返回top变量指向的元素，然后将top变量减一，便移除了数据项。要知道 top 变量指向的始终是栈顶的元素。

**产生的问题：**

* 上面栈的实现初始化容量之后，后面是不能进行扩容的（虽然栈不是用来存储大量数据的），如果说后期数据量超过初始容量之后怎么办？（自动扩容）
* 我们是用数组实现栈，在定义数组类型的时候，也就规定了存储在栈中的数据类型，那么同一个栈能不能存储不同类型的数据呢？（声明为Object）
* 栈需要初始化容量，而且数组实现的栈元素都是连续存储的，那么能不能不初始化容量呢？（改为由链表实现）

#### 用链表实现一个链式栈
对于上面出现的问题，第一个能自动扩容，第二个能存储各种不同类型的数据，解决办法如下：（第三个在讲链表的时候在介绍）

这个模拟的栈在JDK源码中，大家可以参考 Stack 类的实现。

```
public
class Stack<E> extends Vector<E>
```

demo:
```
package com.ys.datastructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {
	// 存储元素的数组,声明为Object类型能存储任意类型的数据
	private Object[] elementData;
	// 指向栈顶的指针
	private int top;
	// 栈的总容量
	private int size;

	// 默认构造一个容量为10的栈
	public ArrayStack() {
		this.elementData = new Object[10];
		this.top = -1;
		this.size = 10;
	}

	public ArrayStack(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("栈初始容量不能小于0: " + initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
		this.top = -1;
		this.size = initialCapacity;
	}

	// 压入元素
	public Object push(Object item) {
		// 是否需要扩容
		isGrow(top + 1);
		elementData[++top] = item;
		return item;
	}

	// 弹出栈顶元素
	public Object pop() {
		Object obj = peek();
		remove(top);
		return obj;
	}

	// 获取栈顶元素
	public Object peek() {
		if (top == -1) {
			throw new EmptyStackException();
		}
		return elementData[top];
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return (top == -1);
	}

	// 删除栈顶元素
	public void remove(int top) {
		// 栈顶元素置为null
		elementData[top] = null;
		this.top--;
	}

	/**
	 * 是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
	 * 
	 * @param minCapacity
	 * @return
	 */
	public boolean isGrow(int minCapacity) {
		int oldCapacity = size;
		// 如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
		if (minCapacity >= oldCapacity) {
			// 定义扩大之后栈的总容量
			int newCapacity = 0;
			// 栈容量扩大两倍(左移一位)看是否超过int类型所表示的最大范围
			if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
				newCapacity = Integer.MAX_VALUE;
			} else {
				newCapacity = (oldCapacity << 1);// 左移一位，相当于*2
			}
			this.size = newCapacity;
			int[] newArray = new int[size];
			elementData = Arrays.copyOf(elementData, size);
			return true;
		} else {
			return false;
		}
	}
}
```

测试：
```
//测试自定义栈类 ArrayStack
//创建容量为3的栈，然后添加4个元素，3个int，1个String.
@Test
public void testArrayStack(){
	 ArrayStack stack = new ArrayStack(3);
	 stack.push(1);
	 //System.out.println(stack.peek());
	 stack.push(2);
	 stack.push(3);
	 stack.push("abc");
	 System.out.println(stack.peek());
	 stack.pop();
	 stack.pop();
	 stack.pop();
	 System.out.println(stack.peek());
}
```

结果：

```
abc
1
```

#### 编程模拟实现一个浏览器的前进、后退功能

**整体思路**

用两个栈来实现。

一个栈用来做页面前面的保存，一个栈做退出的保存页面链接。

比如从a ->b ->c 那么栈就存储了a,b,c 元素 。倒退那么就把c放到第二个栈中。c,b,a。这样就保存了下来这些链接内容，知道怎么前进与退出了

#### 栈总结

栈通过提供限制性的访问方法push()和pop()，使得程序不容易出错。

对于栈的实现，我们稍微分析就知道，数据入栈和出栈的时间复杂度都为O(1)，也就是说栈操作所耗的时间不依赖栈中数据项的个数，因此操作时间很短。而且需要注意的是栈不需要比较和移动操作，我们不要画蛇添足。

### 队列

#### 用数组实现一个顺序队列

#### 用链表实现一个链式队列

#### 实现一个循环队列

### 递归

#### 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)

#### 编程实现求阶乘 n!

#### 编程实现一组数据集合的全排列