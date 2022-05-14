package me.cosmi.mad.practical.ui.listx;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import me.cosmi.mad.practical.databinding.ActivityListBinding;
import me.cosmi.mad.practical.ui.base.BaseActivity;

public class ListActivity extends BaseActivity<ActivityListBinding, ListViewModel, ListListenerHolder> {

    @NonNull
    @Override
    protected ActivityListBinding createViewBinding(final LayoutInflater inflater) {
        return ActivityListBinding.inflate(inflater);
    }

    @NonNull
    @Override
    protected ListViewModel createViewModel() {
        final ListViewModelFactory factory = new ListViewModelFactory();

        return new ViewModelProvider(this, factory).get(ListViewModel.class);
    }

    @NonNull
    @Override
    protected ListListenerHolder createEventListenerHolder(final ListViewModel viewModel) {
        return new ListListenerHolder(viewModel);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.viewBinding.ivProfile.setOnClickListener(this.eventListener::ivProfile);
    }
}