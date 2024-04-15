// $Id: UMLCompositeStateConcurrentCheckBox.java 16807 2009-02-19 07:29:11Z mvw $
// Copyright (c) 1996-2009 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.uml.ui.behavior.state_machines;

import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLCheckBox2;

/**
 * @deprecated by mvw in V0.28alpha - not used, replaced by button in toolbar.
 * @since Dec 14, 2002
 * @author jaap.branderhorst@xs4all.nl
 */
@Deprecated
public class UMLCompositeStateConcurrentCheckBox extends UMLCheckBox2 {

    /**
     * Constructor for UMLCompositeStateConcurrentCheckBox.
     */
    public UMLCompositeStateConcurrentCheckBox() {
         super(Translator.localize("label.concurrent"),
            ActionSetCompositeStateConcurrent.getInstance(),
            "isConcurent");
    }

    /*
     * @see org.argouml.uml.ui.UMLCheckBox2#buildModel()
     */
    public void buildModel() {
        setSelected(Model.getFacade().isConcurrent(getTarget()));
    }

}
