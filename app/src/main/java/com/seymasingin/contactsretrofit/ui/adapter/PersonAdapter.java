package com.seymasingin.contactsretrofit.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.seymasingin.contactsretrofit.data.model.Person;
import com.seymasingin.contactsretrofit.databinding.CardItemBinding;
import com.seymasingin.contactsretrofit.ui.fragment.HomeFragmentDirections;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.CardHolder>{


    private List<Person> personList;
    private ContactsListener contactsListener;

    public PersonAdapter(List<Person> personList, ContactsListener contactsListener) {

        this.personList = personList;
        this.contactsListener = contactsListener;
    }

    public class CardHolder extends RecyclerView.ViewHolder {
        private CardItemBinding binding;
        public CardHolder(CardItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardItemBinding binding = CardItemBinding.inflate(layoutInflater, parent, false);
        return new CardHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        Person person = personList.get(position);
        CardItemBinding b = holder.binding;

        b.tvPerson.setText(person.getPerson_name()+ " "+ person.getPerson_tel());
        b.icDelete.setOnClickListener(view ->{
            Snackbar.make(view, person.getPerson_name()+ "delete?", Snackbar.LENGTH_LONG)
                    .setAction("YES", view1 -> {
                        contactsListener.onDelete(person.getPerson_id());
                    }).show();
        });
        b.card.setOnClickListener(view ->{
            HomeFragmentDirections.HomeToDetail direction = HomeFragmentDirections.homeToDetail(person);
            Navigation.findNavController(view).navigate(direction);
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public interface ContactsListener {
        public void onDelete(int person_id);
    }
}
