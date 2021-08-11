package com.hk2994.haushaltapp.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hk2994.haushaltapp.R;
import com.hk2994.haushaltapp.model.Balance;

import java.util.List;

public class BalancesAdapter extends RecyclerView.Adapter<BalancesAdapter.BalancesViewHolder> {

    private final List<Balance> balances;

    public BalancesAdapter(List<Balance> items) {
        this.balances = items;
    }

    /**
     * Create a new ViewHolder by a given type. Returns an balance row if viewType has the value
     * TYPE_ITEM and a header row if viewType has the value TYPE_HEADER
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an
     *               adapter position
     * @param viewType The view type of the new View
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * */
    @Override
    public BalancesAdapter.BalancesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.fragment_balance_item,
                parent,
                false
        );
        return new BalancesViewHolder(view);

    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the item views.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item
     *               at the given position in the balance list.
     * @param position The position of the item within the adapter's list.
     * */
    @Override
    public void onBindViewHolder(final BalancesAdapter.BalancesViewHolder holder, int position) {
        Balance balance = balances.get(position);
        BalancesViewHolder itemViewHolder = (BalancesViewHolder) holder;
        itemViewHolder.date.setText(balance.getDateString());
        itemViewHolder.amount.setText(balance.getAmount() + "€");

    }

    /**
     * Returns the total number of items in the balances list
     *
     * @return The total number of items
     * */
    @Override
    public int getItemCount() {
        return balances.size();
    }

    public class BalancesViewHolder extends RecyclerView.ViewHolder {
        public final TextView date;
        public final TextView amount;

        public BalancesViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.BalanceDate);
            amount = itemView.findViewById(R.id.BalanceAmount);
        }
    }

}