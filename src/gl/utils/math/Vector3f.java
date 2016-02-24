package gl.utils.math;

public class Vector3f {

	public float x, y, z;

	public Vector3f() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	
	public String toString() {
		return "Vector3f(" + x + ", " + y + ", " + z + ")";
	}
	
	//STATIC FUNCTIONS//
	
	public static Vector3f add(Vector3f left, Vector3f right) {
		if(left == null) left = new Vector3f();
		if(right == null) right = new Vector3f();
		return new Vector3f(left.x + right.x, left.y + right.y, left.z + right.z);
	}
	
	public static Vector3f add(Vector3f left, float right) {
		return new Vector3f(left.x + right, left.y + right, left.z + right);
	}
	
	public static Vector3f subtract(Vector3f left, Vector3f right) {
		if(left == null) left = new Vector3f();
		if(right == null) right = new Vector3f();
		return new Vector3f(left.x - right.x, left.y - right.y, left.z - right.z);
	}
	
	public static Vector3f subtract(Vector3f left, float right) {
		if(left == null) left = new Vector3f();
		return new Vector3f(left.x - right, left.y - right, left.z - right);
	}
	
	public static float magnitude(Vector3f vector) {
		if(vector == null) vector = new Vector3f();
		return (float) Math.sqrt((vector.x * vector.x) + (vector.y * vector.y) + (vector.z * vector.z));
	}
	
	public static Vector3f multiply(Vector3f vector, float scalar) {
		if(vector == null) vector = new Vector3f();
		return new Vector3f(scalar * vector.x, scalar * vector.y, scalar * vector.z);
	}
	
	public static float dot(Vector3f left, Vector3f right) {
		if(left == null) left = new Vector3f();
		if(right == null) right = new Vector3f();
		return left.x * right.x + left.y * right.y + left.z * right.z;
	}
	
	public static Vector3f cross(Vector3f left, Vector3f right) {
		if(left == null) left = new Vector3f();
		if(right == null) right = new Vector3f();
		return new Vector3f((left.y * right.z) - (left.z * right.y), (left.z * right.x) - (left.x * right.z), (left.x * right.y) - (left.y * right.x));
	}
}
























