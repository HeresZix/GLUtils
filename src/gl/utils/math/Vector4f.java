package gl.utils.math;

public class Vector4f {

	public float x, y, z, w;

	public Vector4f() {
		x = 0;
		y = 0;
		z = 0;
		w = 0;
	}
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getZ() {
		return z;
	}
	
	public void setZ(float z) {
		this.z = z;
	}
	
	public float getW() {
		return w;
	}
	
	public void setW(float w) {
		this.w = w;
	}
	
	public String toString() {
		return "Vector4f(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
	
	//STATIC FUNCTIONS//
	
	public static Vector4f add(Vector4f left, Vector4f right) {
		if(left == null) left = new Vector4f();
		if(right == null) right = new Vector4f();
		return new Vector4f(left.x + right.x, left.y + right.y, left.z + right.z, left.w + right.w);
	}
	
	public static Vector4f add(Vector4f left, float right) {
		return new Vector4f(left.x + right, left.y + right, left.z + right, left.w + right);
	}
	
	public static Vector4f subtract(Vector4f left, Vector4f right) {
		if(left == null) left = new Vector4f();
		if(right == null) right = new Vector4f();
		return new Vector4f(left.x - right.x, left.y - right.y, left.z - right.z, left.w - right.w);
	}
	
	public static Vector4f subtract(Vector4f left, float right) {
		if(left == null) left = new Vector4f();
		return new Vector4f(left.x - right, left.y - right, left.z - right, left.w - right);
	}
	
	public static float magnitude(Vector4f vector) {
		if(vector == null) vector = new Vector4f();
		return (float) Math.sqrt((vector.x * vector.x) + (vector.y * vector.y) + (vector.z * vector.z) + (vector.w * vector.w));
	}
	
	public static Vector4f multiply(Vector4f vector, float scalar) {
		if(vector == null) vector = new Vector4f();
		return new Vector4f(scalar * vector.x, scalar * vector.y, scalar * vector.z, scalar * vector.w);
	}
	
	public static float dot(Vector4f left, Vector4f right) {
		if(left == null) left = new Vector4f();
		if(right == null) right = new Vector4f();
		return left.x * right.x + left.y * right.y + left.z * right.z + left.w * right.w;
	}
	
	public static Vector4f cross(Vector4f left, Vector4f right) {
		if(left == null) left = new Vector4f();
		if(right == null) right = new Vector4f();
		return new Vector4f((left.y * right.z) - (left.z * right.y), (left.z * right.x) - (left.x * right.z), (left.x * right.y) - (left.y * right.x), 0.0f);
	}
}
























