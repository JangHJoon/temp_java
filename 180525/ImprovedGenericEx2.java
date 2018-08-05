class ValueHolder<T>{  //generic class

	private T value;

	public ValueHolder(T value) {  
		this.value = value;   
	}

	public T getValue() {  
		return value;  
	}
}

public class ImprovedGenericEx2{

	public static <T> ValueHolder<T>[] doBadThing(ValueHolder<T>... values) { //Varargs
	// public static <String> ValueHolder<String>[] doBadThing(ValueHolder<String>... values)

		Object[] objs = values;  
		objs[0] = new ValueHolder<Integer>(10);  
		return values;  

	}

	public static void main(String[] args) {  		
		
		ValueHolder<String>[] result = doBadThing(new ValueHolder<String>("foo"), new ValueHolder<String>("bar"));

		for (ValueHolder<String> holder : result) {  
			String value = holder.getValue(); // ClassCastException ¹ß»ý  
			System.out.println(value);  
		}
	}



}
