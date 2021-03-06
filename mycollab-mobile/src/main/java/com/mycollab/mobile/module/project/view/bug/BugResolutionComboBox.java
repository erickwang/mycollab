/**
 * This file is part of mycollab-mobile.
 *
 * mycollab-mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-mobile.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.mobile.module.project.view.bug;

import com.mycollab.mobile.ui.I18nValueComboBox;
import com.mycollab.module.project.i18n.OptionI18nEnum.BugResolution;

/**
 * @author MyCollab Ltd.
 * @since 4.5.2
 */
public class BugResolutionComboBox extends I18nValueComboBox {
    private static final long serialVersionUID = 1L;

    private BugResolutionComboBox(boolean nullIsAllowable, Enum<?>... values) {
        super(nullIsAllowable, values);
    }

    public static BugResolutionComboBox getInstanceForWontFixWindow() {
        return new BugResolutionComboBox(false, BugResolution.CannotReproduce, BugResolution.Duplicate, BugResolution.Invalid);
    }

    public static BugResolutionComboBox getInstanceForValidBugWindow() {
        return new BugResolutionComboBox(false);
    }

    public static BugResolutionComboBox getInstanceForResolvedBugWindow() {
        return new BugResolutionComboBox(false, BugResolution.Fixed);
    }
}
