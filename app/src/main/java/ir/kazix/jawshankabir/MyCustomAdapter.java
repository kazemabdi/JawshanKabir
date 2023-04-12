package ir.kazix.jawshankabir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {

    private ArrayList<MySentence> mySentenceArrayList = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewA;
        private final TextView textViewB;

        public ViewHolder(View view) {
            super(view);

            textViewA = view.findViewById(R.id.sentence_a);
            textViewB = view.findViewById(R.id.sentence_b);
        }

        public TextView getTextViewA() {
            return textViewA;
        }

        public TextView getTextViewB() {
            return textViewB;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param arrayList ArrayList<MyMessage> containing the data to populate views to be used
     *                  by RecyclerView.
     */
    public MyCustomAdapter(ArrayList<MySentence> arrayList) {

        mySentenceArrayList = arrayList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sentence_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.getTextViewA().setText(mySentenceArrayList.get(position).getStringA());
        viewHolder.getTextViewB().setText(mySentenceArrayList.get(position).getStringB());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mySentenceArrayList.size();
    }
}