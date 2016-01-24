package com.example.admin.quickscan.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        List<Category> list = new ArrayList<>();
        list.add(new Category(1, "Category 1", ""));
        list.add(new Category(1, "Category 2", ""));
        list.add(new Category(1, "Category 3", ""));
        list.add(new Category(1, "Category 4", ""));
        list.add(new Category(1, "Category 5", ""));
        list.add(new Category(1, "Category 6", ""));
        list.add(new Category(1, "Category 7", ""));
        list.add(new Category(1, "Category 8", ""));
        list.add(new Category(1, "Category 9", ""));

        recyclerView.setAdapter(new RecyclerAdapterCategory(list));
    }

    public class RecyclerAdapterCategory extends RecyclerView.Adapter<RecyclerAdapterCategory.ViewHolder> {

        private List<Category> listCategory;

        public RecyclerAdapterCategory(List<Category> listCategory) {
            this.listCategory = listCategory;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.list_item_category, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Category category = listCategory.get(position);
            holder.textView.setText(category.getCategoryName());
//            holder.imageView.setImageResource(category.getCategoryName());
        }

        @Override
        public int getItemCount() {
            return listCategory.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageView;
            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);

                imageView = (ImageView) itemView.findViewById(R.id.ivListItemCategory);
                textView = (TextView) itemView.findViewById(R.id.tvListItemCategory);
            }
        }
    }
}
