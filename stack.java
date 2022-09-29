    public class stack {
	 static int top1;
	 static int[] excelcol;
	 static int top2;
	 static int[] temp;

    	public static class Stack1{
		public Stack1(int len){
			top1=-1;
			excelcol= new int[len];
		}
		
		public static void push1(int data)
		{
			top1=top1+1;
			excelcol[top1]=data;
		}
		public static int pop1()
		{
			int temp;
			temp=excelcol[top1];
			excelcol[top1]=' ';
			top1=top1-1;
			return temp;
   		}
	}
	public static class Stack2
	{
		public Stack2(int len)
		{
			top2=-1;
			temp= new int[len];
		}
		
		public static void push2(int data)
		{
			top2=top2+1;
			temp[top2]=data;
		}
		public static int pop2()
		{
			int tem;
			tem=temp[top2];
			temp[top2]=' ';
			top2=top2-1;
			return tem;
		}
	}
	public static void undo()
	{
		int temp;
		temp=Stack1.pop1();
		Stack2.push2(temp);
	}
	public static void redo()
	{
		int temp;
		temp=Stack2.pop2();
		Stack1.push1(temp);	
	}
	public static void enter(int data)
	{
		Stack1.push1(data);
	}
	public static void Displayexcelcoloumn()
	{
		int len=top1;
		for(int i=0;i<=top1;i++)
		{
			System.out.println(excelcol[i]);
		}
	}
	public static void main(String[]args)
	{
		Stack1 obj=new Stack1(15);
		Stack2 obj1=new Stack2(15);
		for (int i=0;i<15;i++)
		{
			stack.enter(i);
		}
		
		System.out.println("elements entered");
		System.out.println();
		stack.Displayexcelcoloumn();
		
		
		stack.undo();
		stack.undo();
		System.out.println("elements after undo");
		System.out.println();
		stack.Displayexcelcoloumn();
		
		
		System.out.println("elements after redo");
		System.out.println();
		stack.redo();
		stack.redo();
		stack.Displayexcelcoloumn();
		
	}
}