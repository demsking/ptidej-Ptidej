/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Ga�l Gu�h�neuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Ga�l Gu�h�neuc and others, see in file; API and its implementation
 ******************************************************************************/
package sad.designsmell.detection.repository.FunctionalDecomposition;

/**
 * This class implements the detection algorithms 
 * of the design smell FunctionalDecomposition.
 * 
 * @author Autogenerated files
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import padl.kernel.IAbstractLevelModel;
import sad.codesmell.detection.repository.FunctionalDecomposition.*;
import sad.kernel.ICodeSmell;
import sad.codesmell.detection.ICodeSmellDetection;
import sad.designsmell.detection.IDesignSmellDetection;
import sad.designsmell.detection.repository.AbstractDesignSmellDetection;
import sad.kernel.impl.DesignSmell;
import sad.util.OperatorsCodeSmells;
import sad.util.Relationships;
import util.io.Files;

public class FunctionalDecompositionDetection extends AbstractDesignSmellDetection implements IDesignSmellDetection {
	private final OperatorsCodeSmells operators;
	private final Relationships relations;

	public FunctionalDecompositionDetection() {
		super();

		this.operators = OperatorsCodeSmells.getInstance();
		this.relations = Relationships.getInstance();
	}
	
	public String getName() {
		return "FunctionalDecomposition";
	}

	public String getRuleCardFile() {
		return "../SAD Rules Creator/src/main/resources/FunctionalDecomposition.rules";
	}

	
public void detect(final IAbstractLevelModel anAbstractLevelModel) {
final Set candidateDesignSmells = new HashSet();

final ICodeSmellDetection csFieldPrivate = new FieldPrivateDetection();
csFieldPrivate.detect(anAbstractLevelModel);
final Set setFieldPrivate = ((FieldPrivateDetection) csFieldPrivate).getCodeSmells();

final ICodeSmellDetection csClassOneMethod = new ClassOneMethodDetection();
csClassOneMethod.detect(anAbstractLevelModel);
final Set setClassOneMethod = ((ClassOneMethodDetection) csClassOneMethod).getCodeSmells();

final Set setaClass = 
this.operators.intersection(setClassOneMethod,setFieldPrivate);

final ICodeSmellDetection csFunctionClass = new FunctionClassDetection();
csFunctionClass.detect(anAbstractLevelModel);
final Set setFunctionClass = ((FunctionClassDetection) csFunctionClass).getCodeSmells();

final ICodeSmellDetection csNoPolymorphism = new NoPolymorphismDetection();
csNoPolymorphism.detect(anAbstractLevelModel);
final Set setNoPolymorphism = ((NoPolymorphismDetection) csNoPolymorphism).getCodeSmells();

final ICodeSmellDetection csNoInheritance = new NoInheritanceDetection();
csNoInheritance.detect(anAbstractLevelModel);
final Set setNoInheritance = ((NoInheritanceDetection) csNoInheritance).getCodeSmells();

final Set setNoInheritPoly = 
this.operators.intersection(setNoInheritance,setNoPolymorphism);

final Set setmainClass = 
this.operators.union(setNoInheritPoly,setFunctionClass);

final Set setFunctionalDecomposition = this.relations.checkAssociationOneToMany(1, setmainClass,  setaClass);

final Iterator iterSet = setFunctionalDecomposition.iterator();
while(iterSet.hasNext()) {
final ICodeSmell aCodeSmell = (ICodeSmell) iterSet.next();
final DesignSmell designSmell = new DesignSmell(aCodeSmell);
designSmell.setName("FunctionalDecomposition");
final String definition = "To defined";
designSmell.setDefinition(definition);
candidateDesignSmells.add(designSmell);
}
this.setSetOfDesignSmells(candidateDesignSmells);
}
}
