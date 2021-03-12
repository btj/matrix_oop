package matrix_oop;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix (from algebra).
 * 
 * @invar | 1 <= getNbRows()
 * @invar | getElementsRowMajor() != null
 * @invar | getElementsRowMajor().length == getNbRows() * getNbColumns()
 * @invar | 1 <= getNbColumns() 
 */
public class Matrix {

	/**
	 * @basic
	 */
	public int getNbRows() { throw new RuntimeException("Not yet implemented"); }

	/**
	 * @basic
	 * @creates | result
	 */
	public double[] getElementsRowMajor() { throw new RuntimeException("Not yet implemented"); }

	/**
	 * @post | result == getElementsRowMajor().length / getNbRows()
	 */
	public int getNbColumns() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows()
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == getNbColumns())
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex ->
	 *       |     IntStream.range(0, getNbColumns()).allMatch(columnIndex ->
	 *       |         result[rowIndex][columnIndex] == getElementsRowMajor()[rowIndex * getNbColumns() + columnIndex]))
	 * 
	 * @creates | result, ...result
	 */
	public double[][] getElementsRowArrays() { throw new RuntimeException("Not yet implemented"); }

	/**
	 * Initializes this object so that it represents the matrix with the given number of rows and columns
	 * and the given elements. The elements are given as an array in row major order.
	 * 
	 * @inspects | elementsRowMajor
	 * 
	 * @throws IllegalArgumentException | nbRows < 1
	 * @throws IllegalArgumentException | nbColumns < 1
	 * @throws IllegalArgumentException | elementsRowMajor == null
	 * @throws IllegalArgumentException | elementsRowMajor.length != nbRows * nbColumns
	 * 
	 * @post | getNbRows() == nbRows
	 * @post | Arrays.equals(getElementsRowMajor(), elementsRowMajor)
	 */
	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) { throw new RuntimeException("Not yet implemented"); }
	
}
