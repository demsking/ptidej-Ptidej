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
package sad.designsmell.detection.repository.LongMethod;

/**
 * This class implements the detection algorithms 
 * of the design smell LongMethod.
 * 
 * @author Autogenerated files
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import padl.kernel.IAbstractLevelModel;
import sad.codesmell.detection.repository.LongMethod.*;
import sad.kernel.ICodeSmell;
import sad.codesmell.detection.ICodeSmellDetection;
import sad.designsmell.detection.IDesignSmellDetection;
import sad.designsmell.detection.repository.AbstractDesignSmellDetection;
import sad.kernel.impl.DesignSmell;
import sad.util.OperatorsCodeSmells;
import sad.util.Relationships;
import util.io.Files;

public class LongMethodDetection extends AbstractDesignSmellDetection implements IDesignSmellDetection {
	private final OperatorsCodeSmells operators;
	private final Relationships relations;

	public LongMethodDetection() {
		super();

		this.operators = OperatorsCodeSmells.getInstance();
		this.relations = Relationships.getInstance();
	}
	
	public String getName() {
		return "LongMethod";
	}

	public String getRuleCardFile() {
		return "../SAD Rules Creator/src/main/resources/LongMethod.rules";
	}

	
public void detect(final IAbstractLevelModel anAbstractLevelModel) {
final Set candidateDesignSmells = new HashSet();

final ICodeSmellDetection csLongMethodClass = new LongMethodClassDetection();
csLongMethodClass.detect(anAbstractLevelModel);
final Set setLongMethodClass = ((LongMethodClassDetection) csLongMethodClass).getCodeSmells();

final Iterator iterSet = setLongMethodClass.iterator();
while(iterSet.hasNext()) {
final ICodeSmell aCodeSmell = (ICodeSmell) iterSet.next();
final DesignSmell designSmell = new DesignSmell(aCodeSmell);
designSmell.setName("LongMethod");
final String definition = "To defined";
designSmell.setDefinition(definition);
candidateDesignSmells.add(designSmell);
}
this.setSetOfDesignSmells(candidateDesignSmells);
}
}
