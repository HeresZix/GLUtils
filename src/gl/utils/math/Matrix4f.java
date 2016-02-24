package gl.utils.math;

public class Matrix4f {

	public float m00;
	public float m01;
	public float m02;
	public float m03;
	public float m10;
	public float m11;
	public float m12;
	public float m13;
	public float m20;
	public float m21;
	public float m22;
	public float m23;
	public float m30;
	public float m31;
	public float m32;
	public float m33;

	public Matrix4f() {
		zero();
	}

	public Matrix4f(Matrix4f matrix) {
		m00 = matrix.m00;
		m01 = matrix.m01;
		m02 = matrix.m02;
		m03 = matrix.m03;
		m10 = matrix.m10;
		m11 = matrix.m11;
		m12 = matrix.m12;
		m13 = matrix.m13;
		m20 = matrix.m20;
		m21 = matrix.m21;
		m22 = matrix.m22;
		m23 = matrix.m23;
		m30 = matrix.m30;
		m31 = matrix.m31;
		m32 = matrix.m32;
		m33 = matrix.m33;
	}

	public float determinant() {
		float f = m00 * ((m11 * m22 * m33 + m12 * m23 * m31 + m13 * m21 * m32) - m13 * m22 * m31 - m11 * m23 * m32
				- m12 * m21 * m33);
		f -= m01 * ((m10 * m22 * m33 + m12 * m23 * m30 + m13 * m20 * m32) - m13 * m22 * m30 - m10 * m23 * m32
				- m12 * m20 * m33);
		f += m02 * ((m10 * m21 * m33 + m11 * m23 * m30 + m13 * m20 * m31) - m13 * m21 * m30 - m10 * m23 * m31
				- m11 * m20 * m33);
		f -= m03 * ((m10 * m21 * m32 + m11 * m22 * m30 + m12 * m20 * m31) - m12 * m21 * m30 - m10 * m22 * m31
				- m11 * m20 * m32);
		return f;
	}

	public void zero() {
		m00 = 0.0f;
		m01 = 0.0f;
		m02 = 0.0f;
		m03 = 0.0f;
		m10 = 0.0f;
		m11 = 0.0f;
		m12 = 0.0f;
		m13 = 0.0f;
		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 0.0f;
		m23 = 0.0f;
		m30 = 0.0f;
		m31 = 0.0f;
		m32 = 0.0f;
		m33 = 0.0f;
	}

	public static Matrix4f identity() {
		Matrix4f result = new Matrix4f();
		result.m00 = 1.0f;
		result.m11 = 1.0f;
		result.m22 = 1.0f;
		result.m33 = 1.0f;

		return result;
	}

	public static Matrix4f orthographic(float left, float right, float bottom, float top, float near, float far) {
		Matrix4f result = identity();

		result.m00 = 2.0f / (right - left);
		result.m11 = 2.0f / (top - bottom);
		result.m22 = 2.0f / (near - far);

		result.m03 = (left + right) / (left - right);
		result.m13 = (bottom + top) / (bottom - top);
		result.m23 = (far + near) / (far - near);

		return result;
	}

	public static Matrix4f add(Matrix4f left, Matrix4f right, Matrix4f dest) {
		if (left == null)
			left = new Matrix4f();
		if (right == null)
			right = new Matrix4f();

		if (dest == null) {
			left.m00 += right.m00;
			left.m01 += right.m01;
			left.m02 += right.m02;
			left.m03 += right.m03;
			left.m10 += right.m10;
			left.m11 += right.m11;
			left.m12 += right.m12;
			left.m13 += right.m13;
			left.m20 += right.m20;
			left.m21 += right.m21;
			left.m22 += right.m22;
			left.m23 += right.m23;
			left.m30 += right.m30;
			left.m31 += right.m31;
			left.m32 += right.m32;
			return left;
		} else {
			dest.m00 = left.m00 + right.m00;
			dest.m01 = left.m01 + right.m01;
			dest.m02 = left.m02 + right.m02;
			dest.m03 = left.m03 + right.m03;
			dest.m10 = left.m10 + right.m10;
			dest.m11 = left.m11 + right.m11;
			dest.m12 = left.m12 + right.m12;
			dest.m13 = left.m13 + right.m13;
			dest.m20 = left.m20 + right.m20;
			dest.m21 = left.m21 + right.m21;
			dest.m22 = left.m22 + right.m22;
			dest.m23 = left.m23 + right.m23;
			dest.m30 = left.m30 + right.m30;
			dest.m31 = left.m31 + right.m31;
			dest.m32 = left.m32 + right.m32;
			dest.m33 = left.m33 + right.m33;
			return dest;
		}
	}

