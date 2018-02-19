package myshoes.com.myshoes.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import myshoes.com.myshoes.R;

/**
 * Created by gopinath on 06/02/18.
 */

public class Profile extends Fragment {
    TextView nameLabel, phoneLabel, addressLabel;
    Button confirm;
    private EditText mNameField, mPhoneField, mAddressField;
    private CircularImageView mProfileImage;
    private Uri resultUri;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //Inflated kids category with this fragment
        View v = inflater.inflate(R.layout.profile_fragment, container, false);
        mNameField = (EditText) v.findViewById(R.id.name);
        mPhoneField = (EditText) v.findViewById(R.id.phone);
        mAddressField = (EditText) v.findViewById(R.id.car);
        nameLabel = (TextView) v.findViewById(R.id.name_label);
        phoneLabel = (TextView) v.findViewById(R.id.phone_label);
        addressLabel = (TextView) v.findViewById(R.id.address_label);
        confirm = (Button) v.findViewById(R.id.confirm);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "Nunito-Regular.ttf");

        mNameField.setTypeface(custom_font);
        mPhoneField.setTypeface(custom_font);
        mAddressField.setTypeface(custom_font);
        nameLabel.setTypeface(custom_font);
        phoneLabel.setTypeface(custom_font);
        addressLabel.setTypeface(custom_font);
        confirm.setTypeface(custom_font);
//        mProfileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, 1);
//            }
//        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            final Uri imageUri = data.getData();
            resultUri = imageUri;
            mProfileImage.setImageURI(resultUri);
        }
    }

    public boolean saveUserInformation() {
//        if (resultUri != null) {
//
//            StorageReference filePath = FirebaseStorage.getInstance().getReference().child("profile_images").child(userID);
//            Bitmap bitmap = null;
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), resultUri);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
//            byte[] data = baos.toByteArray();
//            UploadTask uploadTask = filePath.putBytes(data);
//
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    finish();
//                    return;
//                }
//            });
//            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
//
//                    Map newImage = new HashMap();
//                    newImage.put("profileImageUrl", mProfileImageUrl);
//                    mDriverDatabase.updateChildren(newImage);
//
//                    return;
//                }
//            });
//        } else {
//
//        }
        return true;
    }
}
