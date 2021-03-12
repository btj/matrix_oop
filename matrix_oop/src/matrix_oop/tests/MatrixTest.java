package matrix_oop.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import matrix_oop.Matrix;

class MatrixTest {

	@Test
	void test() {
		Matrix matrix = new Matrix(3, 2, new double[] {1, 0, 0, 1, 0, 0});
		assertEquals(3, matrix.getNbRows());
		assertEquals(2, matrix.getNbColumns());
		assertArrayEquals(new double[] {1, 0, 0, 1, 0, 0}, matrix.getElementsRowMajor());
		double[][] rows = {
				{1, 0},
				{0, 1},
				{0, 0}
		};
		assertTrue(Arrays.deepEquals(rows, matrix.getElementsRowArrays()));
	}

}
