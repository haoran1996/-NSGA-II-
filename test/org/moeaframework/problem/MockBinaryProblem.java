/* Copyright 2009-2018 David Hadka
 *
 * This file is part of the MOEA Framework.
 *
 * The MOEA Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * The MOEA Framework is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.moeaframework.problem;

import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.BinaryVariable;

/**
 * A mock problem with binary variables.  The objective of this problem is to
 * maximize the number of 1 bits in the binary string.
 */
public class MockBinaryProblem extends AbstractProblem {

	public MockBinaryProblem() {
		super(1, 1);
	}

	@Override
	public void evaluate(Solution solution) {
		BinaryVariable binary = (BinaryVariable)solution.getVariable(0);
		solution.setObjective(0, 10 - binary.cardinality());
	}

	@Override
	public Solution newSolution() {
		Solution solution = new Solution(1, 1);
		solution.setVariable(0, new BinaryVariable(10));
		return solution;
	}

}
