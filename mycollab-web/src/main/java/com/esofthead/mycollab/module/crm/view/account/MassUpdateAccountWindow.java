/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.crm.view.account;

import com.esofthead.mycollab.common.i18n.GenericI18Enum;
import com.esofthead.mycollab.module.crm.CrmTypeConstants;
import com.esofthead.mycollab.module.crm.domain.Account;
import com.esofthead.mycollab.module.crm.i18n.AccountI18nEnum;
import com.esofthead.mycollab.module.crm.ui.CrmAssetsManager;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.ui.AbstractBeanFieldGroupEditFieldFactory;
import com.esofthead.mycollab.vaadin.ui.FormContainer;
import com.esofthead.mycollab.vaadin.ui.IFormLayoutFactory;
import com.esofthead.mycollab.vaadin.web.ui.MassUpdateWindow;
import com.esofthead.mycollab.vaadin.web.ui.grid.GridFormLayoutHelper;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Field;

/**
 * @author MyCollab Ltd.
 * @since 2.0
 */
public class MassUpdateAccountWindow extends MassUpdateWindow<Account> {
    private static final long serialVersionUID = 1L;

    public MassUpdateAccountWindow(String title, AccountListPresenter presenter) {
        super(title, CrmAssetsManager.getAsset(CrmTypeConstants.ACCOUNT), new Account(), presenter);
    }

    @Override
    protected IFormLayoutFactory buildFormLayoutFactory() {
        return new MassUpdateAccountFormLayoutFactory();
    }

    @Override
    protected AbstractBeanFieldGroupEditFieldFactory<Account> buildBeanFormFieldFactory() {
        return new AccountEditFormFieldFactory<>(updateForm, false);
    }

    private class MassUpdateAccountFormLayoutFactory implements IFormLayoutFactory {
        private static final long serialVersionUID = 1L;

        private GridFormLayoutHelper informationLayout;
        private GridFormLayoutHelper addressLayout;

        @Override
        public ComponentContainer getLayout() {
            FormContainer formLayout = new FormContainer();

            informationLayout = GridFormLayoutHelper.defaultFormLayoutHelper(2, 6);
            formLayout.addSection(AppContext.getMessage(AccountI18nEnum.SECTION_ACCOUNT_INFORMATION),
                    informationLayout.getLayout());

            addressLayout = GridFormLayoutHelper.defaultFormLayoutHelper(2, 6);
            formLayout.addSection(AppContext.getMessage(AccountI18nEnum.SECTION_ADDRESS_INFORMATION), addressLayout.getLayout());
            formLayout.addComponent(buildButtonControls());

            return formLayout;
        }

        @Override
        public void attachField(Object propertyId, final Field<?> field) {
            if (propertyId.equals("industry")) {
                informationLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_INDUSTRY), 0, 0);
            } else if (propertyId.equals("type")) {
                informationLayout.addComponent(field, AppContext.getMessage(GenericI18Enum.FORM_TYPE), 1, 0);
            } else if (propertyId.equals("ownership")) {
                informationLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_OWNERSHIP), 0, 1);
            } else if (propertyId.equals("assignuser")) {
                informationLayout.addComponent(field, AppContext.getMessage(GenericI18Enum.FORM_ASSIGNEE), 1, 1);
            } else if (propertyId.equals("city")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_BILLING_CITY), 0, 0);
            } else if (propertyId.equals("shippingcity")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_SHIPPING_CITY), 1, 0);
            } else if (propertyId.equals("state")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_BILLING_STATE), 0, 1);
            } else if (propertyId.equals("postalcode")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_BILLING_POSTAL_CODE), 1, 1);
            } else if (propertyId.equals("billingcountry")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_BILLING_COUNTRY), 0, 2);
            } else if (propertyId.equals("shippingcountry")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_SHIPPING_COUNTRY), 1, 2);
            } else if (propertyId.equals("shippingstate")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_SHIPPING_STATE), 0, 3);
            } else if (propertyId.equals("shippingpostalcode")) {
                addressLayout.addComponent(field, AppContext.getMessage(AccountI18nEnum.FORM_SHIPPING_POSTAL_CODE), 1, 3);
            }

        }
    }
}
