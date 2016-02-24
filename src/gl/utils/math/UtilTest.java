package gl.utils.math;

public class UtilTest {

	public static void main(String[] args) {
		Matrix4f one = Matrix4f.identity();
		Matrix4f.multiply(one, 4.0f, null);
		System.out.println(one.toString());
		Matrix4f.invert(one, null);
		System.out.println(one.toString());
	}
}