	public static Matrix4f subtract(Matrix4f left, Matrix4f right, Matrix4f dest) {
		if (left == null)
			left = new Matrix4f();
		if (right == null)
			right = new Matrix4f();

		if (dest == null) {
			left.m00 -= right.m00;
			left.m01 -= right.m01;
			left.m02 -= right.m02;
			left.m03 -= right.m03;
			left.m10 -= right.m10;
			left.m11 -= right.m11;
			left.m12 -= right.m12;
			left.m13 -= right.m13;
			left.m20 -= right.m20;
			left.m21 -= right.m21;
			left.m22 -= right.m22;
			left.m23 -= right.m23;
			left.m30 -= right.m30;
			left.m31 -= right.m31;
			left.m32 -= right.m32;
			return left;
		} else {
			dest.m00 = left.m00 - right.m00;
			dest.m01 = left.m01 - right.m01;
			dest.m02 = left.m02 - right.m02;
			dest.m03 = left.m03 - right.m03;
			dest.m10 = left.m10 - right.m10;
			dest.m11 = left.m11 - right.m11;
			dest.m12 = left.m12 - right.m12;
			dest.m13 = left.m13 - right.m13;
			dest.m20 = left.m20 - right.m20;
			dest.m21 = left.m21 - right.m21;
			dest.m22 = left.m22 - right.m22;
			dest.m23 = left.m23 - right.m23;
			dest.m30 = left.m30 - right.m30;
			dest.m31 = left.m31 - right.m31;
			dest.m32 = left.m32 - right.m32;
			dest.m33 = left.m33 - right.m33;
			return dest;
		}
	}

	public static Matrix4f multiply(Matrix4f matrix, float scalar, Matrix4f dest) {
		if(dest == null) {
			matrix.m00 = matrix.m00 * scalar;
			matrix.m01 = matrix.m01 * scalar;
			matrix.m02 = matrix.m02 * scalar;
			matrix.m03 = matrix.m03 * scalar;
			matrix.m10 = matrix.m10 * scalar;
			matrix.m11 = matrix.m11 * scalar;
			matrix.m12 = matrix.m12 * scalar;
			matrix.m13 = matrix.m13 * scalar;
			matrix.m20 = matrix.m20 * scalar;
			matrix.m21 = matrix.m21 * scalar;
			matrix.m22 = matrix.m22 * scalar;
			matrix.m23 = matrix.m23 * scalar;
			matrix.m30 = matrix.m30 * scalar;
			matrix.m31 = matrix.m31 * scalar;
			matrix.m32 = matrix.m32 * scalar;
			matrix.m33 = matrix.m33 * scalar;
			return matrix;
		} else {
			dest.m00 = matrix.m00 * scalar;
			dest.m01 = matrix.m01 * scalar;
			dest.m02 = matrix.m02 * scalar;
			dest.m03 = matrix.m03 * scalar;
			dest.m10 = matrix.m10 * scalar;
			dest.m11 = matrix.m11 * scalar;
			dest.m12 = matrix.m12 * scalar;
			dest.m13 = matrix.m13 * scalar;
			dest.m20 = matrix.m20 * scalar;
			dest.m21 = matrix.m21 * scalar;
			dest.m22 = matrix.m22 * scalar;
			dest.m23 = matrix.m23 * scalar;
			dest.m30 = matrix.m30 * scalar;
			dest.m31 = matrix.m31 * scalar;
			dest.m32 = matrix.m32 * scalar;
			dest.m33 = matrix.m33 * scalar;
			return dest;
		}
	}

