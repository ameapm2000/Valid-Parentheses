public class Solution 
{
	public static void main(String args[])
	{
		Solution s = new Solution();
		System.out.print(s.isValid("([])"));
	}
	
    int top = -1;
	public boolean isValid(String s)
	{
		int []stack = new int[s.length()];
		if(s.length() % 2 != 0)
        {
        	return false;
        }
		for(int i=0;i<s.length();i++)
		{
			if((int)s.charAt(i) == 40 || (int)s.charAt(i) == 91 || (int)s.charAt(i) == 123)
			{
				Push(stack,(int)s.charAt(i));
			}
			else if((int)s.charAt(i) == 41 || (int)s.charAt(i) == 93 || (int)s.charAt(i) == 125)
			{
			    if(top == -1)
			        return false;
				if(Peep(stack) == 40 && (int)s.charAt(i) == 41)
				{
					Pop(stack);
				}
				else if(Peep(stack) == 91 && (int)s.charAt(i) == 93)
				{
					Pop(stack);
				}
				else if(Peep(stack) == 123 && (int)s.charAt(i) == 125)
				{
					Pop(stack);
				}
			}
		}
		
		if(top == -1)
			return true;
		else
			return false;
	}
	
	public int Peep(int []stack)
	{
		return stack[top];
	}
	
	public void Push(int []stack,int n)
	{
		if(top != stack.length)
			stack[++top] = n;
	}
	
	public int Pop(int []stack)
	{
		if(top != -1)
			return stack[top--];
		else
			return 0;
			
	}   
}