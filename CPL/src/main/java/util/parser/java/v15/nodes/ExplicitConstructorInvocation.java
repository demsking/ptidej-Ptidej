/*******************************************************************************
 * Copyright (c) 2014 Yann-Gaël Guéhéneuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Gaël Guéhéneuc and others, see in file; API and its implementation
 ******************************************************************************/
//
// Generated by JTB 1.2.2
//

package util.parser.java.v15.nodes;

/**
 * Grammar production:
 * f0 -> ( <IDENTIFIER> "." )*
 * f1 -> [ "this" "." ]
 * f2 -> [ TypeArguments() ]
 * f3 -> ( "this" | "super" )
 * f4 -> Arguments()
 * f5 -> ";"
 */
public class ExplicitConstructorInvocation implements Node {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public NodeListOptional f0;
   public NodeOptional f1;
   public NodeOptional f2;
   public NodeChoice f3;
   public Arguments f4;
   public NodeToken f5;

   public ExplicitConstructorInvocation(NodeListOptional n0, NodeOptional n1, NodeOptional n2, NodeChoice n3, Arguments n4, NodeToken n5) {
      this.f0 = n0;
      this.f1 = n1;
      this.f2 = n2;
      this.f3 = n3;
      this.f4 = n4;
      this.f5 = n5;
   }

   public ExplicitConstructorInvocation(NodeListOptional n0, NodeOptional n1, NodeOptional n2, NodeChoice n3, Arguments n4) {
      this.f0 = n0;
      this.f1 = n1;
      this.f2 = n2;
      this.f3 = n3;
      this.f4 = n4;
      this.f5 = new NodeToken(";");
   }

   public void accept(util.parser.java.v15.visitors.Visitor v) {
      v.visit(this);
   }
   public Object accept(util.parser.java.v15.visitors.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