	public static Matrix4f invert(Matrix4f matrix, Matrix4f dest) {
		if (matrix == null)
			matrix = Matrix4f.identity();
		float determinant = matrix.determinant();
		if (dest == null) {
			float determinant_inv = 1f/determinant;
			
			float t00 =  determinant3(matrix.m11, matrix.m12, matrix.m13, matrix.m21, matrix.m22, matrix.m23, matrix.m31, matrix.m32, matrix.m33);
			float t01 = -determinant3(matrix.m10, matrix.m12, matrix.m13, matrix.m20, matrix.m22, matrix.m23, matrix.m30, matrix.m32, matrix.m33);
			float t02 =  determinant3(matrix.m10, matrix.m11, matrix.m13, matrix.m20, matrix.m21, matrix.m23, matrix.m30, matrix.m31, matrix.m33);
			float t03 = -determinant3(matrix.m10, matrix.m11, matrix.m12, matrix.m20, matrix.m21, matrix.m22, matrix.m30, matrix.m31, matrix.m32);

			float t10 = -determinant3(matrix.m01, matrix.m02, matrix.m03, matrix.m21, matrix.m22, matrix.m23, matrix.m31, matrix.m32, matrix.m33);
			float t11 =  determinant3(matrix.m00, matrix.m02, matrix.m03, matrix.m20, matrix.m22, matrix.m23, matrix.m30, matrix.m32, matrix.m33);
			float t12 = -determinant3(matrix.m00, matrix.m01, matrix.m03, matrix.m20, matrix.m21, matrix.m23, matrix.m30, matrix.m31, matrix.m33);
			float t13 =  determinant3(matrix.m00, matrix.m01, matrix.m02, matrix.m20, matrix.m21, matrix.m22, matrix.m30, matrix.m31, matrix.m32);

			float t20 =  determinant3(matrix.m01, matrix.m02, matrix.m03, matrix.m11, matrix.m12, matrix.m13, matrix.m31, matrix.m32, matrix.m33);
			float t21 = -determinant3(matrix.m00, matrix.m02, matrix.m03, matrix.m10, matrix.m12, matrix.m13, matrix.m30, matrix.m32, matrix.m33);
			float t22 =  determinant3(matrix.m00, matrix.m01, matrix.m03, matrix.m10, matrix.m11, matrix.m13, matrix.m30, matrix.m31, matrix.m33);
			float t23 = -determinant3(matrix.m00, matrix.m01, matrix.m02, matrix.m10, matrix.m11, matrix.m12, matrix.m30, matrix.m31, matrix.m32);

			float t30 = -determinant3(matrix.m01, matrix.m02, matrix.m03, matrix.m11, matrix.m12, matrix.m13, matrix.m21, matrix.m22, matrix.m23);
			float t31 =  determinant3(matrix.m00, matrix.m02, matrix.m03, matrix.m10, matrix.m12, matrix.m13, matrix.m20, matrix.m22, matrix.m23);
			float t32 = -determinant3(matrix.m00, matrix.m01, matrix.m03, matrix.m10, matrix.m11, matrix.m13, matrix.m20, matrix.m21, matrix.m23);
			float t33 =  determinant3(matrix.m00, matrix.m01, matrix.m02, matrix.m10, matrix.m11, matrix.m12, matrix.m20, matrix.m21, matrix.m22);

			matrix.m00 = t00 * determinant_inv;
			matrix.m11 = t11 * determinant_inv;
			matrix.m22 = t22 * determinant_inv;
			matrix.m33 = t33 * determinant_inv;
			matrix.m01 = t10 * determinant_inv;
			matrix.m10 = t01 * determinant_inv;
			matrix.m20 = t02 * determinant_inv;
			matrix.m02 = t20 * determinant_inv;
			matrix.m12 = t21 * determinant_inv;
			matrix.m21 = t12 * determinant_inv;
			matrix.m03 = t30 * determinant_inv;
			matrix.m30 = t03 * determinant_inv;
			matrix.m13 = t31 * determinant_inv;
			matrix.m31 = t13 * determinant_inv;
			matrix.m32 = t23 * determinant_inv;
			matrix.m23 = t32 * determinant_inv;
			
			return matrix;
		} else {
			float determinant_inv = 1f/determinant;
			
			float t00 =  determinant3(matrix.m11, matrix.m12, matrix.m13, matrix.m21, matrix.m22, matrix.m23, matrix.m31, matrix.m32, matrix.m33);
			float t01 = -determinant3(matrix.m10, matrix.m12, matrix.m13, matrix.m20, matrix.m22, matrix.m23, matrix.m30, matrix.m32, matrix.m33);
			float t02 =  determinant3(matrix.m10, matrix.m11, matrix.m13, matrix.m20, matrix.m21, matrix.m23, matrix.m30, matrix.m31, matrix.m33);
			float t03 = -determinant3(matrix.m10, matrix.m11, matrix.m12, matrix.m20, matrix.m21, matrix.m22, matrix.m30, matrix.m31, matrix.m32);

			float t10 = -determinant3(matrix.m01, matrix.m02, matrix.m03, matrix.m21, matrix.m22, matrix.m23, matrix.m31, matrix.m32, matrix.m33);
			float t11 =  determinant3(matrix.m00, matrix.m02, matrix.m03, matrix.m20, matrix.m22, matrix.m23, matrix.m30, matrix.m32, matrix.m33);
			float t12 = -determinant3(matrix.m00, matrix.m01, matrix.m03, matrix.m20, matrix.m21, matrix.m23, matrix.m30, matrix.m31, matrix.m33);
			float t13 =  determinant3(matrix.m00, matrix.m01, matrix.m02, matrix.m20, matrix.m21, matrix.m22, matrix.m30, matrix.m31, matrix.m32);

			float t20 =  determinant3(matrix.m01, matrix.m02, matrix.m03, matrix.m11, matrix.m12, matrix.m13, matrix.m31, matrix.m32, matrix.m33);
			float t21 = -determinant3(matrix.m00, matrix.m02, matrix.m03, matrix.m10, matrix.m12, matrix.m13, matrix.m30, matrix.m32, matrix.m33);
			float t22 =  determinant3(matrix.m00, matrix.m01, matrix.m03, matrix.m10, matrix.m11, matrix.m13, matrix.m30, matrix.m31, matrix.m33);
			float t23 = -determinant3(matrix.m00, matrix.m01, matrix.m02, matrix.m10, matrix.m11, matrix.m12, matrix.m30, matrix.m31, matrix.m32);

			float t30 = -determinant3(matrix.m01, matrix.m02, matrix.m03, matrix.m11, matrix.m12, matrix.m13, matrix.m21, matrix.m22, matrix.m23);
			float t31 =  determinant3(matrix.m00, matrix.m02, matrix.m03, matrix.m10, matrix.m12, matrix.m13, matrix.m20, matrix.m22, matrix.m23);
			float t32 = -determinant3(matrix.m00, matrix.m01, matrix.m03, matrix.m10, matrix.m11, matrix.m13, matrix.m20, matrix.m21, matrix.m23);
			float t33 =  determinant3(matrix.m00, matrix.m01, matrix.m02, matrix.m10, matrix.m11, matrix.m12, matrix.m20, matrix.m21, matrix.m22);

			dest.m00 = t00 * determinant_inv;
			dest.m11 = t11 * determinant_inv;
			dest.m22 = t22 * determinant_inv;
			dest.m33 = t33 * determinant_inv;
			dest.m01 = t10 * determinant_inv;
			dest.m10 = t01 * determinant_inv;
			dest.m20 = t02 * determinant_inv;
			dest.m02 = t20 * determinant_inv;
			dest.m12 = t21 * determinant_inv;
			dest.m21 = t12 * determinant_inv;
			dest.m03 = t30 * determinant_inv;
			dest.m30 = t03 * determinant_inv;
			dest.m13 = t31 * determinant_inv;
			dest.m31 = t13 * determinant_inv;
			dest.m32 = t23 * determinant_inv;
			dest.m23 = t32 * determinant_inv;
			
			return dest;
		}
	}

	private static float determinant3(float t00, float t01, float t02, float t10, float t11, float t12, float t20,
			float t21, float t22) {
		return t00 * (t11 * t22 - t12 * t21) + t01 * (t12 * t20 - t10 * t22) + t02 * (t10 * t21 - t11 * t20);
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(m00).append(' ').append(m10).append(' ').append(m20).append(' ').append(m30).append('\n');
		buf.append(m01).append(' ').append(m11).append(' ').append(m21).append(' ').append(m31).append('\n');
		buf.append(m02).append(' ').append(m12).append(' ').append(m22).append(' ').append(m32).append('\n');
		buf.append(m03).append(' ').append(m13).append(' ').append(m23).append(' ').append(m33).append('\n');
		return buf.toString();
	}
}
