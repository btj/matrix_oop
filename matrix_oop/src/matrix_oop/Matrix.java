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
	 * @invar | elements != null
	 * @invar | 1 <= elements.length
	 * @invar | 1 <= nbColumns
	 * @invar | Arrays.stream(elements).allMatch(row -> row != null && row.length == nbColumns)
	 */
	private int nbColumns;
	/**
	 * @representationObject
	 * @representationObjects
	 */
	private double[][] elements;

	/**
	 * @basic
	 */
	public int getNbRows() {
		return elements.length;
	}

	/**
	 * @inspects | this
	 * @basic
	 * @creates | result
	 */
	public double[] getElementsRowMajor() {
		double[] result = new double[elements.length * nbColumns];
		for (int rowIndex = 0; rowIndex < elements.length; rowIndex++)
			for (int columnIndex = 0; columnIndex < nbColumns; columnIndex++)
				result[rowIndex * nbColumns + columnIndex] = elements[rowIndex][columnIndex];
		return result;
	}

	/**
	 * @post | result == getElementsRowMajor().length / getNbRows()
	 */
	public int getNbColumns() {
		return nbColumns;
	}
	
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
	public double[][] getElementsRowArrays() {
		double[][] result = new double[elements.length][];
		for (int rowIndex = 0; rowIndex < elements.length; rowIndex++)
			result[rowIndex] = elements[rowIndex].clone();
		return result;
		
//		return Arrays.stream(elements).map(row -> row.clone()).toArray(n -> new double[n][]);
	}

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
	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) {
		if (nbRows < 1)
			throw new IllegalArgumentException("`nbRows` is less than 1");
		if (nbColumns < 1)
			throw new IllegalArgumentException("`nbColumns` is less than 1");
		if (elementsRowMajor == null)
			throw new IllegalArgumentException("`elementsRowMajor` is null");
		if (elementsRowMajor.length != nbRows * nbColumns)
			throw new IllegalArgumentException("length of `elementsRowMajor` is wrong");
		
		this.nbColumns = nbColumns;
		this.elements = new double[nbRows][nbColumns];
		for (int rowIndex = 0; rowIndex < elements.length; rowIndex++)
			for (int columnIndex = 0; columnIndex < nbColumns; columnIndex++)
				elements[rowIndex][columnIndex] = elementsRowMajor[rowIndex * nbColumns + columnIndex];
	}
	
	/**
	 * Adds the given matrix to this matrix.
	 * 
	 * @throws IllegalArgumentException | other == null
	 * @throws IllegalArgumentException | other.getNbRows() != this.getNbRows()
	 * @throws IllegalArgumentException | other.getNbColumns() != this.getNbColumns()
	 * 
	 * @mutates | this
	 * @inspects | other
	 * 
	 * @post | getNbRows() == old(getNbRows())
	 * @post | getNbColumns() == old(getNbColumns())
	 * @post | IntStream.range(0, getNbRows() * getNbColumns()).allMatch(i ->
	 *       |     getElementsRowMajor()[i] == old(getElementsRowMajor())[i] + other.getElementsRowMajor()[i])
	 */
	public void add(Matrix other) {
		if (other == null)
			throw new IllegalArgumentException("`other` is null");
		if (other.getNbRows() != this.getNbRows() || other.getNbColumns() != this.getNbColumns())
			throw new IllegalArgumentException("`other`'s shape is wrong");
		
		for (int rowIndex = 0; rowIndex < elements.length; rowIndex++)
			for (int columnIndex = 0; columnIndex < nbColumns; columnIndex++)
				elements[rowIndex][columnIndex] += other.elements[rowIndex][columnIndex];
	}
	
}
