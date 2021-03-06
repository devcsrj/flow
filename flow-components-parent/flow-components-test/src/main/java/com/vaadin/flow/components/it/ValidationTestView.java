/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.components.it;

import com.vaadin.ui.Component;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.common.HasValidation;

/**
 * Abstract view class for testing validation with components that implement
 * {@link HasValidation}.
 */
public abstract class ValidationTestView extends TestView {
    /**
     * Default constructor.
     */
    public ValidationTestView() {
        initView();
    }

    private void initView() {
        HasValidation field = getValidationComponent();
        ((Component) field).setId("field");
        add(((Component) field));

        Button button = new Button("Make the input invalid");
        button.setId("invalidate");
        button.addClickListener(event -> {
            field.setErrorMessage("Invalidated from server");
            field.setInvalid(true);
        });
        add(button);

        button = new Button("Make the input valid");
        button.setId("validate");
        button.addClickListener(event -> {
            field.setErrorMessage(null);
            field.setInvalid(false);
        });
        add(button);
    }

    /**
     * Gets the component to be tested.
     * 
     * @return a component that implements {@link HasValidation}
     */
    protected abstract HasValidation getValidationComponent();
}
