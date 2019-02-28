package net.smartleon.knowledgeplant;
public class DynamicArray {
    public static void main(String[] args)
    {
        int incre = 2; //容量增加量
        int[] firstArray = {1,2,3,4};
        int[] b = new int[firstArray.length+incre];//新数组
        System.arraycopy(firstArray, 0, b, 0, firstArray.length);//将firstArray数组内容复制新数组b
        b[4] = 5;//b数组新增元素
        b[5] = 6;
        firstArray = b;//改变引用
        System.out.println("扩容后数组firstArray容量为为："+firstArray.length+"  数组firstArray内容：");
        for(int i:firstArray) {
            System.out.print(i + "  ");
        }
    }
}
