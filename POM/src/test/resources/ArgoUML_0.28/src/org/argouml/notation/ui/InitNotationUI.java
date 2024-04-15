// $Id: InitNotationUI.java 13960 2007-12-21 02:31:44Z tfmorris $
// Copyright (c) 2007 The Regents of the University of California. All
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

package org.argouml.notation.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.Argo;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.application.api.InitSubsystem;

/**
 * Initialise this subsystem.
 *
 * @author Michiel
 */
public class InitNotationUI implements InitSubsystem {

    public void init() {

    }

    public List<GUISettingsTabInterface> getProjectSettingsTabs() {
        List<GUISettingsTabInterface> result = 
            new ArrayList<GUISettingsTabInterface>();
        result.add(new SettingsTabNotation(Argo.SCOPE_PROJECT));
        return result;
    }

    public List<GUISettingsTabInterface> getSettingsTabs() {
        List<GUISettingsTabInterface> result = 
            new ArrayList<GUISettingsTabInterface>();
        result.add(new SettingsTabNotation(Argo.SCOPE_APPLICATION));
        return result;
    }

    public List<AbstractArgoJPanel> getDetailsTabs() {
        return Collections.emptyList();
    }

}
