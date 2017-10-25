package defaultArgsDemo;

import java.util.ArrayList;

/**
 * This exercise implements (as succinctly as possible) the Python example 
 * demonstrating that default arguments are evaluated in the context of the 
 * `def` statement. As well as show an example of how to emulate default 
 * arguments in Java using overloading.<p>
 * 
 * <pre>
  def f(a, L=[]):
    L.append(a)
    return L

  print(f(1))
  [1]
  print(f(2))
  [1, 2]
  print(f(3))
  [1, 2, 3]
 
  # versus

  def f(a, L=None):
    if L is None:
      L = []
    L.append(a)
    return L

  print(f(1))
  [1]
  print(f(2))
  [2]
  print(f(3))
  [3]
 
 *</pre>
 * 
 * @author ken
 *
 */
public class DefaultArgsDemo {

	static ArrayList<Object> emptyList = new ArrayList<Object>();
	static ArrayList<Object> noneList = null;
	
	/**
	 * def f(a, L)
	 * 
	 * @param a
	 *            element
	 * @param L
	 *            list
	 *            
	 * @return list with element appended
	 */
	static ArrayList<Object> f(Object a, ArrayList<Object> L) {
		if (L == null) {
			L = new ArrayList<Object>();
		}
		L.add(a);
		return L;
	}

	/**
	 * def f(a, L=[])
	 * 
	 * Could be named "f" for true overloading. Only rename one of these
	 * versions depending on which default arg value is chosen.
	 * 
	 * @param a
	 *            element
	 * 
	 * @return list with element appended
	 */
	static ArrayList<Object> fDefaultEmpty(Object a) {
		return f(a, emptyList);
	}
	
	/**
	 * def f(a, L=None)
	 * 
	 * Could be named "f" for true overloading. Only rename one of these
	 * versions depending on which default arg value is chosen.
	 * 
	 * @param a
	 *            element
	 * @param L

	 * @return new list of element a
	 */
	static ArrayList<Object> fDefaultNone(Object a) {
		return f(a, null);
	}

	public static void main(String[] args) {

		System.out.println(fDefaultEmpty("check"));
		System.out.println(fDefaultEmpty(2));
		System.out.println(fDefaultEmpty("check check"));

		System.out.println(fDefaultNone(1));
		System.out.println(fDefaultNone(2));
		System.out.println(fDefaultNone(3));
		System.out.println(fDefaultNone("let's jam"));

	}

}
