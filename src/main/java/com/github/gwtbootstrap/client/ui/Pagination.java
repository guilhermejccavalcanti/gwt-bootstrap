/*
 *  Copyright 2013 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Widget;
import com.github.gwtbootstrap.client.ui.base.*;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.google.gwt.user.client.ui.*;
import java.util.Iterator;

//@formatter:on
public class Pagination extends Composite implements HasStyle, IsResponsive, HasId, InsertPanel.ForIsWidget, HasWidgets.ForIsWidget {

    private final DivWidget paginationDiv = new DivWidget();

    ;

    ;

    private UnorderedList list = new UnorderedList();

    public Pagination() {
        paginationDiv.setStyle(Bootstrap.Pagination.LEFT);
        paginationDiv.add(list);
        setSize(PaginationSize.NORMAL);
        initWidget(paginationDiv);
    }

    @Override
    public void add(IsWidget w) {
        list.add(w);
    }

    @Override
    public boolean remove(IsWidget w) {
        return paginationDiv.remove(w);
    }

    @Override
    public void insert(IsWidget w, int beforeIndex) {
        paginationDiv.insert(w, beforeIndex);
    }

    @Override
    public int getWidgetIndex(IsWidget child) {
        return paginationDiv.getWidgetIndex(child);
    }

    /**
     * Gets the child widget at the specified index.
     *
     * @param index the child widget's index
     * @return the child widget
     */
    @Override
    public Widget getWidget(int index) {
        return list.getWidget(index);
    }

    /**
     * Gets the number of child widgets in this panel.
     *
     * @return the number of children
     */
    @Override
    public int getWidgetCount() {
        return list.getWidgetCount();
    }

    /**
     * Gets the index of the specified child widget.
     *
     * @param child the widget to be found
     * @return the widget's index, or <code>-1</code> if it is not a child of this
     *         panel
     */
    @Override
    public int getWidgetIndex(Widget child) {
        return list.getWidgetIndex(child);
    }

    /**
     * Removes the widget at the specified index.
     *
     * @param index the index of the widget to be removed
     * @return <code>false</code> if the widget is not present
     */
    @Override
    public boolean remove(int index) {
        return list.remove(index);
    }

    public static enum PaginationSize implements Style {

        MINI(), SMALL(), NORMAL(), LARGE();

        @Override
        public String get() {
            if (this != NORMAL) {
                return "pagination-" + this.name().toLowerCase();
            }
            return "";
        }
    }

    public void setAlignment(String alignment) {
        if (alignment.equalsIgnoreCase("right"))
            setStyle(Bootstrap.Pagination.RIGHT);
        else if (alignment.equalsIgnoreCase("centered"))
            setStyle(Bootstrap.Pagination.CENTERED);
        else
            setStyle(Bootstrap.Pagination.LEFT);
    }

    /**
     * {@inheritDoc}
     */
    public void setId(String id) {
        paginationDiv.setId(id);
    }

    /**
     * {@inheritDoc}
     */
    public String getId() {
        return paginationDiv.getId();
    }

    /**
     * {@inheritDoc}
     */
    public void setHideOn(Device device) {
        paginationDiv.setHideOn(device);
    }

    /**
     * {@inheritDoc}
     */
    public void setShowOn(Device device) {
        paginationDiv.setShowOn(device);
    }

    /**
     * {@inheritDoc}
     */
    public void removeStyle(Style style) {
        paginationDiv.removeStyle(style);
    }

    /**
     * {@inheritDoc}
     */
    public void addStyle(Style style) {
        paginationDiv.addStyle(style);
    }

    /**
     * {@inheritDoc}
     */
    public void setStyle(Style style) {
        paginationDiv.setStyle(style);
    }

    /**
     * Pulls the widget to the right side.
     *
     * @param pullRight
     *            <code>true</code> if the widget should be aligned right.
     */
    public void pullRight(boolean pullRight) {
        paginationDiv.pullRight(pullRight);
    }

    public void setSize(PaginationSize size) {
        StyleHelper.changeStyle(paginationDiv, size, PaginationSize.class);
    }

    /**
     * {@inheritDoc}
     */
    public void add(Widget w) {
        list.add(w);
    }

    /**
     * Removes all child widgets.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Gets an iterator for the contained widgets. This iterator is required to
     * implement {@link java.util.Iterator#remove()}.
     */
    @Override
    public Iterator<Widget> iterator() {
        return list.iterator();
    }

    /**
     * Removes a child widget.
     *
     * @param w the widget to be removed
     * @return <code>true</code> if the widget was present
     */
    @Override
    public boolean remove(Widget w) {
        return list.remove(w);
    }

    /**
     * Inserts another widget into this one.
     *
     * @param w
     *            the widget to be inserted
     * @param beforeIndex
     *            the index of the position before which it should be set
     */
    public void insert(Widget w, int beforeIndex) {
        list.insert(w, beforeIndex);
    }

    public NavLink addPageLink(int page) {
        final NavLink pageLink = new NavLink(String.valueOf(page));
        insert(pageLink, page);
        return pageLink;
    }

    public NavLink addPreviousLink() {
        final NavLink pageLink = new NavLink("<");
        insert(pageLink, 0);
        return pageLink;
    }

    public NavLink addNextLink() {
        final NavLink pageLink = new NavLink(">");
        add(pageLink);
        return pageLink;
    }
}
