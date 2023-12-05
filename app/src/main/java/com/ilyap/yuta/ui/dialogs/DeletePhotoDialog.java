package com.ilyap.yuta.ui.dialogs;

import static com.ilyap.yuta.utils.UserUtils.getCurrentUser;

import android.content.Context;

import com.ilyap.yuta.R;
import com.ilyap.yuta.models.User;
import com.ilyap.yuta.ui.fragments.ProfileFragment;
import com.ilyap.yuta.utils.RequestUtils;

@SuppressWarnings("ConstantConditions")
public class DeletePhotoDialog extends CustomInteractiveDialog {

    public DeletePhotoDialog(Context context, ProfileFragment profileFragment) {
        super(context, profileFragment);
        setDialogLayout(R.layout.delete_photo_dialog);
    }

    @Override
    public void start() {
        super.start();

        dialog.findViewById(R.id.close).setOnClickListener(v -> dismiss());
        dialog.findViewById(R.id.submit).setOnClickListener(v -> {
            deletePhoto(profileFragment);
            dismiss();
        });
    }

    protected static void deletePhoto(ProfileFragment profileFragment) {
        User user = getCurrentUser();
        RequestUtils.deleteUserPhotoRequest(user);
        // TODO
        user.setPhoto("https://github.com/Panovky/YUTA/blob/develop/media/images/cropped-default_user_photo.png?raw=true");
        user.setCroppedPhoto("https://github.com/Panovky/YUTA/blob/develop/media/images/cropped-default_user_photo.png?raw=true");
        if (profileFragment != null) {
            profileFragment.updateImage(user);
        }
    }
}