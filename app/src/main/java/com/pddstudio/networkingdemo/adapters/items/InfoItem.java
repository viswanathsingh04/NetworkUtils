/*
 * Copyright 2016 Patrick J
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.pddstudio.networkingdemo.adapters.items;
/*
 * This Class was created by Patrick J
 * on 22.02.16. For more Details and licensing information
 * have a look at the README.md
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.pddstudio.networkingdemo.R;

public class InfoItem extends AbstractItem<InfoItem, InfoItem.ViewHolder> {

    private final String captionName;
    private final String description;

    public InfoItem(String caption, String description) {
        this.captionName = caption;
        this.description = description;
    }

    @Override
    public int getType() {
        return R.id.intro_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_intro;
    }

    @Override
    public void bindView(ViewHolder viewHolder) {
        super.bindView(viewHolder);
        viewHolder.captionText.setText(captionName);
        viewHolder.descriptionText.setText(description);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView captionText;
        TextView descriptionText;

        public ViewHolder(View itemView) {
            super(itemView);
            captionText = (TextView) itemView.findViewById(R.id.introHeaderView);
            descriptionText = (TextView) itemView.findViewById(R.id.introContentView);
        }
    }

}
