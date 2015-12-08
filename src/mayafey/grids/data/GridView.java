package mayafey.grids.data;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GridView<Type> {
	
	private final Type[] arr;
	private final int[] x;
	private final int[] y;
	
	private int size = 0;
	private int givenSize = 0;
	
	public GridView(Type[] arr)
	{
		this.arr = arr;
		this.x = new int[arr.length];
		this.y = new int[arr.length];
	}
	
	@SuppressWarnings("unchecked")
	public GridView(Class<Type> type, int size)
	{
		this.arr = (Type[]) Array.newInstance(type, size);
		this.x = new int[size];
		this.y = new int[size];
	}
	
	public int size()
	{
		return this.size;
	}
	
	public int getGivenSize()
	{
		return this.givenSize;
	}
	
	public void setGivenSize(int size)
	{
		this.givenSize = size;
	}
	
	/**
	 * xy[0] = X
	 * xy[1] = Y
	 */
	public void getPos(int pos, int[] xy)
	{
		xy[0] = x[pos];
		xy[1] = y[pos];
	}
	
	public Type getObj(int pos)
	{
		return arr[pos];
	}
	
	public void reset()
	{
		Arrays.fill(arr, 0, size, null);
		Arrays.fill(x, 0, size, 0);
		Arrays.fill(y, 0, size, 0);
		size = 0;
	}
	
	public void add(Type obj, int x, int y)
	{
		   arr[size  ] = obj;
		this.x[size  ] = x;
		this.y[size++] = y;
	}

}
