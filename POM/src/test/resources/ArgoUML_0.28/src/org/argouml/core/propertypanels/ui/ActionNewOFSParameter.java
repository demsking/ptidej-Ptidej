// $Id: ActionNewOFSParameter.java 15598 2008-08-21 14:21:24Z penyaskito $
// Copyright (c) 2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
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

package org.argouml.core.propertypanels.ui;

import java.awt.event.ActionEvent;

import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionNewModelElement;
/**
 * @author mkl
 */
public class ActionNewOFSParameter extends AbstractActionNewModelElement {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object target = getTarget();
        if (Model.getFacade().isAObjectFlowState(target)) {
            Object type = getType(target);
            Object parameter = Model.getCoreFactory().createParameter();
            Model.getCoreHelper().setType(parameter, type);
            Model.getActivityGraphsHelper().addParameter(target, parameter);
        }
    }
    private static Object getType(Object target) {
        Object type = Model.getFacade().getType(target);
        if (Model.getFacade().isAClassifierInState(type)) {
            type = Model.getFacade().getType(type);
        }
        return type;
    }
}
