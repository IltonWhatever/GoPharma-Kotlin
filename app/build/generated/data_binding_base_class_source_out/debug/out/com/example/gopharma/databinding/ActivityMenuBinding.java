// Generated by view binder compiler. Do not edit!
package com.example.gopharma.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gopharma.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText filter;

  @NonNull
  public final ConstraintLayout linearLayout;

  @NonNull
  public final TextView logo;

  @NonNull
  public final ConstraintLayout logobar;

  @NonNull
  public final ImageView notify;

  @NonNull
  public final ImageView options;

  @NonNull
  public final EditText searchbar;

  private ActivityMenuBinding(@NonNull ConstraintLayout rootView, @NonNull EditText filter,
      @NonNull ConstraintLayout linearLayout, @NonNull TextView logo,
      @NonNull ConstraintLayout logobar, @NonNull ImageView notify, @NonNull ImageView options,
      @NonNull EditText searchbar) {
    this.rootView = rootView;
    this.filter = filter;
    this.linearLayout = linearLayout;
    this.logo = logo;
    this.logobar = logobar;
    this.notify = notify;
    this.options = options;
    this.searchbar = searchbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.filter;
      EditText filter = ViewBindings.findChildViewById(rootView, id);
      if (filter == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      ConstraintLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.logo;
      TextView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      id = R.id.logobar;
      ConstraintLayout logobar = ViewBindings.findChildViewById(rootView, id);
      if (logobar == null) {
        break missingId;
      }

      id = R.id.notify;
      ImageView notify = ViewBindings.findChildViewById(rootView, id);
      if (notify == null) {
        break missingId;
      }

      id = R.id.options;
      ImageView options = ViewBindings.findChildViewById(rootView, id);
      if (options == null) {
        break missingId;
      }

      id = R.id.searchbar;
      EditText searchbar = ViewBindings.findChildViewById(rootView, id);
      if (searchbar == null) {
        break missingId;
      }

      return new ActivityMenuBinding((ConstraintLayout) rootView, filter, linearLayout, logo,
          logobar, notify, options, searchbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
