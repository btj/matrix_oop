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

	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) { throw new RuntimeException("Not yet implemented"); }
	
}
