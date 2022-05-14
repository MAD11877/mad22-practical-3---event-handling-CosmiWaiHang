package me.cosmi.mad.practical.ui.listx;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import java.util.Random;
import java.util.function.Supplier;

import me.cosmi.mad.practical.data.domain.User;
import me.cosmi.mad.practical.ui.base.BaseListenerHolder;
import me.cosmi.mad.practical.ui.main.MainActivity;

public class ListListenerHolder extends BaseListenerHolder<ListViewModel> {

    private static final Supplier<Integer> RAND_INT = () -> Math.abs(new Random().nextInt());
    private static final Supplier<Boolean> RAND_BOOL = () -> new Random().nextBoolean();

    public ListListenerHolder(final ListViewModel viewModel) {
        super(viewModel);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void ivProfile(final View view) {
        new AlertDialog
                .Builder(view.getContext())
                .setTitle("Profile")
                .setMessage("MADness")
                .setPositiveButton("View", (dialogInterface, which) -> {
                    final User user = new User();
                    user.setName("Username");
                    user.setDescription("User description");
                    user.setId(RAND_INT.get());
                    user.setIsFollowed(RAND_BOOL.get());

                    MainActivity.start(view.getContext(), user);
                })
                .setNegativeButton("Close", null)
                .create()
                .show();
    }
}
